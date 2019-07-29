package com.stackroute.Muzix.Service;

import com.stackroute.Muzix.Domain.Track;
import com.stackroute.Muzix.repository.MuzixRepository;
import com.stackroute.Muzix.service.MuzixService;
import com.stackroute.Muzix.service.MuzixServiceimpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.EmptyStackException;

import static org.mockito.Mockito.*;

public class TrackServiceTest {
    @Mock
    MuzixRepository muzixRepository;
    @InjectMocks
    MuzixServiceimpl muzixServiceimpl;
    @Autowired
    private MockMvc mockMvc;
    Track track;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        mockMvc= MockMvcBuilders.standaloneSetup(muzixRepository).build();
         track=new Track(2,"devi","good","A");
    }
    @Test
    public void ServiceTestForSave() throws Exception{
        when(muzixRepository.save(track)).thenReturn(track);
        boolean saveTrack=muzixServiceimpl.saveTrack(track);
        Assert.assertEquals(true,saveTrack);
        verify(muzixRepository,times(1)).save(track);

    }
    @Test
    public void deleteTrack()throws Exception{

        doNothing().when(muzixRepository).delete(any());
        muzixServiceimpl.deleteTrack(2);
        //Assert.assertEquals(true,deletetrack);
        verify(muzixRepository,times(1)).deleteById(anyInt());
    }

}
