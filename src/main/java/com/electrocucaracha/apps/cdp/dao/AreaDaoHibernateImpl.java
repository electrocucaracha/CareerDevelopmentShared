package com.electrocucaracha.apps.cdp.dao;

import static com.electrocucaracha.apps.cdp.dao.HibernateUtil.getSessionFactory;

import com.electrocucaracha.apps.cdp.entities.AreaEntity;

public class AreaDaoHibernateImpl extends BaseDao<AreaEntity> implements AreaDao{
	
	@Override
	public AreaEntity getAreaByTitle(String title) {
		AreaEntity result = (AreaEntity) getSessionFactory().openSession()
				.createQuery("from AreaEntity where title = :title").setString("title", title).uniqueResult();

		return result;
	}

}
