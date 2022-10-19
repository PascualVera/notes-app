package com.notesapp.notesapp.note;

import java.time.LocalDate;

public class NoteValidator {

	private Boolean validationResult;
	private String validationReport;
	public void ValidateNote(Note note)
	{
		if(ValidateTitle(note.getTitle()))
		{
			validationResult=false;
			validationReport="Title is null or empty";
			return;
		}
		
		if(validateDate(note.getEstimatedDateOfCompletion())) {
			validationResult=false;
			validationReport="Time travel issues";
			return;
		}
		
		if(ValidatePriority(note.getPriority()))
		{
			validationResult=false;
			validationReport="Invalid Priority Value";
			return;
		}
		
		validationResult=true;
	}
	
	public Boolean ValidateTitle(String title)
	{
		
		return title == null || title.trim().isEmpty();
	}
	
	public Boolean validateDate(LocalDate date) {
		if (date.isBefore(LocalDate.now()) ) {
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean ValidatePriority(String priorityRank)
	{
		NotePriority[] priorities= NotePriority.values();
		for(NotePriority pri: priorities)
		{
			if(pri.toString().equals(priorityRank))
			{
				return false;
			}
		}
		return true;
	}
	
	public Boolean getValidationResult() {
		return validationResult;
	}
	
	public String getValidationReport() {
		return validationReport;
	}

	
	
}



