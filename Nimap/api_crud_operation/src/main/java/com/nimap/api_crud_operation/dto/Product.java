package com.nimap.api_crud_operation.dto;





import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int pid;
private String pname;
private double pprice;
private int quantity;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn
private Category category;

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}

public double getPprice() {
	return pprice;
}

public void setPprice(double pprice) {
	this.pprice = pprice;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@JsonIgnore
public Category getCategory() {
	return category;
}
@JsonProperty
public void setCategory(Category category) {
	this.category = category;
}




}
