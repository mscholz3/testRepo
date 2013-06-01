package testmain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import main.M3uBuilder;

import org.junit.BeforeClass;
import org.junit.Test;

import testmain.helpstructures.StructureProvider;


public class M3uBuilderTest {
	private static M3uBuilder													m3uToTest;
	private static List<String>													testEpisodes;
	private static LinkedHashMap<String, List<String>>							testSeasons;
	private static LinkedHashMap<String, LinkedHashMap<String, List<String>>>	testSeries;
	private static StructureProvider										testStrucProv;

	@BeforeClass
	public static void setUpEnvironment() {
		testStrucProv = new StructureProvider();
		testEpisodes = testStrucProv.getEpisodes();
		testSeasons = testStrucProv.getSeasons();
		testSeries = testStrucProv.getSeries();

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
