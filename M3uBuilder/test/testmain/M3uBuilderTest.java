package testmain;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import main.M3uBuilder;

import org.junit.Before;
import org.junit.Test;

public class M3uBuilderTest {
	private M3uBuilder								m3uToTest;
	private Set<String>								testEpisodes;
	private Map<String, Set<String>>				testSeasons;
	private Map<String, Map<String, Set<String>>>	testSeries;

	@Before
	public void setUp() {
		testEpisodes = new HashSet<>();
		{
			testEpisodes.add("Episode 1");
			testEpisodes.add("Episode 2");
			testEpisodes.add("Episode 3");
			testEpisodes.add("Episode 4");
			testEpisodes.add("Episode 5");
		}

		testSeasons = new HashMap<>();
		{
			testSeasons.put("Season 1", testEpisodes);
			testSeasons.put("Season 2", testEpisodes);
			testSeasons.put("Season 3", testEpisodes);
		}

		testSeries = new HashMap<>();
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
	public void getSeriesTest() {
		final Set<String> seriesTest = m3uToTest.getSeries();
		assertEquals("Keysets of the series should be the same",
			testSeries.keySet(), seriesTest);
	}

	@Test
	public void getSeasonsTest() {
		final Set<String> seasonsTest = m3uToTest.getSeasons("Firefly");
		assertEquals("Keysets of the seasons should be the same",
			testSeasons.keySet(), seasonsTest);
	}

	@Test
	public void getEpisodesTest() {
		final Set<String> episodesTest = m3uToTest.getEpisodes("Firefly",
			"Season 1");
		assertEquals("Sets of the episodes should be the same", testEpisodes,
			episodesTest);
	}
}
