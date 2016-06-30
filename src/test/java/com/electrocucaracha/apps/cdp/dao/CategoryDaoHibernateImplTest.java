package com.electrocucaracha.apps.cdp.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.electrocucaracha.apps.cdp.entities.CategoryEntity;

public class CategoryDaoHibernateImplTest {

	private CategoryDao controller;

	private static final String TEST_TITLE = "Test title";

	@Before
	public void setUp() throws Exception {
		controller = new CategoryDaoHibernateImpl();
		
		CategoryEntity entity = new CategoryEntity();
		entity.setTitle(TEST_TITLE);

		controller.create(entity);
	}

	@Test
	public void findCategoryByTitle() {
		assertNull(controller.getCategoryByTitle("Non-existing"));
		assertNotNull(controller.getCategoryByTitle(TEST_TITLE));
	}

}
