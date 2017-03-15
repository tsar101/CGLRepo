package org.animesh.PDFReading.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
   
   
   private SessionFactory sessionFactory;
   
   public  SessionUtil getInstance(){
           return this;
   }
   
   public SessionUtil(){
       Configuration configuration = new Configuration();
       configuration.configure("hibernate.cfg.xml");
       sessionFactory = configuration.buildSessionFactory();
   
   }
   
   public  Session getSession(){
       Session session =  this.sessionFactory.openSession();
       
       return session;
   }
}