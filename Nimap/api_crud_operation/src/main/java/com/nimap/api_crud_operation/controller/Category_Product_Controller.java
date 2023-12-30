package com.nimap.api_crud_operation.controller;



import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.api_crud_operation.dto.Category;
import com.nimap.api_crud_operation.dto.Product;
import com.nimap.api_crud_operation.service.Category_Product_Service;

@RestController
public class Category_Product_Controller {
	@Autowired
public Category_Product_Service service;
	//1.CREATE CATEGORY
	@PostMapping("/api/categories")
public Category saveCategory(@RequestBody Category category) {
		
	return service.saveCategory(category);
}
	//============================================================================
	//2.GET ALL CATEGORY
		
		@GetMapping("/api/categories")
		public List<Category>getAllCategory(
				@RequestParam(value="pagenumber",defaultValue = "0",required = false)Integer pagenumber,
				@RequestParam(value="pagesize",defaultValue = "2",required = false)Integer pagesize
		
		){
			return service.getAllCategory(pagenumber, pagesize);
		}
	
	//======================================================================================
		//3.GET CATEGORY BYID
		@GetMapping("/api/categories/{di}")
		public Optional<Category>getBYIDCat(@PathVariable("di")int id) {
			return service.getCategoryBYId(id);
		}
//===========================================================================
		//4.UPDATE CATEGORY BYID

		@PutMapping("/api/categories/{di}")
		public Category updateCategoryBYID(@RequestBody Category cat,@PathVariable("di")int id) {
			return service.updateCategoryBYID(cat,id);
		}
	//================================================================================
		//5.DELETE CATEGORY BYID
		@DeleteMapping("/api/categories/{di}")
		public void deleteCategoryByid(@PathVariable("di" )int id) {
			service.deleteCategoryBYId(id);
			
		}
		
		/// API CRUD OPERATION BY PRODUCT
	//1.CREATE PRODUCT
	@PostMapping("/api/products")
	public Product saveProduct(@RequestBody Product pro) {
return service.saveProduct(pro);

	}
	
	//============================================================================

//	//2.GET ALL PRODUCT
//	
	@GetMapping("/api/products")
	public List<Product>getAllProduct(
			@RequestParam(value="pagenumber",defaultValue = "0",required = false)Integer pagenumber,
			@RequestParam(value="pagesize",defaultValue = "2",required = false)Integer pagesize
	
	){
		return service.getAllProduct(pagenumber,pagesize);
	}
	
	//======================================================================================
	
//3.GET PRODUCT BYID
@GetMapping("/api/products/{di}")
	public Optional<Product>getProductByid(@PathVariable("di")int id) {
		return service.getProductById(id);
	}

//=====================================================================================


	//4.UPDATE PRODUCT BYID

@PutMapping("/api/products/{di}")
public Product updateProductBYid(@RequestBody Product pro,@PathVariable("di") int id) {
	return service.updateProductByid(pro, id);
}


//=======================================================================================

	
//DELETE PRODUCT BYID
@DeleteMapping("api/products/{di}")
public void deleteProductByid(@PathVariable("di" )int id) {
	service.deleteProductById(id);
	
}
}
