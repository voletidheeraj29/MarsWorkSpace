package com.java;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;  
  
  
public class StoreData {  
public static void main(String[] args) {  
      
    //creating configuration object  
    Configuration cfg=new Configuration();  
    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
      
    //creating session factory object  
    SessionFactory factory=cfg.buildSessionFactory();  
      
    //creating session object  
    Session session=factory.openSession();  
      
    //creating transaction object  
    Transaction t=session.beginTransaction();  
          
    Person e1=new Person();  
    e1.setId(151);  
    e1.setName("Asawari");  
    e1.setAddress("nagapur");  
   Person e2=new Person();
    e2.setId(152);
    e2.setName("Ramesh");
    e2.setAddress("hyd");
    session.persist(e1);//persisting the object  
    session.persist(e2);
    t.commit();//transaction is commited  
    session.close();  
      
    System.out.println("successfully saved");  
      
}  
}  