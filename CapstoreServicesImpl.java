package com.cg.capstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capstore.beans.Category;
import com.cg.capstore.beans.Inventory;
import com.cg.capstore.beans.Merchant;
import com.cg.capstore.beans.Product;
import com.cg.capstore.daoservices.CategoryDao;
import com.cg.capstore.daoservices.InventoryDao;
import com.cg.capstore.daoservices.MerchantDao;
import com.cg.capstore.daoservices.ProductDao;
@Service
public class CapstoreServicesImpl implements CapstoreServices{
	@Autowired
	MerchantDao merchantDao;
	@Autowired
	InventoryDao inventoryDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;

	public MerchantDao getMerchantDao() {
		return merchantDao;
	}



	public void setMerchantDao(MerchantDao merchantDao) {
		this.merchantDao = merchantDao;
	}



	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}



	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}



	@Override
	public Merchant findOne(String merchantId) {
		return merchantDao.findOne(merchantId);
	}



	@Override
	public Inventory findInventoryOfMerchant(String merchantId) {
		Inventory inventory1=null;
		List<Inventory> inventories=inventoryDao.getInventoryId();
		for (Inventory inventory : inventories) {
			if(inventory.getMerchant().getMerchant_id().equals(merchantId))
				inventory1=inventory;
		}
		return inventory1;
	}



	@Override
	public List<Category> findAllCategoriesOfInventory(String merchantId) {
		return categoryDao.findAll(this.findInventoryOfMerchant(merchantId).getInventory_id());
	}



	@Override
	public boolean removeCategory(int categoryId) {
		return categoryDao.removeCategory(categoryId);
	}



	@Override
	public boolean AddCategory(Category category, Merchant merchant) {
		category.setInventory(this.findInventoryOfMerchant(merchant.getMerchant_id()));
		return categoryDao.addCategory(category);
	}



	@Override
	public List<Product> findAllProductsOfInventory(String merchantId) {
		return productDao.findAllProductsBasedOnInventory(this.findInventoryOfMerchant(merchantId).getInventory_id());
	}



	@Override
	public boolean removeProduct(String productId) {
		System.out.println(productDao.removeProduct(productId));
		return productDao.removeProduct(productId);
	}



	@Override
	public Product getOneProduct(String productId) {
		return productDao.findOne(productId);
	}



	@Override
	public boolean updateProduct(Product product) {
		return productDao.updateProduct(product);
	}



	@Override
	public List<Inventory> findAll() {
		return inventoryDao.getInventoryId();
	}



	@Override
	public Category findCategory(int categoryId) {
		return categoryDao.findOne(categoryId);
	}
	
}
