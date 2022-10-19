package com.notesapp.notesapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.notesapp.notesapp.note.Note;
import com.notesapp.notesapp.note.NoteController;

import org.junit.jupiter.api.Assertions;

@SpringBootTest
class NotesAppApplicationTests {
	
	//Note parameter
	//ID
	//Title
	//Text
	//Date
	//Date of completion
	//Link
	//Mentions
	//Priority
	
	//Testing notes null or empty
	List<Note> nullOrEmptyNotes = new ArrayList<Note>();
	
	NoteController repository = new NoteController();
	
	@Test
	void noteCreation_SomeValueIsNullOrEmpty_ReturnInvalidInput() {
		
		ResponseEntity<Note> nullNote = repository.postNote(new Note(0, null, null, null, null, null, null, null));
		ResponseEntity<Note> emptyNote = repository.postNote(new Note(0, "", "", LocalDate.now(),  LocalDate.now(), "", "", ""));
		
		assertEquals(emptyNote.getStatusCode(), HttpStatus.BAD_REQUEST);
		
	}
	


}
