package com.maxmin;

public enum JobCategory {

	JobCategorySystem(0),
	JobCategoryUser(1);

	int category;
	
	JobCategory(int category) {
		
		this.category = category;
	}
	
	int showCategory() {
		
		return category;
	} 
}
