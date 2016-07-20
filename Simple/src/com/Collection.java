package com;

import java.util.Enumeration;
import java.util.Vector;

 class Collection {

	public static void main(String[] args) {
	Vector<String> v = new Vector<String>();
		Enumeration<String> en = null;
		v.addElement("raj");
		v.addElement("ramu");
		v.addElement("rani");
		v.addElement("shanti");
		en=v.elements();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement());
		}
	}

}
