package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceimpl implements MuzixService {
private MuzixRepository muzixRepository;

    public MuzixServiceimpl() {
    }

    @Autowired
    public MuzixServiceimpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    @Override
    //saves the track
    public Track saveTrack(Track track) {
Track saveedTrack=muzixRepository.save(track);
return saveedTrack;
    }

    @Override
    //delete the track based on id
    public int deleteTrack(int trackId) {
    muzixRepository.deleteById(trackId);
        return trackId;
    }

    @Override
    //retrive all tracks
    public List<Track> getAllTracks() {
    return muzixRepository.findAll();
    }

    @Override
    //retrive track based on id
    public Optional<Track> getTrackById(int trackId) {
    return muzixRepository.findById(trackId);
    }

    @Override
    //update track based on id
    public Track updateById(Track track, int trackId) {
        Optional<Track> userOptional = muzixRepository.findById(trackId);
        if (!userOptional.isPresent())
            return track;
        track.setTrackid(trackId);
        muzixRepository.save(track);
        return track;
    }
}
