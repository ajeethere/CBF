package com.cbf.cbf.services;

import com.cbf.cbf.entities.FAQs;
import com.cbf.cbf.repositories.FAQsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FAQsService {
    @Autowired
    FAQsRepository faQsRepository;

    public void addFaq(FAQs faQs) {
        faQsRepository.save(faQs);
    }

    public List<FAQs> getFAQs() {
        return faQsRepository.findAll();
    }

    public Optional<FAQs> getFAQsById(Long id) {
        return faQsRepository.findById(id);
    }
}
