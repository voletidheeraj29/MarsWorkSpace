package com;

import java.util.*;

public class Vector1{
   public static void main(String args[]) {
      /* Vector of initial capacity(size) of 2 */
      Vector<String> vec = new Vector<String>(2);
      System.out.println("Default capacity increment is: "+vec.capacity());
      /* Adding elements to a vector*/
      vec.addElement("Apple");
      vec.addElement("Orange");
      vec.addElement("Mango");
      vec.addElement("Fig");
      vec.addElement("chikku");
      Vector<String> vec1 = new Vector<String>(2);
      /* check size and capacityIncrement*/
      System.out.println("Size is: "+vec.size());
      System.out.println("Default capacity increment is: "+vec.capacity());

      vec1.addElement("chikku");
      vec1.addElement("fruit2");
      vec1.addElement("fruit3");
      System.out.println(vec.addAll(vec1));
      /*size and capacityIncrement after two insertions*/
      System.out.println("Size after addition: "+vec.firstElement());
      System.out.println("Capacity after increment is: "+vec.lastElement());

      /*Display Vector elements*/
      Enumeration en = vec.elements();
      System.out.println("\nElements are:");
      while(en.hasMoreElements())
         System.out.print(en.nextElement()+" ");
   }
}
