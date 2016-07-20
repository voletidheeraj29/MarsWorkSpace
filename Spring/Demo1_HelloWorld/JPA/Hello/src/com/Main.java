package com;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public class Main {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
    	System.out.println("hi..");
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hello");
        EntityManager em = emf.createEntityManager();
    	
 
         System.out.println("hi");
       try {
            em.getTransaction().begin();
             
            User user = new User();
            user.setName("newUser");
            user.setPassword("ax222");
             
            em.persist(user);
             
         em.getTransaction().commit();
        }
        catch (Exception e) {
           // em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{
            emf.close();
        }
         
        System.out.println("... over");
    
    }
}