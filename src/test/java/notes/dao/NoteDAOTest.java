package notes.dao;

import static org.junit.Assert.*;
import notes.domain.Note;
import notes.testcategories.DeployTest;
import notes.testcategories.UnitTest;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
@Category(UnitTest.class)
public class NoteDAOTest {

    @Autowired
    NoteDAO noteDAO; 
    
    @Test
    public void test() {
        Note note=new Note();
        note.setText("poznamka");
        noteDAO.insertNote(note);
        assertEquals("poznamka", noteDAO.listNotes().get(0).getText());
        assertEquals(1, noteDAO.listNotes().size()); 
    }

}
