package com.api.learning_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.learning_track.model.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Long>{

}
