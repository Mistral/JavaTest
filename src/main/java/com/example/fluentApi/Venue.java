package com.example.fluentApi;

import java.util.List;

class Venue {

	private String venueName;

	private String city;

	private List<Show> shows; // repertuar

	static Venue create(String name, String city, List<Show> shows) {
		return new Venue(name, city, shows);
	}

	private Venue(String venueName, String city, List<Show> shows) {
		this.venueName = venueName;
		this.city = city;
		this.shows = shows;
	}

	public List<Show> getShows() {
		return shows;
	}

}
