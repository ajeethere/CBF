package com.cbf.cbf.services;

import com.cbf.cbf.entities.Fair;
import com.cbf.cbf.repositories.FairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FairService {
    @Autowired
    FairRepository fairRepository;

    public ResponseEntity<?> getFairs() {
        return new ResponseEntity<>(fairRepository.findAll(), HttpStatus.OK);
    }

    public Optional<Fair> getFairById(Long id) {
        return new ResponseEntity<>(fairRepository.findById(id), HttpStatus.OK).getBody();
    }

    public void addFair(Fair fair) {
        try {
            fairRepository.save(fair);
        } catch (Exception e) {
//            if (fair.getId() != null) {
//                return new ResponseEntity<>("Updating fair failed!", HttpStatus.BAD_REQUEST);
//            } else {
//                return new ResponseEntity<>("Adding fair failed!", HttpStatus.BAD_GATEWAY);
//            }
        }
    }
}
