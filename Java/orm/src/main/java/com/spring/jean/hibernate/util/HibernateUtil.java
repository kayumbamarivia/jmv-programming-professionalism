package com.spring.jean.hibernate.util;

import com.spring.jean.hibernate.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    // Step 1: Private constructor to prevent instantiation
    private HibernateUtil() {
    }

    // Step 2: The static inner class for the Singleton instance
    private static class HibernateUtilHolder {
        // The Hibernate SessionFactory instance is created here
        private static final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")  // Load hibernate.cfg.xml configuration
                .addAnnotatedClass(User.class)   // Add annotated classes or Use mapping property in hibernate.cfg.xml
                .buildSessionFactory();  // Build SessionFactory
    }

    // Step 3: Public method to get the SessionFactory
    public static SessionFactory getSessionFactory() {
        return HibernateUtilHolder.sessionFactory;  // Return the created sessionFactory instance
    }
}
