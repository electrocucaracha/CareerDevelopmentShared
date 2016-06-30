package com.electrocucaracha.apps.cdp.models;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.electrocucaracha.apps.cdp.entities.CategoryEntity;

public class CategoryModelTest {
	private static final String TEST_TITLE = "Test title";
	private static final String TEST_DEFINITION = "Test definition";
	private static final double TEST_BUDGET = 50.0;
	private static final double TEST_TIME = 10.0;

	@Test
	public void objectWithAllProperties() {

		CategoryEntity entity = new CategoryEntity();
		entity.setTitle(TEST_TITLE);
		entity.setDefinition(TEST_DEFINITION);
		entity.setBudget(TEST_BUDGET);
		entity.setTime(TEST_TIME);

		CategoryModel model = new CategoryModel(entity);

		String toJson = "{\"budget\":" + TEST_BUDGET + ",\"time\":" + TEST_TIME + ",\"title\":\"" + TEST_TITLE
				+ "\",\"definition\":\"" + TEST_DEFINITION + "\",\"comments\":null}";

		assertEquals(model.toJson(), toJson);
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void nullEntityArgument() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Category entity model cannot be null");
		new CategoryModel(null);
	}
}
