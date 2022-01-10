package com.psephoi.mvc.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psephoi.mvc.model.Poll;

@Repository
public class PollDAOImpl implements PollDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public Long save(Poll poll) {
      sessionFactory.getCurrentSession().save(poll);
      return poll.getId();
   }

   @Override
   public Poll get(long id) {
      return sessionFactory.getCurrentSession().get(Poll.class, id);
   }

   
   @Override
   public List<Poll> list() {
	  Session session = sessionFactory.getCurrentSession();
	  CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
	  CriteriaQuery<Poll> cr = cb.createQuery(Poll.class);
	  Root<Poll> root = cr.from(Poll.class);
	  cr.select(root);
	  
	  Query<Poll> query = session.createQuery(cr);
	  List<Poll> list = query.getResultList();
	   
   /** HQL instead of Criteria **/
   // List<Poll> list = sessionFactory.getCurrentSession().createQuery("from Poll").list();
      return list;
   }
   
   @Override
   public void update(Long id, Poll poll) {
      Session session = sessionFactory.getCurrentSession();
      Poll poll2 = session.byId(Poll.class).load(id);
      poll2.setPollname(poll.getPollname());
      poll2.setDescription(poll.getDescription());
      poll2.setChoice1(poll.getChoice1());
      poll2.setChoice2(poll.getChoice2());
      poll2.setEmail(poll.getEmail());
      session.flush();
      
   }

   @Override
   public void delete(Long id) {
      Poll Poll = sessionFactory.getCurrentSession().byId(Poll.class).load(id);
      sessionFactory.getCurrentSession().delete(Poll);
   }

}