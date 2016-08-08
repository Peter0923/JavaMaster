package com.autodesk.zen.model;

import java.util.HashMap;
import java.util.Map;

public class Hero {
	private String name;
	private String desc;
	private Map<String,Object> inputs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Map<String, Object> getInputs() {
		return inputs;
	}

	public void setInputs(Map<String, Object> inputs) {
		this.inputs = inputs;
	}
}
