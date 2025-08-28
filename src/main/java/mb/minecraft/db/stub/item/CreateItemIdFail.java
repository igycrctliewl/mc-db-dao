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
public class CreateItemIdFail {

	private static final Logger logger = LogManager.getLogger( CreateItemIdFail.class );

	public static AbstractApplicationContext context;

	public static void main(String[] args) {

		context = new AnnotationConfigApplicationContext( "mb.minecraft.db" );
		ItemDao itemDao = context.getBean( ItemDao.class );

		Item item = new Item();
		item.setId( 1 );
		item.setName( "New Item" );
		mb.minecraft.model.Item newItem = itemDao.insertOne( item );
		logger.info( "Returned: {}", newItem );

		context.close();
	}
}