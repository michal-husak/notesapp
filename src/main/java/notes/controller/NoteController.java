package notes.controller;

import notes.domain.Note;
import notes.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class NoteController {
    
    @Autowired
    private NoteService noteService;
    
    
    @RequestMapping(value = "/notes", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public java.util.List<Note> getAll()
    {
        return noteService.getAllNotes();  
    }
    
    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public ResponseEntity<Note> create(@RequestBody String text, UriComponentsBuilder builder)
    {
        return new ResponseEntity<Note>(noteService.createNewNote(text), HttpStatus.CREATED);
    }

    public NoteService getNoteService() {
        return noteService;
    }

    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

}
