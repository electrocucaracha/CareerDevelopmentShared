package com.electrocucaracha.apps.cdp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.electrocucaracha.apps.cdp.entities.CategoryEntity;

public class CategoryDaoHibernateImplTest {

	private CategoryDaoHibernateImpl controller;
	
	private static final String TEST_TITLE = "Test title";
	private static final String TEST_DEFINITION = "Test definition";
	private static final double TEST_BUDGET = 50.0;
	private static final double TEST_TIME = 10.0;

	@Before
	public void setUp() throws Exception {
		controller = new CategoryDaoHibernateImpl();
	}

	@Test
	public void getNonExistingCategory() {
		CategoryEntity category = controller.get(-1);
		assertTrue(category == null);
	}

	@Test
	public void createOneCategory() {
		List<CategoryEntity> result = controller.retrieve();
		int count = result.size();
		assertTrue(count >= 0);

		CategoryEntity entity = new CategoryEntity();
		entity.setTitle(TEST_TITLE);
		entity.setDefinition(TEST_DEFINITION);
		entity.setBudget(TEST_BUDGET);
		entity.setTime(TEST_TIME);

		controller.create(entity);
		assertNotNull(entity.getId());

		CategoryEntity saved = controller.get(entity.getId());
		assertEquals(entity, saved);
	}

	@Test
	public void retrieveOneCategory() {
		final int count = 10;
		for (int i = 0; i <= count; i++) {
			controller.create(new CategoryEntity("test" + i, "Definition", 100.0, 50.0));
		}

		List<CategoryEntity> result = controller.retrieve();
		assertTrue(result.size() >= count);
	}

	@Test
	public void deleteExistingCategory() {
		List<CategoryEntity> result = controller.retrieve();
		int count = result.size();
		assertTrue(count >= 0);

		CategoryEntity category = new CategoryEntity("test", "Definition", 100.0, 50.0);

		controller.create(category);
		result = controller.retrieve();
		assertEquals(count + 1, result.size());

		controller.delete(category);
		result = controller.retrieve();
		assertEquals(count, result.size());
	}

	@Test
	public void updateOneCategory() {
		CategoryEntity category = new CategoryEntity("test", "Definition", 100.0, 50.0);
		controller.create(category);
		assertNotNull(category.getId());

		String newCategory = "test2";
		String newDefinition = "Definition2";
		double newBudget = 50.0;
		double newTime = 25.0;
		category.setTitle(newCategory);
		category.setDefinition(newDefinition);
		category.setBudget(newBudget);
		category.setTime(newTime);
		controller.update(category);

		CategoryEntity updatedCategory = controller.get(category.getId());
		assertEquals(updatedCategory.getTitle(), newCategory);
		assertEquals(updatedCategory.getDefinition(), newDefinition);
		assertTrue(updatedCategory.getBudget() == newBudget);
		assertTrue(updatedCategory.getTime() == newTime);
	}

}
