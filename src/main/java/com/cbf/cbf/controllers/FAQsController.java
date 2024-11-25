package com.cbf.cbf.controllers;

import com.cbf.cbf.entities.FAQs;
import com.cbf.cbf.services.FAQsService;
import com.cbf.cbf.tdos.FAQsTdos;
import com.cbf.cbf.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/faqs")
public class FAQsController {

    @Autowired
    FAQsService faQsService;


    @GetMapping
    public ResponseEntity<?> getFAQs(){
        return new ResponseEntity<>(faQsService.getFAQs(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addFaq(@RequestBody FAQs faQs){
        faQs.setCreateAt(Utils.getDate());
        faQs.setUpdatedAt(Utils.getDate());
        faQsService.addFaq(faQs);
        return ResponseEntity.ok("FAQ added successfully");
    }

    @PutMapping
    public ResponseEntity<?> editFaq(@RequestBody FAQsTdos faQsTdos){
        Optional<FAQs> faQs=faQsService.getFAQsById(faQsTdos.getId());
        if (faQs.isPresent()){
            faQs.get().setUpdatedAt(Utils.getDate());
            faQs.get().setAnswer(faQsTdos.getAnswer());
            faQsService.addFaq(faQs.get());
            return ResponseEntity.ok("FAQ updated successfully");
        }else {
            return new ResponseEntity<>("FAQ not found!",HttpStatus.BAD_REQUEST);
        }
    }
}