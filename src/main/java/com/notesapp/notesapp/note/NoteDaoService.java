package com.notesapp.notesapp.note;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;



@Component
public class NoteDaoService {

	private static List<Note> notes= new ArrayList<>();
	private static int notesCount=0;
	
	static {notes.add(new Note(++notesCount, "Note1", "Text1", LocalDate.now().plusDays(7), null, null, null));}
	
	public List<Note> findAll(){
		return notes;
	}
	
	
	/*public User findOne(int id) {
		//look this up later
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
	}*/
	
	public Note save(Note note)
	{
		note.setId(++notesCount);
		notes.add(note);
		return note;
	}
	
	
	public Boolean delete(int id)
	{
		Predicate<? super Note> predicate = note -> note.getId()==id;
		return notes.removeIf(predicate);
	}
	
	
	public Note update(Note upNote,long noteID)
	{
		//Predicate<? super Note> predicate = note -> note.getId()==upNote.getId();
		Note oldNote = null;
		for(Note singleNote: notes)
		{
			if(singleNote.getId()==noteID)
			{
				oldNote=singleNote;
			}
		}
		
		
		oldNote.UpdateValues(upNote);
		
		return oldNote;
		
		
	}

}
