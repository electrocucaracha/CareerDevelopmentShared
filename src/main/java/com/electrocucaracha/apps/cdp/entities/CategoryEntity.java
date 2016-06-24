package com.electrocucaracha.apps.cdp.entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseDbObject {

	private String title;
	private String definition;
	private double budget;
	private double time;
	private String comments;
	private AreaEntity[] areas;

	public CategoryEntity() {
	}

	public CategoryEntity(String title, String definition, double budget, double time) {
		super();
		this.title = title;
		this.definition = definition;
		this.budget = budget;
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public AreaEntity[] getAreas() {
		return areas;
	}

	public void setAreas(AreaEntity[] areas) {
		this.areas = areas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(areas);
		long temp;
		temp = Double.doubleToLongBits(budget);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((definition == null) ? 0 : definition.hashCode());
		temp = Double.doubleToLongBits(time);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CategoryEntity other = (CategoryEntity) obj;
		if (!Arrays.equals(areas, other.areas))
			return false;
		if (Double.doubleToLongBits(budget) != Double.doubleToLongBits(other.budget))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (definition == null) {
			if (other.definition != null)
				return false;
		} else if (!definition.equals(other.definition))
			return false;
		if (Double.doubleToLongBits(time) != Double.doubleToLongBits(other.time))
			return false;
		return true;
	}

}
