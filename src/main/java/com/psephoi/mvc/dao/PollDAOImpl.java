package com.psephoi.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.psephoi.mvc.model.Poll;

@Repository
public class PollDAOImpl implements PollDAO {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Poll poll) {
      sessionFactory.getCurrentSession().save(poll);
      return poll.getId();
   }

   @Override
   public Poll get(long id) {
      return sessionFactory.getCurrentSession().get(Poll.class, id);
   }

   @Override
   public List<Poll> list() {
      List<Poll> list = sessionFactory.getCurrentSession().createQuery("from Poll").list();
      return list;
   }
   
   @Override
   public void update(long id, Poll poll) {
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
   public void delete(long id) {
      Poll Poll = sessionFactory.getCurrentSession().byId(Poll.class).load(id);
      sessionFactory.getCurrentSession().delete(Poll);
   }

}