package testmain;

import io.JSonFileIO;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import testmain.helpstructures.StructureProvider;

public class JSonFileIOTest {
	private JSonFileIO															jsonWriterToTest;
	private static LinkedHashMap<String, LinkedHashMap<String, List<String>>>	testSeries;
	private static StructureProvider											testStrucProv;

	@BeforeClass
	public static void setUpEnvironment() {
		testStrucProv = new StructureProvider();
		testSeries = testStrucProv.getSeries();
	}

	@Test
	public void testJSon() {
		jsonWriterToTest = new JSonFileIO();
		jsonWriterToTest.writeToJSon(testSeries);
	}
}
