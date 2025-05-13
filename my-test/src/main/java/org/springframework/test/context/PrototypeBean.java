package org.springframework.test.context;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
// @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope(value = "prototype")
public class PrototypeBean {
	private String name;

	public PrototypeBean(String name) {
		this.name = name;
	}

	public PrototypeBean() {
	}

	@Override
	public String toString() {
		return "PrototypeBean{" +
				"name='" + name + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void doWork(String name) {
		this.setName(name);
		System.out.println( this.name + " doWork step 1");
		System.out.println(this.hashCode());
		try {
			Thread.sleep(1000);
			System.out.println( this.name + " doWork step 2");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setName(String name) {
		System.out.println(this.hashCode());
		this.name = name;
	}
}
