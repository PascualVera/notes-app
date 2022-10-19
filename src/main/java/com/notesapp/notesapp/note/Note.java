package com.notesapp.notesapp.note;

import java.time.LocalDate;
/*
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.PositiveOrZero;
*/

public class Note {
	//Note parameter
	//ID
	//Title
	//Text
	//Date
	//Date of completion
	//Link
	//Mentions
	//Priority
	//@PositiveOrZero(message=("ID Should not be Empty or Negative"))
	private long id;
	//@Size(min=2, message=("Title Should not be Empty"))
	//@NotNull
	private String title;
	//@Size(min=1, message=("Text Should not be Empty"))
	//@NotNull
	private String text;
	private LocalDate date;
	//@FutureOrPresent(message=("Expected dat of Completion should be in the future."))
	//@NotNull
	private LocalDate estimatedDateOfCompletion;
	private LocalDate actualDateOfCompletion;
	private String Link;
	private String mentions;
	//@Size(min=1, message=("Priority Should not be Empty"))
	private String priority;
	
	
	public Note(long id, String title, String text, LocalDate estimatedDateOfCompletion, String link,
			String mentions, String priority) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.date = LocalDate.now();
		this.estimatedDateOfCompletion = estimatedDateOfCompletion;
		Link = link;
		this.mentions = mentions;
		this.priority = priority;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getMentions() {
		return mentions;
	}
	public void setMentions(String mentions) {
		this.mentions = mentions;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public LocalDate getEstimatedDateOfCompletion() {
		return estimatedDateOfCompletion;
	}
	public void setEstimatedDateOfCompletion(LocalDate estimatedDateOfCompletion) {
		this.estimatedDateOfCompletion = estimatedDateOfCompletion;
	}
	public LocalDate getActualDateOfCompletion() {
		return actualDateOfCompletion;
	}
	public void setActualDateOfCompletion(LocalDate actualDateOfCompletion) {
		this.actualDateOfCompletion = actualDateOfCompletion;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", text=" + text + ", date=" + date
				+ ", estimatedDateOfCompletion=" + estimatedDateOfCompletion + ", actualDateOfCompletion="
				+ actualDateOfCompletion + ", Link=" + Link + ", mentions=" + mentions + ", priority=" + priority + "]";
	}
	
	
	
	
}
