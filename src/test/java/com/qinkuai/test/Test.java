package com.qinkuai.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.qinkuai.classdemo.model.Student;

public class Test {
	
	public static void main(String[] args) throws Exception{
		List<String> list = new ArrayList<>();
		
		list.add("Zhang");
		list.add("Wen");
		list.add("Qinkuai");
		
		for (String string : list) {
			System.out.println(string);
		}
		
	}
	

}
