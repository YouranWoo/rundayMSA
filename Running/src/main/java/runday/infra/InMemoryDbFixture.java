package runday.infra;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Collection;
import java.util.Properties;

public class InMemoryDbFixture {

    private String scope;

    private Collection<Class<?>> entities;

    public InMemoryDbFixture(String scope, Collection<Class<?>> entities) {
        this.scope = scope;
        this.entities = entities;
    }

    public EntityManager createEntityManager() {
        Properties properties = new Properties();
        properties.put("javax.persistence.provider", "org.hibernate.ejb.HibernatePersistence");
        properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
        properties.put("hibernate.connection.username", "sa");
        properties.put("hibernate.connection.password", "");
        properties.put("hibernate.connection.driver_class", "org.h2.Driver");
        properties.put("hibernate.connection.url", String.format("jdbc:h2:mem:%s;MODE=DB2", scope));
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");

        Configuration cfg = new Configuration().addProperties(properties);
        for (Class<?> clazz : entities) {
            cfg.addAnnotatedClass(clazz);
        }

        EntityManagerFactory factory = cfg.buildSessionFactory();
        return factory.createEntityManager();
    }
}