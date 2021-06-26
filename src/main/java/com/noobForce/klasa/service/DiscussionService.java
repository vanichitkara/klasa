package com.noobForce.klasa.service;

import com.noobForce.klasa.model.Discussion;
import com.noobForce.klasa.repository.DiscussionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DiscussionService {

    @Autowired
    DiscussionRepository discussionRepository;

    private static final Logger log = LoggerFactory.getLogger(DiscussionService.class);

    public List<Discussion> getAllDiscussion() {
        return discussionRepository.findAll();
    }

    public List<Discussion> getByKeyword(String keyword) {return discussionRepository.findByKeyword(keyword);}

    public List<Discussion> getByDate(int date)
    {
        return discussionRepository.findByDate(LocalDate.of(2021, 6,date));
    }

    public Discussion addDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }
}
