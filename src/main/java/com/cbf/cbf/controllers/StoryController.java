package com.cbf.cbf.controllers;

import com.cbf.cbf.entities.Story;
import com.cbf.cbf.services.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/story")
public class StoryController {
    @Autowired
    StoryService storyService;

    @PostMapping
    public ResponseEntity<?> addStory(@RequestBody Story story) {
        storyService.addStory(story);
        return ResponseEntity.ok("Story added.");
    }

    @GetMapping
    public ResponseEntity<?> getStories() {
        return ResponseEntity.ok(storyService.getStories());
    }
}
