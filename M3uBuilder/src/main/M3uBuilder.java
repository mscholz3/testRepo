package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class M3uBuilder extends Object{
	Map<String, Map<String, Set<String>>> series = new HashMap<>();

	public M3uBuilder(Map<String, Map<String, Set<String>>> series) {
		this.series = series;
	}

	public Set<String> getSeries() {
		if (series.isEmpty())
			return null;

		return series.keySet();
	}

	public Set<String> getSeasons(final String serie) {
		if (series.isEmpty())
			return null;

		if (!series.containsKey(serie))
			return null;

		Map<String, Set<String>> seasons = series.get(serie);
		return seasons.keySet();
	}

	public Set<String> getEpisodes(String serie, String season) {
		
		return null;
	}
}
