package com.stackroute.Muzix.service;

import com.stackroute.Muzix.Exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.Exceptions.TrackNotFoundException;
import com.stackroute.Muzix.Track;

import java.util.List;
import java.util.Optional;


public interface MuzixService {
    public boolean saveTrack(Track track) throws TrackAlreadyExistsException;
    public boolean deleteTrack(int trackId) throws TrackNotFoundException ;
    public List<Track> getAllTracks();
    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException;
    public boolean updateById(Track track,int Id) throws TrackNotFoundException;
    public List<Track> getByName(String name);
}
