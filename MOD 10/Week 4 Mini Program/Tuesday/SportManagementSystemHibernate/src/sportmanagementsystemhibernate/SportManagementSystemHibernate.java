/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportmanagementsystemhibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Tristan
 */
public class SportManagementSystemHibernate {

    /**
     * @param args the command line arguments
     */
    
     private static SessionFactory factory;
    
     public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            factory = new Configuration().configure().buildSessionFactory();
       
        
        SportManagementSystemHibernate hsm = new SportManagementSystemHibernate();
        
        ///read out the data
        
        Session session = factory.openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            List stuff = session.createQuery("FROM sportmanagementsystemhibernate.Foosball").list();
            
            for (Iterator iterator = stuff.iterator(); iterator.hasNext();) {
                Foosball club = (Foosball) iterator.next();
                
                System.out.println("Player " + club.getPlayerId() + "\r\n Name : " + 
                        club.getName() + "\r\n Age : " + club.getAge() + "\r\n Matches : " + 
                        club.getMatches() + "\r\n Location : " + club.getLocation());
            }
            
            tx.commit();
            
        } catch (HibernateException e) {
            if (tx!= null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
         } catch (Throwable ex) {
            System.err.println("Haha eRRor!");
            throw new ExceptionInInitializerError(ex);
        }
        
        
    }
    
}
