package testmain;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import testmain.helpstructures.StructureProvider;

public class JSonFileIOTest {
	// private JSonFileIO jsonWriterToTest;
	// private static LinkedHashMap<String, LinkedHashMap<String, List<String>>>
	// testSeries;
	private static StructureProvider	testStrucProv;

	@BeforeClass
	public static void setUpEnvironment() {
		testStrucProv = new StructureProvider();
		// testSeries = testStrucProv.getSeries();
	}

	@Before
	public void setUp() {
		// jsonWriterToTest = new JSonFileIO();
	}

	@Test
	public void testJSon() {
		// jsonWriterToTest.writeToJSon(testSeries);
	}
}
