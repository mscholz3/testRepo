package testmain.helpstructures;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class StructureProvider {
	private final List<String>													testEpisodesList;
	private final List<String>													testSeasonsList;
	private final List<String>													testSeriesList;
	private final LinkedHashMap<String, List<String>>							testSeriesFolderList;
	private final LinkedHashMap<String, List<String>>							testSeasons;
	private final LinkedHashMap<String, LinkedHashMap<String, List<String>>>	testSeries;
	private final Set<String>													testVideoFormats;
	private final Set<String>													testMusicFormats;
	private final Random														rand;
	private final static String													testDirName	= "TestDir";

	public static String getTestDirName() {
		return testDirName;
	}

	public StructureProvider() {
		rand = new Random();

		testEpisodesList = new ArrayList<>();
		{
			testEpisodesList.add("Episode 1");
			testEpisodesList.add("Episode 2");
			testEpisodesList.add("Episode 3");
			testEpisodesList.add("Episode 4");
			testEpisodesList.add("Episode 5");
		}

		testSeasonsList = new ArrayList<>();
		{
			testSeasonsList.add("Season 1");
			testSeasonsList.add("Season 2");
			testSeasonsList.add("Season 3");
		}

		testSeriesList = new ArrayList<>();
		{
			testSeriesList.add("Better Off Ted");
			testSeriesList.add("Breaking Bad");
			testSeriesList.add("Castle");
			testSeriesList.add("Firefly");
			testSeriesList.add("Futurama");
		}

		testSeriesFolderList = new LinkedHashMap<>();
		{
			for (final String series : testSeriesList) {
				testSeriesFolderList.put(series, testSeasonsList);
			}
		}

		testSeasons = new LinkedHashMap<>();
		{
			testSeasons.put("Season 1", testEpisodesList);
			testSeasons.put("Season 2", testEpisodesList);
			testSeasons.put("Season 3", testEpisodesList);
		}

		testSeries = new LinkedHashMap<>();
		{
			testSeries.put("Better Off Ted", testSeasons);
			testSeries.put("Breaking Bad", testSeasons);
			testSeries.put("Castle", testSeasons);
			testSeries.put("Firefly", testSeasons);
			testSeries.put("Futurama", testSeasons);
		}

		testVideoFormats = new HashSet<>();
		{
			testVideoFormats.add("mkv");
			testVideoFormats.add("avi");
			testVideoFormats.add("divx");
			testVideoFormats.add("flv");
			testVideoFormats.add("mp4");
			testVideoFormats.add("mpg");
		}

		testMusicFormats = new HashSet<>();
		{
			testMusicFormats.add("mp3");
			testMusicFormats.add("flac");
			testMusicFormats.add("ogg");
		}
	}

	public Set<String> getVideoFormats() {
		return testVideoFormats;
	}

	public Set<String> getMusicFormats() {
		return testMusicFormats;
	}

	public List<String> getEpisodes() {
		return testEpisodesList;
	}

	public List<String> getVideoEpisodes() {
		final String formatStr[] = new String[testVideoFormats.size()];
		final List<String> testVideoEpisodesList = new ArrayList<>();
		int i = 0;
		for (final String format : testVideoFormats) {
			formatStr[i++] = format;
		}
		for (final String episode : testEpisodesList) {
			testVideoEpisodesList.add(episode.concat(String.format("%s%s", ".",
				formatStr[rand.nextInt(testVideoFormats.size())])));
		}
		return testVideoEpisodesList;
	}

	public LinkedHashMap<String, List<String>> getSeasons() {
		return testSeasons;
	}

	public LinkedHashMap<String, LinkedHashMap<String, List<String>>> getSeries() {
		return testSeries;
	}

	public LinkedHashMap<String, List<String>> getSeriesFolderStructure() {
		return testSeriesFolderList;
	}

	public void makeFolderStructure() {
		final StructureProvider testStrucProv = new StructureProvider();
		final String pathSeparator = System.getProperty("file.separator");

		/* create own file structure to test */
		new File(testDirName).mkdir();
		for (final Entry<String, List<String>> entry : testStrucProv
			.getSeriesFolderStructure().entrySet()) {
			final String seriesFolder = String.format("%s%s%s", testDirName,
				pathSeparator, entry.getKey());
			new File(seriesFolder).mkdir();
			for (final String season : entry.getValue()) {
				final String seasonFolder = String.format("%s%s%s",
					seriesFolder, pathSeparator, season);
				new File(seasonFolder).mkdir();
			}
		}
	}

	public void makeVideoFolderStructure() {
		final StructureProvider testStrucProv = new StructureProvider();
		final String pathSeparator = System.getProperty("file.separator");
		FileWriter fileWriter;

		/* create own file structure to test */
		new File(testDirName).mkdir();
		for (final Entry<String, List<String>> entry : testStrucProv
			.getSeriesFolderStructure().entrySet()) {
			final String seriesFolder = String.format("%s%s%s", testDirName,
				pathSeparator, entry.getKey());
			new File(seriesFolder).mkdir();
			for (final String season : entry.getValue()) {
				final String seasonFolder = String.format("%s%s%s",
					seriesFolder, pathSeparator, season);
				new File(seasonFolder).mkdir();
				for (final String episode : getVideoEpisodes()) {
					final String episodeName = String.format("%s%s%s",
						seasonFolder, pathSeparator, episode);
					try {
						fileWriter = new FileWriter(episodeName);
						fileWriter.write("");
						fileWriter.close();
						System.out.println("Write: " + episodeName);
					}
					catch (final IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
	}

	/**
	 * Deletes the Folder and all sub folders and files;
	 */
	public void deleteTestFolder() {
		deleteStructure(new File(testDirName));
	}

	// probably deleteOnExit when making the structure is a better idea
	// but I have to test if files get deleted to
	private void deleteStructure(final File file) {
		if (file.isDirectory()) {
			while (file.listFiles().length > 0) {
				deleteStructure(file.listFiles()[0]);
			}
		}
		file.delete();
		System.out.println("Deleted: " + file.getPath());
	}
}
