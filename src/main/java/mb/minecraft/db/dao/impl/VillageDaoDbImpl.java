package mb.minecraft.db.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import mb.minecraft.dao.VillageDao;
import mb.minecraft.model.Village;


@Repository
public class VillageDaoDbImpl implements VillageDao {

	private static final Logger logger = LogManager.getLogger( VillageDaoDbImpl.class );

	@Autowired
	private EntityManager em;


	@Override
	public void destroy() throws Exception {
		logger.info( ">>>> VillageDaoDbImpl.destroy()" );
	}

	@Override
	public boolean deleteOne( Village village ) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery( "DELETE FROM VILLAGE WHERE ID = ?" );
		q.setParameter( 1, village.getId() );
		int numRows = q.executeUpdate();
		em.getTransaction().commit();
		return numRows > 0;
	}

	@Override
	public Village insertOne( Village village ) {
		// TODO catch  java.sql.SQLIntegrityConstraintViolationException
		em.getTransaction().begin();
		em.persist( village );
		em.getTransaction().commit();
		return village;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Village> selectAll() {
		Query q = em.createQuery( "select v from Village v" );
		return q.getResultList();
	}

	@Override
	public Village selectOneById( int villageId ) {
		Query q = em.createQuery( "select  v from Village v where v.id = ?1" );
		q.setParameter( 1, villageId );
		try {
			Village v = (Village) q.getSingleResult();
			return v;
		} catch( NoResultException nre ) {
			return null;
		}
	}

	@Override
	public Village selectOneByName( String villageName ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Village update( Village village ) {
		// TODO Auto-generated method stub
		return null;
	}

}
