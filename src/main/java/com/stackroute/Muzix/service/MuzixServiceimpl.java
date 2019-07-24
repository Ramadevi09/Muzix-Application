package com.stackroute.Muzix.service;

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
    public boolean saveTrack(Track track) {
Track saveedTrack=muzixRepository.save(track);
return true;
    }

    @Override
    public boolean deleteTrack(int trackId) {
    muzixRepository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> getAllTracks() {
    return muzixRepository.findAll();
    }

    @Override
    public Optional<Track> getTrackById(int trackId) {
    return muzixRepository.findById(trackId);
    }

    @Override
    public boolean updateById(Track track, int trackId) {
        Optional<Track> userOptional = muzixRepository.findById(trackId);
        if (!userOptional.isPresent())
            return false;
        track.setTrackid(trackId);
        muzixRepository.save(track);
        return true;
    }
}
