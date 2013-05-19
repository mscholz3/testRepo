package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M3uBuilderMain {
	private static Map<String, Map<String, Set<String>>>	testSeries;

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		new M3uBuilderMain();
		System.out.println(new M3uBuilder(testSeries).getSeries().toString());
	}

	public M3uBuilderMain() {
		final Set<String> testEpisodes = new HashSet<>();
		testEpisodes.add("Episode 1");
		testEpisodes.add("Episode 2");
		testEpisodes.add("Episode 3");
		testEpisodes.add("Episode 4");
		testEpisodes.add("Episode 5");

		final Map<String, Set<String>> testSeasons = new HashMap<>();
		testSeasons.put("Season 1", testEpisodes);
		testSeasons.put("Season 2", testEpisodes);
		testSeasons.put("Season 3", testEpisodes);

		testSeries = new HashMap<>();
		testSeries.put("Better Off Ted", testSeasons);
		testSeries.put("Breaking Bad", testSeasons);
		testSeries.put("Castle", testSeasons);
		testSeries.put("Firefly", testSeasons);
		testSeries.put("Futurama", testSeasons);
	}
}
