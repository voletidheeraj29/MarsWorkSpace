package com; 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence; 
public class Main1 {     /**     * @param args     */   
	public static void main(String[] args)
	{        
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hello");   
		EntityManager em = emf.createEntityManager();   
		try {            em.getTransaction().begin();    
		         User user = em.find(User.class, 4);   
		         System.out.println(user.getName());  
		         System.out.println("User:"+user);
		         em.getTransaction().commit();        
		         
		}      
		catch (Exception e) 
		{           
			em.getTransaction().rollback();  
			e.printStackTrace();       
			}        
		finally
		{            emf.close();       
		
		}                
		System.out.println(".... over");    }
	
} 
