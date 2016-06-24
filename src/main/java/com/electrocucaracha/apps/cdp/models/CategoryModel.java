package com.electrocucaracha.apps.cdp.models;

import org.json.simple.JSONObject;

import com.electrocucaracha.apps.cdp.entities.CategoryEntity;

public class CategoryModel {
	private CategoryEntity entity;

	public CategoryModel(CategoryEntity entity) {
		this.entity = entity;
	}
	
	public String toJson(){
		JSONObject obj = new JSONObject();
		
		obj.put("title", entity.getTitle());
		obj.put("definition", entity.getDefinition());
		obj.put("budget", entity.getBudget());
		obj.put("time", entity.getTime());
		obj.put("comments",  entity.getComments());
		
		return obj.toJSONString();
	}
}
