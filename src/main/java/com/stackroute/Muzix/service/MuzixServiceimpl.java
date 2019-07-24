package com.stackroute.Muzix.service;

import com.stackroute.Muzix.Exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.Exceptions.TrackNotFoundException;
import com.stackroute.Muzix.Track;
import com.stackroute.Muzix.repository.MuzixRepository;
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
    public boolean saveTrack(Track track) throws TrackAlreadyExistsException {
        if(muzixRepository.existsById(track.getTrackid())){
            throw new TrackAlreadyExistsException("id already exists");
        }
Track saveedTrack=muzixRepository.save(track);
return true;
    }

    @Override
    public boolean deleteTrack(int trackId) throws TrackNotFoundException {
        Track track=new Track();
        if(!muzixRepository.findById(trackId).isPresent()){
            throw new TrackNotFoundException("id not found");
        }
    muzixRepository.deleteById(trackId);
        return true;
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
    public boolean updateById(Track track, int trackId) throws TrackNotFoundException {
        Optional<Track> userOptional = muzixRepository.findById(trackId);
        if (!userOptional.isPresent()) {
            throw new TrackNotFoundException("id not found");

        }
        track.setTrackid(trackId);
        muzixRepository.save(track);
        return true;
    }

    @Override
    public List<Track> getByName(String name) {
        List<Track> tracks=muzixRepository.findTitleByName(name);
        return tracks;
    }
}
