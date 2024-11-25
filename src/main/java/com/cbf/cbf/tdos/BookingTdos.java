package com.cbf.cbf.tdos;

import com.cbf.cbf.annotations.FormatDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BookingTdos {
    @JsonProperty("fId")
    private Long fId;
    @JsonProperty("uId")
    private Long uId;
    private List<String> tickets;
    private String date;
}
