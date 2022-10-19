package com.notesapp.notesapp.note;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class NoteController {
	//Note parameter
		//ID
		//Title
		//Text
		//Date
		//Date of completion
		//Link
		//Mentions
		//Priority
	static List<Note> notes = new ArrayList<Note>();
	
	static {notes.add(new Note(0, "Note1", "Text1",null, null, null, null, null));}
	
	
	@PostMapping(path = "/notes")
	public ResponseEntity<Note> postNote(@RequestBody Note note) {
		notes.add(note);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(note.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping(path = "/notes")
	public List<Note> getAllNotes(){
		return notes;
	}
}
