package com.stackroute.musicAssignment.muzixAppMysql.service;


import com.stackroute.musicAssignment.muzixAppMysql.domain.Track;
import com.stackroute.musicAssignment.muzixAppMysql.exceptions.TrackAlreadyExistsException;
import com.stackroute.musicAssignment.muzixAppMysql.exceptions.TrackNotFoundException;
import com.stackroute.musicAssignment.muzixAppMysql.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository = trackRepository;
    }

    @Override
    //save the tracks
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack = trackRepository.save(track);

        if(savedTrack == null)
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return savedTrack;
    }

    @Override
    //retrive all tracks
    public List<Track> getAllTracks() {

        return trackRepository.findAll();
    }

    @Override
    //retrive tracks by name
    public List<Track> getTracksByName(String name) {

        return trackRepository.getTrackByName(name);

    }
//update track based on id
    public Track updateTrack(Track track, int id) throws TrackNotFoundException
    {
        Optional<Track> track1 = trackRepository.findById(id);

        if(!track1.isPresent())
        {
            throw new TrackNotFoundException("Track Not Found");
        }

        track.setId(id);

        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }
//delete track based on id
    public int deleteTrack(int id) throws TrackNotFoundException
    {
        Optional<Track> track1 = trackRepository.findById(id);

        if(!track1.isPresent())
        {
            throw new TrackNotFoundException("Track Not Found");
        }

        try {

            trackRepository.delete(track1.get());

            return id;

        }
        catch (Exception exception)
        {
            return 0;
        }
    }
//serching tracks
    @Override
    public List<Track> searchTracks(String searchString) {

        return trackRepository.searchTracks(searchString);
    }
}