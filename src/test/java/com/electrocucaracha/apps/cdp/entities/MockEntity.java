package com.electrocucaracha.apps.cdp.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mocks")
public class MockEntity extends BaseDbObject {
	private String field;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
}
