package com.cg.capstore.services;

import java.util.List;

import com.cg.capstore.beans.Category;
import com.cg.capstore.beans.Inventory;
import com.cg.capstore.beans.Merchant;
import com.cg.capstore.beans.Product;

public interface CapstoreServices {
	public Merchant findOne(String merchantId);
	public Inventory findInventoryOfMerchant(String merchantId);
	public List<Category> findAllCategoriesOfInventory(String merchantId);
	public boolean removeCategory(int categoryId);
	public boolean AddCategory(Category category,Merchant merchant);
	public List<Product> findAllProductsOfInventory(String merchantId);
	public boolean removeProduct(String productId);
	public Product getOneProduct(String productId);
	public boolean updateProduct(Product product);
	public List<Inventory> findAll();
	public Category findCategory(int categoryId);
}