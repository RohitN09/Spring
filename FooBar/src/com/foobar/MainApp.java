package com.foobar;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		Bar bar = context.getBean("bar",Bar.class);
		System.out.println(bar);
		bar.processFooName();
		context.close();
	}
}
