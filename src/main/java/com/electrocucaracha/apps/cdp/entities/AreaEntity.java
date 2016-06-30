package com.electrocucaracha.apps.cdp.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "areas")
public class AreaEntity extends BaseDbObject {

	private String title;

	public AreaEntity() {

	}

	public AreaEntity(String area) {
		super();
		this.title = area;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String area) {
		this.title = area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AreaEntity other = (AreaEntity) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
