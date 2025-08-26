package mb.minecraft.db.stub.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import mb.minecraft.dao.VillageDao;
import mb.minecraft.model.Village;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class RenameVillage {

	public static AbstractApplicationContext context;

	private static final Logger logger = LogManager.getLogger( RenameVillage.class );

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		VillageDao villageDao = context.getBean( VillageDao.class );

		Village village = villageDao.selectOneByName( "Heart" );
		logger.info( "Returned: {}", village );

		village.setName( "Heart o the Desert");
		village = villageDao.update( village );

		context.close();
	}
}