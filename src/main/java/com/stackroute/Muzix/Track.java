package com.stackroute.Muzix;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Track {
    @Id
    //@GeneratedValue()
    private int trackid;
    private String trackname;
    private String comments;
    private String rating;

    public Track() {
    }

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
    public String toString() {
        return "Track{" +
                "trackid=" + trackid +
                ", trackname='" + trackname + '\'' +
                ", comments='" + comments + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
