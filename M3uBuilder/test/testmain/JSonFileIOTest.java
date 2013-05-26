package testmain;

import io.JSonFileIO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class JSonFileIOTest {
	private JSonFileIO													jsonWriterToTest;
	private LinkedHashMap<String, LinkedHashMap<String, List<String>>>	testSeries;

	@Before
	public void setUp() {
		jsonWriterToTest = new JSonFileIO();
		final List<String> testEpisodes = new ArrayList<String>();
		{
			testEpisodes.add("Episode 1");
			testEpisodes.add("Episode 2");
			testEpisodes.add("Episode 3");
			testEpisodes.add("Episode 4");
			testEpisodes.add("Episode 5");
		}

		final LinkedHashMap<String, List<String>> testSeasons = new LinkedHashMap<String, List<String>>();
		{
			testSeasons.put("Season 1", testEpisodes);
			testSeasons.put("Season 2", testEpisodes);
			testSeasons.put("Season 3", testEpisodes);
		}

		testSeries = new LinkedHashMap<String, LinkedHashMap<String, List<String>>>();
		testSeries.put("Better Off Ted", testSeasons);
		testSeries.put("Breaking Bad", testSeasons);
		testSeries.put("Castle", testSeasons);
		testSeries.put("Firefly", testSeasons);
		testSeries.put("Futurama", testSeasons);

	}

	@Test
	public void testWriteMapToJSon() {
		jsonWriterToTest.writeMapToJSon(testSeries);

	}
}
