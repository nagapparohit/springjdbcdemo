package com.nagappa.springjdbcdemo.jdbcdemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nagappa.springjdbcdemo.jdbcdemo.entity.Person;
import com.nagappa.springjdbcdemo.jdbcdemo.jpa.PersonJPARepo;
/**
 * This will automatically create becuase hibernate have schema update feautre as spring sees entity ,jpa in classpath
 * @author 91783
 *
 */
@SpringBootApplication
public class JPAdemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJPARepo repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JPAdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\nUser id 10001 -->{}",repository.findById(10001));
		
		/*
		 * logger.info("\ninserting 10004 -->No of rows changed--> {}",repository.insert
		 * (new Person(10004,"Tara","Berlin", new Date())));
		 */
		//hibernate will ignore the id if its new record so best way to do is remove id from above cmd.
		logger.info("\ninserting 10004 -->No of rows changed--> {}",repository.insert(new
				  Person("Tara","Berlin", new Date())));
		logger.info("\nupdate 10003 --> No of rows changed-->{}",repository.update(new
				  Person(10003,"peter","Delhi", new Date())));
				 
		//unfortnately we cannot use logger here as it return void
		repository.deleteById(10002);
				 
		logger.info("\nAll users --> {}",repository.findAll());
		   
		
		 
		
		
	}

}
