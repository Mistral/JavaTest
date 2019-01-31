package com.example.fluentApi;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class ShowManagerTest {

	private Show firstShow;

	private Show secondShow;

	private Show thirdShow;

	private Show fourthShow;

	private Venue venue;

	private ShowManager showManager;

	@Before
	public void setUp() {
		showManager = new ShowManager();

		firstShow = Show.create("exampleShow #1", Arrays.asList(
				Event.create(LocalDateTime.of(2019, 1, 31, 8, 30)),
				Event.create(LocalDateTime.of(2019, 1, 31, 8, 45)),
				Event.create(LocalDateTime.of(2019, 1, 31, 8, 50)),
				Event.create(LocalDateTime.of(2019, 1, 17, 8, 30))
		));

		secondShow = Show.create("exampleShow #2", Arrays.asList(
				Event.create(LocalDateTime.of(2019, 1, 31, 9, 30)),
				Event.create(LocalDateTime.of(2019, 1, 31, 8, 45)),
				Event.create(LocalDateTime.of(2019, 1, 28, 8, 30)),
				Event.create(LocalDateTime.of(2019, 1, 17, 8, 30))
		));

		thirdShow = Show.create("exampleShow #3", Arrays.asList(
				Event.create(LocalDateTime.of(2019, 1, 19, 9, 30)),
				Event.create(LocalDateTime.of(2019, 1, 18, 8, 45)),
				Event.create(LocalDateTime.of(2019, 1, 28, 8, 30)),
				Event.create(LocalDateTime.of(2019, 1, 17, 8, 30))
		));

		fourthShow = Show.create("exampleShow #4", Collections.emptyList());

		venue = Venue.create("Example Venue", "World", Arrays.asList(
				firstShow,
				secondShow,
				thirdShow,
				fourthShow
		));
	}

	@Test
	public void shouldReturnListShowsWithEventsInGivenDate() {

		Optional<List<Show>> showList = showManager.getShows(venue, LocalDate.of(2019, 1, 31).atStartOfDay());

		assertTrue(showList.isPresent());
		// two shows with any events in this date
		assertEquals(2, showList.get().size());
		// five events in this date
		assertEquals(5, (int) showList.get()
									  .stream()
									  .map(show -> show.getEvents().size())
									  .reduce(Integer::sum)
									  .get());
	}

	@Test
	public void shouldReturnEmptyShowListInGivenDate() {
		Optional<List<Show>> showList = showManager.getShows(venue, LocalDate.of(2020, 1, 1).atStartOfDay());

		assertFalse(showList.isPresent());
	}

}