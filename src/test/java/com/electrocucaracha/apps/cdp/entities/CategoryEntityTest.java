package com.electrocucaracha.apps.cdp.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryEntityTest {
	private static final String TEST_TITLE = "Test title";
	private static final String TEST_DEFINITION = "Test definition";
	private static final double TEST_BUDGET = 50.0;
	private static final double TEST_TIME = 10.0;
	private static final String TEST_COMMENTS = "Test comments";

	private CategoryEntity entity = new CategoryEntity();
	private CategoryEntity entityDuplicate = new CategoryEntity();

	@Before
	public void setUp() throws Exception {
		entity.setDefinition(TEST_DEFINITION);
		entity.setBudget(TEST_BUDGET);
		entity.setTitle(TEST_TITLE);
		entity.setComments(TEST_COMMENTS);
		entity.setTime(TEST_TIME);
	}

	@Test
	public void validateSameObject() {
		assertEquals(entity, entity);
	}

	@Test
	public void validateEqualsNull() {
		assertNotEquals(entity, null);
	}

	@Test
	public void validateEqualsDifferentClass() {
		assertNotEquals(entity, new Object());
	}

	@Test
	public void validateDifferentAreas() {
		entityDuplicate.setAreas(new AreaEntity[1]);

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateDifferentBudget() {
		entityDuplicate.setAreas(null);
		entityDuplicate.setBudget(TEST_BUDGET + 1);

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateDifferentTitle() {
		entityDuplicate.setAreas(null);
		entityDuplicate.setBudget(TEST_BUDGET);

		assertNotEquals(entityDuplicate, entity);

		entityDuplicate.setTitle(TEST_TITLE + "2");

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateDifferentComments() {
		entityDuplicate.setAreas(null);
		entityDuplicate.setBudget(TEST_BUDGET);
		entityDuplicate.setTitle(TEST_TITLE);

		assertNotEquals(entityDuplicate, entity);

		entityDuplicate.setComments(TEST_COMMENTS + "2");

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateDifferentDefinition() {
		entityDuplicate.setAreas(null);
		entityDuplicate.setBudget(TEST_BUDGET);
		entityDuplicate.setTitle(TEST_TITLE);
		entityDuplicate.setComments(TEST_COMMENTS);

		assertNotEquals(entityDuplicate, entity);

		entityDuplicate.setDefinition(TEST_DEFINITION + "2");

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateDifferentTime() {
		entityDuplicate.setAreas(null);
		entityDuplicate.setBudget(TEST_BUDGET);
		entityDuplicate.setTitle(TEST_TITLE);
		entityDuplicate.setComments(TEST_COMMENTS);
		entityDuplicate.setDefinition(TEST_DEFINITION);
		entityDuplicate.setTime(TEST_TIME + 1);

		assertNotEquals(entity, entityDuplicate);
	}
	
	@Test
	public void validateEqualObjects() {
		entityDuplicate.setAreas(null);
		entityDuplicate.setBudget(TEST_BUDGET);
		entityDuplicate.setTitle(TEST_TITLE);
		entityDuplicate.setComments(TEST_COMMENTS);
		entityDuplicate.setDefinition(TEST_DEFINITION);
		entityDuplicate.setTime(TEST_TIME);

		assertEquals(entity, entityDuplicate);
	}
	
	@Test
	public void validateHashCode() {
		entityDuplicate = new CategoryEntity();
		
		assertEquals(entityDuplicate.hashCode(), 887503681);
	}
}
