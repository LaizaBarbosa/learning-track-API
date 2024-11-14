package com.api.learning_track.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.learning_track.model.Track;
import com.api.learning_track.repository.TrackRepository;

@Service
public class TrackService implements CrudService<Long, Track>{
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    public Track findById(Long id) {
        return this.trackRepository.findById(id).orElseThrow();
        
    }


    public Track create(Track newTrack) {
        return trackRepository.save(newTrack);
        
    }
    

    public void delete(Long id) {
        trackRepository.deleteById(id);
        
    }

    
    public List<Track> findAll() {
        return this.trackRepository.findAll();
        
    }


    public Track update(Long id, Track updatedTrack) {
        Track trackDb = this.findById(id);

        trackDb.setName(updatedTrack.getName());
        trackDb.setSteps(updatedTrack.getSteps());

        return this.trackRepository.save(trackDb);
    }

    
}
