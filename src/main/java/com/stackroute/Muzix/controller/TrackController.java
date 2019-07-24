package com.stackroute.Muzix.controller;

import com.stackroute.Muzix.Exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.Exceptions.TrackNotFoundException;
import com.stackroute.Muzix.Domain.Track;
import com.stackroute.Muzix.service.MuzixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {
    MuzixService muzixService;
@Autowired
    public TrackController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
    ResponseEntity responseEntity;
    try{
        muzixService.saveTrack(track);
        responseEntity=new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
    }
    catch (Exception exception){
        responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
    }
return  responseEntity;
    }
    @GetMapping("track")
   public ResponseEntity<?> getAllTracks(){
return new ResponseEntity<List<Track>>(muzixService.getAllTracks(),HttpStatus.OK);
    }
    @DeleteMapping("delete/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        try{
            muzixService.deleteTrack(trackId);
            responseEntity=new ResponseEntity<String>("successfully deleted", HttpStatus.OK);
        }
        catch (Exception exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return  responseEntity;
    }
    @PutMapping("update/{trackId}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track,@PathVariable int trackId) throws TrackNotFoundException{
        ResponseEntity responseEntity;
        try{
            muzixService.updateById(track,trackId);
            responseEntity=new ResponseEntity<String>("successfully updated", HttpStatus.OK);
        }
        catch (Exception exception){
            responseEntity=new ResponseEntity<String>(exception.getMessage(),HttpStatus.CONFLICT);
        }
        return  responseEntity;
    }
    //get Mapping
    @GetMapping("/names/{name}")
    public ResponseEntity<List<Track>> getByname(@PathVariable String name) {
        List<Track> track = muzixService.getByName(name);
        return new ResponseEntity<List<Track>>(track, HttpStatus.OK);
    }

}
