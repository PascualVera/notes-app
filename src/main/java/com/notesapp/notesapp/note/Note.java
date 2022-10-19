package com.notesapp.notesapp.note;

import java.time.LocalDate;

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
	
	private long id;
	private String title;
	private String text;
	private LocalDate date;
	private LocalDate dateOfCompletion;
	private String Link;
	private String mentions;
	private String priority;
	
	
	public Note(long id, String title, String text, LocalDate date, LocalDate dateOfCompletion, String link,
			String mentions, String priority) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.date = date;
		this.dateOfCompletion = dateOfCompletion;
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
	public LocalDate getDateOfCompletion() {
		return dateOfCompletion;
	}
	public void setDateOfCompletion(LocalDate dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
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
	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", text=" + text + ", date=" + date + ", dateOfCompletion="
				+ dateOfCompletion + ", Link=" + Link + ", mentions=" + mentions + ", priority=" + priority + "]";
	}
	
	
}
