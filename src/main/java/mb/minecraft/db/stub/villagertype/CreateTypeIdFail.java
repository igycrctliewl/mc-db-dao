package mb.minecraft.db.stub.villagertype;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import mb.minecraft.dao.VillagerTypeDao;
import mb.minecraft.db.entity.VillagerType;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class CreateTypeIdFail {

	private static final Logger logger = LogManager.getLogger( CreateTypeIdFail.class );

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		VillagerTypeDao villagerTypeDao = context.getBean( VillagerTypeDao.class );

		VillagerType type = new VillagerType();
		type.setId( 101 );
		type.setProfession( "Profession-43" );
		mb.minecraft.model.VillagerType newType = villagerTypeDao.insertOne( type );

		logger.info( "Returned: {}", newType );

		context.close();
	}
}