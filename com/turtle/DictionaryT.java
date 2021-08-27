package com.turtle; 

import java.util.*;

public class DictionaryT
{

	private Map<Integer,String> rule=new HashMap();

	public void setRule(char s,String e){
		rule.put((int)s,e);
	}

	public String getRule(char s){
		return rule.get((int)s);
	}
	
}
