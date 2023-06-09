/**
 * 
 */
package dawg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author jammavi
 *
 */
public class Records extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList<String> contestsList;
	private ArrayList<String> Acontests = new ArrayList<String>();
	private int year = 2023;
	
	private ControllingFrame controller;

	public Records() {
		
		controller = ControllingFrame.getInstance();
		addComponents();
	}
	
	public ArrayList<String> getArray(){
		return Acontests;
		
	}
	
	public void clearField() {
		contestsList.clearSelection();
	}
	
	

	private class RecordsViewListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				String selected = contestsList.getSelectedValue();
				ControllingFrame.setSelectedContest(selected);
			}
		}

	}

	private void addComponents() {
		BorderLayout layout = new BorderLayout();
		setLayout(layout);
		// Create a label for the title
		JLabel titleLabel = new JLabel("Previous Contests");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// Create a list of previous contests

		Acontests.add("Current Contest");

		String[] contests = Acontests.toArray(new String[Acontests.size()]);
		
		contestsList = new JList<>(contests);
		contestsList.addListSelectionListener(new RecordsViewListener());
		contestsList.setFont(new Font("Arial", Font.PLAIN, 16));
		contestsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane listScrollPane = new JScrollPane(contestsList);
		
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		
		JButton button = new JButton("New Contest");
		button.addActionListener(controller);
		button.setActionCommand("New");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//contest.addContest(contestField.getText());
				
				
				
			}
		});
		
		
		
		bottomPanel.add(button);
		add(bottomPanel, BorderLayout.SOUTH);
		add(titleLabel, BorderLayout.NORTH);
		add(listScrollPane, BorderLayout.CENTER);
		
		add(titleLabel, BorderLayout.NORTH);
		add(listScrollPane, BorderLayout.CENTER);

	}
	
	public void addContest() {
		int size = Acontests.size();
		Acontests.set(size-1, Integer.toString(year));
		Acontests.add("Current Contest");
		String[] newcontests = Acontests.toArray(new String[Acontests.size()]);
		contestsList.setListData(newcontests);
		year++;
	}
}