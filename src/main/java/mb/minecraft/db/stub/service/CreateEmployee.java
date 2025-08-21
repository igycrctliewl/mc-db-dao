package mb.minecraft.db.stub.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import jakarta.persistence.EntityManager;
import mb.minecraft.db.entity.Village;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class CreateEmployee {

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		EntityManager em = context.getBean( EntityManager.class );
		em.getTransaction().begin();

		Village village = new Village();
		village.setId( 4 );
		village.setName( "Deep Water Cove" );

		em.persist(village);
		em.getTransaction().commit();

		context.close();
	}
}