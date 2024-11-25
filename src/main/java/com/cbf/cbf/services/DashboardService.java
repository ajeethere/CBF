package com.cbf.cbf.services;

import com.cbf.cbf.entities.Dashboard;
import com.cbf.cbf.repositories.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DashboardService {
    @Autowired
    DashboardRepository dashboardRepository;

    public void addDashboardData(Dashboard dashboard){
        dashboard.setId(1L);
        dashboardRepository.save(dashboard);
    }

    public List<Dashboard> getDashboardData(){
        return dashboardRepository.findAll();
    }
    public Optional<Dashboard> getDashboard(Long id){
        return dashboardRepository.findById(id);
    }
}
