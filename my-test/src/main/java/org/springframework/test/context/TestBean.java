package org.springframework.test.context;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestBean {
	private String name = "me";

	/** 注入原型 bean */
	@Autowired
	private PrototypeBean prototypeBean;
	@Autowired
	private ObjectProvider<PrototypeBean> objectProvider;

	public TestBean(String name) {
		this.name = name;
	}

	public TestBean() {
	}

	@Override
	public String toString() {
		return "MyTestBean{" +
				"name='" + name + '\'' +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void exec(String name) {
		prototypeBean.doWork(name);
	}
	public void execProvider(String name) {
		PrototypeBean ifAvailable = objectProvider.getIfAvailable();
		if (ifAvailable != null) {
			ifAvailable.doWork(name);
		}
	}
}
