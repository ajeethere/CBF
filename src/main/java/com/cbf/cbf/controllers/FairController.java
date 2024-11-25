package com.cbf.cbf.controllers;

import com.cbf.cbf.entities.Fair;
import com.cbf.cbf.services.FairService;
import com.cbf.cbf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/fair")
public class FairController {

    @Autowired
    FairService fairService;

    @GetMapping
    public ResponseEntity<?> getFair() {
        return fairService.getFairs();
    }

    @GetMapping("/{id}")
    public Optional<Fair> getFairById(@PathVariable Long id) {
        return fairService.getFairById(id);
    }

    @PostMapping
    public ResponseEntity<?> addFair(@RequestBody Fair fair) {
        fair.setCreatedAt(Utils.getDate());
        fair.setUpdatedAt(Utils.getDate());
        fair.setActive(true);
        fairService.addFair(fair);
        return new ResponseEntity<>("Fair Added Successfully!", HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<?> editFair(@RequestBody Fair fair) {
        Optional<Fair> oldFair = getFairById(fair.getId());
        if (oldFair.isPresent()) {
            Fair oldFairObj = oldFair.get();
            fair.setUpdatedAt(Utils.getDate());
            fair.setCreatedAt(oldFairObj.getCreatedAt());
            if (fair.getName() == null) fair.setName(oldFairObj.getName());
            if (fair.getAddress() == null) fair.setAddress(oldFairObj.getAddress());
            if (fair.getCity() == null) fair.setCity(oldFairObj.getCity());
            if (fair.getBooked() == null) fair.setBooked(oldFairObj.getBooked());
            if (fair.getAgeLimit() == null) fair.setAgeLimit(oldFairObj.getAgeLimit());
            fair.setActive(oldFairObj.isActive());
            if (fair.getAreaSize() == null) fair.setAreaSize(oldFairObj.getAreaSize());
            if (fair.getDateFrom() == null) fair.setDateFrom(oldFairObj.getDateFrom());
            if (fair.getToDate() == null) fair.setToDate(oldFairObj.getToDate());
            if (fair.getLatitude() == null) fair.setLatitude(oldFairObj.getLatitude());
            if (fair.getLongitude() == null) fair.setLongitude(oldFairObj.getLongitude());
            if (fair.getTiming() == null) fair.setTiming(oldFairObj.getTiming());
            if (fair.getStations() == null) fair.setStations(oldFairObj.getStations());
            if (fair.getDescription() == null) fair.setDescription(oldFairObj.getDescription());
            if (fair.getRatting() == null) fair.setRatting(oldFairObj.getRatting());
            if (fair.getNote() == null) fair.setNote(oldFairObj.getNote());
            if (fair.getInstruction() == null) fair.setInstruction(oldFairObj.getInstruction());
            if (fair.getSecurityRatting() == null) fair.setSecurityRatting(oldFairObj.getSecurityRatting());
            if (fair.getCapacity() == null) fair.setCapacity(oldFairObj.getCapacity());
            if (fair.getSafetyRatting() == null) fair.setSafetyRatting(oldFairObj.getSafetyRatting());
            if (fair.getImages() != null) {
                if (oldFair.get().getImages() != null) {
                    fair.getImages().addAll(oldFair.get().getImages());
                }
            } else {
                fair.setImages(oldFair.get().getImages());
            }
            fairService.addFair(fair);
            return new ResponseEntity<>("Fair Updated Successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Fair Not Found!", HttpStatus.BAD_GATEWAY);
        }

    }
}
