package com; 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence; 
public class Main2 
{     /**     * @param args     */  
	public static void main(String[] args)
	{   
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hello"); 
		EntityManager em = emf.createEntityManager(); 
		try {            em.getTransaction().begin(); 
		         User user = em.find(User.class, 1);  
		         System.out.println("user"+user);
		         user.setName("Changedname");    
		         em.getTransaction().commit();   
		         
		     }      
		 catch (Exception e)
		    {            em.getTransaction().rollback();   
		            e.printStackTrace();       
		           }    
		   finally{       
			      emf.close();   
			      
		          }        
		   
		   System.out.println("...over");   
		   }
	} 