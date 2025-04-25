package com.jhonny.inventario.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        // Carga hibernate.cfg.xml desde src/main/resources/
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // busca hibernate.cfg.xml en el classpath
                .build();
        try {
            return new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw new ExceptionInInitializerError("Error inicializando Hibernate: " + ex.getMessage());
        }
    }

    /** Devuelve el SessionFactory singleton */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /** Cierra el SessionFactory liberando recursos */
    public static void shutdown() {
        getSessionFactory().close();
    }
}
