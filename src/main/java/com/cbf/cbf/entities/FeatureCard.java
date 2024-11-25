package com.cbf.cbf.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FeatureCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String featureText;

    @ManyToOne
    @JoinColumn(name = "dash_id")
    @JsonIgnore
    private Dashboard dashboard;
}
