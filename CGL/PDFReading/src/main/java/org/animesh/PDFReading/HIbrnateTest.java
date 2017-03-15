package org.animesh.PDFReading;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import org.hibernate.Transaction;
import org.animesh.PDFReading.Model.Tier2Candidate;
import org.animesh.PDFReading.dao.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class HIbrnateTest {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
		// TODO Auto-generated method stub
		Session session = new SessionUtil().getSession();
        Transaction tx = (Transaction) session.beginTransaction();
        String hql = " from Tier2Candidate where rollNumber = :id";
        Tier2Candidate query = (Tier2Candidate) session.createQuery(hql).
        						setParameter("id", 1601012072L).
        						getSingleResult();
        
        
        
        System.out.println(query);
        tx.commit();
        session.close();
        System.runFinalizersOnExit(true);
        System.exit(0);
		
	}

}
