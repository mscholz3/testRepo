package main;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class M3uBuilder extends Object {
	LinkedHashMap<String, LinkedHashMap<String, List<String>>>	series	= new LinkedHashMap<>();

	public M3uBuilder(
		final LinkedHashMap<String, LinkedHashMap<String, List<String>>> series) {
		this.series = series;
	}

	public Set<String> getSeries() {
		if (series == null || series.isEmpty()) {
			return null;
		}

		return series.keySet();
	}

	public Set<String> getSeasons(final String serie) {
		if (series == null || series.isEmpty()) {
			return null;
		}

		if (!series.containsKey(serie)) {
			return null;
		}

		final LinkedHashMap<String, List<String>> seasons = series.get(serie);
		return seasons.keySet();
	}

	public List<String> getEpisodes(final String serie, final String season) {
		if (series == null || series.isEmpty()) {
			return null;
		}

		if (!series.containsKey(serie)) {
			return null;
		}

		final LinkedHashMap<String, List<String>> seasonsTemp = series
			.get(serie);

		if (seasonsTemp.isEmpty()) {
			return null;
		}

		if (!seasonsTemp.containsKey(season)) {
			return null;
		}

		return seasonsTemp.get(season);
	}
}
