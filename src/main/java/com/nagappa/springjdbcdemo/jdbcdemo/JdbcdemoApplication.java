package com.nagappa.springjdbcdemo.jdbcdemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nagappa.springjdbcdemo.jdbcdemo.entity.Person;

//@SpringBootApplication
public class JdbcdemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("\nAll users --> {}",dao.findAll());
		logger.info("\nUser id is 10001 -->{}",dao.findById(10001));
		logger.info("\ndeleting id 10002 --> No of rows deleted-->{}",dao.deleteById(10002));
		logger.info("\nAfter Deleting All users --> {}",dao.findAll());
		logger.info("\ninserting 10004 -->No of rows changed--> {}",dao.insert(new Person(10004,"Tara","Berlin",
				new Date())));
		
		logger.info("\nupdate 10003 --> No of rows changed-->{}",dao.update(new Person(10003,"peter","Delhi",
				new Date())));
		
		
		
	}

}
