package akm_case_study.model;
/*
package com.alexanderkojimakiyama.imreadytoorder.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_collection")
public class UserMealCollection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="collection_id")
	private Long id;
	
	@Column(name="collection_name")
	private String collectionName;
	
	@OneToMany(mappedBy="collection")
	private List<CreatedMeal> createdMeals;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "collection_user", referencedColumnName = "user_id")
	private User user; // allows a user to have MANY custom meals 

	public Long getId() {
		return id;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public List<CreatedMeal> getCreatedMeals() {
		return createdMeals;
	}

	public void setCreatedMeals(List<CreatedMeal> createdMeals) {
		this.createdMeals = createdMeals;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
*/
