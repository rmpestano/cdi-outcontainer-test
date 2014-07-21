package com.rs.jug.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

@ApplicationScoped
public class MyBean {

	private boolean alive;
	
	@PostConstruct
	public void init(){
		alive = true;
	}
	
	public boolean isAlive() {
		return alive;
	}
}
