package mb.minecraft.db.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import mb.minecraft.dao.VillageDao;
import mb.minecraft.model.Village;


@Repository
public class VillageDaoDbImpl implements VillageDao {

	@Autowired
	private EntityManager em;


	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteOne(Village arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Village insertOne( Village village ) {
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
	public Village selectOneById(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Village selectOneByName(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Village update(Village arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
