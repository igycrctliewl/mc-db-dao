package mb.minecraft.db.stub.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import jakarta.persistence.EntityManager;
import mb.minecraft.dao.VillageDao;
import mb.minecraft.db.entity.Village;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class DeleteVillage {

	private static final Logger logger = LogManager.getLogger( DeleteVillage.class );

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		EntityManager em = context.getBean( EntityManager.class );
		VillageDao villageDao = context.getBean( VillageDao.class );

		Village village = new Village();
		village.setId( 1 );
		if( villageDao.deleteOne( village ) )
			logger.info( "Row deleted" );
		else
			logger.info( "Nothing done" );

		context.close();
	}
}