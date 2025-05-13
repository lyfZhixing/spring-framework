package org.springframework.test.context.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.TestBean;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");

		// 包扫描
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.springframework.test");
		TestBean bean = context.getBean(TestBean.class);
		System.out.println("annotation - package - " + bean);

		// 类扫描
		AnnotationConfigApplicationContext classContext = new AnnotationConfigApplicationContext(TestBean.class);
		TestBean clazzBean = classContext.getBean(TestBean.class);
		System.out.println("annotation - class - " + clazzBean);

		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		Object xmlBean = xmlContext.getBean("myTestBean");
		System.out.println("xml - " + xmlBean);

	}
}