package com.cbf.cbf.services;

import com.cbf.cbf.entities.Feed;
import com.cbf.cbf.repositories.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedService {
    @Autowired
    FeedRepository feedRepository;

    public void addFeed(Feed feed){
        feedRepository.save(feed);
    }

    public List<Feed> getFeeds(){
        return feedRepository.findAll();
    }


}
