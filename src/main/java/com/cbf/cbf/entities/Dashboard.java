package com.cbf.cbf.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String fairs;
    private String entrepreneurs;
    private String cities;
    private String countries;
    private String policy;
    private String policyDesc;

    @OneToMany(mappedBy = "dashboard",cascade = CascadeType.ALL)
    private List<FeatureCard> featureCards=new ArrayList<>();

    @OneToMany(mappedBy = "dashboard",cascade = CascadeType.ALL)
    private List<Feed> feeds=new ArrayList<>();

}
