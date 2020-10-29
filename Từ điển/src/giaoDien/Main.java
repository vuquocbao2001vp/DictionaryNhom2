package giaoDien;

import static translate.Google.translate;
import Dictionary.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import static audio.Speek.speek;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.DropMode;

@SuppressWarnings("serial")
public class Main extends JFrame {
	private String[] data;
	
	static {
		try {
			DictionaryManagement.insertFromFile();
		}
		catch (Exception e) {
			 System.out.print(e.getMessage());
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setSize(600, 500);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {150, 450};
		gridBagLayout.rowHeights = new int[] {50, 450};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {50, 400, 150};
		gbl_panel_1.rowHeights = new int[] {150};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0};
		panel_1.setLayout(gbl_panel_1);
		
		JTextField txtSearch = new JTextField();
		txtSearch.setEditable(false);
		txtSearch.setBackground(Color.WHITE);
		txtSearch.setText("Từ: ");
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.ipady = 10;
		gbc_txtSearch.insets = new Insets(0, 5, 0, 5);
		gbc_txtSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch.gridx = 0;
		gbc_txtSearch.gridy = 0;
		panel_1.add(txtSearch, gbc_txtSearch);
		txtSearch.setColumns(11);
		
		JTextArea engBox = new JTextArea();
		engBox.setWrapStyleWord(true);
		JScrollPane scrollEngBox = new JScrollPane(engBox);
		GridBagConstraints gbc_scrollEngBox = new GridBagConstraints();
		gbc_scrollEngBox.ipady = 20;
		gbc_scrollEngBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollEngBox.gridx = 1;
		gbc_scrollEngBox.gridy = 0;
		panel_1.add(scrollEngBox, gbc_scrollEngBox);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1.gridx = 2;
		gbc_panel_1_1.gridy = 0;
		panel_1.add(panel_1_1, gbc_panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[] {150};
		gbl_panel_1_1.rowHeights = new int[] {25, 25};
		gbl_panel_1_1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_1_1.rowWeights = new double[]{0.0, 0.0};
		panel_1_1.setLayout(gbl_panel_1_1);
		
		JButton transButton = new JButton("Google  dịch");
		transButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_transButton = new GridBagConstraints();
		gbc_transButton.insets = new Insets(0, 0, 5, 0);
		gbc_transButton.gridx = 0;
		gbc_transButton.gridy = 0;
		panel_1_1.add(transButton, gbc_transButton);
		
		JButton speekButton = new JButton("", new ImageIcon(".\\data\\speak.png"));
		speekButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_speekButton = new GridBagConstraints();
		gbc_speekButton.insets = new Insets(0, 0, 5, 0);
		gbc_speekButton.gridx = 0;
		gbc_speekButton.gridy = 1;
		panel_1_1.add(speekButton, gbc_speekButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		getContentPane().add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(1, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		JList<String> recomend = new JList<String>();
		recomend.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(recomend);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.rowHeights = new int[] {375, 75};
		gbl_panel_3.columnWidths = new int[] {450};
		gbl_panel_3.columnWeights = new double[]{1.0};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0};
		panel_3.setLayout(gbl_panel_3);
		
		JScrollPane scrollVieBox = new JScrollPane();
		GridBagConstraints gbc_scrollVieBox = new GridBagConstraints();
		gbc_scrollVieBox.fill = GridBagConstraints.BOTH;
		gbc_scrollVieBox.gridx = 0;
		gbc_scrollVieBox.gridy = 0;
		panel_3.add(scrollVieBox, gbc_scrollVieBox);
		
		JTextArea vieBox = new JTextArea();
		vieBox.setEditable(false);
		scrollVieBox.setViewportView(vieBox);
		
		JPanel panelButton = new JPanel();
		panelButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelButton = new GridBagConstraints();
		gbc_panelButton.insets = new Insets(0, 0, 1, 0);
		gbc_panelButton.fill = GridBagConstraints.BOTH;
		gbc_panelButton.gridx = 0;
		gbc_panelButton.gridy = 1;
		panel_3.add(panelButton, gbc_panelButton);
		GridBagLayout gbl_panelButton = new GridBagLayout();
		gbl_panelButton.columnWidths = new int[] {150, 100, 100, 100};
		gbl_panelButton.rowHeights = new int[] {30};
		gbl_panelButton.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panelButton.rowWeights = new double[]{0.0};
		panelButton.setLayout(gbl_panelButton);
		
		JButton aButton = new JButton("none");
		aButton.setEnabled(false);
		aButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_aButton = new GridBagConstraints();
		gbc_aButton.insets = new Insets(0, 0, 0, 5);
		gbc_aButton.gridx = 2;
		gbc_aButton.gridy = 0;
		panelButton.add(aButton, gbc_aButton);
		
		JButton deleteButton = new JButton("delete");
		deleteButton.setEnabled(false);
		deleteButton.setBackground(Color.WHITE);
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.gridx = 3;
		gbc_deleteButton.gridy = 0;
		panelButton.add(deleteButton, gbc_deleteButton);
		
//		add Listener
		

		data = DictionaryManagement.dictionarySearcher(new String());
		recomend.setListData(data);
		
		recomend.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				vieBox.setEditable(false);
				aButton.setText("edit");
				engBox.setText(data[recomend.getSelectedIndex()]);
				vieBox.setText(Dictionary.listWord.get(DictionaryManagement.dictionaryLookup(engBox.getText())).getWord_explain());
				vieBox.setCaretPosition(0);
				data = DictionaryManagement.dictionarySearcher(engBox.getText());
				recomend.setListData(data);
				deleteButton.setEnabled(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
		
		speekButton.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				speek(engBox.getText());
			}
			
		});
		
		engBox.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				aButton.setEnabled(!engBox.getText().isEmpty());
				vieBox.setEditable(false);
				data = DictionaryManagement.dictionarySearcher(engBox.getText());
				recomend.setListData(data);
				int pos = DictionaryManagement.dictionaryLookup(engBox.getText());
				if (pos != Dictionary.listWord.size()) {
					vieBox.setText(show(Dictionary.listWord.get(pos)));
					aButton.setText("edit");
					deleteButton.setEnabled(true);
				} else {
					vieBox.setText(new String());
					aButton.setText("new");
					deleteButton.setEnabled(false);
				}
				
				vieBox.setCaretPosition(0);
			}
			
		});
		
		transButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vieBox.setText(translate(engBox.getText()));
				vieBox.setCaretPosition(0);
			}
			
		});
		
		aButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (aButton.getText().equals("save")) {
					int pos = DictionaryManagement.dictionaryLookup(engBox.getText());
					if (pos != Dictionary.listWord.size()) {
						Dictionary.listWord.get(pos).setWord_explain(vieBox.getText());
					} else {
						DictionaryManagement.insert(new Word(engBox.getText(), vieBox.getText()));
					}
					
					try {
						DictionaryManagement.dictionaryExportToFile();
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
					vieBox.setEditable(false);
					aButton.setText("edit");
					deleteButton.setEnabled(true);
					data = DictionaryManagement.dictionarySearcher(engBox.getText());
					recomend.setListData(data);
				} else {
					vieBox.setEditable(true);
					aButton.setText("save");
				}
			}
			
		});
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				vieBox.setEditable(false);
				Dictionary.listWord.remove(DictionaryManagement.dictionaryLookup(engBox.getText()));
				try {
					DictionaryManagement.dictionaryExportToFile();
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				data = DictionaryManagement.dictionarySearcher(engBox.getText());
				recomend.setListData(data);
				deleteButton.setEnabled(false);
				vieBox.setText(new String());
			}
			
		});
	}
	
	private static String show(Word aWord) {
		String temp = aWord.getWord_explain();
		String s = new String();
		int pos = 40;
		while (pos < temp.length() ) {
			while (pos < temp.length() && temp.charAt(pos) != ' ') ++pos;
			s = s.concat(temp.substring(0, pos) + "\n");
			if (pos != temp.length()) temp = temp.substring(pos+1);
			else temp = new String();
			pos = 40;
		}
		s = s.concat(temp);
		return s;
	}

}
