package org.assignment.view;

public class CompanyPOJO {

	private int index;
	private String company;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "CompanyPOJO [index=" + index + ", company=" + company + "]";
	}
	
	
	
}
