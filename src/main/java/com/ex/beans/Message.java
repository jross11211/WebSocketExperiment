package com.ex.beans;

//This is a test

public class Message {
	 
    private String from;
    private String text;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Message [from=" + from + ", text=" + text + "]";
	}
}