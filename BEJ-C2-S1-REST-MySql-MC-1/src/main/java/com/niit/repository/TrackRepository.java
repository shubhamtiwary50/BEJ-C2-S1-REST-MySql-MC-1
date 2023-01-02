package com.niit.repository;

import com.niit.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository  extends JpaRepository<Track, Integer> {

    List<Track> findByProductId(int trackId);

    Track updateByTrackId(Track track, int trackId);

    List<Track> findByArtistName(String artistName);
}
