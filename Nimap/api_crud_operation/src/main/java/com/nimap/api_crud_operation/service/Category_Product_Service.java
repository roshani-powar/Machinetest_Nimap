package com.nimap.api_crud_operation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.nimap.api_crud_operation.dao.Category_Product_Dao;
import com.nimap.api_crud_operation.dto.Category;
import com.nimap.api_crud_operation.dto.Product;

@Service
public class Category_Product_Service {
	
	//1.API CRUD OPERATION BY CATEGORY
	
//1.Create category
	@Autowired
	private Category_Product_Dao dao;
	public Category saveCategory(Category category) {

		return dao.saveCategory(category);
	}
	
	//=====================================================================================
		//2.GET CATEGORY
		public List<Category>getAllCategory(int pagenumber,int pagesize){
				
			return dao.getAllCategory(pagenumber, pagesize);
			
		}
		
	//===========================================================================
	
	//3.GET CATEGORY BYID
		 public Optional<Category>getCategoryBYId(int id) {
				return dao.getCategoryBYId(id);
			}
		 
		 //=======================================================
		 
		//4.UPDATE CATEGORY BYID
		 public Category updateCategoryBYID(Category cat,int id) {
			 Optional<Category>catOptional=dao.getCategoryBYId(id);
			 cat.setCid(id);
				 return dao.saveCategory(cat);
		 }
//==============================================================================
		//5.DELETE CATEGORY BYID

		 public void deleteCategoryBYId(int id) {
				 dao.deleteCategoryBYId(id);
			}
		 
		 
		 //===========================================================================
		 
	//API CRUD OPEARTION BY PRODUCT
	
	//1.CREATE PRODUCT
	public Product saveProduct(Product pro) {
		// TODO Auto-generated method stub
		
		return dao.saveProduct(pro);
	}
	
	
////	//2.GET ALL PRODUCT
	public List<Product>getAllProduct(int pagenumber,int pagesize){
			
		return dao.getAllProduct(pagenumber, pagesize);
		
	}
	
//=============================================================================================
	

	//3.GET PRODUCT BYID
	 public Optional<Product>getProductById(int id) {
			return dao.getProductById(id);
		}


//==================================================================================================
	

	//4.UPDATE PRODUCT BYID

	 public Product updateProductByid(Product pro,int id) {
		 Optional<Product>proOptional=dao.getProductById(id);
		 pro.setPid(id);
			 return dao.saveProduct(pro);
		}



//======================================================================================================
	
//DELETE PRODUCT BYID

	 public void deleteProductById(int id) {
			 dao.deleteProductById(id);
		}
	}



