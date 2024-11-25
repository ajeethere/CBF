package com.cbf.cbf.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String feed;
    private String address;

    @ManyToOne
    @JoinColumn(name = "dashboard_id")
    @JsonIgnore
    private Dashboard dashboard;
}
