package com.stackroute.muzix.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackid;
    private String trackname;
    private String comments;
    private String rating;
//no param constructor
    public Track() {
    }
//parameterized constructor
    public Track(int trackid, String trackname, String comments, String rating) {
        this.trackid = trackid;
        this.trackname = trackname;
        this.comments = comments;
        this.rating = rating;
    }



    public int getTrackid() {
        return trackid;
    }

    public void setTrackid(int trackid) {
        this.trackid = trackid;
    }

    public String getTrackname() {
        return trackname;
    }

    public void setTrackname(String trackname) {
        this.trackname = trackname;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    //tostring method
    public String toString() {
        return "Track{" +
                "trackid=" + trackid +
                ", trackname='" + trackname + '\'' +
                ", comments='" + comments + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
