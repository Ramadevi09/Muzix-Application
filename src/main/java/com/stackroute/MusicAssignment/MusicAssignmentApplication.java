package com.stackroute.MusicAssignment;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.MusicAssignment.MuzixAppMysql.domain.Track;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class MusicAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicAssignmentApplication.class, args);

		ObjectMapper mapper = new ObjectMapper();
		try {
			Track track = mapper.readValue(new File("/home/ramadevi/Documents/download.json"), Track.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}