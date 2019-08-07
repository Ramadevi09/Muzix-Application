package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;


public interface MuzixService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public int deleteTrack(int trackId) throws TrackNotFoundException;
    public List<Track> getAllTracks();
    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException;
    public Track updateById(Track track,int Id) throws TrackNotFoundException;
    public List<Track> getByName(String name);
}
