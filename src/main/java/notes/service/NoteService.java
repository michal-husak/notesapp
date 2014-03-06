package notes.service;

import notes.dao.NoteDAO;
import notes.domain.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class NoteService {

    @Autowired
    private NoteDAO noteDAO;
    
    public NoteDAO getNoteDAO() {
        return noteDAO;
    }

    public void setNoteDAO(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;  
    }

    public Note createNewNote(String noteText)
    {
        Note note=new Note();
        note.setText(noteText);
        noteDAO.insertNote(note);
        return note;
    }
    
    public java.util.List<Note> getAllNotes()
    {
        return noteDAO.listNotes();
    }
}
