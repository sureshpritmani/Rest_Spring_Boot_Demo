package org.assignment.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
    private int index;  
	
	@Column(name="company")
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
	
