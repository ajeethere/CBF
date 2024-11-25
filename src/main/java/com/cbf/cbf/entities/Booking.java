package com.cbf.cbf.entities;

import com.cbf.cbf.annotations.AppendBrand;
import com.cbf.cbf.annotations.FormatDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<String> tickets;
    private String date;
    private boolean active;
    private Date createdAt;
    @FormatDate(pattern = "dd-MMM-yyyy") // Specify the required date format
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "fair_id")
    @JsonIgnore
    private Fair fair;

    @JsonProperty("u_id")
    private Long getUserId(){
        return user.getId();
    }

    @JsonProperty("f_id")
    private Long getFairId(){
        return fair.getId();
    }
}
