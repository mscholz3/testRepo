package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class M3uBuilderMainWindow {
	/**
	 * initializes a new Display and a new Shell
	 */
	public M3uBuilderMainWindow() {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new GridLayout(1, true));
		shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		new M3uComposite(shell, SWT.NONE).setLayoutData(new GridData(SWT.FILL,
			SWT.FILL, true, true, 1, 1));
		shell.pack();
		shell.open();
		// Create and check the event loop
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
