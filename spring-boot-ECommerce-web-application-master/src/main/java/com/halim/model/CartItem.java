package com.halim.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "cartitem")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int quantity;
	@Temporal(TemporalType.DATE)
	private Date date;
	private  long user_id;
	private String time;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id",nullable=false, updatable=false)
	private Product product;
//	@OneToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="userid", referencedColumnName = "id")
//	private User user;
@OneToOne
@JoinColumn(name = "userid",insertable = false,
		updatable=false,referencedColumnName = "id")
private User user1;

	public String getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "CartItem{" +
				"id=" + id +
				", quantity=" + quantity +
				", date=" + date +
				", time=" + time +
				", product=" + product +
				", user1=" + user1 +
				", user_id=" + user_id +
				'}';
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}


//
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
	public long getUser_id() {
		return user_id;
	}



	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

}
