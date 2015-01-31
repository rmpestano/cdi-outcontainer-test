package com.rs.jug.bean;

import org.apache.deltaspike.core.api.config.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MyBean {

	private boolean alive;

	@Inject
	@ConfigProperty(name="test")
	String test;
	
	@PostConstruct
	public void init(){
		alive = true;
	}
	
	public boolean isAlive() {
		return alive;
	}

	public String getTestSystemProperty(){
		return test;
	}
}
