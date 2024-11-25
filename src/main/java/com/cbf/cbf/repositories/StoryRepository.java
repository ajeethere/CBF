package com.cbf.cbf.repositories;

import com.cbf.cbf.entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story,Long> {
}
