package com.electrocucaracha.apps.cdp.dao;

import java.util.List;

import com.electrocucaracha.apps.cdp.entities.AreaEntity;

public interface AreaDao {

	AreaEntity getAreaByTitle(String title);

	long create(AreaEntity model);

	List<AreaEntity> retrieve();

	AreaEntity get(long id);

	void delete(AreaEntity model);

	void update(AreaEntity model);

}
