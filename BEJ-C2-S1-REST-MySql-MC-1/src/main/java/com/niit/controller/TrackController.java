package com.niit.controller;

import com.niit.domain.Track;
import com.niit.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TrackController{


    TrackService trackService;

    @Autowired
    TrackController(TrackService trackService){
        this.trackService = trackService;
    }

    @PostMapping("/addtrack")
//    question mark ? is a wild card character
    public ResponseEntity<?> addTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.CREATED);
    }

    @GetMapping("/getAllTracks")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<>(trackService.getAllTracks(), HttpStatus.CREATED);
    }

    @GetMapping("/getByTrackId/{trackId}")
    public ResponseEntity<?> getTrackByTrackId(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.getByTrackId(trackId),HttpStatus.FOUND);
    }

    @GetMapping("/getbytrackartist/{trackArtist}")
    public ResponseEntity<?> getTrackByArtist(@PathVariable String trackArtist){
        return new ResponseEntity<>(trackService.getTrackByArtistName(trackArtist),HttpStatus.FOUND);
    }

    @DeleteMapping("deletetrackbyid/{trackId}")
    public ResponseEntity<?> deleteTrackById(@PathVariable int trackId){
        return new ResponseEntity<>(trackService.deleteByTrackId(trackId),HttpStatus.OK);
    }



}
