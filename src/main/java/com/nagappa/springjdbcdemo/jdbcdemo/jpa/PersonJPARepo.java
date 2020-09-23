package com.nagappa.springjdbcdemo.jdbcdemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nagappa.springjdbcdemo.jdbcdemo.entity.Person;

//Repository
//Transaction

@Repository
@Transactional
public class PersonJPARepo {
	
	//connect to database
	@PersistenceContext
	EntityManager  entityManager;
	
	
	public Person findById(int id) {
		
		return entityManager.find(Person.class,id);//jpa
	
	}
}
