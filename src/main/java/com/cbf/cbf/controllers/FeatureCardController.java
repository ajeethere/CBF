package com.cbf.cbf.controllers;

import com.cbf.cbf.entities.Dashboard;
import com.cbf.cbf.entities.FeatureCard;
import com.cbf.cbf.services.DashboardService;
import com.cbf.cbf.services.FeatureCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/feature")
public class FeatureCardController {

    @Autowired
    FeatureCardService featureCardService;

    @Autowired
    DashboardService dashboardService;

    @PostMapping
    public ResponseEntity<?> addFeature(@RequestBody FeatureCard featureCard){
        Optional<Dashboard> dashboard=dashboardService.getDashboard(1L);
        if (dashboard.isPresent()) {
            featureCard.setDashboard(dashboard.get());
            featureCardService.addFeature(featureCard);
            return ResponseEntity.ok("added");
        }else {
            return new ResponseEntity<>("Dashboard not added!",HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<?> getFeatures(){
        return new ResponseEntity<>(featureCardService.getFeatures(), HttpStatus.OK);
    }
 }
