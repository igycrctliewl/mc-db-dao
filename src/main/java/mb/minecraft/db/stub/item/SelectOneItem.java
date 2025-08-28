package mb.minecraft.db.stub.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import mb.minecraft.dao.ItemDao;
import mb.minecraft.model.Item;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class SelectOneItem {

	public static AbstractApplicationContext context;

	private static final Logger logger = LogManager.getLogger( SelectOneItem.class );

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		ItemDao itemDao = context.getBean( ItemDao.class );

		Item item = itemDao.selectOneById( 1001 );
		logger.info( "Returned: {}", item );

		context.close();
	}
}