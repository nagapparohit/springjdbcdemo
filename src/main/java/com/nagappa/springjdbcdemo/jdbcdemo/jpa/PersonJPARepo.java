package com.nagappa.springjdbcdemo.jdbcdemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
	
	
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
		return namedQuery.getResultList();
	}
	public Person findById(int id) {
		
		return entityManager.find(Person.class,id);//jpa
	
	}
	
	/**
	 * Whether you want to update or insert you need to call the merge method
	 * merge will knw if there is id set in the person then it will update
	 * and if there is no id set it will insert the person.
	 * @param person
	 * @return
	 */
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	
	
	public Person insert(Person person) {
		return entityManager.merge(person);
	}
	
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	
	
	
	
}
