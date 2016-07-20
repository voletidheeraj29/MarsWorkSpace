package com.java;

import org.hibernate.*;  
import org.hibernate.cfg.*;  
  
public class Test {  
public static void main(String[] args) {  
    Session session=new AnnotationConfiguration()  
         .configure().buildSessionFactory().openSession();  
      
    Transaction t=session.beginTransaction();  
      
    Employee e1=new Employee();  
    e1.setId(1001);  
    e1.setName("sonoo");  
    e1.setAddress("jaiswal");  
      
    Employee e2=new Employee();  
    e2.setId(1002);  
    e2.setName("vimal");  
    e2.setAddress("jaiswal");  
      
    session.persist(e1);  
    session.persist(e2);  
      
    t.commit();  
    session.close();  
    System.out.println("successfully saved");  
}  
}  