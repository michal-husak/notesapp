package notes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seq", initialValue=1, allocationSize=1000)
@Table(name="Notes")
public class Note {

    private int id;
    private String text;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Column(name="id")
    public int getId() { 
        return id;
    }
    public void setId(int id) {
        this.id = id; 
    }
    
    @Column(name="text")
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
