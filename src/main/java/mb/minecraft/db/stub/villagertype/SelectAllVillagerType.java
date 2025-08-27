package mb.minecraft.db.stub.villagertype;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import mb.minecraft.dao.VillagerTypeDao;
import mb.minecraft.model.VillagerType;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class SelectAllVillagerType {

	private static final Logger logger = LogManager.getLogger( SelectAllVillagerType.class );

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		VillagerTypeDao villagerTypeDao = context.getBean( VillagerTypeDao.class );

		List<VillagerType> types = villagerTypeDao.selectAll();
		logger.info( "returned {} rows", types.size() );
		types.stream().forEach( v -> logger.info( "{}", v ) );

		context.close();
	}
}