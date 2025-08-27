package mb.minecraft.db.stub.villagertype;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import mb.minecraft.dao.VillagerTypeDao;
import mb.minecraft.model.VillagerType;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class SelectOneType {

	public static AbstractApplicationContext context;

	private static final Logger logger = LogManager.getLogger( SelectOneType.class );

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		VillagerTypeDao villagerTypeDao = context.getBean( VillagerTypeDao.class );

		VillagerType type = villagerTypeDao.selectOneById( 105 );
		logger.info( "Returned: {}", type );

		context.close();
	}
}