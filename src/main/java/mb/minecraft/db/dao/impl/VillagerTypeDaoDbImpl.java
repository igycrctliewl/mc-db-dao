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
import mb.minecraft.dao.VillagerTypeDao;
import mb.minecraft.model.VillagerType;


@Repository
public class VillagerTypeDaoDbImpl implements VillagerTypeDao {

	private static final Logger logger = LogManager.getLogger( VillagerTypeDaoDbImpl.class );

	@Autowired
	private EntityManager em;


	@Override
	public void destroy() throws Exception {
		logger.info( ">>>> VillagerTypeDaoDbImpl.destroy()" );
	}

	@Override
	public boolean deleteOne( VillagerType type ) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery( "DELETE FROM VILLAGER_TYPE WHERE ID = ?1" );
		q.setParameter( 1, type.getId() );
		int numRows = q.executeUpdate();
		em.getTransaction().commit();
		return numRows > 0;
	}

	@Override
	public VillagerType insertOne( VillagerType type ) {
		try {
			em.getTransaction().begin();
			em.persist( type );
			em.getTransaction().commit();
		} catch ( RollbackException rx ) {
			logger.error( rx );
			return null;
		}
		return type;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<VillagerType> selectAll() {
		Query q = em.createQuery( "select t from VillagerType t" );
		return q.getResultList();
	}

	@Override
	public VillagerType selectOneById( int typeId ) {
		Query q = em.createQuery( "select t from VillagerType t where t.id = ?1" );
		q.setParameter( 1, typeId );
		try {
			VillagerType type = (VillagerType) q.getSingleResult();
			return type;
		} catch( NoResultException nre ) {
			return null;
		}
	}

	@Override
	public VillagerType selectOneByName( String profession ) {
		Query q = em.createQuery( "select t from VillagerType t where t.profession = ?1" );
		q.setParameter( 1, profession );
		try {
			VillagerType type = (VillagerType) q.getSingleResult();
			return type;
		} catch( NoResultException nre ) {
			return null;
		}
	}

}
