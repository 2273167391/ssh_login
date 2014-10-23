package com.tenghu.ssh.core.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class StringTest {
	public static void main(String[] args) {
		System.out.println(" asdfasdf sadfasf\nsafdasd ");
		String s=" asdfasdfasdf c, \nasdfdasf\nfsadf ";
		System.out.println(s.replaceAll("\\s*", ""));
		String[] as=new String[4];
		System.out.println(new Random().nextInt(as.length));
		Map<String, String> handlerMap=new HashMap<String, String>();
		handlerMap.put("1", "zhijieshuru");
		handlerMap.put("2", "shuru");
		
		System.out.println(handlerMap.containsKey("5"));
		StringBuffer sb=new StringBuffer();
		Object list=new ArrayList<String>();
		System.out.println(sb instanceof StringBuffer);
		System.out.println(list instanceof StringBuffer);
	}
}
