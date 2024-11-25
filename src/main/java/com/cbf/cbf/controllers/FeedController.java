package com.cbf.cbf.controllers;

import com.cbf.cbf.entities.Dashboard;
import com.cbf.cbf.entities.Feed;
import com.cbf.cbf.services.DashboardService;
import com.cbf.cbf.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/feed")
public class FeedController {
    @Autowired
    FeedService feedService;

    @Autowired
    DashboardService dashboardService;

    @PostMapping
    public ResponseEntity<?> addFeed(@RequestBody Feed feed){
        Optional<Dashboard> dashboard=dashboardService.getDashboard(1L);
        if (dashboard.isPresent()) {
            feed.setDashboard(dashboard.get());
            feedService.addFeed(feed);
            return ResponseEntity.ok("added");
        }else {
            return new ResponseEntity<>("Dashboard not added!", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<?> getFeeds(){
        return new ResponseEntity<>(feedService.getFeeds(),HttpStatus.OK);
    }
}
