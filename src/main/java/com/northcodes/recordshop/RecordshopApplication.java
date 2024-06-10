package com.northcodes.recordshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecordshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecordshopApplication.class, args);
//		try (var connection = DB.connect()){
//			if(connection != null)
//			{
//				System.out.println("Connection succeeded!");
//			}
//			else
//			{
//				// this should never really occur as any problem connecting should trigger a SQLException
//				System.out.println("Connection failed!");
//			}
//		} catch (
//				SQLException e) {
//			System.err.println(e.getMessage());
//		}
	}

}
