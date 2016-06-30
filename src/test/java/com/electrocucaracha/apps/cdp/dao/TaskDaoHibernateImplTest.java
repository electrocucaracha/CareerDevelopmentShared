package com.electrocucaracha.apps.cdp.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.electrocucaracha.apps.cdp.entities.TaskEntity;

public class TaskDaoHibernateImplTest {
	
	private TaskDao controller;

	private static final String TEST_TITLE = "Test title";

	@Before
	public void setUp() throws Exception {
		controller = new TaskDaoHibernateImpl();

		TaskEntity entity = new TaskEntity();
		entity.setTitle(TEST_TITLE);

		controller.create(entity);
	}

	@Test
	public void findTaskByTitle() {
		assertNull(controller.getTaskByTitle("Non-existing"));
		assertNotNull(controller.getTaskByTitle(TEST_TITLE));
	}
}
