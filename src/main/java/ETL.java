import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static org.neo4j.driver.v1.Values.parameters;
import org.neo4j.driver.v1.Session;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class ETL {
    public static void parseFile(String fileName, Session session){
        File file = new File(fileName);
        BufferedReader reader = null;
        JsonParser parser=new JsonParser();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString ;

            while ((tempString = reader.readLine()) != null) {
                try{
                    JsonObject jsonObject=(JsonObject) parser.parse(tempString);
                    parseJson(jsonObject,session);
                }catch (Exception e){
                    continue;
                }

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    private static void parseJson(JsonObject corpRootObject,Session session){
        JsonArray shareholders=null ;
        JsonArray abnormalInfo=null;
        JsonArray staff=null;
        JsonArray investment=null;
        JsonArray modification=null;
        String startDate,stopDate,state,id,reg_capt, legal_person,address, Eng_name, mail, type,reg_date,field,reg_auth,name,tel,introduction,checkdate,province;
        try{
            id = corpRootObject.get("统一社会信用代码：").getAsString();
        }catch(Exception e){
            try{
                id = corpRootObject.get("注册号：").getAsString();
            }catch(Exception a){
                return ;
            }
        }



        try{
            name = corpRootObject.get("企业名称：").getAsString();
        }catch(Exception e){
                try{
                    name = corpRootObject.get("名称：").getAsString();
                    parseIndividualBusiness(corpRootObject,session);//处理个体工商户，没有股东与任职，节点标签为“个体工商户”
                    return;
                }catch (Exception a){
                    System.out.println("出现新的企业名称字段,id为"+id);
                    return;
                }

        }

        type = corpRootObject.get("类型：").getAsString();
        try{
            field = corpRootObject.get("经营范围：").getAsString();
        }catch (Exception e){
            try{
                field=corpRootObject.get("业务范围：").getAsString();
            }catch(Exception a){
                System.out.println("经营范围出错，检查"+id);
                field="";
            }

        }

        reg_date = corpRootObject.get("成立日期：").getAsString();
        reg_auth = corpRootObject.get("登记机关：").getAsString();
        state = corpRootObject.get("登记状态：").getAsString();

        startDate=checkBeforeParse(corpRootObject,"营业期限自：");
        stopDate=checkBeforeParse(corpRootObject,"营业期限至：");
        reg_capt = checkBeforeParse(corpRootObject,"注册资本：");
        legal_person = checkBeforeParse(corpRootObject,"法定代表人：");
        address = checkBeforeParse(corpRootObject,"住所：");
        mail = checkBeforeParse(corpRootObject,"邮箱：");
        checkdate = checkBeforeParse(corpRootObject,"核准日期：");
        Eng_name= checkBeforeParse(corpRootObject,"英文名称：");
        tel = checkBeforeParse(corpRootObject,"电话：");
        introduction= checkBeforeParse(corpRootObject,"简介：");

        province = id2Province(id);
        if(address.equals("******")) address = checkBeforeParse(corpRootObject,"主要经营场所：");
        if(address.equals("******")) address = checkBeforeParse(corpRootObject,"经营场所：");


        /************************** 解析jsonarray *****************************/
        try{
            shareholders = corpRootObject.get("股东信息").getAsJsonArray();
        }catch(Exception e){
            System.out.println("无法获得股东信息");
        }
        try{
            staff = corpRootObject.get("任职人员").getAsJsonArray();
        }catch (Exception e){
            System.out.println("无法获得人员信息");
        }
        try{
            abnormalInfo = corpRootObject.get("经营异常信息").getAsJsonArray();
        }catch (Exception e){
            System.out.println("无法获得营异常信息");
        }
        try{
            investment = corpRootObject.get("企业股东信息").getAsJsonArray();
        }catch ( Exception e){
            System.out.println("无法获得企业股东投资详情");
        }
        try{
            modification = corpRootObject.get("变更信息").getAsJsonArray();
        }catch(Exception e){
            System.out.println("无法获得变更信息");
        }




        /****************************  企业基本信息 ***************************/
        try{
            session.run("merge(n:企业:"+province+"{name:{name}}) set n.id={id},n.type={type},n.state={state},n.reg_capt={reg_capt},n.legal_person={legal_person}" +
                            ",n.address={address},n.Eng_name={Eng_name},n.mail={mail},n.reg_date={reg_date},n.field={field},n.reg_auth={reg_auth},n.tel={tel}," +
                            "n.checkDate={checkdate},n.introduction={introduction},n.modification={modification},n.startDate={startDate},n.stopDate={stopDate}",
                    parameters("id",id,"name",name,"type",type,"state",state,"reg_capt",reg_capt,"legal_person",legal_person,
                            "address",address,"Eng_name",Eng_name,"mail",mail,"reg_date",reg_date,"field",field,
                            "reg_auth",reg_auth,"tel",tel,"checkdate",checkdate,"introduction",introduction,"modification",modification.toString(),"startDate",startDate,"stopDate",stopDate));
        }catch (Exception e){
            e.printStackTrace();
        }
        /******************************* 经营异常信息 ****************************/
        if(abnormalInfo !=null){
            JsonObject obj;
            for(JsonElement element: abnormalInfo){
                try{
                    obj = element.getAsJsonObject();
                    parseAbnormalInfo(obj,session,id);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }



        /************************** 股东信息 或 合伙人信息******************************/
        if(shareholders!=null){
            JsonObject shObj;
            for(JsonElement element : shareholders){
                try{
                    shObj = element.getAsJsonObject();
                    String stockType = shObj.get("股东类型").getAsString();

                        if(stockType.contains("自然人"))
                            parseShareHolders(shObj,session,"人",id,stockType);
                        else if(
                                stockType.equals("外商投资投资性公司")||
                                stockType.equals("外国(地区)投资者")||
                                stockType.equals("其他投资者")||
                                stockType.contains("企业")||
                                stockType.contains("法人")||
                                stockType.equals("")){
                            parseShareHolders(shObj,session,"企业",id,stockType);
                        }else{
                            System.out.println("出现其他股东类型 "+name);

                        }
                }catch(Exception e){

                    //不是股东，检查是不是合伙人
                    try{
                        shObj = element.getAsJsonObject();
                        String shType = shObj.get("合伙人类型").getAsString();
                        if(shType.equals("其他投资者")||
                                shType.contains("企业")||
                                shType.contains("法人")){
                            parsePartner(shObj,session,"企业",id,shType);
                        }else if(shObj.get("合伙人类型").getAsString().equals("自然人股东")){
                            parsePartner(shObj,session,"人",id,"自然人");
                        }
                        else{
                            System.out.println("出现其他合伙人类型"+ name);
                        }
                    }catch(Exception a){
                        try{

                            shObj = element.getAsJsonObject();
                            if(shObj.get("主管部门类型").getAsString().equals("自然人股东")||
                                    shObj.get("主管部门类型").getAsString().equals("其他投资者")){
                                parseSpecShareHolders(shObj,session,"人",id);

                            }else{
                                parseSpecShareHolders(shObj,session,"企业",id);

                            }
                        }catch (Exception w){
                            try{
                                shObj = element.getAsJsonObject();
                                String setupType=shObj.get("发起人类型").getAsString();

                                if(setupType.equals("自然人股东")){//发起人当作股东处理
                                    parseShareHolders(shObj,session,"人",id,"自然人股东");
                                }else if(setupType.contains("企业")||
                                        setupType.contains("法人")||
                                        setupType.contains("公司")){
                                    parseShareHolders(shObj,session,"企业",id,setupType);
                                }
                            }catch (Exception e3){
                                try{
                                    shObj = element.getAsJsonObject();
                                    parseShareHolders(shObj,session,"企业",id,"企业");
                                }catch (Exception e4){
                                    System.out.println("出现其非股东，非合伙人，非主管部门类型企业"+name);
                                }

                            }

                        }

                    }
                }

            }
        }
   /************************** 解析股东出资的具体信息 ************************/
        if(investment!=null){
            JsonObject obj;
            for(JsonElement element: investment){
                obj = element.getAsJsonObject();
                parseInvestment(obj,session,id);
            }
        }


        /**************************** 任职人员信息 **************************
         * staff 是一个jsonarray，里面包含员工jsonobject
         */

       if(staff!=null||staff.size()!=0){
           String position;
           for(JsonElement jsonElement : staff){
               JsonObject o = jsonElement.getAsJsonObject();
               String staffName=null;
               Set<String> set = o.keySet();
                for( String i : set){
                   staffName =i;
                }
                String positionCode = o.get(staffName).getAsString();
               position= ImageDecode.recPos(positionCode,id,staffName);
               session.run("match (n:企业{id:{id}}) merge(p:人{name:{name}}) merge (p)-[:任职{position:{position}}]->(n)",
                       parameters("id",id,"name",staffName,"position",position));
           }
       }

    }

    private static void parseShareHolders(JsonObject shObj,Session session,String type,String id,String sType) {

        try{
            JsonObject infoObj = shObj.getAsJsonObject("股东出资信息");
            String sh_id = checkBeforeParse(shObj,"证照/证件编号");
            String sh_province = id2Province(sh_id);
            String shType= sType;//股东类型
            String sh_name = checkBeforeParse(shObj,"股东名称");
            if(sh_name.equals("******")) sh_name=checkBeforeParse(shObj,"名称"); //有的企业没有股东类型字段，如江门市蓬江区杜阮跃进印刷厂
            if(sh_name.equals("******")) sh_name=checkBeforeParse(shObj,"发起人名称"); //有的企业没有股东类型字段，如江门市蓬江区杜阮跃进印刷厂

            String subscription = checkBeforeParse(infoObj,"认缴额（万元）");
            String actual_subscription = checkBeforeParse(infoObj,"实缴额（万元）");
            String method = checkBeforeParse(infoObj,"认缴出资方式");
            String subscp_date = checkBeforeParse(infoObj,"认缴出资日期");
            String actual_subscp_date = checkBeforeParse(infoObj,"实缴出资日期");
            if(type.equals("企业")){//股东的id号未确定
                session.run("match(p{id:{id}}) merge(n:企业:"+sh_province+"{name:{name}}) " +
                                "merge (n)-[:股东{subscription:{subscription},actual_subscription:{actual_subscription},method:{method}," +
                                "subscp_date:{subscp_date},actual_subscp_date:{actual_subscp_date},sh_type:{sh_type}} ]->(p)",
                        parameters("id",id,"name",sh_name,"subscription",
                                subscription,"actual_subscription",actual_subscription,"method",method,"subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date,"sh_type",shType));

            }
            else if(type.equals("人")){
                session.run("match(p{id:{id}}) merge(n:人{name:{name}}) " +
                                "merge (n)-[:股东{subscription:{subscription},actual_subscription:{actual_subscription},method:{method}," +
                                "subscp_date:{subscp_date},actual_subscp_date:{actual_subscp_date},sh_type:{sh_type}} ]->(p)",
                        parameters("id",id,"name",sh_name,"subscription",
                                subscription,"actual_subscription",actual_subscription,"method",method,"subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date,"sh_type",shType));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    private static void parsePartner(JsonObject baseObj,Session session,String type,String id,String pType){
        try{
            JsonObject infoObj = baseObj.getAsJsonObject("股东出资信息");
            String partner_id = baseObj.get("证照/证件编号").getAsString();
            String pt_name = checkBeforeParse(baseObj,"合伙人");
            String pt_type = pType;
            String pt_province = id2Province(partner_id);
            String subscription = checkBeforeParse(infoObj,"认缴额（万元）");
            String actual_subscription = checkBeforeParse(infoObj,"实缴额（万元）");
            String method = checkBeforeParse(infoObj,"认缴出资方式");
            String subscp_date = checkBeforeParse(infoObj,"认缴出资日期");
            String actual_subscp_date = checkBeforeParse(infoObj,"实缴出资日期");
            if(type.equals("企业"))
            session.run("match(p{id:{id}}) merge(n:企业:"+pt_province+"{name:{name}}) " +
                            "merge (n)-[:合伙人{subscription:{subscription},actual_subscription:{actual_subscription},method:{method}," +
                            "subscp_date:{subscp_date},actual_subscp_date:{actual_subscp_date},sh_type:{sh_type}}]->(p)",
                    parameters("id",id,"name",pt_name,"subscription",
                            subscription,"actual_subscription",actual_subscription,"method",method,"subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date,"sh_type",pt_type));//注意数据库中合伙人类型是以sh_type存的
            else
                session.run("match(p{id:{id}}) merge(n:人{name:{name}}) " +
                            "merge (n)-[:合伙人{subscription:{subscription},actual_subscription:{actual_subscription},method:{method}," +
                            "subscp_date:{subscp_date},actual_subscp_date:{actual_subscp_date},sh_type:{sh_type}}]->(p)",
                    parameters("id",id,"name",pt_name,"subscription",
                            subscription,"actual_subscription",actual_subscription,"method",method,"subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date,"sh_type",pt_type));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private static void parseAbnormalInfo(JsonObject obj,Session session,String id){
        String irgReason = obj.get("列入经营异常名录原因").getAsString();
        String irgDate = obj.get("列入日期").getAsString();
        String irgAuth = obj.get("作出决定机关(列入)").getAsString();
        String deIrgReason = obj.get("移出经营异常名录原因").getAsString();
        String deIrgDate = obj.get("移出日期").getAsString();
        String deIrgAuth = obj.get("作出决定机关(移出)").getAsString();
        try{
            session.run("match (n{id:{id}}) merge (n)-[:经营异常{irgDate:{irgDate},irgAuth:{irgAuth}," +
                    "deIrgReason:{deIrgReason},deIrgDate:{deIrgDate},deIrgAuth:{deIrgAuth}}]->(p:异常{irgReason:{irgReason}})",
                    parameters("id",id,"irgDate",irgDate,"irgAuth",irgAuth,"deIrgReason",deIrgReason,
                            "deIrgDate",deIrgDate,"deIrgAuth",deIrgAuth,"irgReason",irgReason));

        }catch (Exception e){
            System.out.println("解析经营异常信息出错");
        }


    }
    //“企业股东信息”
    private static void parseInvestment(JsonObject obj, Session session, String id) {
        String sh_name = checkBeforeParse(obj,"股东");
        String subscription = checkBeforeParse(obj,"认缴额（万元）");
        String actual_subscription = checkBeforeParse(obj,"实缴额（万元）");
        String method = checkBeforeParse(obj,"认缴出资方式");
        String subscp_date = checkBeforeParse(obj,"认缴出资日期");
        String actual_subscp_date = checkBeforeParse(obj,"实缴出资日期");
        if(sh_name.contains("公司")||sh_name.contains("企业")||sh_name.contains("有限")){

            try{
                  session.run("match q= (p{name:{name}})-[r:股东]->(n{id:{id}}) delete r",parameters("name",sh_name,"id",id));
                session.run("match(n{id:{id}}),(p:企业{name:{name}}) merge (p)-[r:股东]->(n) set r.subscription={subscription} ,r.actual_subscription={actual_subscription}," +
                        "r.method={method},r.subscp_date={subscp_date},r.actual_subscp_date={actual_subscp_date}",parameters("id",id,"name",sh_name
                        ,"subscription",subscription,"actual_subscription",actual_subscription,"method",method,
                        "subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date));
                session.run("match(n{id:{id}}) merge (p:企业{name:{name}})-[r:股东]->(n) set r.subscription={subscription} ,r.actual_subscription={actual_subscription}," +
                        "r.method={method},r.subscp_date={subscp_date},r.actual_subscp_date={actual_subscp_date}",parameters("id",id,"name",sh_name
                        ,"subscription",subscription,"actual_subscription",actual_subscription,"method",method,
                        "subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date));
            }catch ( Exception e){
                e.printStackTrace();
                System.out.println("解析投资信息出错");
            }
        }else{
            try{
                  session.run("match q= (p{name:{name}})-[r:股东]->(n{id:{id}}) delete r",parameters("name",sh_name,"id",id));
                session.run("match(n{id:{id}}),(p:人{name:{name}}) merge (p)-[r:股东]->(n) set r.subscription={subscription} ,r.actual_subscription={actual_subscription}," +
                        "r.method={method},r.subscp_date={subscp_date},r.actual_subscp_date={actual_subscp_date}",parameters("id",id,"name",sh_name
                        ,"subscription",subscription,"actual_subscription",actual_subscription,"method",method,
                        "subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date));
                session.run(" match(n{id:{id}}) merge (p:人{name:{name}})-[r:股东]->(n) set r.subscription={subscription} ,r.actual_subscription={actual_subscription}," +
                        "r.method={method},r.subscp_date={subscp_date},r.actual_subscp_date={actual_subscp_date}",parameters("id",id,"name",sh_name
                        ,"subscription",subscription,"actual_subscription",actual_subscription,"method",method,
                        "subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date));
            }catch ( Exception e){
                e.printStackTrace();
                System.out.println("解析投资信息出错");
            }
        }

    }
    //"主管部门"
    private static void parseSpecShareHolders(JsonObject obj, Session session, String type,String id){
        try{
            JsonObject infoObj = obj.getAsJsonObject("股东出资信息");
            String sh_id = checkBeforeParse(obj,"证照/证件号码");

            String sh_province = id2Province(sh_id);
            String subscription = checkBeforeParse(infoObj,"认缴额（万元）");
            String actual_subscription = checkBeforeParse(infoObj,"实缴额（万元）");
            String method = checkBeforeParse(infoObj,"认缴出资方式");
            String subscp_date = checkBeforeParse(infoObj,"认缴出资日期");
            String actual_subscp_date = checkBeforeParse(infoObj,"实缴出资日期");

            String sh_name = obj.get("主管部门名称").getAsString();

            if(type.equals("人")){
                session.run("match(p{id:{id}}) merge(n:人{name:{name}}) " +
                                "merge (n)-[:股东{subscription:{subscription},actual_subscription:{actual_subscription},method:{method}," +
                                "subscp_date:{subscp_date},actual_subscp_date:{actual_subscp_date}} ]->(p)",
                        parameters("id",id,"name",sh_name,"subscription",
                                subscription,"actual_subscription",actual_subscription,"method",method,"subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date));
            }else{
                session.run("match(p{id:{id}}) merge(n:企业:"+sh_province+"{name:{name}}) " +
                                "merge (n)-[:股东{subscription:{subscription},actual_subscription:{actual_subscription},method:{method}," +
                                "subscp_date:{subscp_date},actual_subscp_date:{actual_subscp_date}} ]->(p)",
                        parameters("id",id,"name",sh_name,"subscription",
                                subscription,"actual_subscription",actual_subscription,"method",method,"subscp_date",subscp_date,"actual_subscp_date",actual_subscp_date));

            }

        }catch (Exception e){
        }

    }
    private static String checkBeforeParse(JsonObject jsonObject,String key){
        try{
            String value = jsonObject.get(key).getAsString();
            if(value.equals("非公示项")) return "******";
            return value;
        }catch (Exception e){
            return "******";
        }
    }
    private static void parseIndividualBusiness(JsonObject baseObject,Session session){
        String type,field,reg_date,reg_auth,state,address,id,owner,name,province;
             owner = checkBeforeParse(baseObject,"经营者：");

           name = baseObject.get("名称：").getAsString();
           try{
               id = baseObject.get("注册号：").getAsString();
           }catch (Exception e){
               id = baseObject.get("统一社会信用代码：").getAsString();
           }

            type = baseObject.get("类型：").getAsString();
            field = baseObject.get("经营范围：").getAsString();
            reg_date = checkBeforeParse(baseObject,"注册日期：");
            reg_auth = checkBeforeParse(baseObject,"登记机关：");
            state = checkBeforeParse(baseObject,"登记状态：");
            address = checkBeforeParse(baseObject,"住所：");
        province = id2Province(id);
        if(address.equals("******")) address = checkBeforeParse(baseObject,"主要经营场所：");
        if(address.equals("******")) address = checkBeforeParse(baseObject,"经营场所：");
        try{
            session.run("merge(n:个体工商户:"+province+"{name:{name}}) set n.id={id},n.type={type},n.state={state},n.legal_person={owner}" +
                            ",n.address={address},n.reg_date={reg_date},n.field={field},n.reg_auth={reg_auth}",
                    parameters("id",id,"name",name,"type",type,"state",state,"owner",owner,
                            "address",address,"reg_date",reg_date,"field",field,"reg_auth",reg_auth));//这里owner改为了legal_person
        }catch (Exception e){
            System.out.println("个体工商户插入失败:"+name);
            e.printStackTrace();
        }
    }
    private static String id2Province(String id){
        try{
            if(id.equals("******")) return "广东省";
            int iid = Integer.parseInt(id.substring(2,4));
            switch (iid){
                case 11: return "北京市";
                case 12: return "天津市";
                case 13: return "河北省";
                case 14: return "山西省";
                case 15: return "内蒙古自治区";
                case 21: return "辽宁省";
                case 22: return "吉林省";
                case 23: return "黑龙省";
                case 31: return "上海市";
                case 32: return "江苏省";
                case 33: return "浙江省";
                case 34: return "安徽省";
                case 35: return "福建省";
                case 36: return "江西省";
                case 37 :return "山东省";
                case 41: return "河南省";
                case 42: return "湖北省";
                case 43: return "湖南省";
                case 44: return "广东省";
                case 45: return "广西壮族自治区";
                case 46: return "海南省";
                case 50: return "重庆市";
                case 51: return "四川省";
                case 52: return "贵州省";
                case 53: return "云南省";
                case 54: return "西藏自治区";
                case 61: return "陕西省";
                case 62: return "甘肃省";
                case 63: return "青海省";
                case 64: return "宁夏回族自治区";
                case 65: return "新疆维吾尔自治区";
                case 71: return "台湾省";
                case 81: return "香港特别行政区";
                case 82: return "澳门特别行政区";
                default: return "广东省";

            }
        }catch(Exception e){
            return "广东省";
        }

    }

}