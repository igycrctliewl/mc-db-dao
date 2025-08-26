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
public class SelectOneVillage {

	public static AbstractApplicationContext context;

	private static final Logger logger = LogManager.getLogger( SelectOneVillage.class );

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		VillageDao villageDao = context.getBean( VillageDao.class );

		Village village = villageDao.selectOneById( 215 );
		logger.info( "Returned: {}", village );

		context.close();
	}
}