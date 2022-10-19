package com.notesapp.notesapp.note;

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
		
		
		
		validationResult=true;
	}
	
	public Boolean ValidateTitle(String title)
	{
		
		return title == null || title.trim().isEmpty();
	}
	
	
	public Boolean getValidationResult() {
		return validationResult;
	}
	
	public String getValidationReport() {
		return validationReport;
	}

	
	
}



