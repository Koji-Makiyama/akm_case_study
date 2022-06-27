package akm_case_study.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "created_meal")
public class CreatedMeal {

	public CreatedMeal() {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="created_meal_id")
	private Long id;
	
	@Column(name="side")
	private String side;
	
	@Column(name="entree")
	private String entree;
	
	@Column(name="dessert")
	private String dessert;
	
	@Column(name="created_meal_name")
	private String createdMealName; 
	
	@Column(name="date_created")
	private LocalDateTime dateCreated;

	@ManyToOne
	@JoinColumn(name="user_id", nullable=false) 
	private User user;

	public CreatedMeal(String side, String entree, String dessert, String createdMealName, User user) {
		this.side = side;
		this.entree = entree;
		this.dessert = dessert;
		this.createdMealName = createdMealName;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getEntree() {
		return entree;
	}

	public void setEntree(String entree) {
		this.entree = entree;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	public String getCreatedMealName() {
		return createdMealName;
	}

	public void setCreatedMealName(String createdMealName) {
		this.createdMealName = createdMealName;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CreatedMeal [id=" + id + ", side=" + side + ", entree=" + entree + ", dessert=" + dessert
				+ ", createdMealName=" + createdMealName + ", dateCreated=" + dateCreated + ", user=" + user + "]";
	}

}
