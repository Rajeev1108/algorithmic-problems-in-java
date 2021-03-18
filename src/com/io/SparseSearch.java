package com.io;

import java.util.HashMap;
import java.util.Map.Entry;

//Sparsed array of string is an array with empty strings in it like shown in input 
class SparseSearch
{
    public static int searchForString(String[] array, String target) 
    {
       
    	HashMap<Integer, String> hmap = new HashMap();
    	
    	for (int i =0; i<array.length-1; i++) {
    		hmap.put(i, array[i]);
    	}
    	
		for (Entry<Integer, String> set : hmap.entrySet()) {
		    if(set.getValue() == target) {
		    	return set.getKey();
		    }
		}
    	
    	
        return -1;
    }
    
    
    public static void main(String[] args) {
    	
    	String[] strArr = {"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};

    	String searchString = "kuchbhi";
    	System.out.println("target Index is---> "+ searchForString(strArr, searchString));
    	
    }
}
