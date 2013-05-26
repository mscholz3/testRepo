package testmain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static testmain.helpstructures.TestStructureProvider.getTestDirName;
import io.DirectoryReader;

import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import testmain.helpstructures.TestStructureProvider;

public class DirectoryReaderTest {
	private static TestStructureProvider	testStruc;

	@BeforeClass
	public static void setUpEnvironment() {
		testStruc = new TestStructureProvider();
		testStruc.makeVideoFolderStructure();
	}

	@AfterClass
	public static void cleanUpEnvironment() {
		new TestStructureProvider().deleteTestFolder();
	}

	@Test
	public void testCheckMainDirectory() throws Exception {
		boolean result;

		final DirectoryReader dirReaderToTest = new DirectoryReader(null);
		// Needed to check private method:
		final Method methodCheckMainDirectory = dirReaderToTest.getClass()
			.getDeclaredMethod("checkMainDirectory", String.class);

		// Make accessible to invoke from the outside
		methodCheckMainDirectory.setAccessible(true);

		// execute method
		result = (boolean) methodCheckMainDirectory.invoke(dirReaderToTest,
			"D:\\Ordner");
		assertTrue("D:\\Ordner should be a valid input", result);

		result = (boolean) methodCheckMainDirectory.invoke(dirReaderToTest,
			(Object) null);
		assertFalse("null should not be a valid input", result);

		result = (boolean) methodCheckMainDirectory.invoke(dirReaderToTest, "");
		assertFalse("\"\" should not be a valid input", result);

		// // Following String values should return false results. At least on
		// // windows, if it gets rewritten for linux this test should be
		// changed.
		// final String stringsToTest[] = { "DD:\\Ordner", "Ordner", "D:Ordner",
		// "D\\Ordner", "D:/Ordner" };
		// for (final String stringToTest : stringsToTest) {
		//
		// result = (boolean) methodCheckMainDirectory.invoke(dirReaderToTest,
		// stringToTest);
		//
		// assertFalse(String.format("Testing: \"%s\" should have failed",
		// stringToTest), result);
		// }
	}

	@Test
	public void testListFoldersRecursive() {
		final DirectoryReader dirReaderToTest;
		// TODO: should create own testing folder structure
		// test should work on Windows and Linux
		if (System.getProperty("os.name").matches("^Windows\\s.*$")) {
			dirReaderToTest = new DirectoryReader(getTestDirName());
		}
		else {
			dirReaderToTest = new DirectoryReader(getTestDirName());
		}
		dirReaderToTest.listFoldersRecursive();
	}
}
