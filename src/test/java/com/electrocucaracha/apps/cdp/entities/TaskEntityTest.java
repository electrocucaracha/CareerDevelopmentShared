package com.electrocucaracha.apps.cdp.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class TaskEntityTest {
	private static final String TEST_TITLE = "Test title";
	private static final String TEST_RESOURCE = "Test resource";
	private static final double TEST_PROGRESS = 50.0;
	private static final double TEST_PRICE = 10.0;
	private static final String TEST_COMMENTS = "Test comments";

	private TaskEntity entity = new TaskEntity();
	private TaskEntity entityDuplicate = new TaskEntity();

	@Before
	public void setUp() throws Exception {
		entity.setTitle(TEST_TITLE);
		entity.setResource(TEST_RESOURCE);
		entity.setProgress(TEST_PROGRESS);
		entity.setPrice(TEST_PRICE);
		entity.setComments(TEST_COMMENTS);
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
	public void validateDifferentComments() {
		assertNotEquals(entityDuplicate, entity);

		entityDuplicate.setComments(TEST_COMMENTS + "2");

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateDifferentPrice() {
		entityDuplicate.setComments(TEST_COMMENTS);
		entityDuplicate.setPrice(TEST_PRICE + 1);

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateDifferentProgress() {
		entityDuplicate.setComments(TEST_COMMENTS);
		entityDuplicate.setPrice(TEST_PRICE);
		entityDuplicate.setProgress(TEST_PROGRESS + 1);

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateDifferentResource() {
		entityDuplicate.setComments(TEST_COMMENTS);
		entityDuplicate.setPrice(TEST_PRICE);
		entityDuplicate.setProgress(TEST_PROGRESS);

		assertNotEquals(entityDuplicate, entity);

		entityDuplicate.setResource(TEST_RESOURCE + "2");

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateDifferentTitle() {
		entityDuplicate.setComments(TEST_COMMENTS);
		entityDuplicate.setPrice(TEST_PRICE);
		entityDuplicate.setProgress(TEST_PROGRESS);
		entityDuplicate.setResource(TEST_RESOURCE);

		assertNotEquals(entityDuplicate, entity);

		entityDuplicate.setTitle(TEST_TITLE + "2");

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateEqualObjects() {
		entityDuplicate.setComments(TEST_COMMENTS);
		entityDuplicate.setPrice(TEST_PRICE);
		entityDuplicate.setProgress(TEST_PROGRESS);
		entityDuplicate.setResource(TEST_RESOURCE);
		entityDuplicate.setTitle(TEST_TITLE);

		assertEquals(entity, entityDuplicate);
	}

	@Test
	public void validateHashCode() {
		entityDuplicate = new TaskEntity();

		assertEquals(entityDuplicate.hashCode(), 28629151);
	}
}
