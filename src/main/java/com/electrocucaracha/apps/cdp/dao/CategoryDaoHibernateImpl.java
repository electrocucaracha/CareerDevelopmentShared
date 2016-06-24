package com.electrocucaracha.apps.cdp.dao;

import static com.electrocucaracha.apps.cdp.dao.HibernateUtil.getSessionFactory;

import com.electrocucaracha.apps.cdp.entities.CategoryEntity;

public class CategoryDaoHibernateImpl extends BaseDao<CategoryEntity> implements CategoryDao {

	@Override
	public CategoryEntity getCategoryByTitle(String title) {
		CategoryEntity result = (CategoryEntity) getSessionFactory().openSession()
				.createQuery("from CategoryEntity where title = :title").setString("title", title).uniqueResult();

		return result;
	}

}
