package mb.minecraft.db.stub.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import mb.minecraft.dao.ItemDao;
import mb.minecraft.db.entity.Item;

/*
 * This is really just a testing stub to confirm the database configuration
 */
public class UpdateItem {

	private static final Logger logger = LogManager.getLogger( UpdateItem.class );

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		ItemDao itemDao = context.getBean( ItemDao.class );

		Item item = new Item();
		item.setId( 151 );
		if( itemDao.deleteOne( item ) )
			logger.info( "Row deleted" );
		else
			logger.info( "Nothing done" );

		context.close();
	}
}