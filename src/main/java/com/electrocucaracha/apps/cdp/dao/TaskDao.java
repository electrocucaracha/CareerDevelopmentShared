package com.electrocucaracha.apps.cdp.dao;

import java.util.List;

import com.electrocucaracha.apps.cdp.entities.TaskEntity;

public interface TaskDao {
	long create(TaskEntity model);

	List<TaskEntity> retrieve();

	TaskEntity get(long id);

	void delete(TaskEntity model);

	void update(TaskEntity model);

}
