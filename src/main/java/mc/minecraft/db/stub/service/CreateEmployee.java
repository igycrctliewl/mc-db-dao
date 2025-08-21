package mc.minecraft.db.stub.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import jakarta.persistence.EntityManager;
import mc.minecraft.db.entity.Employee;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class CreateEmployee {

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mc.minecraft.db" );
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