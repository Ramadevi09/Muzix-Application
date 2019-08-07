package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;

import java.util.List;
import java.util.Optional;


public interface MuzixService {
    public Track saveTrack(Track track);
    public int deleteTrack(int trackId) ;
    public List<Track> getAllTracks();
    public Optional<Track> getTrackById(int trackId);
    public Track updateById(Track track,int Id);
}
