package com.cg.capstore.daoservices;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.capstore.beans.Category;
@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao{
	@PersistenceContext
	EntityManager entityManager;
	

	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public List<Category> findAll(int inventoryId) {
		return entityManager.
				createQuery("select c from Category c where inventoryId="+inventoryId).getResultList();
	}


	@Override
	public boolean removeCategory(int categoryId) {
		entityManager.remove(entityManager.find(Category.class, categoryId));
		entityManager.flush();
		return true;
	}


	@Override
	public boolean addCategory(Category category) {
		entityManager.persist(category);
		entityManager.flush();
		return true;
	}


	@Override
	public Category findOne(int categoryId) {
		return entityManager.find(Category.class, categoryId);
	}

}
