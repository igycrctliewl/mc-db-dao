package mb.minecraft.db.stub.village;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import mb.minecraft.dao.VillageDao;
import mb.minecraft.db.entity.Village;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class CreateVillageIdFail {

	private static final Logger logger = LogManager.getLogger( CreateVillageIdFail.class );

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		VillageDao villageDao = context.getBean( VillageDao.class );

		Village village = new Village();
		village.setId( 201 );
		village.setName( "Village-43" );
		mb.minecraft.model.Village newVillage = villageDao.insertOne( village );

		logger.info( newVillage );

		context.close();
	}
}