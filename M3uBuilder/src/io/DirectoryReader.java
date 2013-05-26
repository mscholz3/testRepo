package io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads the directory of a given path recursively and makes it available for
 * other classes.
 * 
 * @author Micha
 */
public class DirectoryReader {
	private File				mainDir;
	private final List<String>	folderList;

	/**
	 * Constructor which sets the mainDirectory when he is initializing.
	 * 
	 * @param mainDirectory
	 *            the main directory where the recursive search starts.
	 */
	public DirectoryReader(final String mainDirectory) {
		if (checkMainDirectory(mainDirectory)) {
			mainDir = new File(mainDirectory);
		}
		folderList = new ArrayList<String>();
	}

	/**
	 * Checks if the inputed String has the right format. TODO: should check if
	 * it runs on Linux or windows. shouldn't check for syntax, should get
	 * syntax with input dialog.
	 */
	private boolean checkMainDirectory(final String mainDirectory) {
		if (mainDirectory == null || mainDirectory.equals("")) {
			return false;
		}

		return true;
	}

	/**
	 * Lists all Folders which contain at least one file. From the main
	 * directory the class has been initiated with.
	 * 
	 * @see #DirectoryReader(String mainDirectory)
	 */
	public void listFoldersRecursive() {
		folderList.clear();
		listFoldersRecursive(mainDir.listFiles());
		System.out.println(folderList.toString());
	}

	/**
	 * Lists beginning from a given folder structure, all sub folders, if they
	 * contain files.
	 * 
	 * @param fileList
	 * @see #listFoldersRecursive()
	 * @see #hasFiles(File)
	 */
	private void listFoldersRecursive(final File[] fileList) {
		File[] tempFiles;
		String path;
		for (final File file : fileList) {
			if (!file.isHidden() && file.isDirectory()) {
				try {
					path = file.getCanonicalPath();
					if (hasFiles(file)) {
						folderList.add(path);
					}
				}
				catch (final IOException e) {
					throw new RuntimeException(e);
				}
				tempFiles = new File(path).listFiles();
				listFoldersRecursive(tempFiles);
			}
		}
	}

	/**
	 * Tests if {link File} has files.
	 * <p>
	 * Return false if {link File} is a file.
	 * 
	 * @param file
	 * @return true if directory has files.
	 */
	private boolean hasFiles(final File file) {
		if (file.isFile()) {
			return false;
		}

		assert file.isDirectory() : "The File should be a directory";

		final File tempFile;

		try {
			tempFile = new File(file.getCanonicalPath());
		}
		catch (final IOException e) {
			throw new RuntimeException(e);
		}

		for (final File loopFile : tempFile.listFiles()) {
			if (loopFile.isFile()) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		final String returnString = String.format("%s", mainDir.toString());
		return returnString;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj.equals(this)) {
			return false;
		}

		if (!(obj instanceof DirectoryReader)) {
			return false;
		}

		final DirectoryReader dirReader = (DirectoryReader) obj;

		if (!dirReader.mainDir.equals(mainDir)) {
			return false;
		}

		return true;
	}
}
