package com.jquery.table;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
public class DatabaseTesingDemo {
       // Connection object
       static Connection con = null;
       // Statement object
       private static Statement stmt;
       // Constant for Database URL
       public static String DB_URL = "jdbc:mysql://localhost:3306/user";   
       // Constant for Database Username
       public static String DB_USER = "root";
       // Constant for Database Password
       public static String DB_PASSWORD = "vunhatle";
 
       @BeforeClass
       public void setUp() throws Exception {
              try{
                     // Get connection to DB
                     Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                     // Statement object to send the SQL statement to the Database
                     stmt = con.createStatement();
                     }
                     catch (Exception e)
                     {
                           e.printStackTrace();
                     }
       }
 
       @Test
       public void test() {
    	   String[] tableData = {"1","Le","28","Hoang Mai","2","Tung","38","Dan Phuong","3","Anh","4","Hai Duong"};
    	   ArrayList<String> dataDB = new ArrayList<String>();
              try{
            	  String name = "Le";
            	 // String query = "select * from userinfo where userName = '"+name+"'";
              String query = "select * from userinfo";
              ResultSet res = stmt.executeQuery(query);
              while (res.next()) {
					/*
					 * System.out.print(res.getString(1)); System.out.print( "\t"
					 * +res.getString(2)); System.out.print("\t" + res.getString(3));
					 * System.out.println("\t" + res.getString(4));
					 */
            	  dataDB.add(res.getString(1));
            	  dataDB.add(res.getString(2));
            	  dataDB.add(res.getString(3));
            	  dataDB.add(res.getString(4));
            	
            	  
            	  
 				 }
              System.out.println(dataDB);
              // EP SANG ARRAY LIST
              ArrayList<String> dataTableArrayList = new ArrayList<String>();
              for(int i = 0; i < tableData.length; i++) {
            	  dataTableArrayList.add(tableData[i]);
              }
              // so sanh hai chuoi
              if(dataDB.size() != dataTableArrayList.size()) {
            	  System.out.println("do dai chuoi khac nhau");
              }else {
            	  for(int i=0; i<dataDB.size(); i++) {

            		  	String dataDBIndex = dataDB.get(i); 
            		  	String dataTableIndex = dataTableArrayList.get(i);
            		  	if(dataDBIndex.equalsIgnoreCase(dataTableIndex)) {
            		  	System.out.println("Du lieu o "+ i + "giong nhau"); }
            		  	else {
            		  	System.out.println("Du lieu o "+ i + "khac nhau"); }

            		  
            	
            	  }
            	  System.out.println(dataTableArrayList);
              }
				
			
              }
              catch(Exception e)
              {
                     e.printStackTrace();
              }     
       }
 
       @AfterClass
       public void tearDown() throws Exception {
              // Close DB connection
              if (con != null) {
              con.close();
              }
       }
}
