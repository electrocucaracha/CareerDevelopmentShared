package com.electrocucaracha.apps.cdp.dao;

import static com.electrocucaracha.apps.cdp.dao.HibernateUtil.getSessionFactory;

import com.electrocucaracha.apps.cdp.entities.TaskEntity;

public class TaskDaoHibernateImpl extends BaseDao<TaskEntity> implements TaskDao {
	
	@Override
	public TaskEntity getTaskByTitle(String title) {
		TaskEntity result = (TaskEntity) getSessionFactory().openSession()
				.createQuery("from TaskEntity where title = :title").setString("title", title).uniqueResult();

		return result;
	}

}
