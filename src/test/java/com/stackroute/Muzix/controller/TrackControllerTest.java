package com.stackroute.Muzix.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.Muzix.Domain.Track;
import com.stackroute.Muzix.service.MuzixService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TrackControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private MuzixService muzixService;
    private Track track;
    @InjectMocks
    TrackController trackController;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(trackController).build();
        track=new Track(1,"Rama","good","A");

    }
    @Test
    public void testcontrollerTest() throws  Exception{
        when(muzixService.saveTrack(track)).thenReturn(true);
        mockMvc.perform(post("/api/v1/track").contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON).content(jsonToString(track)))
                .andExpect(status().isCreated())
                .andDo(print());

    }
    @Test
    public void testcontrollerDeleteTest() throws  Exception{
        when(muzixService.deleteTrack(1)).thenReturn(true);
        mockMvc.perform(post("/api/v1/track").contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON).content(jsonToString(track)))
                .andExpect(status().isCreated())
                .andDo(print());

    }
    public String jsonToString(final Track track)
    {
        String string="";
        try {
            string=new ObjectMapper().writeValueAsString(track);
        } catch( JsonProcessingException e) {
            e.printStackTrace();
        }
        return string;
    }


}
