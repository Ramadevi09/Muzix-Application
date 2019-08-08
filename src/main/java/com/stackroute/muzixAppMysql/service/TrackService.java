package com.stackroute.muzixAppMysql.service;
import com.stackroute.muzixAppMysql.domain.Track;
import com.stackroute.muzixAppMysql.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixAppMysql.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks();

  //  public List<Track> getTracksByName(String name);

    public Track updateTrack(Track track, int id) throws TrackNotFoundException;

    public int deleteTrack(int id) throws TrackNotFoundException;

   // public List<Track> searchTracks(String searchString);
}
