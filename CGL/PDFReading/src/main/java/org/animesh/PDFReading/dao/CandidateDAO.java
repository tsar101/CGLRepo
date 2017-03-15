package org.animesh.PDFReading.dao;

import org.animesh.PDFReading.Model.Tier2Candidate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidateDAO {
	
	@Autowired
	private SessionUtil sessionUtil;
	
	public Tier2Candidate getCandidateResultForRollNumber(Long rollNumber)
	{
		Session session = sessionUtil.getSession();
        //Transaction tx = (Transaction) session.beginTransaction();
        String hql = " from Tier2Candidate where rollNumber = :id";
        Tier2Candidate result = (Tier2Candidate) session.createQuery(hql).
        						setParameter("id", rollNumber).
        						getSingleResult();
        session.close();
        
        return result;
	}
	public CandidateDAO(){
		System.out.println("Bean initiated");
	}
	

}
