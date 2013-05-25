package gui;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class M3uComposite extends Composite {
	public M3uComposite(final Shell parent, final int style) {
		super(parent, SWT.NONE);
		setLayout(new GridLayout(2, true));

		new Label(parent, SWT.NONE);

		final Composite compTable = new Composite(parent, SWT.NONE);
		final TableColumnLayout tblClmnLayout = new TableColumnLayout();
		compTable.setLayout(tblClmnLayout);

		final Table table = new Table(compTable, SWT.NONE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn tblColumnSerien = new TableColumn(table, SWT.NONE);
		tblColumnSerien.setText("Serien");
		final TableColumn tblColumnSeason = new TableColumn(table, SWT.NONE);
		tblColumnSeason.setText("Season");
		final TableColumn tblColumnEpisode = new TableColumn(table, SWT.NONE);
		tblColumnEpisode.setText("Episode");

		tblClmnLayout.setColumnData(tblColumnSerien, new ColumnWeightData(33));
		tblClmnLayout.setColumnData(tblColumnSeason, new ColumnWeightData(33));
		tblClmnLayout.setColumnData(tblColumnEpisode, new ColumnWeightData(33));
	}
}
