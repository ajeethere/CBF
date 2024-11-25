package com.cbf.cbf.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Fair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String latitude;
    private String longitude;
    private String address;
    private String imageUrl;
    private List<String> images;
    private String city;
    private String ratting;
    private String capacity;
    private String dateFrom;
    private String toDate;
    private String timing;
    private boolean active;
    private String booked;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String instruction;
    private String ageLimit;
    private String note;
    private String securityRatting;
    private String safetyRatting;
    private String areaSize;
    private String stations;
    private Date createdAt;
    private Date updatedAt;


    @OneToMany(mappedBy = "fair",cascade = CascadeType.ALL)
    private List<Booking> bookings=new ArrayList<>();
}
