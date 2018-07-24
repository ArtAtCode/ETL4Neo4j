import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ImageDecode {
    public static  final  String POS_OUTPUT_ROOT_PATH ="C://Users//15944//Desktop//企业信息";
    public  static void decode(String encodedText,String corpId, String personName){
        BASE64Decoder decoder = new BASE64Decoder();
        try
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(encodedText.substring(22));//需要去掉"data:image/png;base64,";
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成png图片
            String imgFilePath = POS_OUTPUT_ROOT_PATH+"//"+corpId;//新生成的图片的位置
            File dir = new File(imgFilePath);
            if(!dir.exists()) {
                dir.mkdir();
            }
            OutputStream out = new FileOutputStream(imgFilePath+"//"+personName+".jpg");
            out.write(b);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            System.out.println("base64编码解析出错");
        }
    }
    public static String recPos(String encodedText,String corpId, String personName){
        if (encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAOCAYAAADT0Rc6AAABaUlEQVR42mNgwA7SgNgUiV8OxEoM\n" +
                "xAN7II4lRmERENtC2cuBOBzKlgbiL0DMg0VPIhDPxoIPAvE1HHJpyAYsRLII2dIuIH4MFUPGWUCs\n" +
                "B8ReWPAEIN6CQ86AkKXyQPwBiP2waNZD0rsJagkMXwLi+2hi27AFLzZLdwNxLdTyHUAsiyNqPqHx\n" +
                "k4F4CprYD2IsrYS6jgkqVgDE74DYEYelhHyK1VKQywKwxCky8IHGLxeSmCU0pQYg4SlQByOLgdSI\n" +
                "Y7OYDYpBhmsh8ZExH5qeLKglyHgvEF9BE7sLTQsoAJQl/gPxayjGx4ZlH0do/KHjhVCLkcXOQVO1\n" +
                "G7qln3BE/A+0+ONBCtpwLHgmNOEhi50E4g6ksoBsSxmgrl+Iho8C8Q00sYe4gpccS62B2AUN90Hz\n" +
                "LrLYNiiNUgSuAeJfSCXOHxzsX1C1RWiO5oOm0HCoT3MIlbvGOIosfNgYzQxQfl4MdVgPjrIaDAC5\n" +
                "foW6ShoocQAAAABJRU5ErkJggg=="))
            return "监事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAOCAYAAADT0Rc6AAABNElEQVR42mNgGERgAxI7HIizSNC7\n" +
                "iRSL1gGxC5T9A0n8KBDbY1FfDsRbsOBfOMTLibXUFmrIazQ8BSrPBFWDjL9hEWMi1qcghReA2BGI\n" +
                "1XDoYQPih1BHwPAvNP59qDqiLK0H4qVQ/kxoEAnT2lJxIOZDkq8G4rtALI0kxgJ1nAsS/obGr4Wq\n" +
                "wwr0gFgQyt6GQ40jGn85EQnpGhAH4bLUFEeqQ8emSI50wYLRfQrKQs1AbIDNUi+oAh4gjofGI4g9\n" +
                "H8rngcp7QdWD8u5sLPgXGh/k071AnIfL0nVIBQIsW8yG8mHx7oWkB+SYZDT8DY2/F0k/VSx1g/KR\n" +
                "8Tc0PijeAxhwlC6gkucp1OCT0JS6DprkT0LZT6HqqtH0G0B9DQrC58QWgbgSBS5sgMVSUMhMQkpo\n" +
                "OAEA4RN1T0Be/bEAAAAASUVORK5CYII="))
            return "监事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAOCAYAAADT0Rc6AAABdklEQVR42qWUMUgDQRBFDwsrsbGw\n" +
                "EBEsLIJIOpEgIkgQK7tUV4iQIoiFnYi9hcgVQZBUYmEnInIIIQQLEUFSiIgIIiGlnVVKZ+EffL4T\n" +
                "TnHhkezfnZ3d2b8XRX7bMIrUL0L7bVsy4rxJNaNBvBlN6jeh8ZwaNtJwuDVeBoxVs6RzxgqRGvvU\n" +
                "3zUu8H/VKCMmsOaQGNcDxriC0R6S3RgfoGd8Gm0sErh0Sn1F44EnxLOWankLctKMAyzojRUo/kvW\n" +
                "2zTqovU1aYxJSrjL5wFjsSTNO2nfM9OIcS7cw0Cqz1LcAjawTtRRTtbCnHFNOma0jGEi3N2xaCnK\n" +
                "y87XKrScCr3DSD+S9sTebcf6XUq6jPtTTpGYtQ5cXf5v0lDaisMJXgFrDzDmot7pDn4zqliAtW1j\n" +
                "huISnIy5M15F63rlnccHgHnEXaheoriS85yOnKemXogmxGkZiePCjEnZ9CgcWsFJt/K+vVMI+AvT\n" +
                "ssaQcYYndYircNs3bFSWiVYudnIAAAAASUVORK5CYII="))
            return "董事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAOCAYAAADT0Rc6AAABMklEQVR42mNgGERgOQE+PrCJWIXl\n" +
                "QLwOCf8gwC+H4i1Y8C8c4uXYLDYHYlsgdgTiG0DsBsReQOwD5YcCcTRUDQwwQfnI+BsWMSZcvi0A\n" +
                "4tlAPAWIJwBxGhB/AuJYII6EWhoAxAZIetiA+CFUDwz/QuPfh6rDAHnQeEPHP3CI51HDUhAQhQYn\n" +
                "Mv6ERUwcSQ8LENcDsQsS/obGr4WqwwpABh4E4nAk/AmNvxcaxMipmlBCugbEQfgsPYOUMsuhliLz\n" +
                "jyNZqofmI1w+BWWhZrS0QLZPs6AJDx3/QuNfg+rLw2YpyOWNBOIUFH/GSHrigTgZDX9D4++FOhgr\n" +
                "cCQy9Toi6XHDktC+ofGXo6UDOJBHC0ZcwQvDSmj6DaC+BgXhc2KLQVmoa4jF8lgsBeXJSUBsSsgy\n" +
                "AN3qgF2kXL4cAAAAAElFTkSuQmCC"))
            return "董事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAACMklEQVR42tWYT0SDYRzHX5NJZiTZ\n" +
                "IRPpkA4TkySZMR1msttMOiR2mA6zSzqkQ5ck6bBLOr06xOyUTKRDhySyQ5JEkg4dRjId5hX1e/mO\n" +
                "n8fzvHvfpr1vPz68+73P8z7f5/f8+z3TNLnliEn2e5UY0exbjFi0UW6cKLUp02OzzW5pdmRFYhbP\n" +
                "R0QGz0PEJxGQ1FkiDiRcEPeKdzlWP0HUFXr6CZ0oe0yzI9OZKC5wm3iFj5MnIkRSwh5xong3YSOo\n" +
                "y8QbUSEGPaa546AOEx/EvKShCKt7DEEtbolnwVeVtMmD6kenH4kHtOFFzR0H9YxYh9BTIqyo25DM\n" +
                "NHGvbFoENYjlekNkPa65o6CuYaR88BWIdyKuENhu1JttZmr4n2h2ZOYopSX7E7cU9qo+5pvGqZlm\n" +
                "lNA57jPLhFgwvh1Sclnzr80PUkh3/BKCQp08BHHOiTvB9yTZJ8WDyuzElcc1O7IAZkQdWD23UpU4\n" +
                "9iIRHSK5r4YTds4iqD6kNTkPa3Yc1IZik24Ke1GALaOMhH0cEtx3TWyxvFKVUk2hvYRHNf95UDWM\n" +
                "pC5wibSI+15sLP8xJO5mhwwsU9HK7ObkhuauBHUGweHsIg/kvqpk9rWCGsN7gyXaSbyrIefUkCaZ\n" +
                "ZXpd1OzoilqB4Nbt40vxbKBsUfhGEAdNBqO+YqPdAtv7NiS3pwEcGAaWYRYdd1OzbYsqrmdWRIVv\n" +
                "mIfMITqxo7h3izZKbLKZp7IQ/lgx970FlzW3tR/u7UF9MyHMgwAAAABJRU5ErkJggg=="))
            return "监事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAOCAYAAADT0Rc6AAABMklEQVR42mNgGERgOQE+PrCJWIXl\n" +
                "QLwOCf8gwC+H4i1Y8C8c4uXYLDYHYlsgdgTiG0DsBsReQOwD5YcCcTRUDQwwQfnI+BsWMSZcvi0A\n" +
                "4tlAPAWIJwBxGhB/AuJYII6EWhoAxAZIetiA+CFUDwz/QuPfh6rDAHnQeEPHP3CI51HDUhAQhQYn\n" +
                "Mv6ERUwcSQ8LENcDsQsS/obGr4WqwwpABh4E4nAk/AmNvxcaxMipmlBCugbEQfgsPYOUMsuhliLz\n" +
                "jyNZqofmI1w+BWWhZrS0QLZPs6AJDx3/QuNfg+rLw2YpyOWNBOIUFH/GSHrigTgZDX9D4++FOhgr\n" +
                "cCQy9Toi6XHDktC+ofGXo6UDOJBHC0ZcwQvDSmj6DaC+BgXhc2KLQVmoa4jF8lgsBeXJSUBsSsgy\n" +
                "AN3qgF2kXL4cAAAAAElFTkSuQmCC"))
            return"董事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAADgElEQVR42sWYf0TcYRzHv04ycyKT\n" +
                "mZnIZHJyzCTJjMncH5lIkjNnZDKZRCYz+2MkOWcykiSZyGSSM845Mycx+2MyE8nJmRkzM5MZt8/D\n" +
                "++Hts+f5rutKDy99n5/f7+f9fD6f57mC4N9yWbjnaB9Fn6s0Co+C0y0pIU71ONoOW64LyZP6uCah\n" +
                "LAxSW7fwRTjvmfNYeIHnIeHAQ5cywGLm3BF+eCg73jkizBM7Qo7qObTxmBEIPe/gjfDR0zdci6AJ\n" +
                "MCU8pfqukKa69lIjeHPIukb0ItXNR85C6DkhI9xFm/2ONTzXQ1hd2oWbRBbRYusPsYZ5viX0YE47\n" +
                "2cGYb9jw9MVrEbUirAorHlYxhsuM8ATGG4EaVP84PKbJ8b6vQhTPRtTnWKdXeIXnqEdUUyYh5mth\n" +
                "D+xj3QJE2sBaOhWsU7/hA+ZzW/Y4Qr8CQ3ylXonaAcHOwMA89RkxFjF+wrOeFtUatSV8JsNcorYp\n" +
                "T7VMQTBXXxvN12typNhycBqiLuLF5gO/IwVEEN5l5KNrEGYbYRgmajXhn8R4TQ7vcvUllaj/89Rj\n" +
                "E7VfuO2hX4kaAXncGGLwsCIONy59ENqkimcwqoK/exDV5jSbgxNIBb7wjzpS1CaiR7fHaF4nBGbb\n" +
                "ZrH53JYMOZxPNKdOklfZlBD1cAH4PPWTsIRNKuF5OUTUcxhbT6QoN1uyCH++OWgvzjs8fNdxMB/p\n" +
                "9I9Q2G2qPBSBt9pivOgPrlMvIXwvPNLwTfhF9emQ8K9DbtbhH9AYl6j76vpTcFyNSiTqDWygxm4m\n" +
                "t73HraDnqIIuIBcmEIY2b+3g2hQgFIw4LXTfXIB3JGCkznsrIe9kUUdJBHuaszBXjklUE/oDDubw\n" +
                "Xm7bwsHXfRRBz8KjmpWoAXJgM3ZrHMLvktDsxZ3k6YcVdRDh2k3GTMEgNtDmtlUcftaDx1SKGYZA\n" +
                "3GY2rJXem4FnMkVKP5ZSLeE/hl2yoZdzjJmA8QHCPQ0RZxA2Px33Op+oZnPeInUUkJd1GlpzzDOb\n" +
                "+5vSRAfGMe+w6bq9i9bpcly30o6rmM7FVZUBCGTKRXjtEoXPAn41sYfU4UR/IFwlI3PENm4D3DaK\n" +
                "fNVH4qSUh/BBZZmAV6/Td7puKBnHKW65pOxuwMYPwFPvn+Q/J1odOSd2iHmNCOMwWhzzYp6fh0wH\n" +
                "wnqIvDZZJS2OlLWMaJoJORCrKn8BUTRTmKI9dZkAAAAASUVORK5CYII="))
            return "总经理，董事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACsAAAAOCAYAAAC2POVFAAACPUlEQVR42sWVX2SVYRzHHzNHcsSR\n" +
                "JF2MyWR2l5kk3SXnYjKOYzKZMV0dk9jFJF3EZCZJzMwcSczMLmZipovM7H4XGZkuJhlJki5ifX98\n" +
                "3vl59j7vToz9+DjP8573eZ7fn+/ze0M4alfEg5znDf7Ls4p4HE7BLog9Meie3RTfxMXEmifiLeN7\n" +
                "4k+CG7xzSww5bM198TPBXt6hVZgUz9z8s5h28zirFkhHQQIsmA03HxWvCGBGvBAjPMv8WGJcwuEj\n" +
                "diAWxLsEC7zjbUo8ZVM7+Fz0/yOxQ8Vi2xdlxubsa/bpF8uMy0XOlgoyVIqc7cORM2JCrLv/7JB5\n" +
                "3h9P7Bc7uytWxJb4ynj1pJydp5S22Q+k0EaZTWezopcDt8WdY5z9bxnUxN0EtcjZNling/SQkQ0u\n" +
                "pbcBAjDJvMSBA353cXYFRzONV5HEiWl2wmUhk0Y5wSVIZfaTaBL8F8ZvUs5WyVSW/k3RHWWy5uYW\n" +
                "9V/a1iIB9ZNB47v47ebPC2TQjvZjGQT3zqHNobUq5Qj0wB3aU6DP2qGdrl/aumHWnY/2HCKA0MIF\n" +
                "a6Bx4z3SmHVczRadJQMdkbMBjdnz27ShUfpuJTrYsn7dVaZVZwdpWabxOkzSEeqOww/SQ6LJSrCW\n" +
                "s/E4mwbKPo1zU2jsF7e+lcxa0B+R0Ad0H8txKRVhnYPNLpPlpivBHF+pXqehdm74mLjmLteaY5vu\n" +
                "4J81uEwDTqPDnNfMuWAZqV4duqIS1GlLx1mFchbRmbOux33KU/T9A1cGuQIA/VG9AAAAAElFTkSu\n" +
                "QmCC"))
            return "副董事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACrUlEQVR42q2WT2TcURDHn1irhwgV\n" +
                "1UNFyaGHVRWqKqJqWVErKnrZQ+0hwqpYVb1URQ89lKpYe4hSkUPkkEtVVawSEauqSuQQVRUqVlRV\n" +
                "6aGHWBXamfj+2m/HvP3lpx0+9vfm/Zt5b2behvBH8iEuF4SpcDQZFhohm+jaI9QeybCfymWhmjZo\n" +
                "TNgS+uHQmumvCEtH3PC48CXFyBlhgdjBnkl7DToeM4M1FxzawvtIX4031tN/JuwJxX9wMrmZeo/+\n" +
                "c0KJaAn3qH0Xtuj3FWEcc5SyQ1NYjfRxhIQh4UCYRXte+CF08XtA36sYo4v8zEgZc2fh3EthF+gB\n" +
                "fxU2sIfy3ImKF9SvbGM+61reye5i8jI5Oe3cZImcZBlMyel+ahfMTSY8hA1eX4HmfzfrT8Nelq41\n" +
                "ooQTHsBJZnXyjvCqh5N60g+oXcX6Fs3Fd5G+qnEy7Sa7MWMKCMt8RidPYF4hkn8apmeMXm92xfAG\n" +
                "Bcfqz9K8UTg8ScwjPFmnY04Gx9Ad5MUlTGyjQq1TtWtFwvWp8NjRP4rc8iDWzRNTWIN1LRwsV2Z7\n" +
                "y+tOBHyk/D+UUyjBNVQ17ZzD4AqqVxvfFRyCFa2C+8Ix0vXhObkecXLPlPsN5ynokJNFRJdlCY6y\n" +
                "bgt2jycb3gAB4VHu8YTUI0VGHfps3iV17hP6/oeTo3TQzBNUada9RSHzLuQw7Ho52cBkT5qmbxNv\n" +
                "nieak7fxm1CDway7afK5CVuY18IHo+s4fvy+jQ4WzSFxizBc8+oWcmQfOZwz+cOUaBzrc9jrIlKD\n" +
                "2UQuWf2Y+Xdmn5eG8/TYXA4TeHS3EdtlVMtvKOsrOGFN+mtY4L6wiFKdhUXUgEmHplMlE4bMhQyg\n" +
                "glZwk/W0v2HJpldx2n0p48+b080qp2FgFoadqFvGBcyZPxt/yS+LYAPiutnbogAAAABJRU5ErkJg\n" +
                "gg=="))
            return "独立董事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACsAAAAOCAYAAAC2POVFAAAB/0lEQVR42rWVQUSDYRjHJ5MOiUw6\n" +
                "TCJJJtltMpmYyQ7pNh12SOwwSbol6dClQ7LDRHaaDpEkySdmpkMS0yFJIpkOHbqlw+xSz5v/x9Pj\n" +
                "+fZ+O/Tys33P+z7f+7zP+3+eLxDQxyIRZc9R2PyOBJH1sS5CFC1rgtKQJ0qMZ6LCniuw8TV5HKCk\n" +
                "cEU8eszl2L5J4sMjyH6iTBzLiUk4ujjEJnteJ07xf5ZIwceQVigQFx5zUR/BLhHvxAkxoJ1kA0Fe\n" +
                "Eq/gDS+rYXPDmSKJczZvuIc/tznKnjzYbtyWucEnHMxTO0mFHQSizUWY/6eSGanFZptg+4gvok4s\n" +
                "2ISexcslRqsPHnNZEawts01LZoc6KOBAL3EkuMG1SPsE85tC4POMIq6d28yaQfiYwvnukD83FSKq\n" +
                "0I6L0ea+sDnICO8kMutV5UZeFB3KAssiQdYRQkHxNlNTWlCDBTsDfUrKCJjb7tAlUm2C7cJ+uf8I\n" +
                "1kggo3CArsJttyjYaUvrikHfSZtm1/DrksPG3LZCjDG/AjLJuUb74baGDxmME2EcrgWJqSOGxs+p\n" +
                "Q2vSHmd+caWt7Sktz1Gy5QabwHyLfTTSmDPymeNOYVG5LgWlql1kq+lDgWSQ2WUfdbKKSjdBbSlf\n" +
                "qxCKswUJ/Y5hbNQJI+LFpjgO0dp2IRnbGCW2iR7LOtPygj81EMiFCWOxNQAAAABJRU5ErkJggg=="))
            return "董事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACsAAAAOCAYAAAC2POVFAAACAUlEQVR42rWVT0TDYRjHZyYdZiTp\n" +
                "kG4dkqTbJDMxHXaYdJlJMrHDJB2iQ4cOXXZIJhPTaTpEkiTTJUkmkR2STGR2SIfdpsNM1PPyfXl6\n" +
                "et/f77fo4WOv99/zfZ89z/Pz+f7HosSih31jRMFlT8B2uWaBWCJaFt5wLk0cGLghni1rGeY3RjQt\n" +
                "IvuIEnEsFzJ4YZsoEnlimb06Tpxi3APByiawJlHnLyxrkx7EKt/vxAkxYAu5OhhkB/YhLkGcYRxk\n" +
                "YrWdQ5zmkaiLubLBHxer7s4SL0QND3M0KVY7vMdLtVMptmWIjMzFtoPYEPFBPBApr4UhxbqlARfr\n" +
                "Ftm2S2SHvYrcg8Mv/NYhVufdFlHBOCHETqEo5xgF/AN8Tu0ZxJkSfHVDwS2yNVx8RTQwPhRis7iI\n" +
                "o/Y/iblXQx7KAlMPuvtLGqj+1mtIAx/bM4NHSfQD+VwVXWLWQawfLS/TrdhV1hsvkRq8X44iBZIG\n" +
                "ijjD51SR5oiIS+sKI79jXsSm0LIizFEOzrhznX95RJJTYSmkaXhIAxWAIdzfQYr9snXilvgkrolN\n" +
                "sS7TgNs0nHJ20Xv5XNkQLS02ivUO+2jEsVZFUf/oi/MsR9MiKrzANBvCcQgFkkRkVzyk3RoqvYmO\n" +
                "I79W/SjODv5do41bPpWcsDjjR6c4InZY7jvZCLHNgmQzlXKBb0CfwRWheTMwAAAAAElFTkSuQmCC"))
            return "理事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACqElEQVR42r2WUYSUURTHx1irh8RK\n" +
                "kqzoIVlj7dsaayWykmRfMg9ZSezDyDysXpL00EvWWvMwljWStTIkSdaItVZW1rL2IUkiWaOHLMk+\n" +
                "jQx1Tn43Z447830zDx1+Zu65937f/d97zrlfJtNui8IR0x4Qqpl0dkWYyPRnt4Qx0x7Dl9YuCDNp\n" +
                "Bx8IR017UGilmHdC+C4UaK90QTeuyOYFPgvrpr2Oz44pIrwa4a3wsUPfbBqRzQSBOn5HWDa+Qhey\n" +
                "wqhwyVAXHpj2PeEl/y8LU8wZJWI8ZWGtQ9+/CFlFzG9+n4P1NU1fsOPCO+EV7VM9hNh9xL0RvkKD\n" +
                "jd5k0Ws824fua9OvvGe+9dXThOsAIg45UeU6OxzsEaJ17G1hN6XAEXeSgccIiPWNmPmH7nn67orz\n" +
                "NdPmZE74YdrTTuSQOcEDCk+JF3aiRJGI9WkufujQN+NEJp1kV5G6Y+Psqi5o24msuTlZwusZ7ZjI\n" +
                "FmEXRIZcrjm2KTjenzPvyyN42lAhPK1Px5z0JfgJ6rVK3mUx2t5KEFkjbytdwlOfM+l8mgobJhUG\n" +
                "yb0l56sTrsGKkU3ciETAFwpPWxF4SBjYcF0yQocjIheEPfKyH5ENV+43I1fBvhF5kfzzrCDU+vao\n" +
                "ulNJOamhcxUBWuKvkZNZ7sY8i63+J5H5DtfSMlXa+nZIucluIlXQNwTZrxoNn/MsMFg/IvU9c/wG\n" +
                "Zlmw9WnanDPzypEPDL3GPjnfvg9XL3KIQSXXr+J+cpW86EFkK/LJN05UWHbJJe+3cyci18ti5Orx\n" +
                "ufx3l28IvwjDLUInZg1OuJQgUqvtU17WoogEO+0qYaAcqZKBYff8Y1TQAid5J+lyvskRz9GeN3eg\n" +
                "txwCB4yvRNWzNo/wMrlk7QwL7IWzkatrlUK44GpJm/0B+H4BqS3ysBwAAAAASUVORK5CYII="))
            return"执行董事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACqUlEQVR42q2WT2RcURSHn4qoGiGq\n" +
                "KroYKqqqomQRVV2UqhijqpsRMSpCRBZdVBhdx2yrYoQaNUZUqOgiopsR0UV0E1WzqAhVNUZVNjWL\n" +
                "qDFMz+W7HCf39d1FLp+57/6b+3vnd+59SXK23BJWAu3LwlQSVyaFauTYZ8JN9bwu3KY+GrnGEkSX\n" +
                "K8Jv4Ylqc+L+CDcC4yeE+4ZZ4ZQ/tn1a0AXhRLin2npCQZgRfgrTqm9ceBhgB0J9l/1kF7ktxZGw\n" +
                "p55/CMdmzHPmLgodYTeSitp0WfhqXtoJIn2/e1lF9bI/BPgOob5pHalCABe9lyl9d5TIJvUHwsdA\n" +
                "tHsp1mszX5cD4yJXv5bhvhpEFRvqAdaz7SNqjtvkO6L0mUjY6A0Qv6scMC8MVdScda+yxmvcVcc1\n" +
                "Lc4EVxq8NE0fbHsjJHKYEnKNWyxnRDZpc7bap675S264+kV+O6xVIBX6OKdLutTJ6afCI+HSeUVy\n" +
                "GDGmlyLSO6HDBjUDY9c6B0UXkbqvQvTSTtF6gG8Q6lsKicw6OGwkna3eqtyukUf7qr5tLN7Aml1l\n" +
                "V52D7RSRd4WS4T1OOQz0lZhzRmQuAxtJJ2RDyJvFPwlvTFve/F9I5BiRH4twVYk18twA/n69zu1Q\n" +
                "TbNrKYNTI3KLo75MbnmbHCPUPx8xJkukK1+EBXOf6uLs/Yr9+nu3iGWrrLtK/gdF1jKwdm2z0bLK\n" +
                "zYT6osnDWJEvOGV9mVMn5Rx34nbAVWtYd+o8D55JRI/8R+QE4/e4NmJEuvG/1KGxgfXXcERRfTjk\n" +
                "uEf9fV5BaI2vpqDIXgZDJXJTHTrzqq5FLrOZlv7EyhDpPyz6CHSCHxvbjiPmgN9NXnqChZvMX7UL\n" +
                "tyIiuaO8vkKSp91d5Yy1DhGTVmaw5Xqgb5S+hbTc8yf6P7u8+XDAlWulAAAAAElFTkSuQmCC\n" +
                "base64"))
            return "首席代表";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAOCAYAAADT0Rc6AAABoUlEQVR42r2UT0REURTGr5G0eCJJ\n" +
                "WkWrFrNLxshom1m0mM1IRkak1WgRLUbSLmmRJDIyRtImaTFGJC3Sov0s0ma0GEkkSVrE9J18L2fu\n" +
                "vDtv2nT5effdd+89/77zjGkefWDV/PNYA0ecz4JPBxPcMwkyCjkzB94c1E1AlE9gOMSpG/W+AHbp\n" +
                "yD7YBvNck5EEp5x303DT2ALr/CgX9Frfl8E9GAhw5hl4nIvRPd4zDc4492yjMV7YA/LgUn2TzUXQ\n" +
                "ACuODNhGa6AMbsEj5xXbaJEpksVXpjjC9EkdCmCcB6tgKsRoR+mNEIlwEUTpodQvYRlI0REpxQ4v\n" +
                "avBZo9EyDfoaSDLVLTXNK6/8lHsOhogr0jtQYhAPnB/aRsWLL7bLCTjmWp28gA/1vtkmvV3Uhp1e\n" +
                "o/b89tsByHJjv3Vpho6YDoSUowaEc6a8oBgNukBqG+fzL0Zn2CqigTTZoILTikH/UJx9KjV4p0o7\n" +
                "iVR695qluaIu9LDT26LIJTCmRHShqFLNei1H0aRUDbMUTSlASD6uXv/5JSZCGAk4F2V07Yh9A2Qg\n" +
                "g+AVrBiLAAAAAElFTkSuQmCC"))
            return "经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACk0lEQVR42rWWQWRcURSGn4roYoSI\n" +
                "6qKqVESMitlVRUSJqCxidhExiwgjYlR1U1XVRZUsqkY9pSIisggREREjjIgsIsLoIqqqVEXULGYX\n" +
                "XTxPaM+p/9bpce6dN6WXz9x37rtzz3/vOee+KOq8dREznrFZoiCeC7BlbaNEKcN7eSLO4OdfbYW4\n" +
                "CPBWvJsjEvQXiCXBF6IunuuwyXcWIHzJ4JD45BkrCx/GiJZHXC+xSmz8wwFGW0RRiRzCgo4a8Vw8\n" +
                "P8U87j8gxjGHmTCoEruesUIGkXNEk9gkrlkiFvHCd0ETdp9Ibs8gbo/4Bs7hxAGcZraN0N0R48wp\n" +
                "5ktbzfBViuxGdHDEfMaGeFuMndA7EwdE5tVJOhYhwBrLi/+/CKznWhIQ2UP8IBrEdJZwjJETOkdC\n" +
                "IksY13AufvSMlZTIdieZtDnJm53kHC9eUXlQEU75wpWf1xXHCB9tvyPm3cN/FwUxwlPa+J3rmMMF\n" +
                "5WeH/ImMq/gDH7mAyD5iH7nh4Nx7p2w1nEAkKrM+5X0jAr4aeaYLTwkbG2w5hI7Lm1T0GxASEnmu\n" +
                "wvzAuArOhMj7yD/NKoRK2wdU3fGAyCtYr5xF5AhIRf/kP4jkUJ0yeI8qLW0nKGQjba6Qu/BrLCQy\n" +
                "EblzKfpNCBnC3WPl5GP8OspwWNoeEgNiXtVIiyNcA9J2liFcB4kb2JQUqWCKbHnKdh0i5RdFonZw\n" +
                "S9FALmn7sJg3bFwvb4yrp2acjhM5ivFUfCxMYIzDfNI6SVe2L0W/BZFPUAj2ICDC7hUNqkaVdOiS\n" +
                "34PCMYWTrGS4CR6hcrJvL4yvmz74moqPmd/VdV1VQ8crbMI8sYz8crt2Cw52wm3lEBeNNaz/Gmu1\n" +
                "a/3ES/gdanz1dP0CG38SpdFXf2kAAAAASUVORK5CYII="))
            return "总经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEcAAAAOCAYAAAB95wG7AAAC9UlEQVR42q2XT2RcURTGnxgR8WRT\n" +
                "VVE1RBfVxSiVRVTVUCNGVJQaFW9RQ8SoqmwiiyxLVVUXo0TMYkQMNbKoGGVEVFV1UxVVFaqqi6hS\n" +
                "8VSNGNpz63t8Pb33/cnk8DP3nffue/d+955zz3ie3eaFSbpeEia89HZFCLzsNi2UMvbJCcvCqSN8\n" +
                "76xwL82Di8JltFtCBe3Twk/Bt/S5JaxZeCF8cNybd3z/mvBd2FcLk8Y2MeY4G8f8GLMYvzAmfe8c\n" +
                "d26SICzOA+ErfExNKAhlC4+FLce9C5aBlyDMFJ75Jlx0TPKEBSNmQzhpuRdZFfPYSslSkjh54QCr\n" +
                "qidZoL7P1It3hc/K13FMNsA3iuS7KYTCDfWsDxE1PWC7N0ziNNEuOsYT0vNekjhdYQUiPRfOOCYY\n" +
                "qmszkLry9dT1GFZ737FLzAL8ENrIDXEWhWycmTFtYKFeQzi9W/oQzbTvxImzjAeH4LuLwRYd4iTt\n" +
                "HBZnDqJ0EYKbDp7QoB8egzhN7L4ZYQdtpodQNO0R7mxWetaSc9hmELej5JtCaMwSdQjLvoBOlOuU\n" +
                "mCcdualMiXk6IUlnEcfYVcxDHxZ9V1h5uDEMEc7TNTOm+tQgBrMtvFe+T5jwoGYm8Tsla2qcDbQL\n" +
                "tBl2qN1GafCf+XhhlMji2j4ltqqFJgRi31uEUAmEGSkNuHPqCNM8oiLClB2rype3iRM6EmhP5Ref\n" +
                "QqpiYRUJnH1vhPuoIXIq1icgfMWSByJyA4rTQmgb9qjPHgSKrj/aCtijiONhNzQVr/AR9n1xhFUO\n" +
                "W3uFfAsoD0YyhFqSOLv4fkC5JzqIqupdxybOJSQ45hEmx74OfrU9pVzAgnXoRBlUHFMKHOK9LnHG\n" +
                "8a1tnKb//HVo4wVRBdx3tA/x7KKlbgkQGmbn3E6YkEnu75DDOthpByjne2ibhXhJp+M6FXxpWQcN\n" +
                "KiMaFnEWENpdVVn/LcLKGdGF2xAG0UJNkmbF53BKlHCCjFJd5SGs2jg5B7FazB/nuutP8h/afy6i\n" +
                "I8pTTAAAAABJRU5ErkJggg=="))
            return "监事会主席";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAADaElEQVR42s2XbWRbURjHIyr2ocpM\n" +
                "xdSUmpmoCTMRETWqJh9q+qVqYqLE1NTMqJmZ2peYmpgYUVNVU6pqamJExExNqX6YmBpTUVVTZmom\n" +
                "YnTPw//weJz7ktt1dvjJvefck3vO/zxvNxSytxwRF/dx9PltQ0TWx3MxouTxTJfH+Fniceg/bFPE\n" +
                "vOALURX3VfTJZ6Yg9LyF98Rnh7G8eO8wcegi1iKx4rH2J8RrXN8iWg6k1IEbeM5t4siB/aCiXsEG\n" +
                "DRWcvrl/SKzh+gYxgjlMxkKReOswFvch6iRxQKwSvR5W+o3o9xB9Q9zn4R0sdBlrnRQek8FeuUUg\n" +
                "bOD2CGK+I3bBHjZdh0jMG0soWBfjzCfMl30VyzulqBFYP3vEDjbn1eaIWcxlgXrU+AP8n+1g+L3d\n" +
                "4hBf4n9GsccIxgOLGlOWaihAMNtYTMw/sliajpUtF1FZjJ/EFjHhc80JCHYGBlETYyzGAnFMzDjM\n" +
                "16IaI9iElxhDCCxqFiJoOJY2HMaySlQvS215WOqFDte8gP/kd/9ACAjDvfcRv69BmAbClpuop+L+\n" +
                "/IJlxUdYg+4fFPOSEPimoITNyD5+Joo5i7CiTtCWHwZsoXewpgPEz7R6dgxCc6h4AaGO8bsLUU0O\n" +
                "MDE4g1BwIlHPYYERQU7EGkMFFiYrB23FNYuFf7XESZ2osjjITvLAmgoJ3Q6cB06WuoPD5rU3cb30\n" +
                "N0TdU+VP3VIaNYWo17EgjVmc7NtGph1xETWM9+V9rJet6DfKqVV40CgskvlO/BL3z1zcvwuxWbt/\n" +
                "SDzzz0Rl1x+3UEYVIfs2kfjSHiVVArFy2McHxit4Uwbr13li2WW+FHVa7M9UP3LPl08SU+8rl8lD\n" +
                "INnHC7gk5hVhmZIN4U6Gpg/358X34RDaCC26rSAB6fiaxG8nok4gvKXF4RdgANIgokFFTcDsJVuI\n" +
                "hbo/JealLOXWc0spVrFYnxF1CONt8XGQwdg23DqEDN+GqyZRp9ZQjlV8WirXrh8QOuqIy7Jp9w/c\n" +
                "+lSmNhQtWdygS6AebGQclnrXx3vvIQsfIuv2WkJSCUIWYFnrIqPz/KvCKKqCBqoB2TeN+D4mYmhO\n" +
                "eZRMVIaZIKL2q+9hPwxYXHAJ1jHnM8BfJJ6KDTq1KJJJGd/qTp+saQ8GLPMGHT6nJYlOxPwDGOdQ\n" +
                "ciMjx6cAAAAASUVORK5CYII="))
            return "董事长,经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEcAAAAOCAYAAAB95wG7AAAC70lEQVR42s2Xf2TUYRzHvyanP2Yk\n" +
                "mSRjfyQzOZJzzklkcn9M9s9MTk5MJpPEJEn/TSYnE2dmZjKSk+TEmZNMRvojJ4nMmZlEkmQS6/Ph\n" +
                "/fD28Tzf231X6eHlvt/n+T73fJ738/nx/UaRv5WENN2n0bfbdlooRp21A8Kt6D9sE8Ic8UGo030d\n" +
                "ffzMBASb8/BCeBcYGw/YcFt4iOsLwnaAnDkAh865KHwLsJlUnBPCWaKGU3T3N4Qqrs8JQ5ijFDyU\n" +
                "hWeBsXTAaz4JfTE2qnirdK8iz0KwCta8hL4Ia1VxnYJAidtNiPJcWAcbwmehgc0qTzwh9pTGlbeY\n" +
                "z321mLVnhDvYhG60x4xfh+ce8sxV+7pxreI8wP8Mw9YUxhOLM2A8xzGNjfvGBmi+XZhP0LXtwNoZ\n" +
                "bHw/DmiFxnRTC8KOMBWYb8Vxh7ImbNHBJBaniM1YNNc0A2NFI047zwmJs4Ax/Y+vCK0uhM0m8tQp\n" +
                "bLCJsI4T56+ElS6wbHiFU7X9gzQvC6HOE7PYDPfpM72edbuAesxl/PcW8kvePDsCwTQE72PDO/hd\n" +
                "hzgu17kcVUCI7UmcgzAwRZQohh01hBVXOutVKx6P+whDQ/muakKtO8BhEPKc98IibGjheulPiLNh\n" +
                "ym7DU5JbJM4ZGGRxxnHfG1SUIbOunuovlPHH8MxheIjyRfhB93djwmofcpcNq4ie+WfiaEiNeqig\n" +
                "6nHfGhJ83vPCOA8vLcAOmw+XY+xmcSbJTld12fbje8k514wLj2Oj3KcGHKN5ZXgKs0ru7WiZsHqE\n" +
                "RGvzTxa/nYgzhvDP02FM40D4gHqTipOBGzKvkStsf47m5Txl/p7nFYBzlVaknwiBLN5zNAy/e96H\n" +
                "QuLou89LhGQDeYubDavE7YipLI6yp+o4jpr/6MFGRuE5V2LWG4N4rgJdFU7SIdWJJqoX900ij41Q\n" +
                "jikZT+WE7JhKIk6f+U7ZDf2ekFjCKc+0SYAVfAuFPkDzbej3zBsMfK4wmU5E+Q1IaB5217FU+QAA\n" +
                "AABJRU5ErkJggg=="))
            return "董事，经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAADg0lEQVR42s2XcWSUYRzHX2dOcsZk\n" +
                "JslxMpmTkTlzJpHJ/TEZMycnE5PJyYyTSfojTmZOJs7MZDImk2TizCQzI/2RScbMmUkiSWYS6/fw\n" +
                "ffj6eZ53t9uVHj7ufZ7nfe59nu/7+32f5w0CdxkSOqneibZayyUhFxy9nBNuOdrz6HOVFuFe8B+W\n" +
                "EWGa2BQqVK+gje8ZgdDTDt4IHz19wyHzaBV2hSy19QhfhDbPmPvCM1xfF/Y9pNULt5gxN4QfHnbr\n" +
                "FfWCcIVYwtu39bvCIq6vCr0YY8g4KAmvPH2dnjnY/qLwkOpbwiTVdZQaweMhazOir1LdvNQpCF3G\n" +
                "XG+izc5jEddRCFt3GYeYr4VtsCN8FVYgkuGFwwpeUr/hA8Zz29Ihzz8QFoR5Dwu4h8uE8ACLNwI1\n" +
                "q/4xZFir43lmXTFcG1Gf4H/6sMYo+usWtUNFqqUIwVx9HTReP5jfvC37NYgaDemPKlFTEOwEAmKZ\n" +
                "+owYs7i/4Pk/LaoNgnXhMwVC3aLmIILGeOmGpy+nRD0sUhst6iz+0zz7OywggvTehX93QZgN2FaY\n" +
                "qH8l/WOOlFtDNOj2JI3rhsDXiCkshttyIZuNFXVAjWEGlKgRsIwTQxIRtorNjUs/hDZW8RhCHeB3\n" +
                "G6LaPcB6cAZWcCxRT2GCUWKIvMayhPTnk4OO4mVHhG85Nprjeuo4RZW1hJiH08AXqZ+Ep5h7Fddz\n" +
                "jRB1Rx1/VhxHoyqJehkT0tjJcdt77LS9Ibt/hNJuTfl2BNFqi4mi3zhOPYfwfYhIwzdhj+qPQtK/\n" +
                "Cd6s0z+ge/6ZqCb1Bx2UcYrgtnVsfD2OZ8/ACzNIQ+vzmzg2BbAOI06CzpszyKYM5q/3ifmQ9bKo\n" +
                "eVqfPf3wms8fx1NHVcoMQyBuMxNop3ElRCazSulkqar0X8BGchIRFVeiBvDAOKJ7DPPZIqE5irsp\n" +
                "0msVNQt766GXX0QAcEC01StqCmHPvMMidHuaxqUdx61Jx1GMvdgI9QspN4rosKlXccytgMUHSPdJ\n" +
                "iDgBm/npOAf7RDUv5y2sYwW+rG1osRGfqWc8O27JsYtbzqr/aMZCBhGpt0Oel4XoAe7vpnnsIbJt\n" +
                "6s3gq6mLMqoJO/od4SIFRYXYwGmA2/Lw937y0CGVUbxRWQr1iBpX38O1kHCk4ByiY+IQgy/jm9tV\n" +
                "2h0enaxhDS1I4zASjnFJz+c0kzqKmH8AbR9TmDmp0gIAAAAASUVORK5CYII="))
            return "董事，总经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAACQklEQVR42s2YT0TDYRjHf5J0yMhk\n" +
                "h0kkySS7ZJIkJtkh3WayQ2KHSdItSYcuHZIdJtIpHSJJkomZ6ZDEdEiSSKZDh27pMLvU8/J9eTze\n" +
                "32r7rX6/h4/1e97f2/O+z/s+fzbLMsscEWbPYeh+K+NE0mpM/st2iMj+8E6r5UDSxB7jiciz5zx0\n" +
                "/J00Nrtn4JJ4sBlLecR2lHi38UcnsU8cOXHqEIxocsQae14hTvD3FDGJOYqYgQxxbjMW9ohtO6fO\n" +
                "E2/EMdFlOZRVbOiCeAGvMFzEQhWnhnA8Y+OKO8znupzHbHOntuH2q4h4xAE4lpC4LZpNLNo0FmLz\n" +
                "PwynLfNVxWO2tVN9xCdRIhJWEyWJhUhUPru3GUuKjf10Wyoes81varf1R9JBHAquERJSP8jmjWCT\n" +
                "M4wsQo7r1DsBD9hWBeirTrKNOtVPFJBfNCp/7QhdDqfMq7e8SQXDLXuukavcsC0LVRIH2VTxozjw\n" +
                "FqRoaE/KbGMTyGGSfWyO625RmSc9Yls6tQX2Um47VYVf3MAuKjnX3aD4jHnEtqmliiD/RpuZU5fx\n" +
                "qUlhkVy3SPSzeRncDs4VWhOuK4sQVI31sEu2TU4dIII4hCpSi2OJoMnmlJCPpH6UzRs1tDzbhnaI\n" +
                "58MeLLzdBdvSqeMYr7IvBzGMqbQx3ahDg6JaajKGSqqRbYgPyT6O27JQw14CG3fDtpYlVHblvHXD\n" +
                "tyc/ilwVqaNu6cGi6qFX/A+V6A/Q9mwhXO1EhfWsS7a19BEbLFrsJFDvDyvfQkljG8ClWhwAAAAA\n" +
                "SUVORK5CYII="))
            return "董事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACsAAAAOCAYAAAC2POVFAAAB7UlEQVR42q2WT0TDYRjHf2YmmZGk\n" +
                "QybSIR0mJkkyYzrMZLfp0CGxw3SYXdIhHbokSYdd0mk6RHZKJtKhQxLZIUkiSYcOI5kOM1Hf33zH\n" +
                "09v7bu/Yy4d3z/u+v/f7Pp4/cxz9SINJ8XsVjDj2IwIWLfaNg3ybPV6dMQdmOT8CKc6HwBfwa84s\n" +
                "gQMNl+DBsJYW52OgYhDZBwrgWLdYEAKl2G3wRpskA0IgrmEPnBrWJizELoN3UAQDtmKHwSeY11wa\n" +
                "EmdPKK7JHXhRbCXNnVKsjw54Ao+8wzh0Ys/BOkWfgaDhbFXjGTUWay3EBhhqt2DBJilUsWv0hoe2\n" +
                "LPgAUYPYdp6ttfFssIMEbngiqYlZORKM315hm2bmJwV5PlTa3D2DwjE/HfKvavhIgmXFpyGgnMnw\n" +
                "Q5ILcK/YnjVxqCaY+6BrG8/6+YIKaTVvlrEo41OlQMHSVmaVmGsh1sOSl7YRWzUkRE2JT78IgZSG\n" +
                "fSaktN2ALVHLTaVrivfFui3WobcKClcsP9L2ahEGY2xC7uPqDLGuip3hpZJd1l5pK2m81RQb4Xpd\n" +
                "NI0418qs839abZGbmx3q2zCvc29OuTjABEnRsysWeZIV+bCh6Vb9TM46Q6gxwobW2Iqw8mE3OQ75\n" +
                "oB3Dfwl1jIJN0NNmn1vyvL+9Ore2AREpTQAAAABJRU5ErkJggg=="))
            return "监事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAAEC0lEQVR42r2YcUScYRzHXzknk8hk\n" +
                "MnNkJjkTk5NkYjL3RyaSzEkikzmTyJzM/hhnTjInkiRJZDKZjHPOzElMf0xm4uTkTCIzk/tjtN/L\n" +
                "95nv/fY819myh4973+d5n+d9nu/z+/2e33ueZy+jQgfdd6Cu1nJXiNX47C1hWNU1CFMX9LspPLLU\n" +
                "x9FmK03CjPefyoSwSBwIGbrPoI6fmYDQixbeC58dbeNCQAiCkHAitFHdsvCa7oPow6VZKKkN6RGO\n" +
                "hWuOdT4T1nD9UCg76FbGYfD7jAjfHZT4ZbeFe8Q2dtTcPxU2cX1f6EMfn6iFOeGto823+gQ2ylAU\n" +
                "9nG9B2EyigTN14yVFF7QfUGYpXttpcfYRK+K6Hm69w0gDaEXsK4x1Jl5bOI6CGErSgJivhMOwRGs\n" +
                "KAeRfN5YQsEWtft8Qn+u266ymDSFC56oq5wLG8K6gw08wyUlPMfifYEaVfsUvLHZ8r4ThCQPos5j\n" +
                "nH7oEUR7hajtylINSQhma2un/nqHeDdNKav7ebiLz5lwiutT3JcIm6jBKqIHlagRCFYP48mq+L2M\n" +
                "56cd42lRjcHsCl/JaCp0iEEETQZuaWuLKVEvstTyX1pq+RJEXcY4/jy/IQTUwb1LiPWdEGYfIa6a\n" +
                "qDW7f4PFjXaww7o+TP26IMgDIo0Jcl2MDpA4JmPwY+FHXOexUNP2E7/TStRBNT4zqEStA1lkDGFY\n" +
                "WB6HG5cBvN8PFa8g1Dl+DyGqOS9MDI4iFPwh6lW8lE/cUYofhm24P2cO2oqzFgsv0OFRj000LMBq\n" +
                "GrCoLWor47f+H2NqQnlARM2BaQEuS/0irGCdRVyvukQ9UulPzpIaFUnUXrxEY17IdXs4PfvUyZqm\n" +
                "kz8NKyhQm839o7A843Y7KsbXwVpN6YfFryFVW0ddyRHHX1Zx/wBtsA5VDZchqu/6QxYWkEVw3S4O\n" +
                "PuNudzCpEQiXIpc6p9RoQ81zCRsSxQaYM+EAaZOHMOOL00r55hI8L4q16jNlvUqMZlHjpIXJlFif\n" +
                "Nh1TJ5UbjEMgrovjK8iUOVgmkycXMRQtuWMLYmleHVQ5bMKYev4KLCqkRPUQA0PwhCnMvUBCsxV3\n" +
                "kaXXKuowQmEPGUoS82TjqfjwiKjDYxMLLljqu6lftyXdmrWkYjoW98C6eh2nfxMsIUvWPYk681zG\n" +
                "IsA0Fu/B3WchYgpj/bDkzC5R/c35gNCRUx8gF+bU1x2n6JzlFDfcUGM0YnJDsLzHVXZ+BoK21ZBS\n" +
                "jSMsJTB2F835DF5gXG8JX02d5H0BHH5PEHKMAfHX2j6yAa6Lw1MGKIaOKu/jg8rwO0sJqW/cWmi1\n" +
                "uNUqdjxlC9pUQnBlU5IQzIM1r1jGDjj+jNHxPFzDfx1NsP5qtFr6hR2f3kzkF9n7lseFpaXKAAAA\n" +
                "AElFTkSuQmCC"))
            return "董事兼总经理";

        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAAD90lEQVR42r2Yf2SVURjHr2uuyYzJ\n" +
                "TJKYJElGMjNXxiT3j8n+mWQy48rkmoxkkvTPlZnJNWYyMzMmV5Ir5rqSyZj9kcmMmZkrGZNJZqLO\n" +
                "4XPy9HTOe9+SDl/3fc95z3vO+T7f58d7Ewl/GzBoE/dt9MVtVwz6Yzx33qBQ45m6QP9Zgxuqr8Fg\n" +
                "JOJdTQYPEv+pDRlMC2waLIn7JfrkM0MQPe3BG4MPgbGsWLfbYC+CgFmDRUVwCpxm7jnRN2PwXNyn\n" +
                "lFEeGsxzfdPgMIBOJQ4HO+eWwUEAVXmAixzQoYRF3f19gyLX1wyuMsci48GEwavAWFsMUgcNPkJQ\n" +
                "s+gfxcAOOwbrXK8ZfFLjS8xxRvqEMULNkr4s7rN4kiV6inMNCu/KwEsCAx7oF45C5muDbbDLoSuQ\n" +
                "ZPHCEwpeinGL98yXfSXPISSpKdRvPWKDDddqBRFm5AF9bczgEetYghrV+AhrN3vm7hFanMEneU8P\n" +
                "fKQYP9CxrduDPIT5xs6L+QcepelYeRhBqj3gF4NVT5zUbRI3s/hqsM/1PvdVAdfaIawe8ZRVHLZh\n" +
                "47vBvcCamlQnmBU8yonmFx76IUFjCffyjfUrUmsp9bCGUk/9RS6IUqpcb4Z7u8/PhIAk7l0l1l+G\n" +
                "mHVCXBSpsd3fTlpQeIeFdf8FMa+Dg10XKLBB2WefaWHOLMr4E9h35jiEwxbqLhILq2LsG7/3IDCJ\n" +
                "Qm+z/4/MSSseenmPDRVPIeo7v9uQ6vKFi8EZQsFvpB5nUZk5B0T8cCihMFk5aBWXPQrf8sRJnaj6\n" +
                "MWSo1WN8hynU1gAZL8XYIb/1ImcUVUhoCOAECCl1A2GUSZb2ei5E6q4qfyqe0mhHkNrFIhpuQdm3\n" +
                "Rva8GkFqkvWyEcRmhaFc5i+gni0xJt2/B+XOU1Es0FcNxOMnEe5fJwylQ07DvyDVun6fB1NUEbJv\n" +
                "hcSXrlFStUNId4DUSxzmFs+NCVe0bjrO/aL6GHmG52U4q84pCxGGlKTmBBeuUpL8nNMx9a5ygywE\n" +
                "yb4cXzOuTaBMiWXhIg47MdzfbugkRjgitPjaCWLpskpUFYw3GEFQEjEk/5DUG4TCtBBKnvWkeFq0\n" +
                "QooKq7iU7u8U8zo95da4pxQredTnSL3C+JH4OMgwtoarupYmeXYFsn8TCioLr+hA0WVKt1JMpdra\n" +
                "9S2hoyI+JBJxauOTKlM7THiyuIMugRrZXB8KuhOjJBrGZfdw32ZPSCpAdp6vvE3hYlElVZZwNkoS\n" +
                "GyZ0OAHJr651qgHZl0PxvSKGDijvk4nK4Wete1p948ZBq8et5rD4mC9oe9oZg8di06HWQoKw+zwm\n" +
                "+vMY0al+1rOnusD/CukaaPXMuxD49JZo/wH0+ZOhWqB0QAAAAABJRU5ErkJggg=="))
            return "董事长兼经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACxUlEQVR42r2WX2RbURzHr4iYiRE1\n" +
                "NXsoNTNTM6aqpvYyM3moKRFVNVWqDxMzIw8104dSUzVTY6aiZkJN7KGmVE1NTdljH6bM7CFiwkzN\n" +
                "TIXtd/hcvjnuvUkfusOHc07uPff3/f07CYLjj7QxEbF/wZiN2C/xW9TIGY+C/zQqxmECz+TZrPEn\n" +
                "4oyzRt0Yl70R47vRG/Pdx8Zr5hOcG8V1nrlhTArunbsJdteP64iacSdGZB4WjQVZfzGWZe1H0Tmg\n" +
                "L+Gbzgm7sp4xVvj+C+OpMc1eaEeNeQahbcMZ2EB9SIP9TiL/GutGNYZ1ntGxZMxjjDP4jPf7Q+OA\n" +
                "DPFHEzsCRD7nnFHjLfNslMgVXtChXuokMpMQkYwncggBp4w5Y9srhwrPl2PO80V+NTaMPQLj5u/i\n" +
                "RO4YL4WdExJZ4QxnxE9SNkU61vn2IIbuG7c7iOw6XV0h35P6ybOe7FJkgd+jKHgiU7BNRx4gArs0\n" +
                "Kx1jCJ+nAR5y1iERnCZyeanhPKnbJtKlzVoC2ROoyTnxepjC2RjOQVwkP2Onc9o35q98kWGR3oQj\n" +
                "mX8yerrorilJk4/GZS9yBVk7L7e4Pt7giFFpeD+M37J+kpCuaYLkp2sgz7SJHIEjme91ELlKLeVJ\n" +
                "mzD1D7gmAu5JZ2y/3HfuvSne64konWpCjavIkvSQTVJY+8ol/4IP06sl8wZGXKGdq8jTeLzPExlQ\n" +
                "Q27/FtfBDPdmzjPYRXlYMqFbkeNcHS4QRVgkKEWhV0U25RCN1Jbn6Zz8/gDvhamyFWFQGWMC0nMZ\n" +
                "UUvU0C+6aDeRdM76QBDeU9d+2dTiPBNGZwNaMm8iskyr3iQiAZ4aZn6eqK5Jqqzyr2ZQvpOmY943\n" +
                "rknT2RL2ySDdK9FkxqQGp7wGqY0npKzdtUrT8FnAuFmMdsZfjXHWRS9VilwPnUZOekAc/RHvDXhX\n" +
                "XhRD/wB5SwMiRVOUpAAAAABJRU5ErkJggg=="))
            return "副总经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACg0lEQVR42rWXQWScQRTHR0SsWqGH\n" +
                "6qFWyaGihypRqyKixB6qokJEVFWUVTlUDyGicqheqodaVbmsHKJiiYiIiBA5VA97yaGqclh66KGq\n" +
                "QtUe6hNL+qZ+H5PJ++abrfbxY/b73nwz/5k3780ac9puCFWTbVV8NHsoXPKeTQvDJt4GhVHzn21K\n" +
                "aATeN/DxrV84Fga853XEx9qSsBrhV2e8dga/8Dll94UjHBLaGgk+R/RJ7bGwR/urUPxLkW+FN5Ei\n" +
                "Q36zmsheJvZAWKetsY5PkT6ptYQx2m1P5IIwIdSE9zmT38M/RuQWY2rUNJFuuDbZJY2mEq4z7LBx\n" +
                "RD5iV74J34U14YnQCUy8h+/sR4r8LGxk8CFPZItQ0Gh5Is8jJCHB2LNwwrmySWfHCdeCtxi+jdL/\n" +
                "p3AhIkFdCbwv4fNPEs8KghKST1EJ11Rk+i7Lanx/WZgP+N0lIpIcOhlJ8s/DThcdnwsXlXDVRF4j\n" +
                "KZmM7Gz7VYSbREchIHJbKW1+6dkIiey2hPRFiNwUPrHzmr0QDp3fTRYwVuQquSEossqZ2404k7u0\n" +
                "Z7sQeUcYF4bIzq6ViZCK8mw4UuSOsvhnRI4xmZR5hKe/54Snnk8lQuSSt8J20HfO78uEppYJXwk/\n" +
                "WJiQyBIXgwPm1ZcXrvZsLJLhprwycUy4jkSE60AgLJdpD3FG952JGWWH2t7Fo8ep0WVKiV3MW0SZ\n" +
                "XZiXLOCZkEmvSrbgX1UGtAnmGbedj4SfJrLB+VrxWOP7ZRatw2oXAjmgl3p7wiXBjnWbjThgARaU\n" +
                "8lJ3NuW6u1O1nNpjnHo3xy0mncim935SuUhMO98v5fwR8G2ccezZ/kKiuSecy6mVr+24vwGFkdkz\n" +
                "ltO0vAAAAABJRU5ErkJggg=="))
            return "其他人员";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACsAAAAOCAYAAAC2POVFAAAB6klEQVR42p2VQUTDURzH/2bSYWKH\n" +
                "mUy67JB0iB2SmRlJksyYDvlLYod0mkiHTol0SJJdpkOSbumQxMwk2a1Tku7ZYSSTJGN9H9/xPO+9\n" +
                "///fjw97b//fe9/f773f7zmO3jbAtPN/K5KgNgayQRyWQA+4IKMQ1XxfoI/MHVHnCx57V8CFX6Hz\n" +
                "oANuFJoMQBd1CawrNIg6X/LY/xyc+BG6Br7AnDI/AB7AocEvHiCzcQ8NNbDtJbQM2mAf5BWuwasy\n" +
                "J2+aYKAydaLOJywaQuCHflaLcqE2ozuz8M3r4rAIXQ01ovvPVLhZrv0JYn6ughA7I43TYEv55l0S\n" +
                "m9Fkz4uMYe8jcAlONXv6Eivu2ZVFbN9WfIh0LfsOsbBnmfkWGAwqdtmn2A4r3TVQ4tomE7XyIo1F\n" +
                "99kNKnZT0/dMYiPSWLSfY2kcsYidAl1mVZ1L28RWwQR/i2N4ZoU2JMcD6RuTWNEvV32IHeWRVzX/\n" +
                "iVb5AVJeGc7zWOoU3W9tDYPzAghLWWlzoyZPJ6k5jRRPqc5errNbJsJVIywywhYXKSuOEd6tX16N\n" +
                "YTDOR0QU4h54BG8gR58cr4QQ/0ThMWa9y3qwFVKYp9STH4tJHnmFGQhZFkjyoYgz4nu2nB3LHRPr\n" +
                "LTJIkcURH0+vbMI3/AfD25Gqfup5qQAAAABJRU5ErkJggg=="))
            return"负责人";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACW0lEQVR42tWWUWTVURzHj5krueJK\n" +
                "kh7GJMneMpOkt+Q+zIzrmplMTE9XEvdhkh5iMpMkMjNXElcmmcRMD5n0voeMTA+TRJIkifX98fnz\n" +
                "c/qfu3vt1vTj457z/59z7u93zvf3O/8Q/rRj4nLO8xrv8qwkrof/yA6JLTHmnp0VH8XhxJwb4hHt\n" +
                "cfEjwRnGnBMTDptzUXxNsNXNAMswI265/jsx5/rxKdoG9LVY1zZhzfWnxD0CfyDuiEs8y/xYol0g\n" +
                "0K7ZtmiKxwmajPE2K27ijDl8IHp/TWygkNg+iSJtC/I+6wyLp7SLfyPIQov3hSjIIQLYJ6bFqntn\n" +
                "zi0yvp5YLw5yUyyLN+ID7ed7HeQikjMnviDZHuRoeTQvBnF0XVzYIch/JteKGElQiYLsgVUq8gAn\n" +
                "sEax8jZK4Cbtuzi+ze8mQS4TYJbDZaS75zk57XY9k3AxwRFIneRb0WDT3tN+2O0gy5xMJpPX4mR0\n" +
                "chXXt13+xfXxhI0Y5sSMz+K7699uIddecjuWa3Bjdm0L5FIZ2QTusA2uicA9ac72u/vO5k0y72C0\n" +
                "5gSBhzYKT40cNl4g4XnHid0GuJ8d74uCDOSQPT/PdTDFvVmK1rBTPu2U0G6QY1wdlsNVmKHCVh3Z\n" +
                "h0iTYtaxXWX3Mqms5Iyp40xAnnMENUsOfaOKtnOStlmvkPpL8jpOm6WcebbZP52sO7IqDpsd5VQb\n" +
                "TioLfNUMuhzppWJeEadc0VlxrFNt/bMaRWbUOTvJ/zVyCk9GnVN/1q38PB5Jpcr1sJOVkF0r+nPm\n" +
                "DbhPxhRDfFGNdxrMbxgHvQEzP3QEAAAAAElFTkSuQmCC"))
            return"总经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACsAAAAOCAYAAAC2POVFAAABwklEQVR42t2VMUgDQRBFQwhiZScW\n" +
                "EgJBLENAREREApJCLESQIBJEBIsUQUS4KoiksxJJIxZilU4k2KYQizQWYhFEELESG4sgR0ijf+Ef\n" +
                "DMPe3gmpHHiQ2ezs/t2Z2Usk/oE1I3yXtWLMKYADx/9TrmAPXAv6Eb5Hbi0MQsY9sV8ZXFl0TIIb\n" +
                "0Ik67RxY5KmfQRGsgFX6G2CLcwJL0pf4lrGk2kuLHQM18AWOQCpK7D64AA1wCvZAjwtvUuwayIuY\n" +
                "EfDOmICB8t84zyY2x73MPpcgE6fOqqxLTT9kvDoksSabdZD+a1ONM+2SnmVsQsSkmLZlga/8mkhr\n" +
                "hSLvwSt/u9gJE2uE3IGSoKf8NktBvhJRDdYF65w/z3Uaaq9vlmFJMesS+yA63aNY6XeE2Jy6wbCb\n" +
                "bTHVeUeD1UNeh8SwbrbChtQMlN9lXNUhdhS8cM1YZm7qOKJmTX3OiJhtsKvwld/mQV1PVxZMg0/e\n" +
                "cjLOVyXOa1AQMUVLA/rKb6o6D8Q2eZhHPluB6CdmoxwmOmMpblsZBGRVfJ63bFL9ESOL5+CHZbek\n" +
                "/jMCD7nOiS04zdPHJWMRazr8zNXBwhbYfC5L6i/ZL+Yzqr73fN5sAAAAAElFTkSuQmCC"))
            return "董事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACOUlEQVR42s2WQUTDURzHZzLJdEuS\n" +
                "RKck+ZMOSTJmhyTTZacOEx2SZGKSTl0mmQ67pNN0iKRDMjEdkg5dJpl0SZJ0iGQ6zET9Xr5/fn77\n" +
                "vf03xXp87P///d9v7/f9vfd+7/l8/6PNEyPsPUn0NeA/Qcx6dVogjhTGiF2FJeYbxgD1EGZ+CWIc\n" +
                "z/tEDM/dxAcRVOKMW+I5J24t3+Zd50GigAxOwmkD2SwhAJcUccIGXkOQnAfiXrGvMb8sE8ZFbhJP\n" +
                "iq+ZiCHEJ9lGTNo3h2cpLzIbRTZfRTYnhUitZZFFrz5SZC/xTkwrwQ4x32PE4HKDxHJbThvUiLxE\n" +
                "h+cmiTQxrEPsKdFj8S2J9zkiI2xlm8glzOZZE0SuIvt+2JaJNyJkEek1k1aRtuUaZMz8kcgMxpB7\n" +
                "krcp7M82ZhtFEYsyMkgQt5k+nZrIK/y+MJFfEOpS+iORpgWAETPA3jntykmQEZiVVxS2e6y6KpER\n" +
                "CDuEyFYlWAdV+LciZQJrPbvHSQj7T5KFUG4roOpGai3XLWS3BcdGAAd2oo4ZqldkyVIoymL/BdlS\n" +
                "jSnsoFBx2xXidjX9iLmG0CKydwFRK6i6pnVhUKdJIn2YnazAxHcnbI9yuaYwe3EIdgtPByqcI65c\n" +
                "BZacsEIehUD71v9LkWPKf6ZxdnJbTtywqpor8gCZ482PrMWxwV8bJI0lb/Z9hd1oPi3PFfSV26Qd\n" +
                "FTSGmVxs9MKcQMaSljtkxCtLHm3YcgWrxbCS7D1WP4K2wb4B0JHs2WPjYdQAAAAASUVORK5CYII="))
            return "职工监事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACT0lEQVR42s2WT0TDYRjHJ0mH6ZIk\n" +
                "SeyQZGaXZCaJTHaaLp12mNhhssPEZDp12SHZIZFO6RBJkkxMkiSRJEliMpMOo8NO3ep58315PHt+\n" +
                "+8NGLx/b7/n93t/7fJ/3eZ7353L9jxEj/OzaD1uzY4aINnooQRwrBIldhSSbO4cFmmGOrcff90YU\n" +
                "2HUBNv5MAsI1f66IF4d7ceuol3gg0kQYk9YJD1ElFhlZ4oyJzBAHgneiqNgzmOODYEueWGPXqwiy\n" +
                "+T9PhDDHB/8kOfik3eMZ8he9afw3DkUIN1ERux4WIrWxhyjWGxmIO0dQDGWsd4k1DCdK6p6y+4Yn\n" +
                "zOe2vLaoEXmDBz46LHJC7KQlCwHavQk2vyret0RsCdu3k8gkdvOiwyKjcEpifHh2uBcVIhvtpKNI\n" +
                "p3R1MxbalK5upWZv0XCk3cvmBSA4wthCenKbeWZQE3mH308m8gdCLdU2iexHxvQwTO1tC1uedWXb\n" +
                "meUuXygZUETW1YgMQdgRRPYqzvrRhdshsiza/aVyFJSYyFnUn2QPQrntAV03VC9dN1Ds3WgIJqqT\n" +
                "RKqJw7lTIgPiOLPsoEtz2x38nubd7pEVvknRa4haQdc1Ywjp6m9TTaZEvcfhMLeZZjjG5uXwfo7x\n" +
                "71XYSjJds9i9GATbxjNAfAlRaaRCvaOgwGpJMo65U8oX1j1qSfvysiOovHNTOXpkLdcMK/IQkeOj\n" +
                "C1GLocArLWIcGhad0JJTuqRlRPjRhw66iJ1cbvWDOYWIpZEycoQaRanBGG3he9fiUYK9z/qH22mx\n" +
                "X7Jf/agGB5XuAAAAAElFTkSuQmCC"))
            return "职工董事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEcAAAAOCAYAAAB95wG7AAAC8klEQVR42r2Xf2TUYRzHv2ZOf8xI\n" +
                "MknG/khmciRzzklkcn9M9s8kJycmM5OMZJL+m0xOJmYymeyfnCQnzpxkMpLkJJE5M5ORJNkfsT4f\n" +
                "3k/e9+l57of71sPLfb/P8/18v8/n93NR5B95IUn3Scy1Os4IuejfjYPCreg/jUlhifgklOm+jDl+\n" +
                "ZhIGW/LwUvgQWJuIYb+3hce4viTsBUgbZzlU5rLwPcA2f+ykcI4owTPu/qZQxPV5YQQyStZDQXge\n" +
                "WEvGEDVfhP4mxlune3XIAgy2iP1dwVyEfRVxnYCB6sYsjPJC2ARbwq5QgbLKU0+KPaN15T3kea4U\n" +
                "U5TPC3eghCraa9ZnEOWHPbKqSw+u1TgP8J5R6JXAep1xBk3kOOaguG9tkOStpdkrbuzFYJhhKH4A\n" +
                "zlyjNVVqWdgXbgTkrXGcAzeEHXJinT45KGPRWlMNrOWMcZpFThzGWcZ79HvfkFpdSJtt1LTTULCK\n" +
                "EtDIOC2nlQqtGl7DU3Z+iORSMNQFYgEb5Dl9pq9D43QBjZir2McO6kvGPDsGg2kK3ofC+/jdhHFc\n" +
                "XXQ1KosU+8s4h/DRBJGnvHSUkFbc6WxUrXki7jM+3umYJS+7VOsJcASEIuej8Aj7reF6JWScLdN2\n" +
                "K56WXCPjnMVHLO6DPPcWXWKkA8OoV3+hjT9BFI8iQpSvwk+6v9sgrbpRu2xaRfRMR8bRlBr3sIiu\n" +
                "x3MbKPCZDoyj55WHiOgs9mxr52oDeTbONOnkOjTrecLWnOsmLCegKM/pS4+TXAGRwqxTyDpqLaSV\n" +
                "vnuqjfqTwm87xrmIUpEhx83BeezMPtsmi4Y3qBV2Pk1yaU+bv+c5Atha5RvvULxDI4VzjqbsD8/Z\n" +
                "KWQcPfu8QkpWULd42LSqG0dNZ3EUPF3Hccy8oxebG0fkTLWZMgm06e4Gz2gHuiacIoeWiSq6F89N\n" +
                "o+aNUY3Jm6jmguz4c1bqN/89WmHAE+Yr8Ny8r6g1GVkU2Xb/SmSaMOCRGwr8tWGGfwMjpB5pzzcP\n" +
                "hAAAAABJRU5ErkJggg=="))
            return "董事，经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAACRUlEQVR42tWYUURDURjHk6SHjEz2\n" +
                "MBlJMsleMplMzGQP6W0me0jsYZL0lqSHXnpI9jCRPU0PkSTJFTPTQxLTQ5JEMnvoobf0MHup7/C/\n" +
                "fI5zd8+NurePn+1+55x7/vfc853v27q61LZIRNh1BD5dixNZjX5homjTp0dzzr/SrG15osR4Jirs\n" +
                "ugIf75OH6JKCK+LRoi3H5k0Q7xaaBogycewxzdo2gQc0MYhNdr1OnOL7LJHEGEFKQYG4sGiLaCzq\n" +
                "EvFGnBCDHtPsyDYg7JJ4BU08dA0TCs4UYXXO2gX3GM99hmJOvqi92Elidz3hYbyoWdvC0ls32cHk\n" +
                "qrYwG/+h2GnyWdnqsKg+4pOoExmPa9a2LG4oI86lB4u2rCTQ7q23bHbq0D/R7Mj6iSOJG4Sj7B9n\n" +
                "46Ygdp5RROhwn+gTwBiRgL4cUnRZ84/MT1RxtpmIc2hf8hnYYTwLyzuiqtgtL4pzUk5UWSyKlzU7\n" +
                "XtSmVErUFGVGgwmcwVkkU4ZI7rtDhk12WNRuzJfzsOZfX1QRRmkFB8jI3HeLJDJtU1JFcZYlPKrZ\n" +
                "8Zm6hk+THCbjvhVilI0r4C1zrlEWcV9DI/zHiCAeqI0wlU38GJh0UbMji6JY5tRxrsj+GBsXU5Qu\n" +
                "e4qyxlDsPnNR42hvs0I7hTYRgnPwhdCnz0XN2haUsp5JQZERTeQSyIdEk8ZbX9aYdxWZXSzeluLX\n" +
                "kx8Jo40wzODB3dSsbSHc3AnD0j1EkjlE+bKLsLOzEWKb7TwrC+CPFRHWCy5rtrVvqjtjG82DxpkA\n" +
                "AAAASUVORK5CYII="))
            return "董事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAADdElEQVR42sWYX2TbURTHIyr6EKWm\n" +
                "ampKzUxFhZmIiBpRk4eavlRVTIyYmqoZNTUze4mpiolRNVU1paqmKkZEzdSU6sPU1JiKqpkyEzNR\n" +
                "ozuH7+XsuPeXpEnt8tHf7/753Xu/95xzT+rz/Vs6iSe+/1vSRFi8h1FXbxkkUnX06yfyNfq0tWJD\n" +
                "T4k3eB4nqg5iagMGHnOXqDg4tsw5QSwIvhBF8V5EnewzAaEXLLwnPjvaMmLeBHHi0IGNa4lYbVZQ\n" +
                "/tB3oreG6NviPYPTZqHniRxxT1hAkljHcwDC6jKADRoK8Bbz/hjf4OfbxBDGDOD7Gl7DpqMtXIeo\n" +
                "vP5vxBrR1ayos8QzbJ4F6lDtj2Axtol4cUGxqFf4zjDxFs9Bh6hcZiDmO+IQHOG7WxBpE9/SoWBD\n" +
                "tDOfMF7WFSxzSlEDsH7e3wEOoOkSwQfbscGSaGMxFokzYtoxXotqNrWDUzcbqzhiW8JCFoLZ2vrF\n" +
                "+IrF0nSsrHqIysbzi9glxlp5OSxiYl7gT4QAP9z7GPHoJoTZhxt6idqI+6fQX1PEXLa2lBK1lqVW\n" +
                "a1jqlYu4cf2ALfQ+EYKFcfyMq74jEJpDxUts6gx/DyGqiWkmBicRClzuzweyovgI79H1ITEuCoHv\n" +
                "CPI4fFnHfboxZgnrbYT8eYWdEVZlQkLQwWXgstQDLJ4PqYznZQ9RL6FvQJAWsdlQgIXJzEFbccli\n" +
                "4V8tcVJfVCkcZMsKW9EfpFNrsIhhWCTzg/gt3l94uH8bYrN2f5/oYxP1SKU/W5bUqCxEvYUD1JjD\n" +
                "lHV7yAqGPET1Y75Mq0TlfPM1rCOJTeq4t+IxXoo6KUQwt7kU5nqLRGXXH7Uwj3ll3Q4uvniNlCqC\n" +
                "+Ju4iPgaxd9GRB2Du8bFZrLYkNygiW2ruPyMBT9UISYDgWQdH9g1MW8OlinZFuHHUK7D/fmwe7DG\n" +
                "U4SWpkoUeWoJ6UWhTkvl3PUDQscW4rIs2v1N6cXC24WFrCt2EQt1fUx8J2ZJt+YsqVjBYn1G1EG0\n" +
                "n4ofB0m07SEMnqvwjT5F3BCbLAr2kQ3IuknEqxEhTlpZiLyoDNOw6g2M6VE3tSFnucUNOgXqwMGP\n" +
                "wlIf1LHnKdzsJ8hSuiwhKQ+xs60IAZ1wYy/6LONCjp+HkgjcelxYbapB+iwhaxneNOtxIcpylXgu\n" +
                "DMJVuhv9x8pfkU9QcthLdMwAAAAASUVORK5CYII=")) return  "经理，董事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAADhklEQVR42sVYX2RbURi/qmLmGjMz\n" +
                "M1NqDzFTIaaqZkrlIWqiL1FTE2WmpiZKVO2pRs1UVYzpQ0QfStUeamrUHmZqSkVFVY2amuhDmIqZ\n" +
                "iNJ9p35nvn37TnIj6Xb4yb3n3PPn+31/Tzzv/7dHhDB7XyDcwXMo4BqPAa+J7++y9wyhu4n59wmj\n" +
                "jT4aJ7xV0E9YVDDB5g5igyAYFPt2EMrYx7YKIU7oJRwSomzsMtaQWAO0sSuYmybcw/MyIYnnG4Qf\n" +
                "BF/hJeWQ/yNhzzH2W7nGMgrQWByTZqC9Cg5gMUt4xzaexiE5vhIOlP5pcWhD9I7oK+MMdvwnYQjv\n" +
                "PQ7lHwDamFVKnhHJSX1J+KacdRz7xRXMgwNtLMKF2RCaTEB7ZSF0XJCqtTy01qgVCWOibxN725aA\n" +
                "NdVrWaDRmSSpXYRjwgOFnB42dw0yWxRhOLxvXdt0AwKZD0r/gNSHhFNmlSYUXCN8hiWMY41lnO0J\n" +
                "vsvBezhqgOzPNSDVrPsc5L4n3HSctSLexxQlVl2kTsBaP5wzqT5crob1vuD5GArdZ/FpmBAjXGyz\n" +
                "pU7BujrQ94zwnTDgILWRpTpJdbm/zzDcBlIX4VIlkBoSmXi5TtbWksNegMSRZWGFx1TehqBsrsA+\n" +
                "xPYEQxYK4X2j8LS/SN3C7xEj9RTEWlTaQGoOBygx9+cxtOiY1yeSpsEKrGRbGUtijsdKtBDIu83e\n" +
                "OS4plVFWwHjyrug7UGQ5IzMGIlch3AWFnAisqR2JSiPVCHWiCKe1JNbogjva+rYbgr8QIYcbSL1n\n" +
                "W14NIH5K5LE+7ysgF8Tquf8raLMTZVQIBXM6gLCtkOrhgClRz3rC4uZAQJi57h6INOtOwig4qRVH\n" +
                "YqmK+OnX8QyDN0hsvG8LPFkOz8jbAbG7OOwnkDiJqsC069g0cs6kplEF2DbCMvkIXG1VEOChtq6K\n" +
                "cqgVUj1YX15gE8mU9x1KWWZhnSkQbBPVVWTEiEgkBaYM7RazgUCujYUDkOojrtsk8xrWMQNhhthF\n" +
                "wUcdO4W1MiApi1tZq6T2KzLMKTe4deXG+EezpK5AU/JquQ8FZEUSC4K5AKTaeFYDoUco0DvElbUK\n" +
                "qzG/S4RbGAvDemrwtDQsu8ZuTCeO5xq+TSuxfhSubvZ82uyfHGloKOO4E8caaSVg23bUhbb1QsAF\n" +
                "ZSyEsZSInbx14jfquFLWQ1QxpiWWb3zXoX8Bul1jCUCh6e8AAAAASUVORK5CYII="))
            return "职工代表监事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACU0lEQVR42sWWT0REURTGnzHGyIgW\n" +
                "adEiniQjbTKLWbRoM/IkiSSjRYa0SItEkqRFtEhaJJJZtEiMMZIkZtGiRduWiZYjeWQkeTLUufke\n" +
                "x+nd92caOvx479777rnfueeedw3jt/USCx7tS+gLY6NELmBMv09fFv78bIYYNpq0TqKGSVxTk70Q\n" +
                "XSG+Hyds4pnIaMbE4WNd0z9LXGq+O8LzAVHA+xvjS7yX5SQW2CG22fsTscfedZaDwCzGqcAMacam\n" +
                "iVdiMYLIBBbORUpzgnZBRaFEnGkoYYwu+nViRKSUWtSUT1B6/kNkwqc/4SGynSgiPb12zcKOlSOc\n" +
                "6SgiU1iTDeRz6q8i8xBXJfaJioZDLLpB7BLniLiDIjXNFmZDiCPaznxE2pqdfNOJVKk1oWFKiJwk\n" +
                "5vGcYWdWkmFVlxejGvpjEOAyR1yJtngrRTZ7JpuxmqaQhUnXw2ZFulF1J7xDFXQtJopITpTrMORa\n" +
                "JPIE4yKJLCL1LOZATfJIdOC9Cwsz2X8rxTDhcFq0c+ItEnmDb0OLbCM+UM4t4WAL7WoHVhCIJyac\n" +
                "/6iV4w3Wpm5OF0QyIF1NHIUgkTHUAVXRP1ngpMhhnGuHB3WZuGYpW/VwsIpzoOwUlwNuJWSDFH4F\n" +
                "8SmPOV/wa6lj/iCRrq1hXgMBrAiRBaQzv7X9pFcWz93YVTXoGBSxILcy8rRTKXSPgqQcP2DRH3BY\n" +
                "R9rcImMM5qeBdjNkurp33nefm5QTtur1QThnwGd8Hr8YldKDEBNj/UnsWFp8N6mZT92aNjV9Y9hJ\n" +
                "nZ3Lhm+WOdKCQi7RbAAAAABJRU5ErkJggg=="))
            return "总会计师";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACMklEQVR42sWWQUREURSGxxhPMiIj\n" +
                "LZJIMtIiMpK0S4skiTGSFhmSFi0SI7NIEknSIpHRIkmMpEUSs5hVRvsWiZEWLTK7kaRNnZP/5ji9\n" +
                "N296M1OHz7v3vvvuO/+95557fb6f1kHM2bQv4F0tLODhm0li0OsPm4gnDGKMB3smmm36DxHTZTKE\n" +
                "bwaILeKEuCVeiS7ijSgq+N2FmIx9lHeJOOqy/4eqn2qHR8AGsS7qeWJb1KUl4azkAd/o9iS+6YHo\n" +
                "LJ7GWKRlM4lGpAXHpUhtb26ryLOQtnHOkEYfNzskUmX2i/2HSKvEe6tKImfh5B1xhbIJ10uIMuRc\n" +
                "RAbhUwHocvC/RPYR43B4C2Xe70dEIxwzRIiEi8iCw0oWnURG8VM7olUM1zDGmhfZcrcEvdUU+Vd7\n" +
                "chNOPKJ/BPuTWUFWjQlalcg9ryI5c/pFaOSwV4z5sZqVigxCHIfnFHGjzrxBIUZvl6L4x/RvRR4g\n" +
                "IYyIjc6D3GOf+LBv+Axtr1Akr+Kayq4RkWyuiXeVgLTILHwtW2Q9wqNNiWRbRfswsYSJyAvhXkRy\n" +
                "6IeUSAttIfhQFPWQiKQJogGTEHQQyZEwg/L3bWoRqdyEbMbGsQT2AdsxLgddOMc0GRwFdu/CJc5J\n" +
                "t3A1tozx2eqIMyUyjrHlre3rR/0ot2BVzWqkEMrPCCmzpwLIcIVfsm0jMoCJMdxgpWRbWmTlF2Rb\n" +
                "n5fLgLFOldmY7hpczHeIMRGubrCNYiWd7Fw3fALSrNz/u7fNuQAAAABJRU5ErkJggg=="))
            return "总工程师";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAADlUlEQVR42sWYb0SdURzHr0lmHiOZ\n" +
                "mUxkJkkumSQzI9ckk94kc80VmUwvrriSvUr0YpJcMb1IehHJTHKNK5lJIkkmiSSTvYiZXsxco/1O\n" +
                "Pmd+OzvPvU+q7cfX8zzn/+97fn/OeWKx/y/PBbXqe0JQz3t5xDF6QVRJCeLqO05ZVHkkSJZq1Cd4\n" +
                "60GLYMqDftW3lQmioNWZ95rgmHmsnAjaBE2CQ0GjqqtgDBeLwFdXiX56/XuCvPrOU6bb9EG0T/8P\n" +
                "gp2Qut+bayxjU5BBIdNpWFCDkl0Ko4IlpeiQYM7BgWDfUz7kkGqI3nLKjlmDrf8uaOe7IWTz94Gv\n" +
                "rpF+muic4JX6HqSteX8iSNCngbW4GIcDX532gLPdesi7IaBDEKCkljaHVJ/MsGulZFvQ45StMrcV\n" +
                "815VYpwsKCZDkPmeTTf4jH4r6GTwzhMKFlX9Eus+cMpyvknzKGQaHP0DUp8JTpVVmlBwW7CGJViX\n" +
                "nWNtL2g3jfdoFIBbPk2fupDQMFokbNQ5IUlLj2cTf4SR2o+1Ll8xqQFWUmC8Pd6/saG7Kj514o43\n" +
                "LmCpSdVGw+j8KaQu6ZBaylJDSQ1z/0Ch8xJIncJCjiBVZ/kM84dleV9y2ImQOAJPjF9jQ93yejVn\n" +
                "MwR3KGRxd12WxNP+InWd5xdF6inEWpxcAqnTLOBIub+Oodsh/ZqdpGkwj5VseOq66BPjFLDMBlqY\n" +
                "2DnplOWcU0qfx4qXPRa+79HljMwERC6g3HUPOXGs6TISlY/Um4KfPEtJF2NU447WwmpQfES1rSTk\n" +
                "aCte8Vj4oSL1MfHTxQzj67JNckGimPu/JliXEdDNLj4QpCMoexFSYyww5ZxntZi1jOFF9uLQDkEj\n" +
                "jDuAUVyE1OYQ63/DKUKXrcOT5fCMvC0VuM1iP0LiAKcCI3dw//gVk5om3lnpVpm8G1dbYC2BajdM\n" +
                "KGgISY5pJz/0QpAuM8n6vuo3jj4aqyRTXXbo6jKKdaYg2CaqW4KvDokZLKnYUSWvYpOL2gikBsR1\n" +
                "m2QmUX4YZdrVRSHgHDvIWBmIzXIrs9LkuRhshFwa9A2vxaPDmOcolvPcGP8QS+o8O+VeLXfZgKyT\n" +
                "xKJgLAKpNp4VINQQ/NQJAxWQt8pzVnCPulqsp4CnVTmZ2mLck8Ut7npifRJXN3O+PO9PjjQ7lHHc\n" +
                "y0qi1K5ElA3IC5Mm3HzCU1dOXcqJnVrKeFaf4/+ERY3HmGZVvgnCFv0LyyNz2GxIjlwAAAAASUVO\n" +
                "RK5CYII=")) return "职工代表董事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACxklEQVR42qWWX2TbURTHfyr6MD+h\n" +
                "JmpqRp6q6mfUHqZiStVETO0l9lAzJQ81MzWmqvqwl5mZqRgTeYiZvFTNTIzqQ1TVmD3MzIyYmJop\n" +
                "NTUTFbpz53vj6/TeX5L18pGb87v/vueec36/IDjZVoSUso0JD4P4lhcmg/9rBeES/b8vpPuYf0WY\n" +
                "63XwqHAkJJQ9K+x3mXtDeO8Qvq+wh1kUMuhXMda0EeG3EDr2uCWUHNSFz55nBb3IsrCNzS2pGJFT\n" +
                "whviE/WrEFQRzoJdElOhPot8JHyHjVkQIpxF8xR7up5d1If+KhyQ11vY3CcygUVuwvOGcYR8CJEl\n" +
                "jDXjflKUuEReEH4J1xyHjWjf18q5H4VvylZzhdtVeJBbQ8iRyMgx7zyejeD/M+EB+izyhbBE81wi\n" +
                "N+EgI/Yt1na1Q/V/XigqW8s1cRd5wrfUFoYh0uTJD2FNGKCClIGAe8IsbmIGdptDadjDGJFL8L5d\n" +
                "+y6iasojsttNnhBpDrdH+RcgZBqq8JxD3tUxdlktrClA5DCcuEp7FrGvzkluOUTXGbJdRoTMEkU4\n" +
                "iG1z2LfT6jBGuC2TyK/otcE5OSRsCS97qNYcrmZeE+XetkGQQ1QMOkiqNRcgitmC89nWoAvrFAXb\n" +
                "UqiwbXpX6cKTIC+tIpc0kRJpD2idY0L3mIpcXD+kaj7voAKhbPuAy5rx3cA2Ckgv78kNhDZ7fw85\n" +
                "qUVex3gr8tBTKFoq/0IK1byD5yhUbHuHSMy4Dr2Gq072ITKrbCyyDHFZ5M3jU4gMcDsVxY7wRdma\n" +
                "jnP9ayWIGevji2cDBWiaOFA3WUMFLCM3TyNyUu1leIJ3J9tq+O20NK636RDYi8gd/Fr+eMI1oE+6\n" +
                "dXxC2i+atqd/hLGLao0k1s9j/9vdquAQwijpeT6NcHA18zE9oWxlOMsUijuOOROeT7A49B4DeD9X\n" +
                "cfbQJ+4vESP6k2gbJnwAAAAASUVORK5CYII=")) return "外部监事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACsAAAAOCAYAAAC2POVFAAACF0lEQVR42tWVQUSDYRjHPzNJuiQd\n" +
                "dkgkyQ4TM0k6xCTpMJFJksRkskNihw4dJtJhOsyYSaZDJNkhiXTolC7p0GG6JLNT7DCZmbGeh//L\n" +
                "4/W97yZdevj5nnd7vu/9f8/zvM/nOP/cYkRE+22T2DDELxAJ+EEi7MKgZb9+Cx1tmKgQo1j7iDIx\n" +
                "boh/JmbgHxDXGi0IZtslLgRx4osoIrYp7mvaRLKYAngU/itREmspOoKNPEC3Q+JKrAMQXsfVD7E9\n" +
                "+L8mYms2sbNElVi0UEUcWx/xhgrsEGfa806IO6LXZS8phMVmiQyymRG+VWylQ4tUhNgjiFknPkXb\n" +
                "cLaeiAfig0iKzJnErqBKdVyV/2dil3EYS8gs/34J4VHE8MHKQ/Qi4gvIWgEv+us2aCPIRFuIZVsl\n" +
                "buGzmC1D74aRrQDi6riqnlW0Nd9oXMaUWE+JDClLiXIH8QIxnHIeYefIvk7W0gZR8YI1LRFG4x4M\n" +
                "YWbOEUPYaFrEcBZH4G8TN8Qpyskjz4uSMg3hew1ivRCrqGtrn5vQAeIbJzyPzR2IjsNPo5TviJfm\n" +
                "ES+hrGFJDItdQvYy2gSQa7/bzXtEDn4OvSdtDGNKjaQ0PgTHmAgVPKOTWD6I9xBVhGCn20PliJM9\n" +
                "IQZ9WXwEmBeMIJVFLu0aKqAymoQQRUtbJ5DJedGjee2L1tTW+92In9Q+BqEu7pH96obXMIHCFoIy\n" +
                "+AeCBaOpMqQHpAAAAABJRU5ErkJggg==")) return "总经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAOCAYAAADT0Rc6AAABf0lEQVR42s2UMUjDUBCGgwQRcXNy\n" +
                "EMGxQ5eM0q2IiIMIUkSchCIiHUTo4OAkiJND6FJEioMgIh1EBHEWdwc3cXByyxBKKOh/8D84Lnmx\n" +
                "bh585F5y7/13915eEPwDWwIt+hGoFzBdMn+qBK+9gAX6R+DWMKSw2D64UuyCL9BnbKbmZT7BVU4Y\n" +
                "I9aOwY0aV5lAymeFouP8nqjYpEhwEryCebAHLsz3M/AAJgrm6gVFtANiVhcrP2cnXHQLfFA8YPbP\n" +
                "4Am8g7aqxCe6zq6lfDo/Z2ugCd5YaQ1cM4EGY+QAdSm+zPgeq+gx4T+1V2wD3NOXRbc9e1tn9lXG\n" +
                "pXy6PXV8Gz9nEbNp8lTKr3MJPgvolLS3oRJNTEE52wF34JxtmgUhWyUMlB96REOKOlIznin7VyXT\n" +
                "OfNuUBIvoiusJjYnVo8rdqJcCKc8wdLCgxFE5cA9cvE+hYNRDo+zTbbVVdjmgo6hGbdY2aLaw665\n" +
                "oTIzPvwtCb2fRYQFc2qeu9oRucAfaC1zclpLjZAAAAAASUVORK5CYII=")) return "经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEcAAAAOCAYAAAB95wG7AAADHUlEQVR42sWXX2RcQRTGxxWraoVV\n" +
                "UdWHEFVReauIqlUlovYhKqwVFRUlqiKqyj5EVVWJioiKUisiokKsqIpaVuShVoU+9CEPFSryEFWl\n" +
                "KipWlfRM/G6cTOfubvemevjszL135pz5zr9ZY/6Uc4LbnudjvPNJSvDA/H+5Ihj8lwraBDuOkrTg\n" +
                "i+B0xJqHgpeMbwiqEbisDjGkYNfcFOxGYEfpuiNYdNDJu1FBIYK0ZvUdSgZMCJ6o+SfBlJq7UWOJ\n" +
                "a69BuCWvouYjghkIeyGYFtziWWjHMuMEBocyL3gs6AW7OM+w3kdOHH2Hsi9Y8ngmxBLfaJkUPGJT\n" +
                "q7jVeX9fsElEuvJVkGRsjX3OPv2CV4yTHnJyzh5XsW8TR2qbg5j6jpCTqBEBCYecHgw6IRgXrKp3\n" +
                "Vskc3+cj9nON3RKsCNYFnxm/8ZBTwuthNNi0uS4o870dZz2ObEZf0+TMYZzd7DupFRDGO4R4Nwo3\n" +
                "BNfqGNtoWs2o+qHTqqD2sOt+HoO+I+RkYd4H1xsBWKXDdeGBijI4lAEIsyn4DAP2+d3C2BUMDWtU\n" +
                "hpCvl1Zp5awRFblVxnH0xao544r1MNWSETgDojz5kcNbsrcZL3jImVQO05FTVF221XPIZvQd6VaB\n" +
                "Cq93ggtOpGTV3LL8izZehMB+IsTim2BPzZ/WMLaF2uWGuVHfGHWYAqgqct6rbnoJ/XH1HcgsIZkh\n" +
                "3Aw5vUm7Ntxz7CE71P3Brhtm3SlnzyEIMw0U5DF14BKhX1DorJNWSWpMuF8vV4y4+sxJPNzukGOo\n" +
                "EfZ5H215hHaZchQHeCv4S3IGaalpDp3jnrWu5jl1AQ3JsXrOkgL2TnZPsOZkQeUY9B1sXFKblj0H\n" +
                "ybOpIY2mIGOSMP9BV2okcizJb0nJNeqWm97LETZso8um0we+K3LwPqcBvI6p70ByHNTgjT08FIbY\n" +
                "LCHarXKyBQPuCi6qYlxW2KB76WdjFMMBlfPD6Jv3FMgQef5+ZJy/MW3UxgXq5CL2bhFRJoY+r5x3\n" +
                "QixHm64nKcK1Fjo867rUX5Mo9EToDCj0LcwnuL+MqmdN6fsNxIlDvwvrjMwAAAAASUVORK5CYII="))
            return "总经理助理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACSElEQVR42uWWTUREURTHM5IWiRZp\n" +
                "kTEkaZExZCRJIklajMhIRhItZjGSmNVIZtcqmc1I0iJDi5HRdiQtRswiLZJI0iKJZOQZs5nO5f84\n" +
                "jnvve33suvy8d979/N9zz7mvpeUflXaiwwIvR4YxCh62rZR8tJkkNiz1/V4DqM5FAydELzGMtk08\n" +
                "06Jd3cNOgzMNDcP3NFtjwrDBam2nRMXPboaJWcEM6uJsgibrM0KMY5fviGn0m4O9QCyhjVsCsDmO\n" +
                "5ltArE+K7CQyxDuxRbT6EXmE3csxHA+R68Q+2u4Sa0QNC1qEyBgRYX3aiCcxT0PYj2inExnGXGqe\n" +
                "QyL0nbhUA8yLWKxZRKYQd5K64Xvqj0Sq05Mlgj9JPgfEuVjYh4cnuzVHvKb51sP6tOJ4TTEcYWfY\n" +
                "8Uti7kviAe82VkwCuzQLcxmyiFT1F6h3qQm7jCPLs65X4rnFqVJlFOPkxFyfCJe4IGoSqQL9GruW\n" +
                "Q6ZS73nEnE1klWXONERyu8JEhoXHTJ4s4UhGLIkna7nOjCKLbOFu55gPkd/xZBLjSRrCvkW/lEWk\n" +
                "utvvMaZvkS84KlfEM96rmFR3T7qe2faIyS3WV5VlYlXgCLuMDbJdIX3EAPEKrwZ+60lemuIvxE92\n" +
                "nWR9pjVx7wi7IOLYFVnAJlzj+nDF3sD7CZtY7skKUjj35Diy7zHxhj4hTdDrjqtLn5gzAq+mMLdX\n" +
                "yWODVXhMiDolbBPj7JgGGDT8F0ZxwYfYUQqjLojd9ktII1IluT1bRmRlDEnJVgK6P58vTSnqCarJ\n" +
                "ltUAAAAASUVORK5CYII=")) return "副董事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACUElEQVR42uWWTUREURTHx8hIRiRJ\n" +
                "iwyjRasxJC1GMiQZSSIjY7SIpMWTEbNK0jZJ2rVKMpuRpF1mkRZtkhbJbDKSJO3e4hlP1Ln5X47T\n" +
                "fR8NrTr8vHfue/fde+75epHIP5Sq0C0iG2LeDpFsYb1KgO4nZ60aaQv9gCgGzFkm7ol2vPvuQZwo\n" +
                "EyeMZoBeBucGXI/xstdGR4gZwsE1gesFsYt7RU7Mmybe8L6SKBHzgK81igipExP47hT0OaKAdyLs\n" +
                "u6MCxzAW9fPGCrzm4qomHBKPxCXuj+ERLQUYOIRNjoWMllWssY8DXEIEqSiYh5HqQNNsjjqkJ8zR\n" +
                "uEJviMMMHa5HxCzu48LISWIQ48/EcIjvW8g7SdNj3PpLI6MoJFWEkclILcrL2/CkLXARVjYrFD3w\n" +
                "PMc2jPWyNdqIDWKc4Qh9He95ShwhojZ1R2wSr8QL81AHxmTofRpyVYsqHnkxlkMK5Bm20GvYD6+6\n" +
                "QYXngUWdUU5x0up0BjDWR3wQV/BqDEbzPFYhctOCkTescpZhJNevmZEp4TEvT6r9b4lcDszJDHFL\n" +
                "lNAiYixcoygUfTjFv/SkLooSV+gPmGf9xsgq6zltMMyGsXX23m+NTCEd/HJyA1VbywKxKHCEXjOs\n" +
                "5WtkDu2hUzx30NdOQhp5alg4G7K68j+tCUNhcoReEXn8Q7IoIg3EtI1GL0X3yjUfI/NoPUfYSIY9\n" +
                "S4iw9ApXjfxVTMOrlqEIBkoBvUb9BHThQybpRrPmpbqEENSSRL4WURC49LO/pzAkDEaqfe6F7Mvf\n" +
                "8gU5pttlko/gGwAAAABJRU5ErkJggg==")) return "执行董事";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFUAAAAOCAYAAABevFBuAAADb0lEQVR42rVYX2SbURT/VFTUp8zM\n" +
                "1EypPsweYkwfamrKRFVNjampPEyoiJrJS/Shj2VmZiZGVUzUhKk+TEWpqpqaMjM1M2VmZmLKVMxE\n" +
                "lO3c+V1+zu79krTp4SfnO/d+98/vnnPu+RIEbpkRDNFzXjAQtC7XBamgfRkTJIPOSEww3aR9TnD+\n" +
                "GGMPChZa6ZgTjEAvC6agXxD8EoSOd+4KlhzYFnz0tM145r8pOBBU1YGyPBfUIvCU+pr11pvseRV7\n" +
                "jZI+8MIwh/8be9Ftl/jlEhHJpD4UfIONkRUkBOMOPBGsedquOBaeBKHD6PNDcPWYHmqImnSQetYB\n" +
                "c3hFwTlHm5U09r/WIvLNSO0XHMKLNDkJeveVGnhP8EXZKh4SUphjlGx34Hm3Hf0fwJu/E6qw+0gN\n" +
                "cWgadcDV1k2klqCPevZRo/5BM1I3BPMgd11w0UNMTT2bhRSUTYdiL7yk6vFKc3A/BSvIYVYKGN83\n" +
                "n89TXWJTUpSYsV/AMd6AcO2dRyDb6PeiSJ1Dxy7Y7mOTox5Sm3kqb3AaZG4gVax68IwW/YhI3Xbk\n" +
                "8NMktYTxJgRb0Bl1pAyjxwPlAZOOnMoygfzSQ7ZhhPAkoYADYVuKbtpbdGENeXLvOF1YY6SbcWZV\n" +
                "v1mqNk6LVCM3sH99+R75wj9AQzfIu0zPjF71ThYkMjYFH5TtMwg4icSxQR/CCFLN5v+0iCW1vyL0\n" +
                "BDnfFukrKNH+kxAD2kQdpYeUuNMOlEAs294h1JNArU0kMW8NHmPQIP0tQrDTnlpAGupH9FqYlLOo\n" +
                "bP0uUmuei6Wu8mdIoT/lwCIuNrbt4oYewalyThrAgU058pVFjNZoa8IG6bunRGoZqcVgn97ZV7n9\n" +
                "k+uD5zikBvA+HYY7mIRtXz3hH0MozZMtgzIt7lhjnWrlI9KrIDWBurNTpO5h3SnKrfZiT6uxOkbq\n" +
                "NQpBi8cghW0V/Gp5STmLia7QTRuoetO1rg1VtJ/pAKmDiIZYBKl9WNem/izOIdk2PF7AegN9c466\n" +
                "M4UQ3sGNHCXm0nuPHF2BZx/i868O3Rzga6o2rPdxfWj1A5CaRx5cx+VoZJkK/VaxDBSpDCw6SM1g\n" +
                "bn2o/4rv8TahC/YuLKKMmjJs4TafRv5LImx7qC62t/0KKhH7XPZUJQuYM4PNL3k+iduRbMQfSQXf\n" +
                "n0Z/Aeh7eLMRENozAAAAAElFTkSuQmCC")) return "监事会副主席";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAOCAYAAADT0Rc6AAABfElEQVR42q2UIUhDQRjHL4gsPAST\n" +
                "wbZgMFhEFsQ2TGIYiCyIDGGIQQyCiBjEYjSIRQwiMhgLSzIwiWFdxLAuIiuyII/xQP8n/4Pbx3fu\n" +
                "FD/4wb13393/3v++9xkzGHOgasJRZY4WG2BSvCuDeTMkVkHth/kac2SMgT7Ii/cXPIwaa6ALeiDl\n" +
                "WCNlTpdrXGyDO45fQBIjOsLEddDgWKPBnIRrXHRAkeOeEN0HJXAKHkL2tvkVGm3F3godMJ7oJrgG\n" +
                "r+AN1MEOyEKi9tRnATpCdJwbpyyYD/AJblhEt569OXG4PxfSFQVSFlOi2OtE3ZwqmnETjUyIHoMJ\n" +
                "xV5NdIZF9i+/zGiEaBM80ZmBn97eWSviTlscb/1CdAksg1lW/3cUOenY40Hc8y44EDmLEaLnrG7f\n" +
                "yXutsxyCd2FjhR3H2rsQYW8+cD0n4NI9FGhFnw1gWllgC+aI3eiRdmmi9mDPvD+fOvcv+F9iO8aU\n" +
                "GR452l3yullTzK8ojaXs9v8CetR/eEstDNUAAAAASUVORK5CYII=")) return "其他";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADkAAAAOCAYAAACVZ7SQAAACzElEQVR42rWWT2RcURSHnxGjYoRZ\n" +
                "REXEEBUVlU1URc0iRBYRVSVGVFSVUV1EjTIquqgoUZVVDBFVo6pERBdRIYssu6ksqipKRVVUlKqI\n" +
                "qAjTc/gep9e5M4m0l89777773j2/e/7cmySnb0uR/rzwXMic8n8XhLtO/zTvmrWycNk8V4Xe2OCs\n" +
                "sO8w5IxtRP6hAj8IpQg3It91CrvCpOkrCnvCeWd8hffaXvNvbd3CgZBrJTJreGt+1krkbeEYkQsO\n" +
                "avC2890YzAlPzPMXYd4821Y3wqzIp8I3+iz3QpHaVoQ2YY0Jwo8aXGcYrx74LlwRvgpTxqAO4SVG\n" +
                "90QWbNmZI2XZWVRPZEH4JVwzC5My4IlMPaoiR4TrhjqT6v1VYZRQ6+PbXrypC3Uf8S8Qm0REZpvk\n" +
                "XPaEIjeER4hdjyxoVGQxGLPjTNrJNcOiLBK6urKfKA79/1HkQ1IrLXi6uD+F4VYiM45IzZtaMKmG\n" +
                "wzNW71DYxHMjhHwJQ1Twb/KyGoicCKLFMuGIXOBdmJO2jZOf7TGRB1ytyCKhlw8mnWQlxxCVkIN3\n" +
                "nIkLGNdzxpxMTHEcJ0qyDh3NPHkYiOxC4Eikus4wNkXHvg/6lFeR6poxNrwLQjuDN23LYcMPaHb/\n" +
                "13bShhFaOD6y56T70TZJHdtC+hlXxOgGBaloqJI34b5a5ps1+rQyfyZiEvbJ3WCDzxmHJKSBd78f\n" +
                "2zMfUFx2KCib5MBJDgMJ+fnG6VdvrJrndiKmEIjU9pj+UewpswXl/4XIi7hZPTMrbEWOSDGRs2z6\n" +
                "XZEjWj04taybkN1wvqlS6BKibP6sIocx0BaMFVMJp9kaVqlaNsxvsjdu4YE0hGt4ocq/7bGuZI6M\n" +
                "3Xi1zrl4iVDeM+fSHHNVsOvIFKfjyP0RYyvppAMYa9s5c3+LsJ0LCsMQRWbKOazXMHjROZqFrc85\n" +
                "615yxg06J5pWDP4BoPXwYFtBtqEAAAAASUVORK5CYII=")) return "财务总监";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEcAAAAOCAYAAAB95wG7AAADcUlEQVR42r2Xb0TcYRzAf05O5kRm\n" +
                "kpnoxSSZmElyJibTi0xvkkkSmcyZiczJ7F0myZxIJkli5kwm4+TMnIn0YjIzkpOTRGZm7sVoz8Pn\n" +
                "mW/fPc91m9nDx/2e57nv/Z7v/+eiyD9GDO1i3s5ateOmYajK7141DKq1hGGigky9YSr6T2PcsCj4\n" +
                "bMiJeY41+Z1xDLbo4a3hY2BvzFBjiEOT4djQItaWDC/FPI6MG48NqzzfNZQDdClnOazMsOFrgJI0\n" +
                "zjXDLcEGnnHzR4Ysz7cNPchYej3MGV4H9mwUpjG4o2jY5XnHcKT2c8i4qDnCqKFhjVcQc+uQDAZb\n" +
                "4HyjrEWcK8tzHAOdGWmM8sawDwd4NY+ylleeFFsX+5YPyMu1jQrKZEQayoP6xozhCUpYRevU/gRR\n" +
                "fskje0zKRhhnnt/pQ684+2eM06oixzGN4r69ViGvLS294kZZzecJX8t3wwnPJ8xLAjc6ULwWZ26q\n" +
                "OmXT8dQwGTCsNo5z4JbhUDjxjD5DKKPJEe6+vSFlnPMip/yXkSPllpjb930htWKkTYmadgMFdykB\n" +
                "lYxTdVpZoTXFezyl19uEXCeK3RFkOKBcs99pQCbFYRx7hm2eCyjq9n7wOYkhYkTMPc5xiExS6dPP\n" +
                "79gUfIbCp3zuYxxXF12N6iXFfjPORV4qO8SIyEvHBmklO52Oqk1PxO3x8oi0SAgW8H4CpdbFXpnP\n" +
                "WlEbsyrVEgEaIRQ5nwzLnLfI80rIOAeq7eY9LbkojNPNSzTuhXJthy7RozpIRnSqDN7cE3syrfqI\n" +
                "pFVa/RprpUC9elohrWqEwXUqJ/6FcWxKDXhYoOvJtS0KvAv/6xxqGAPMiBC34T/L/IW6XD4nons5\n" +
                "s66daxVqmzROSujkOrTUs0XXnIcqLMdQVK6luNW6MUekSAoiZB1FkVZuNFJrCqog5zHmaAVFYzgn\n" +
                "9ofGGaRUJIXjpnmfdGZDpHI3q9gmxPV6l5Dr8rT5Wc8VQNeqJMW+O9Ct6vHopoi2TiLMrn3z3J1C\n" +
                "xrF3n3ekZF5cKKNq7laXVWdxzHm6juOK+o06DjdAJNyv4MEpDNNSRSsfI93TFOsHpKRzqLxF79K9\n" +
                "5FqKCOwXNWZERbUsyI5fd6Um9d+jGpo9Yb6C52Z8RU0M+74LYj6NUSOia9nz2zWBP6DJc2j2yLUF\n" +
                "/tpIOn4CvBZhpfss4TAAAAAASUVORK5CYII="))
            return "董事兼经理";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACsAAAAOCAYAAAC2POVFAAACAUlEQVR42rWVT0TDYRjHZyYdZiTp\n" +
                "kG4dkqTbJDMxHXaYdJlJMrHDJB2iQ4cOXXZIJhPTaTpEkiTTJUkmkR2STGR2SIfdpsNM1PPyfXl6\n" +
                "et/f77fo4WOv99/zfZ89z/Pz+f7HosSih31jRMFlT8B2uWaBWCJaFt5wLk0cGLghni1rGeY3RjQt\n" +
                "IvuIEnEsFzJ4YZsoEnlimb06Tpxi3APByiawJlHnLyxrkx7EKt/vxAkxYAu5OhhkB/YhLkGcYRxk\n" +
                "YrWdQ5zmkaiLubLBHxer7s4SL0QND3M0KVY7vMdLtVMptmWIjMzFtoPYEPFBPBApr4UhxbqlARfr\n" +
                "Ftm2S2SHvYrcg8Mv/NYhVufdFlHBOCHETqEo5xgF/AN8Tu0ZxJkSfHVDwS2yNVx8RTQwPhRis7iI\n" +
                "o/Y/iblXQx7KAlMPuvtLGqj+1mtIAx/bM4NHSfQD+VwVXWLWQawfLS/TrdhV1hsvkRq8X44iBZIG\n" +
                "ijjD51SR5oiIS+sKI79jXsSm0LIizFEOzrhznX95RJJTYSmkaXhIAxWAIdzfQYr9snXilvgkrolN\n" +
                "sS7TgNs0nHJ20Xv5XNkQLS02ivUO+2jEsVZFUf/oi/MsR9MiKrzANBvCcQgFkkRkVzyk3RoqvYmO\n" +
                "I79W/SjODv5do41bPpWcsDjjR6c4InZY7jvZCLHNgmQzlXKBb0CfwRWheTMwAAAAAElFTkSuQmCC"))
            return "理事长";
        else if(encodedText.equals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACsAAAAOCAYAAAC2POVFAAACAUlEQVR42rWVT0TDYRjHZyYdZiTp\n" +
                "kG4dkqTbJDMxHXaYdJlJMrHDJB2iQ4cOXXZIJhPTaTpEkiTTJUkmkR2STGR2SIfdpsNM1PPyfXl6\n" +
                "et/f77fo4WOv99/zfZ89z/Pz+f7HosSih31jRMFlT8B2uWaBWCJaFt5wLk0cGLghni1rGeY3RjQt\n" +
                "IvuIEnEsFzJ4YZsoEnlimb06Tpxi3APByiawJlHnLyxrkx7EKt/vxAkxYAu5OhhkB/YhLkGcYRxk\n" +
                "YrWdQ5zmkaiLubLBHxer7s4SL0QND3M0KVY7vMdLtVMptmWIjMzFtoPYEPFBPBApr4UhxbqlARfr\n" +
                "Ftm2S2SHvYrcg8Mv/NYhVufdFlHBOCHETqEo5xgF/AN8Tu0ZxJkSfHVDwS2yNVx8RTQwPhRis7iI\n" +
                "o/Y/iblXQx7KAlMPuvtLGqj+1mtIAx/bM4NHSfQD+VwVXWLWQawfLS/TrdhV1hsvkRq8X44iBZIG\n" +
                "ijjD51SR5oiIS+sKI79jXsSm0LIizFEOzrhznX95RJJTYSmkaXhIAxWAIdzfQYr9snXilvgkrolN\n" +
                "sS7TgNs0nHJ20Xv5XNkQLS02ivUO+2jEsVZFUf/oi/MsR9MiKrzANBvCcQgFkkRkVzyk3RoqvYmO\n" +
                "I79W/SjODv5do41bPpWcsDjjR6c4InZY7jvZCLHNgmQzlXKBb0CfwRWheTMwAAAAAElFTkSuQmCC"))
            return "理事长";
        else if(encodedText.equals(""))
            return "非公示项";
        else {

            System.out.println("出现新的职位:"+encodedText);
            decode(encodedText,corpId,personName);
            return "未公示";

        }

    }
}
