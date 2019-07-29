package com.stackroute.Muzix.repositroy;

import com.stackroute.Muzix.Domain.Track;
import com.stackroute.Muzix.repository.MuzixRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@RunWith(SpringRunner.class)
@DataJpaTest
public class Repository {
    @Autowired
    MuzixRepository muzixRepository;
    Track track;

    List<Track> list = null;


    @Before
    public void setUp() {
        track = new Track();
        track.setTrackid(1);
        track.setTrackname("sindhu");
        track.setComments("good");
        track.setRating("A");
        list = new ArrayList<>();
        list.add(track);

    }

    @After
    public void tearDown() {

        muzixRepository.deleteAll();
    }

    @Test
    public void testSaveTrack() {
        muzixRepository.save(track);
        Track fetchTrack = muzixRepository.findById(track.getTrackid()).get();
        Assert.assertEquals(1, fetchTrack.getTrackid());

    }

    @Test
    public void testGetAllTracks() {
        muzixRepository.save(track);
        List<Track> fetchTrack = muzixRepository.findAll();
        Assert.assertEquals(list, fetchTrack);
    }

    @Test
    public void testUpdateTrack() {
// save one object in database
        muzixRepository.save(track);
// fetch that object from database
        Track fetchTrack = muzixRepository.findById(track.getTrackid()).get();
//update any field of the track
        track.setComments("bad");
// save it again
        muzixRepository.save(track);
// fetch it again and verify that updated field is there or not .
        Assert.assertEquals("bad", track.getComments());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeleteTrack() {
// save one object in database
        muzixRepository.save(track);
// fetch that object from database
        Track fetchTrack = muzixRepository.findById(track.getTrackid()).get();
        // verify fetched data is not null
        Assert.assertEquals("sindhu",fetchTrack.getTrackname());
// delete the data
        muzixRepository.deleteById(1);
// fetch again and verify its null now
// Assert.assertEquals(null,muzixRepository.findById(track.getTrackId()).get());
        muzixRepository.findById(track.getTrackid()).get();


    }
}



