package mb.minecraft.db.dao;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/*
 * Create the EntityManager bean for the application
 */
@Component
public class DbConfig {

	@Bean
	public EntityManager main(String[] args) {
		Map<String,Object> properties = new HashMap<>();
//		properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:derby://ibookg4:1527/tutorialdb3;create=true" );
		properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:derby:C:/Users/mikebro/db/mcdb;create=true" );
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "mc-db", properties );
		return emfactory.createEntityManager();
	}
}