package com.cbf.cbf.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class FAQs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("uId")
    private Long uId;
    private String question;
    @Column(columnDefinition = "TEXT")
    private String answer;
    private Date createAt;
    private  Date updatedAt;
}
