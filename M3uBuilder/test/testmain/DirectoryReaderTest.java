package testmain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.DirectoryReader;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class DirectoryReaderTest {
	private DirectoryReader	dirReaderToTest;

	@Before
	public void setUp() {
		dirReaderToTest = new DirectoryReader();
	}

	@Test
	public void testCheckMainDirectory() throws Exception {
		boolean result;

		// Needed to check private method:
		final Method methodCheckMainDirectory = dirReaderToTest.getClass()
			.getDeclaredMethod("checkMainDirectory", String.class);

		// Make accessible to invoke from the outside
		methodCheckMainDirectory.setAccessible(true);

		// execute method
		result = (boolean) methodCheckMainDirectory.invoke(dirReaderToTest,
			"D:\\Ordner");

		assertTrue("D:\\Ordner should be a valid input", result);

		/*
		 * Following String values should return false results. At least on
		 * windows, if it gets rewritten for linux this test should be changed.
		 */
		final String stringsToTest[] = { "DD:\\Ordner", "Ordner", "D:Ordner",
			"D\\Ordner", "D:/Ordner" };
		for (final String stringToTest : stringsToTest) {

			result = (boolean) methodCheckMainDirectory.invoke(dirReaderToTest,
				stringToTest);

			assertFalse(String.format("Testing: \"%s\" should have failed",
				stringToTest), result);
		}

	}
}
