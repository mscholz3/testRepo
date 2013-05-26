package testmain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import main.M3uBuilder;

import org.junit.Before;
import org.junit.Test;

public class M3uBuilderTest {
	private M3uBuilder													m3uToTest;
	private List<String>												testEpisodes;
	private LinkedHashMap<String, List<String>>							testSeasons;
	private LinkedHashMap<String, LinkedHashMap<String, List<String>>>	testSeries;

	@Before
	public void setUp() {
		testEpisodes = new ArrayList<>();
		{
			testEpisodes.add("Episode 1");
			testEpisodes.add("Episode 2");
			testEpisodes.add("Episode 3");
			testEpisodes.add("Episode 4");
			testEpisodes.add("Episode 5");
		}

		testSeasons = new LinkedHashMap<>();
		{
			testSeasons.put("Season 1", testEpisodes);
			testSeasons.put("Season 2", testEpisodes);
			testSeasons.put("Season 3", testEpisodes);
		}

		testSeries = new LinkedHashMap<>();
		{
			testSeries.put("Better Off Ted", testSeasons);
			testSeries.put("Breaking Bad", testSeasons);
			testSeries.put("Castle", testSeasons);
			testSeries.put("Firefly", testSeasons);
			testSeries.put("Futurama", testSeasons);
		}

		m3uToTest = new M3uBuilder(testSeries);
	}

	@Test
	public void testGetSeries() {
		assertNull(new M3uBuilder(null).getSeries());
		assertNull(new M3uBuilder(
			new LinkedHashMap<String, LinkedHashMap<String, List<String>>>())
			.getSeries());
		final Set<String> seriesTest = m3uToTest.getSeries();
		assertEquals("Keysets of the series should be the same",
			testSeries.keySet(), seriesTest);
	}

	@Test
	public void testGetSeasons() {
		final Set<String> seasonsTest = m3uToTest.getSeasons("Firefly");
		assertEquals("Keysets of the seasons should be the same",
			testSeasons.keySet(), seasonsTest);
	}

	@Test
	public void testGetEpisodes() {
		final List<String> episodesTest = m3uToTest.getEpisodes("Firefly",
			"Season 1");
		assertEquals("Sets of the episodes should be the same", testEpisodes,
			episodesTest);
	}
}
