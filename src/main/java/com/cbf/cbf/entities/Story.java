package com.cbf.cbf.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
