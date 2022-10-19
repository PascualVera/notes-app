package com.notesapp.notesapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


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
	
	
	NoteController repository = new NoteController();
	
	
	@Test
	void noteCreation_TitleIsNull_ReturnInvalidInput() {
		
		ResponseEntity<Note> note = repository.postNote(new Note(0, null, null, null, null, null, null, null));
		
		assertEquals(note.getStatusCode(), HttpStatus.BAD_REQUEST);
		
		
	}

}
