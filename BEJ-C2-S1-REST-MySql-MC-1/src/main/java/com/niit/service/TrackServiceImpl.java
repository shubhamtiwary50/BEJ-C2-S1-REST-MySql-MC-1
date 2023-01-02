package com.niit.service;

import com.niit.domain.Track;
import com.niit.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements  TrackService{


    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public Track addTrack(Track track) {
        if(trackRepository.findById(track.getTrackId()).isEmpty()){
            return (Track) trackRepository.save(track);
        }
        return null;
//        return trackRepository.save(track);
    }

    @Override
    public List<Track> getAllTracks() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public String deleteByTrackId(int trackId) {
        if(trackRepository.findById(trackId).isEmpty()){
            return  "user does not exist";
        }
        trackRepository.deleteById(trackId);
        return "User deleted successfully";
    }

    @Override
    public List<Track> getByTrackId(int trackId) {
        return trackRepository.findByProductId(trackId);
    }

    @Override
    public List<Track> getTrackByArtistName(String artistName) {
        return trackRepository.findByArtistName(artistName);
    }

    @Override
    public Track updateByTrackId(Track track, int trackId) {
        return trackRepository.updateByTrackId(track,trackId);
    }
}
