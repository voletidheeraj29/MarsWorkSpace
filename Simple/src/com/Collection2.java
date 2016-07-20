package com;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Collection2 {
public static void main(String args[]){
	List<Integer> l=new ArrayList<Integer>();
	ListIterator <Integer> li=null;
l.add(12);
l.add(13);
li=l.listIterator();
while(li.hasNext()){
	System.out.println(li);
	
}
System.out.println();

}
}
