package notes.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.Arrays;

import notes.domain.Note;
import notes.service.NoteService;
import notes.testcategories.DeployTest;
import notes.testcategories.UnitTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@Category(UnitTest.class)
@RunWith(MockitoJUnitRunner.class)
public class NoteControllerTest {

    @Mock
    NoteService noteServiceMock;  
    
    @InjectMocks
    private NoteController noteController=new NoteController();

    private MockMvc mockMvc;
    //private NoteService noteServiceMock;

    @Before
    public void setup() {
        Note first = new Note();
        first.setText("prva");
        Note second = new Note();
        second.setText("druhaaaa");
        when(noteServiceMock.getAllNotes()).thenReturn(Arrays.asList(first, second));
        //noteController.setNoteService(noteServiceMock);
        this.mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
    }

    @Test
    public void getTest() throws Exception {
        //System.out.println(noteServiceMock.getAllNotes());
        mockMvc.perform(get("/notes")).andExpect(status().isOk())
        .andExpect(content().contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))))
        ;
        
    }

}
