package com.cg.capstore.daoservices;

import java.util.List;

import com.cg.capstore.beans.Category;

public interface CategoryDao {
	public List<Category> findAll(int inventoryId);
	public boolean removeCategory(int categoryId);
	public boolean addCategory(Category category);
	public Category findOne(int categoryId);
}
