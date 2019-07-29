package com.stackroute.MusicAssignment.MuzixAppMysql.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    public TrackMatches results;
}
