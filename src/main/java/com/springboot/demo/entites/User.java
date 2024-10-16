package com.springboot.demo.entites;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",nullable = false)
	private String name;
	
	@Column(unique = true,length = 30)
	private String email;
	


	@Column(name = "password",nullable = false,unique = true)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	//@JsonManagedReference
	private List<Address> addressList;
	
	@Column(name="created_at", nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updated_at", nullable = false)
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
//	@ManyToMany(mappedBy = "usersList")
//	List<Product> productList;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	//@JsonManagedReference
	private List<CartsItems> cartItemList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	
	

	@JsonIgnore
	public List<CartsItems> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartsItems> cartItemList) {
		this.cartItemList = cartItemList;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String name, String email, String password, List<Address> addressList, LocalDateTime createdAt,
			LocalDateTime updatedAt, List<CartsItems> cartItemList) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.addressList = addressList;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		//this.cartItemList = cartItemList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", addressList="
				+ "]";
	}
	
	
	
	
}
