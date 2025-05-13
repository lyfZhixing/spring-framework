package org.springframework.test.context.main;

import com.sun.tools.javac.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.PrototypeBean;
import org.springframework.test.context.TestBean;

public class ScopeMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello world! Test scope.....");

		// 在单例bean中注入原型bean
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.springframework.test.context");
		PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
		System.out.println(prototypeBean.getName());

		// 单例
		TestBean clazzBean = context.getBean(TestBean.class);
		for (String name : List.of("lisi", "zhangsan", "wangwu")) {
			// clazzBean.exec(name);
			new Thread(() -> clazzBean.execProvider(name)).start();
		}
		Thread.sleep(4000);
		System.out.println("main end");
	}
}
