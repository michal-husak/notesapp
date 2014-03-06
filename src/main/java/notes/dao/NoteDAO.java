package notes.dao;

import java.util.List;

import notes.domain.Note;

public interface NoteDAO {

    
    
    public void insertNote(Note note); 
    public List<Note> listNotes(); 
}
