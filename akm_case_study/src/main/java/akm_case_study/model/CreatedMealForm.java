package akm_case_study.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CreatedMealForm {

		private String createdMealName; 
		
		// private LocalDateTime dateCreated;

		//@OneToMany(mappedBy="createdMeal")
		//private List<FoodItem> mealItems;  // allows a created_meal to have MANY food items
		
		private String mealItem1;
		private String mealItem2;
		private String mealItem3;
		private String mealItem4;
		private String mealItem5;
		private String mealItem6;
		private String mealItem7;
		private String mealItem8;
		private String mealItem9;
		
		public String getCreatedMealName() {
			return createdMealName;
		}

		public void setCreatedMealName(String createdMealName) {
			this.createdMealName = createdMealName;
		}

		public String getMealItem1() {
			return mealItem1;
		}

		public void setMealItem1(String mealItem1) {
			this.mealItem1 = mealItem1;
		}

		public String getMealItem2() {
			return mealItem2;
		}

		public void setMealItem2(String mealItem2) {
			this.mealItem2 = mealItem2;
		}

		public String getMealItem3() {
			return mealItem3;
		}

		public void setMealItem3(String mealItem3) {
			this.mealItem3 = mealItem3;
		}

		public String getMealItem4() {
			return mealItem4;
		}

		public void setMealItem4(String mealItem4) {
			this.mealItem4 = mealItem4;
		}

		public String getMealItem5() {
			return mealItem5;
		}

		public void setMealItem5(String mealItem5) {
			this.mealItem5 = mealItem5;
		}

		public String getMealItem6() {
			return mealItem6;
		}

		public void setMealItem6(String mealItem6) {
			this.mealItem6 = mealItem6;
		}

		public String getMealItem7() {
			return mealItem7;
		}

		public void setMealItem7(String mealItem7) {
			this.mealItem7 = mealItem7;
		}

		public String getMealItem8() {
			return mealItem8;
		}

		public void setMealItem8(String mealItem8) {
			this.mealItem8 = mealItem8;
		}

		public String getMealItem9() {
			return mealItem9;
		}

		public void setMealItem9(String mealItem9) {
			this.mealItem9 = mealItem9;
		}

		/*
		public LocalDateTime getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(LocalDateTime dateCreated) {
			this.dateCreated = dateCreated;
		}
*/

        

		
	}
