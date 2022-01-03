package com.psephoi.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psephoi.mvc.model.Poll;
import com.psephoi.mvc.dao.PollDAO;

@Service
@Transactional(readOnly = true)
public class PollServiceImpl implements PollService {

   @Autowired
   private PollDAO pollDAO;

   @Transactional
   @Override
   public long save(Poll poll) {
      return pollDAO.save(poll);
   }

   @Override
   public Poll get(long id) {
      return pollDAO.get(id);
   }

   @Override
   public List<Poll> list() {
      return pollDAO.list();
   }

   @Transactional
   @Override
   public void update(long id, Poll poll) {
      pollDAO.update(id, poll);
   }

   @Transactional
   @Override
   public void delete(long id) {
      pollDAO.delete(id);
   }

}