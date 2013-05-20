package io;

/**
 * Reads the directory of a given path recursively and makes it available for
 * other classes.
 * 
 * @author Micha
 */
public class DirectoryReader {
	private String	mainDirectory;

	/**
	 * Empty constructor.
	 */
	public DirectoryReader() {}

	/**
	 * Constructor which sets the mainDirectory when he is initializing.
	 * 
	 * @param mainDirectory
	 *            the main directory where the recursive search starts.
	 */
	public DirectoryReader(final String mainDirectory) {
		setMainDirectory(mainDirectory);
	}

	/**
	 * Returns the main directory.
	 * 
	 * @return the main directory
	 */
	public String mainDirectory() {
		return mainDirectory;
	}

	/**
	 * Sets the main directory.
	 * 
	 * @param mainDirectory
	 */
	public void setMainDirectory(final String mainDirectory) {
		if (checkMainDirectory(mainDirectory)) {
			this.mainDirectory = mainDirectory;
		}
	}

	/**
	 * Checks if the inputed String has the right format. TODO: should check if
	 * it runs on unix or windows.
	 */
	private boolean checkMainDirectory(final String mainDirectory) {
		if (mainDirectory == null || mainDirectory.equals("")) {
			return false;
		}

		if (!mainDirectory.matches("^\\w:\\\\.*$")) {
			return false;
		}

		return true;
	}
}
