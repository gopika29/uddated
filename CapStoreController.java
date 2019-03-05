package com.cg.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.capstore.beans.Category;
import com.cg.capstore.beans.Merchant;
import com.cg.capstore.beans.Product;
import com.cg.capstore.services.CapstoreServices;

@Controller
public class CapStoreController {
	@Autowired
	CapstoreServices capstoreServices;

	public CapstoreServices getCapstoreServices() {
		return capstoreServices;
	}
	public void setCapstoreServices(CapstoreServices capstoreServices) {
		this.capstoreServices = capstoreServices;
	}
	Merchant merchant;
	@RequestMapping(value="/HomePage")
	public String goToHomePage() {
		return "HomePage";
	}
	@RequestMapping(value="/MerchantPage",method=RequestMethod.GET)
	public String goToMerchantPage(Model model) {
		model.addAttribute("Merchant", new Merchant());
		return "GoToInventoryPage";
	}
	@RequestMapping(value="/EditItems",method=RequestMethod.POST)
	public String goToMerchantInventory(@ModelAttribute(value="Merchant")Merchant merchant,Model model){
		this.merchant=capstoreServices.findOne(merchant.getMerchant_id());
		model.addAttribute("Merchant",this.merchant);
		return "MerchantInventory";
	}
	@RequestMapping(value="/removeCategory",method=RequestMethod.GET)
	public String removeCategoryPage(Model model) {
		model.addAttribute("CategoryList", capstoreServices.findAllCategoriesOfInventory(merchant.getMerchant_id()));
		return "RemoveCategories";
	}
	@RequestMapping(value="/remove",method=RequestMethod.GET)
	public String removeCategory(@RequestParam(value="categoryId")int categoryId,Model model) {
		capstoreServices.removeCategory(categoryId);
		model.addAttribute("CategoryList", capstoreServices.findAllCategoriesOfInventory(merchant.getMerchant_id()));
		model.addAttribute("message", "deleted successfully");
		return "RemoveCategories";

	}
	@RequestMapping(value="/addCategory",method=RequestMethod.GET)
	public String addCategoryPage(Model model) {
		model.addAttribute("Category", new Category());
		return "AddCategory";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute(value="Category")Category category,Model model) {
		capstoreServices.AddCategory(new Category(category.getCategoryName(), category.getType()), merchant);
		model.addAttribute("message", "category added");
		return "AddCategory";
	}
	@RequestMapping(value="/editItems",method=RequestMethod.GET)
	public String goToEditItemsPage(Model model) {
		model.addAttribute("productList", capstoreServices.findAllProductsOfInventory(merchant.getMerchant_id()));
		return "EditItems";

	}
	@RequestMapping(value="/removeItems",method=RequestMethod.GET)
	public String removeProducts(@RequestParam(value="productId")String productId,Model model) {
		capstoreServices.removeProduct(productId);
		System.out.println(capstoreServices.removeProduct(productId));
		model.addAttribute("productList", capstoreServices.findAllProductsOfInventory(merchant.getMerchant_id()));
		model.addAttribute("message", "deleted successfully");
		return "EditItems";
	}
	@RequestMapping(value="/EditProduct",method=RequestMethod.GET)
	public String goToUpdatePage(@RequestParam(value="productId")String productId,Model model) {
		model.addAttribute("Product", capstoreServices.getOneProduct(productId));
		return "EditProductPage";	
	}
	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute(value="Product")Product product,Model model) {

		capstoreServices.updateProduct(product);
		model.addAttribute("message", "updated successfully");
		return "EditProductPage";
	}
	@RequestMapping(value="/goToAddProductPage",method=RequestMethod.GET)
	public String goToAddProductPage(Model model,@RequestParam(value="categoryId")int categoryId) {
		model.addAttribute("Category",capstoreServices.findCategory(categoryId));
		model.addAttribute("product", new Product());
		return "AddProduct";
	}
	//admin-----------------
	@RequestMapping(value="/AdminPage",method=RequestMethod.GET) public String
	goToAdminPage(Model model) {
		model.addAttribute("InventoryList", capstoreServices.findAll());
		return "AdminPage"; 
	}
	@RequestMapping(value="/showCategoriesofMerchant",method=RequestMethod.GET)
	public String showAllCategoriesOfMerchant(@RequestParam(value="merchantId")String merchantId,Model model){
		this.merchant=capstoreServices.findOne(merchantId);
		model.addAttribute("Merchant",this.merchant);
		return "MerchantInventory";
	}

}
