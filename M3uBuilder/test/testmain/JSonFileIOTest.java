package testmain;

import io.JSonFileIO;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import testmain.helpstructures.TestStructureProvider;

public class JSonFileIOTest {
	private JSonFileIO															jsonWriterToTest;
	private static LinkedHashMap<String, LinkedHashMap<String, List<String>>>	testSeries;
	private static TestStructureProvider										testStrucProv;

	@BeforeClass
	public static void setUpEnvironment() {
		testStrucProv = new TestStructureProvider();
		testSeries = testStrucProv.getSeries();
	}

	@Before
	public void setUp() {
		jsonWriterToTest = new JSonFileIO();
	}

	@Test
	public void testJSon() {
		jsonWriterToTest.writeToJSon(testSeries);
	}
}
