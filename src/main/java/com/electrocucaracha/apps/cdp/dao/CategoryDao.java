package com.electrocucaracha.apps.cdp.dao;

import java.util.List;

import com.electrocucaracha.apps.cdp.entities.CategoryEntity;

public interface CategoryDao {
	long create(CategoryEntity model);

	List<CategoryEntity> retrieve();

	CategoryEntity get(long id);

	void delete(CategoryEntity model);

	void update(CategoryEntity model);
	
	CategoryEntity getCategoryByTitle(String title);
}
