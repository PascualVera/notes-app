package com.notesapp.notesapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.notesapp.notesapp.note.Note;

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
	
	
	
	
	
	@Test
	void noteCreationSendingStringReturnsNote() {
		
		Note note = new Note(0, null, null, null, null, null, null, null);
		assertNotEquals(note.getTitle(), null);
		
		
	}

}
