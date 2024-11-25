package com.cbf.cbf.services;

import com.cbf.cbf.entities.Story;
import com.cbf.cbf.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoryService {
    @Autowired
    StoryRepository storyRepository;

    public void addStory(Story story){
        storyRepository.save(story);
    }

    public List<Story> getStories(){
        return storyRepository.findAll();
    }
}
