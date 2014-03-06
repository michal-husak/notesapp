package notes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import notes.domain.Note;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class NoteDAOImpl implements NoteDAO {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insertNote(Note note) {
        entityManager.persist(note); 
    }

    @Override
    public List<Note> listNotes() { 
        return entityManager.createQuery("from Note", Note.class).getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
