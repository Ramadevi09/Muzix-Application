package com.stackroute.Muzix.service;

import com.stackroute.Muzix.Track;

import java.util.List;
import java.util.Optional;


public interface MuzixService {
    public boolean saveTrack(Track track);
    public boolean deleteTrack(int trackId) ;
    public List<Track> getAllTracks();
    public Optional<Track> getTrackById(int trackId);
    public boolean updateById(Track track,int Id);
    public List<Track> getByName(String name);
}
