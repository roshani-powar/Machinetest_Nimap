package com.nimap.api_crud_operation.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int cid;
private String ctitle;
@OneToMany(cascade=CascadeType.ALL,mappedBy = "category")
private List<Product>products;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCtitle() {
	return ctitle;
}
public void setCtitle(String ctitle) {
	this.ctitle = ctitle;
}
public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
@Override
public String toString() {
	return "Category [cid=" + cid + ", ctitle=" + ctitle + ", products=" + products + "]";
}


}
