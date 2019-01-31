package com.example.fluentApi;

import java.time.LocalDateTime;

class Event {

	private final LocalDateTime dateTime;

	static Event create(LocalDateTime dateTime) {
		return new Event(dateTime);
	}

	private Event(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	LocalDateTime getDateTime() {
		return dateTime;
	}

	boolean isInTheSameDay(LocalDateTime dateTime) {
		return dateTime.toLocalDate().isEqual(this.dateTime.toLocalDate());
	}

}
