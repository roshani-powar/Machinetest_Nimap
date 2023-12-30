package com.nimap.api_crud_operation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.nimap.api_crud_operation.dto.Category;
import com.nimap.api_crud_operation.dto.Product;
import com.nimap.api_crud_operation.repository.Category_repository;
import com.nimap.api_crud_operation.repository.Product_repository;

@Repository
public class Category_Product_Dao {
@Autowired
private Category_repository c_repository;

@Autowired
private Product_repository p_repository;


//1.API CRUD OPERATION BY CATEGORY
//1.Create or save the data
public Category saveCategory(Category category) {
List<Product>products=category.getProducts(); //list of product to generate cid as foregien key
for(Product product : products) {   //for each loop
	product.setCategory(category);
}
	return c_repository.save(category);
}


//==========================================================================================
//2.GET ALL CATEGORY
public List<Category>getAllCategory(int pagenumber,int pagesize) {
	Pageable p1=PageRequest.of(pagenumber, pagesize);
	Page<Category>page=c_repository.findAll(p1);
	return page.getContent();
}



//==========================================================================================
//3.GET CATEGORY BYID
public Optional<Category>getCategoryBYId(int id) {
		return c_repository.findById(id);
	}



//=========================================================================================
//4.UPDATE CATEGORY BYID
public Category updateCategoryBYId(Category cat,int id) {
	 Optional<Category>catOptional=c_repository.findById(id);
	 cat.setCid(id);
		return c_repository.save(cat);
	}
	
	

//===================================================================
//5.DELETE CATEGORY BYID

public void deleteCategoryBYId(int id) {
	 
		 c_repository.deleteById(id);
	}
		
		

//============================================================================================
//2.API CRUD OPERATION BY PRODUCT

//1.CREATE PRODUCT DATA
public Product saveProduct(Product pro) {
	return p_repository.save(pro);
}

//==========================================================================================

//2.GET ALL PRODUCT
public List<Product>getAllProduct(int pagenumber,int pagesize) {
	Pageable p1=PageRequest.of(pagenumber, pagesize);
	Page<Product>page=p_repository.findAll(p1);
	return page.getContent();
}

//============================================================================================
//3.GET PRODUCT BYID
 public Optional<Product>getProductById(int id) {
		return p_repository.findById(id);
	}


//=========================================================================================


//4.UPDATE PRODUCT BYID

 public Product updateProductByid(Product pro,int id) {
	 Optional<Product>proOptional=p_repository.findById(id);
	 
	 pro.setPid(id);
		return p_repository.save(pro);
 }



//=================================================================================


//DELETE PRODUCT BYID

 public void deleteProductById(int id) {
	 Optional<Product>proOptional=p_repository.findById(id);
	 if(proOptional.isPresent()) {
		 Product productToDelete=proOptional.get();
		 Category productCategory=productToDelete.getCategory();
		 
		 if(productCategory!=null) {
			 productCategory.getProducts().remove(productToDelete);
		 }
		 else {
			p_repository.delete(productToDelete);
		
		
	}

	 }}}

