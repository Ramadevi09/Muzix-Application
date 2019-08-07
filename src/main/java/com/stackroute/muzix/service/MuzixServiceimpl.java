package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
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
    public Track saveTrack(Track track) throws TrackAlreadyExistsException
    {
        if(muzixRepository.existsById(track.getTrackid())){
            throw new TrackAlreadyExistsException("id already exists");
        }
        Track saveedTrack=muzixRepository.save(track);
        return track;
    }

    @Override
    public int deleteTrack(int trackId) throws TrackNotFoundException {
        Track track=new Track();
        if(!muzixRepository.findById(trackId).isPresent()){
            throw new TrackNotFoundException("id not found");
        }
        muzixRepository.deleteById(trackId);
        return trackId;
    }

    @Override
    public List<Track> getAllTracks() {
        return muzixRepository.findAll();
    }

    @Override
    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException {
        if(!muzixRepository.findById(trackId).isPresent()){
            throw new TrackNotFoundException("id not found");
        }
        return muzixRepository.findById(trackId);
    }

    @Override
    public Track updateById(Track track, int trackId) throws TrackNotFoundException {
        Optional<Track> userOptional = muzixRepository.findById(trackId);
        if (!userOptional.isPresent()) {
            throw new TrackNotFoundException("id not found");

        }
        track.setTrackid(trackId);
        muzixRepository.save(track);
        return track;
    }

    @Override
    public List<Track> getByName(String name) {
        List<Track> tracks=muzixRepository.findTitleByName(name);
        return tracks;
    }

}
