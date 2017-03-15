package org.animesh.PDFReading.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="LIST2")
@Entity
public class Tier2Candidate {
	
	@Column(name="RollNumber")
	@Id
	private long rollNumber;
	@Column(name="Category")
	private String category;
	@Column(name="CandidateName")
	private String candidateName;
	public long getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(long rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	@Override
	public String toString() {
		
		return "Name :" + candidateName + 
			   " Roll Number : " + rollNumber + 
			   " category : " + category;
	}
	
	

}
