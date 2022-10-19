package com.notesapp.notesapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.HttpStatus;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.notesapp.notesapp.note.Note;
import com.notesapp.notesapp.note.NoteController;
import com.notesapp.notesapp.note.NoteDaoService;

import org.junit.jupiter.api.Assertions;


@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest
//@ContextConfiguration(classes = { NoteController.class, ValidationAutoConfiguration.class})
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
	//NoteDaoService service=new NoteDaoService();
	@Autowired
	private NoteController repository;
	
	@Test
	void noteCreation_SomeValueIsNullOrEmpty_ReturnInvalidInput() {
		
		ResponseEntity<Note> nullNote = repository.postNote(new Note(0, null, null, null, null, null, null));
		ResponseEntity<Note> emptyNote = repository.postNote(new Note(0, "", "",  LocalDate.now(), "", "", ""));
		
		assertEquals(HttpStatus.BAD_REQUEST, nullNote.getStatusCode());
		
	}
	
	@Test
	void noteCreation_EstimatedDateBeforeCreatedDate_ReturnInvalidRequest()
	{
		ResponseEntity<Note> timeTravelNote = repository.postNote(new Note(0, "Test Title", "Test Desc", LocalDate.now().minusDays(1), null, null, null));
		
		assertEquals(HttpStatus.BAD_REQUEST, timeTravelNote.getStatusCode());
	}
	
	@Test
	void noteDeletion_NonExistantID_ReturnNotFound() {
		ResponseEntity<Boolean> noteToDeleteID=repository.deleteNote(-1);
		
		assertEquals(HttpStatus.NOT_FOUND, noteToDeleteID.getStatusCode());
	}
	@Test 
	void notePriority_NotValidInput_ReturnsInvalidRequest() { 
		ResponseEntity<Note> urgentNote = repository.postNote(new Note(0, "Test Title", "Test Desc", LocalDate.now().plusDays(1), null, null, "Corre puto"));
		
		assertEquals(HttpStatus.BAD_REQUEST, urgentNote.getStatusCode());
	}
	
	void notePatch_InvalidMemberChanges_ReturnsInvalidRequest()
	{
		ResponseEntity<Note> updatedNote= repository.updateNote(1,new Note(0, "Test Title", "Test Desc", LocalDate.now().plusDays(1), null, null, "Corre puto"));
		
		assertEquals(HttpStatus.BAD_REQUEST, updatedNote.getStatusCode());
				
	}
	
	
	
	
	


}
