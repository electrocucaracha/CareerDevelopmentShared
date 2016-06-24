package com.electrocucaracha.apps.cdp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.electrocucaracha.apps.cdp.dao.AreaDaoHibernateImpl;
import com.electrocucaracha.apps.cdp.entities.AreaEntity;

public class AreaDaoHibernateImplTest {

	private AreaDaoHibernateImpl controller;

	@Before
	public void setUp() throws Exception {
		controller = new AreaDaoHibernateImpl();
	}

	@Test
	public void createOneArea() {
		List<AreaEntity> result = controller.retrieve();
		int count = result.size();
		assertTrue(count >= 0);

		AreaEntity area = new AreaEntity("test");

		controller.create(area);
		assertNotNull(area.getId());

		AreaEntity saved = controller.get(area.getId());
		assertEquals(area, saved);
	}

	@Test
	public void retrieveOneArea() {
		final int count = 10;
		for (int i = 0; i <= count; i++) {
			controller.create(new AreaEntity("test" + i));
		}

		List<AreaEntity> result = controller.retrieve();
		assertTrue(result.size() >= count);
	}

	@Test
	public void deleteExistingArea() {
		List<AreaEntity> result = controller.retrieve();
		int count = result.size();
		assertTrue(count >= 0);

		AreaEntity area = new AreaEntity("test");

		controller.create(area);
		result = controller.retrieve();
		assertEquals(count + 1, result.size());

		controller.delete(area);
		result = controller.retrieve();
		assertEquals(count, result.size());
	}

	@Test
	public void updateOneArea() {
		AreaEntity area = new AreaEntity("test");
		controller.create(area);
		assertNotNull(area.getId());

		String newArea = "test2";
		area.setArea(newArea);
		controller.update(area);

		AreaEntity updatedArea = controller.get(area.getId());
		assertEquals(updatedArea.getArea(), newArea);
	}

}
