package com.electrocucaracha.apps.cdp.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.electrocucaracha.apps.cdp.entities.AreaEntity;

public class AreaDaoHibernateImplTest {
	
	private AreaDao controller;

	private static final String TEST_TITLE = "Test title";

	@Before
	public void setUp() throws Exception {
		controller = new AreaDaoHibernateImpl();

		AreaEntity entity = new AreaEntity();
		entity.setTitle(TEST_TITLE);

		controller.create(entity);
	}

	@Test
	public void findAreaByTitle() {
		assertNull(controller.getAreaByTitle("Non-existing"));
		assertNotNull(controller.getAreaByTitle(TEST_TITLE));
	}
}
