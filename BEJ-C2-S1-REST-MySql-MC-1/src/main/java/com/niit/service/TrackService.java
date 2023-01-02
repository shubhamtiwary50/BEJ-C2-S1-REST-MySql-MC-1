package com.niit.service;

import com.niit.domain.Track;

import java.util.List;

public interface TrackService {

    public Track addTrack(Track track);
    public List<Track> getAllTracks();
    public String deleteByTrackId(int trackId);
    public List<Track> getByTrackId(int trackId);
    public List<Track> getTrackByArtistName(String artistName);
    public Track updateByTrackId(Track track ,int trackId);

}
