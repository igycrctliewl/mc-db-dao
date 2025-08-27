package mb.minecraft.db.stub.village;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import mb.minecraft.dao.VillageDao;
import mb.minecraft.model.Village;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class SelectAllVillage {

	public static AbstractApplicationContext context;

	private static final Logger logger = LogManager.getLogger( SelectAllVillage.class );

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		VillageDao villageDao = context.getBean( VillageDao.class );

		List<Village> villages = villageDao.selectAll();
		logger.info( "returned {} rows", villages.size() );
		villages.stream().forEach( v -> logger.info( "{}", v ) );

		context.close();
	}
}