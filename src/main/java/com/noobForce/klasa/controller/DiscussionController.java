package com.noobForce.klasa.controller;

import com.noobForce.klasa.model.Discussion;
import com.noobForce.klasa.repository.DiscussionRepository;
import com.noobForce.klasa.service.DiscussionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discussions")
public class DiscussionController {

    @Autowired
    DiscussionRepository discussionRepository;

    @Autowired
    DiscussionService discussionService;

    private static final Logger log = LoggerFactory.getLogger(DiscussionController.class);

    @GetMapping("/getAll")
    public List<Discussion> showDiscussion() {
        return discussionService.getAllDiscussion();
    }

    @GetMapping("/getAll/{keyword}")
    public List<Discussion> getFilteredDiscussion(@PathVariable String keyword) {
        if(keyword.isEmpty() || keyword.isBlank()) return discussionService.getAllDiscussion();
        else return discussionService.getByKeyword(keyword);

    }

    @GetMapping("/getAllByDate/{date}")
    public List<Discussion> getDiscussionsByDate(@PathVariable int date) {
        return discussionService.getByDate(date);
    }

    @PostMapping("/addMessage")
    public Discussion addDiscussion(@RequestBody Discussion discussion) {
        return discussionService.addDiscussion(discussion);
    }
}