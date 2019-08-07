package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.service.MuzixService;
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
    //saves the track
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
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
    //get all tracks
   public ResponseEntity<?> getAllTracks(){
return new ResponseEntity<List<Track>>(muzixService.getAllTracks(),HttpStatus.OK);
    }
    @DeleteMapping("delete/{trackId}")
    //delete track
    public ResponseEntity<?> deleteTrack(@PathVariable int trackId){
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
    //updates the track
    public ResponseEntity<?> updateTrack(@RequestBody Track track,@PathVariable int trackId){
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

}
