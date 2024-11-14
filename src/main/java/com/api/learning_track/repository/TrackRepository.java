package com.api.learning_track.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.learning_track.model.Track;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

}
