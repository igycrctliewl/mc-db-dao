package com.mikebro.jpatutorial.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mikebro.jpatutorial.entity.Employee;

import jakarta.persistence.EntityManager;

/*
 * This started from a tutorials-point(less) JPA tutorial, which didn't really help
 * I found much more help from this guy:
 * Thanks https://www.vogella.com/tutorials/JavaPersistenceAPI/article.html
 */
public class CreateEmployee {

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "com.mikebro.jpatutorial" );
		EntityManager em = context.getBean( EntityManager.class );
		em.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEid(20444);
		employee.setEmployeeName("Mikebro");
		employee.setSalary(62500);
		employee.setDeg("Programmer");

		em.persist(employee);
		em.getTransaction().commit();

		context.close();
	}
}