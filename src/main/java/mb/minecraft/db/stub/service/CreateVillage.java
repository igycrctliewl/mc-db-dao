package mb.minecraft.db.stub.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import jakarta.persistence.EntityManager;
import mb.minecraft.dao.VillageDao;
import mb.minecraft.db.entity.Village;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class CreateVillage {

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		EntityManager em = context.getBean( EntityManager.class );
		VillageDao villageDao = context.getBean( VillageDao.class );

		Village village = new Village();
		village.setName( "Village-43" );
		mb.minecraft.model.Village newVillage = villageDao.insertOne( village );

		context.close();
	}
}