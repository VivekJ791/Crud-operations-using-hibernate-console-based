package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtility {
    public static SessionFactory getSessionFactory(){
        Configuration c=new Configuration();
        c.configure();
        SessionFactory sf=c.buildSessionFactory();
        return sf;
    }
}
