package com.stackroute.musicAssignment.muzixAppMysql.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    public TrackMatches results;
}
