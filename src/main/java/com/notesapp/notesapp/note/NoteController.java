package com.notesapp.notesapp.note;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;


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
	//static List<Note> notes = new ArrayList<Note>();
	
	private NoteDaoService service;
	public NoteController(NoteDaoService service)
	{
		this.service=service;
	}
	
	@PostMapping(path = "/notes")
	public ResponseEntity<Note> postNote( @RequestBody Note note) {
		//Note Validation
		NoteValidator validator=new NoteValidator();
		validator.ValidateNote(note);
		
		if(validator.getValidationResult())
		{
			Note savedNote= service.save(note);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedNote.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
		
		
		return ResponseEntity.badRequest().build();
		
		
		
	}
	
	@GetMapping(path = "/notes")
	public List<Note> getAllNotes(){
		return service.findAll();
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Boolean> deleteNote(@PathVariable int id)
	{
		Boolean deletionStatus=service.delete(id);
		if(deletionStatus)
		{
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/notes/{id}")
	public ResponseEntity<Note> updateNote(@PathVariable int id,@RequestBody Note note)
	{
		Note updatedNote=service.update(note,id);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(updatedNote.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		
		
	}
	
	
}
