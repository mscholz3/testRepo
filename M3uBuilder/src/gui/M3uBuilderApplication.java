package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class M3uBuilderApplication {

	private JFrame		frame;
	private JTable		table;
	private JTabbedPane	tabbedPane;
	private JTable		table_1;
	private JTable		table_2;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					final M3uBuilderApplication window = new M3uBuilderApplication();
					window.frame.setVisible(true);
				}
				catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public M3uBuilderApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		final JTree tree = new JTree();
		tree.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Series") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					node_1 = new DefaultMutableTreeNode("Castle");
					node_2 = new DefaultMutableTreeNode("Seasons");
					node_3 = new DefaultMutableTreeNode("Season 01");
					node_3.add(new DefaultMutableTreeNode("episode 1"));
					node_3.add(new DefaultMutableTreeNode("episode 2"));
					node_2.add(node_3);
					node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Fringe");
					node_2 = new DefaultMutableTreeNode("Seasons");
					node_3 = new DefaultMutableTreeNode("Season 01");
					node_3.add(new DefaultMutableTreeNode("episode 1"));
					node_3.add(new DefaultMutableTreeNode("episode 2"));
					node_2.add(node_3);
					node_3 = new DefaultMutableTreeNode("Season 02");
					node_3.add(new DefaultMutableTreeNode("episode 1"));
					node_2.add(node_3);
					node_1.add(node_2);
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Mac Gyver");
					node_2 = new DefaultMutableTreeNode("Seasons");
					node_3 = new DefaultMutableTreeNode("Season 01");
					node_3.add(new DefaultMutableTreeNode("episode 1"));
					node_3.add(new DefaultMutableTreeNode("episode 2"));
					node_2.add(node_3);
					node_3 = new DefaultMutableTreeNode("Season 02");
					node_3.add(new DefaultMutableTreeNode("episode 1"));
					node_2.add(node_3);
					node_1.add(node_2);
					add(node_1);
				}
			}));
		frame.getContentPane().add(tree);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);

		table = new JTable();
		tabbedPane.addTab("Series", null, table, null);
		table.setColumnSelectionAllowed(true);
		table.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] { { "Castle" },
			{ "Fringe" }, { "Mac Gyver" }, { null }, { null }, { null },
			{ null }, { null }, }, new String[] { "Episodes" }));

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {
			{ "Season 01" }, { "Season 02" }, { null }, },
			new String[] { "Seasons" }));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_1.getColumnModel().getColumn(0).setMinWidth(75);
		table_1
			.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_1.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		table_1.setColumnSelectionAllowed(true);
		tabbedPane.addTab("Seasons", null, table_1, null);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] {
			{ "Episode 01" }, { "Episode 02" }, { null }, },
			new String[] { "Seasons" }));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(150);
		table_2.getColumnModel().getColumn(0).setMinWidth(75);
		table_2
			.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_2.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		table_2.setColumnSelectionAllowed(true);
		tabbedPane.addTab("Episodes", null, table_2, null);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(0).setMinWidth(50);
	}

}
