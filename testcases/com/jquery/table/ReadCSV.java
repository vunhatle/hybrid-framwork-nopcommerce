package com.jquery.table;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
public class ReadCSV {
	
	@Test
	 public static void readDataLineByLine() 
	 { 
		 String file  = System.getProperty("user.dir")+ File.separator + "uploadFiles" + File.separator+"csv.csv";
	     try { 
	   
	         // Create an object of filereader 
	         // class with CSV file as a parameter. 
	         FileReader filereader = new FileReader(file); 
	   
	         // create csvReader object passing 
	         // file reader as a parameter 
	         com.opencsv.CSVReader csvReader = new CSVReaderBuilder(filereader) 
                     .withSkipLines(1) 
                     .build(); 
	         String[] nextRecord; 
	   
	         // we are going to read data line by line 
	         while ((nextRecord = csvReader.readNext()) != null) { 
	             for (String cell : nextRecord) { 
	                 System.out.print(cell + "\n"); 
	             } 
	             //System.out.println(); 
	         } 
	     } 
	     catch (Exception e) { 
	         e.printStackTrace(); 
	     } 
	 } 


 
 
} 
 
      

