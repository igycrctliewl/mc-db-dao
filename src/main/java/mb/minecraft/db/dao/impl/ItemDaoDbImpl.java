package mb.minecraft.db.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.RollbackException;
import mb.minecraft.dao.ItemDao;
import mb.minecraft.model.Item;


@Repository
public class ItemDaoDbImpl implements ItemDao {

	private static final Logger logger = LogManager.getLogger( ItemDaoDbImpl.class );

	@Autowired
	private EntityManager em;

	@Override
	public void destroy() throws Exception {
		logger.info( ">>>> ItemDaoDbImpl.destroy()" );
	}

	@Override
	public boolean deleteOne( Item item ) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery( "DELETE FROM ITEM WHERE ID = ?1" );
		q.setParameter( 1, item.getId() );
		int numRows = q.executeUpdate();
		em.getTransaction().commit();
		return numRows > 0;
	}

	@Override
	public Item insertOne( Item item ) {
		try {
			em.getTransaction().begin();
			em.persist( item );
			em.getTransaction().commit();
		} catch ( RollbackException rx ) {
			logger.error( rx );
			return null;
		}
		return item;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Item> selectAll() {
		Query q = em.createQuery( "select i from Item i" );
		return q.getResultList();
	}

	@Override
	public Item selectOneById( int itemId ) {
		Query q = em.createQuery( "select i from Item i where i.id = ?1" );
		q.setParameter( 1, itemId );
		try {
			Item i = (Item) q.getSingleResult();
			return i;
		} catch( NoResultException nre ) {
			return null;
		}
	}

	@Override
	public Item selectOneByName( String itemName ) {
		Query q = em.createQuery( "select i from Item i where i.name = ?1" );
		q.setParameter( 1, itemName );
		try {
			Item i = (Item) q.getSingleResult();
			return i;
		} catch( NoResultException nre ) {
			return null;
		}
	}

	@Override
	public Item update( Item item ) {
		em.clear();
		em.getTransaction().begin();
		Query q = em.createNativeQuery( "UPDATE ITEM SET IMAGE_SOURCE = ?1 WHERE ID = ?2" );
		q.setParameter( 1, item.getImageSource() );
		q.setParameter( 2, item.getId() );
		int numRows = q.executeUpdate();
		em.getTransaction().commit();
		if( numRows > 0 )
			return item;
		else
			return null;
	}

}
