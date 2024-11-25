package com.cbf.cbf.controllers;

import com.cbf.cbf.entities.Dashboard;
import com.cbf.cbf.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dash")
public class DashboardController {
    @Autowired
    DashboardService dashboardService;

    @PostMapping
    public ResponseEntity<?> postDashData(@RequestBody Dashboard dashboard){
        dashboardService.addDashboardData(dashboard);
        return ResponseEntity.ok("added");
    }

    @GetMapping
    public ResponseEntity<?> getDashboard(){
        return new ResponseEntity<>(dashboardService.getDashboardData(), HttpStatus.OK);
    }
}
