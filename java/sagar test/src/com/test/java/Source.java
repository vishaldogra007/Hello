package com.test.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 class Technology {
	private int techIndex;
	private String tech;
	public int getTechIndex() {
		return techIndex;
	}
	public void setTechIndex(int techIndex) {
		this.techIndex = techIndex;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Technology [techIndex=" + techIndex + ", tech=" + tech + "]";
	}

	
	

}
 class TechService {
	String[] techArray = {"Java" , "Python" ,"C#" , "MERN" , "MEAN" };
	public List<String> getAllTexts(String sentence){
		List<String> l1 = new ArrayList<String>();
		for (String val: sentence.split(" ")){
			l1.add(val);
			
		}
		return l1;
	    
    }
		
	public List<Technology> getTechnologies(String sentence){
		
		List<Technology> lt = new ArrayList<Technology>();
		String[] ls = sentence.split(" ");
		for(int j=0 ;j<ls.length ; j++) {
		//for (String val: sentence.split(" ")){
			for(int i=0 ; i< techArray.length ; i++) {
				if(ls[j].equals(techArray[i])) {
					Technology techData = new Technology();
					String techno = ls[j];
					techData.setTech(techno);
					techData.setTechIndex(j);
					lt.add(techData);
					
				}
				
			}
				
		}
		return lt;
	}
}
 public class Source{
	 public static void main(String args[]) {
		 
		 TechService t = new TechService();
		 List<Technology> s = t.getTechnologies("Classes on Java MERN and MEAN");
		 for(Technology st : s) {
			 System.out.println(st);
			 
		 }
		 
	 }
 }
