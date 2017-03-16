package org.animesh.PDFReading.dao;

import org.animesh.PDFReading.Model.Tier1Candidate;
import org.animesh.PDFReading.Model.Tier2Candidate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidateDAO {
	
	@Autowired
	private SessionUtil sessionUtil;
	
	public Tier1Candidate getCandidateResultForRollNumber(Long rollNumber)
	{
		Session session = sessionUtil.getSession();
        //Transaction tx = (Transaction) session.beginTransaction();
        String hql = " from Tier1Candidate where rollNumber = :id";
        Tier1Candidate result = (Tier1Candidate) session.createQuery(hql).
        						setParameter("id", rollNumber).
        						getSingleResult();
        session.close();
        
        return result;
	}
	public CandidateDAO(){
		System.out.println("Bean initiated");
	}
	

}
