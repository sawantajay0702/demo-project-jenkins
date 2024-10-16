package com.springboot.demo.entites;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="product_name")
	private String pname;
	
	@Column(name="price",nullable = false)
	private BigDecimal price;
	

	@ManyToOne
	@JoinColumn(name = "cat_id")
	//@JsonBackReference
	private Category category;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name = "imageurl")
	private String imageurl;
	
	@OneToMany(mappedBy = "product")
	//@JsonManagedReference
	private List<CartsItems> cartItemList;
	
	@Column(name="created_at",nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;	
	
	@Column(name="updated_at" ,nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	
//	@ManyToMany
//	@JoinTable(
//			name = "products_users",
//			joinColumns =@JoinColumn(name="product_id"),
//			inverseJoinColumns = @JoinColumn(name="user_id")
//			)
//	private List<User> usersList;
	
	

	public Product() {
	
	}

	public Product(Long id, String pname, BigDecimal price, Category category, Integer quantity, String imageurl,
		List<CartsItems> cartItemList, LocalDateTime createdAt, LocalDateTime updatedAt) {
	super();
	this.id = id;
	this.pname = pname;
	this.price = price;
	this.category = category;
	this.quantity = quantity;
	this.imageurl = imageurl;
	this.cartItemList = cartItemList;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
}







	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@JsonIgnore
	public List<CartsItems> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartsItems> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", price=" + price + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
}
