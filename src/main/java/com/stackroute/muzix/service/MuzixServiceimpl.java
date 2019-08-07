package com.stackroute.muzix.service;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceimpl implements MuzixService, ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
    @Value("${track.1.name:default}")
    String name1;
    @Value("${track.1.rating:default}")
    String rating1;
    @Value("${track.1.comments:default}")
    String comments1;
    @Value("${track.2.name:default}")
    String name2;
    @Value("${track.2.rating:default}")
    String rating2;
    @Value("${track.2.comments:default}")
    String comments2;



    private MuzixRepository muzixRepository;

    public MuzixServiceimpl() {
    }

    @Autowired
    public MuzixServiceimpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    @Override
    //saves the track
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(muzixRepository.existsById(track.getTrackid())){
            throw new TrackAlreadyExistsException("id already exists");
        }
Track saveedTrack=muzixRepository.save(track);
return track;
    }

    @Override
    //delete track based on Id
    public int deleteTrack(int trackId) throws TrackNotFoundException {
        Track track=new Track();
        if(!muzixRepository.findById(trackId).isPresent()){
            throw new TrackNotFoundException("id not found");
        }
    muzixRepository.deleteById(trackId);
        return trackId;
    }

    @Override
    //retrive all tracks
    public List<Track> getAllTracks() {
    return muzixRepository.findAll();
    }

    @Override
    //retrive traks based on id
    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException {
        if(!muzixRepository.findById(trackId).isPresent()){
            throw new TrackNotFoundException("id not found");
        }
    return muzixRepository.findById(trackId);
    }

    @Override
    //update track by id
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
    //get tracks based on name
    public List<Track> getByName(String name) {
        List<Track> tracks=muzixRepository.findTitleByName(name);
        return tracks;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        muzixRepository.save(new Track(1,name1,rating1,comments1));
        muzixRepository.save(new Track(2,name2,rating2,comments2));

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Command Line Runner Implemented");
    }
}
