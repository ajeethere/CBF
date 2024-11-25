package com.cbf.cbf.services;

import com.cbf.cbf.entities.FeatureCard;
import com.cbf.cbf.repositories.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeatureCardService {
    @Autowired
    FeatureRepository featureRepository;

    public void addFeature(FeatureCard featureCard){
        featureRepository.save(featureCard);
    }

    public List<FeatureCard> getFeatures(){
        return featureRepository.findAll();
    }
}
