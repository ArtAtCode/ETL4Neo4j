import static org.neo4j.driver.v1.Values.parameters;


import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

import org.neo4j.driver.v1.Session;


public class ConnectionTest {
    public static final String TOBEPARSEDFILE = "C:\\Users\\15944\\Desktop\\中软资料\\企业信息\\total_bj.json";
    public static void main(String [] args){

        Driver driver ;
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic( "neo4j", "Linux1997" ));
        Session session = driver.session();
        ETL.parseFile(TOBEPARSEDFILE,session);
        session.close();
        driver.close();
    }

}
