package com.cbf.cbf.repositories;

import com.cbf.cbf.entities.FeatureCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<FeatureCard,Long> {
}
