package com.test.java;

class SpamDetector{
 private int primaryCount;
 private int promotionCount;
 private int updateCount;
public int getPrimaryCount() {
	return primaryCount;
}
public void setPrimaryCount(int primaryCount) {
	this.primaryCount = primaryCount;
}
public int getPromotionCount() {
	return promotionCount;
}
public void setPromotionCount(int promotionCount) {
	this.promotionCount = promotionCount;
}
public int getUpdateCount() {
	return updateCount;
}
public void setUpdateCount(int updateCount) {
	this.updateCount = updateCount;
}
   
SpamDetector(int primaryCount , int promotionCount , int updateCount){
	this.primaryCount = primaryCount;
	this.promotionCount  = promotionCount;
	this.updateCount = updateCount;
}

public String addmessage (String email) throws SpamAttackException , SuspendException {
	
	String[] ls = email.split(" ");
	String[] prowords = {"offer" , "bonanza" ,"sale" , "hurry"  };
	String[] words = {"excel"  , "word" ,"ppt" ,"update"};
	//for(String var : ls) {
	for(int i=0 ; i< prowords.length ; i++) {
		for(int j=0 ; j<ls.length ;j++) {
			
		if(prowords[i].equals(ls[j]) ) {
			
			promotionCount = promotionCount + 1;
			
		}else if(words[i].equals(ls[j])) {
			System.out.println(getUpdateCount());
			updateCount=updateCount +1;
			
		}else {
			System.out.println("pc " + primaryCount);
			primaryCount = primaryCount+1;
		}
		}
	}
	if(promotionCount > updateCount && updateCount > primaryCount  ) {
		throw new SuspendException("Account Suspended");
	}else if(promotionCount > ((primaryCount + updateCount)*0.75)) {
		throw new SpamAttackException("Account in Attack");
	}else {
		return "Safe";
	}
}
 
	
	
}

class SpamAttackException extends Exception {
	public SpamAttackException(String message) {
		super(message);
		
	}
}
class SuspendException extends Exception {
	public SuspendException(String message) {
		super(message);
		
	}
}

public class Source2 {
	public static void main(String args[]) {
		try {
			SpamDetector spamDetector = new SpamDetector(10 , 10 ,10);
			System.out.println(spamDetector.addmessage("iphone 21 offer"));
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
