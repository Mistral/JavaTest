package com.example.fluentApi;

import java.util.List;

class Show {

	private String showName;

	private List<Event> events; // lista konkretnych wydarzeń danego tytułu

	static Show create(String showName, List<Event> events) {
		return new Show(showName, events);
	}

	private Show(String showName, List<Event> events) {
		this.showName = showName;
		this.events = events;
	}

	String getShowName() {
		return showName;
	}

	List<Event> getEvents() {
		return events;
	}

}
