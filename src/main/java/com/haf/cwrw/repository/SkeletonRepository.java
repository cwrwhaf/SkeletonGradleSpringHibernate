package com.haf.cwrw.repository;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.haf.cwrw.model.SkeletonModel;

@Repository("skeletonRepository")
public class SkeletonRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public SkeletonModel save(SkeletonModel skeletonModel){
    	
    	currentSession = sessionFactory.getCurrentSession();
    
    	currentSession.persist(skeletonModel);
    	currentSession.flush();
    	
    	return skeletonModel;
    }

	public SkeletonModel getSkeletonById(long skeletonId) {
		currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("from SkeletonModel where id = :id ");
		query.setParameter("id", skeletonId);
		SkeletonModel model  = (SkeletonModel) query.uniqueResult();
		return model;
	}
	
}
