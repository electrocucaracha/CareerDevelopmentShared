package com.electrocucaracha.apps.cdp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.electrocucaracha.apps.cdp.entities.MockEntity;

public class BaseDaoTest {

	BaseDao<MockEntity> controller;

	@Before
	public void setUp() throws Exception {
		controller = new BaseDao<MockEntity>() {
		};
	}

	@Test
	public void validateTypeOfT() {
		assertEquals(controller.getTypeOfT(), MockEntity.class);
	}

	@Test
	public void validateRetrieveEmptyList() {
		List<MockEntity> objects = controller.retrieve();

		assertTrue("The list contains " + objects.size() + " objects", objects.isEmpty());
	}

	@Test
	public void validateGetNonExistingObject() {
		assertNull(controller.get(33L));
	}

	@Test
	public void validateCRUD() {
		MockEntity obj = new MockEntity();
		controller.create(obj);

		assertTrue(obj.getId() > 0);

		obj = controller.get(obj.getId());

		assertNotNull(obj);

		obj.setField("test");

		controller.update(obj);

		obj = controller.get(obj.getId());

		assertNotNull(obj);
		assertEquals(obj.getField(), "test");
		
		controller.delete(obj);
		obj = controller.get(obj.getId());
		assertNull(obj);

	}
}
