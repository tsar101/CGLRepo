package org.animesh.PDFReading.Model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="TIER1_RESUT")
@Entity
public class Tier1Candidate {

	@Column(name="RollNumber")
	@Id
	private long rollNumber;
	@Column(name="Name")
	private String candidateName;
	@Column(nullable=true ,name="CAT1")
	private Byte catgeory1;
	@Column(nullable=true ,name="CAT2")
	private Byte catgeory2;
	@Column(nullable=true ,name="CAT3")
	private Byte catgeory3;
	@Column(name="PostPreference")
	private String postPreference;
	@Column(nullable=true ,name="SIC")
	private Byte SIC;
	@Column(nullable=true ,name="EQSIC")
	private Byte EQSIC;
	@Column(nullable=true ,name="AAO")
	private Byte AAO;
	@Column(nullable=true ,name="EQAAO")
	private Byte EQAAO;
	private BigDecimal Marks;
	public long getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(long rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public Byte getCatgeory1() {
		return catgeory1;
	}
	public void setCatgeory1(Byte catgeory1) {
		this.catgeory1 = catgeory1;
	}
	public Byte getCatgeory2() {
		return catgeory2;
	}
	public void setCatgeory2(Byte catgeory2) {
		this.catgeory2 = catgeory2;
	}
	public Byte getCatgeory3() {
		return catgeory3;
	}
	public void setCatgeory3(Byte catgeory3) {
		this.catgeory3 = catgeory3;
	}
	public String getPostPreference() {
		return postPreference;
	}
	public void setPostPreference(String postPreference) {
		this.postPreference = postPreference;
	}
	public Byte getSIC() {
		return SIC;
	}
	public void setSIC(Byte sIC) {
		SIC = sIC;
	}
	public Byte getEQSIC() {
		return EQSIC;
	}
	public void setEQSIC(Byte eQSIC) {
		EQSIC = eQSIC;
	}
	public Byte getAAO() {
		return AAO;
	}
	public void setAAO(Byte aAO) {
		AAO = aAO;
	}
	public Byte getEQAAO() {
		return EQAAO;
	}
	public void setEQAAO(Byte eQAAO) {
		EQAAO = eQAAO;
	}
	public BigDecimal getMarks() {
		return Marks;
	}
	public void setMarks(BigDecimal marks) {
		Marks = marks;
	}
	}
