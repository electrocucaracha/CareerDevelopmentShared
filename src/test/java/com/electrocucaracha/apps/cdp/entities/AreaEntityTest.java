package com.electrocucaracha.apps.cdp.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class AreaEntityTest {
	private static final String TEST_TITLE = "Test title";

	private AreaEntity entity = new AreaEntity();
	private AreaEntity entityDuplicate = new AreaEntity();

	@Before
	public void setUp() throws Exception {
		entity.setTitle(TEST_TITLE);
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
	public void validateDifferentTitle() {
		assertNotEquals(entityDuplicate, entity);

		entityDuplicate.setTitle(TEST_TITLE + "2");

		assertNotEquals(entityDuplicate, entity);
	}

	@Test
	public void validateEqualObjects() {
		entityDuplicate.setTitle(TEST_TITLE);

		assertEquals(entity, entityDuplicate);
	}

	@Test
	public void validateHashCode() {
		entityDuplicate = new AreaEntity();
		
		assertEquals(entityDuplicate.hashCode(), 31);
	}
}
