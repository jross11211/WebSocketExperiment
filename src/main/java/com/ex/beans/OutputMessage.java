package com.ex.beans;

public class OutputMessage {
	
	String from;
	String to;
	String time;
	//String serverMessage = "Hello Client!";
	
	public OutputMessage(String from, String to, String time) {
		super();
		this.from = from;
		this.to = to;
		this.time = time;
	}

	@Override
	public String toString() {
		return "OutputMessage [from=" + from + ", to=" + to + ", time=" + time + "]";
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
