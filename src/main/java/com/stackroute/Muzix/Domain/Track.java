package com.stackroute.Muzix.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PropertySource("com.stackroute.resources")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackid;
    private String trackname;
    private String comments;
    private String rating;

}