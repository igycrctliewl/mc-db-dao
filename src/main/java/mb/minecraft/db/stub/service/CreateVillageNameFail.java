package mb.minecraft.db.stub.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import mb.minecraft.dao.VillageDao;
import mb.minecraft.db.entity.Village;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class CreateVillageNameFail {

	private static final Logger logger = LogManager.getLogger( CreateVillageNameFail.class );

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		VillageDao villageDao = context.getBean( VillageDao.class );

		Village village = new Village();
		village.setId( 999 );
		village.setName( "Heart" );
		mb.minecraft.model.Village newVillage = villageDao.insertOne( village );

		logger.info( "Returned {}", newVillage );

		context.close();
	}
}