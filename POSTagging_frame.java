package ontology;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class POSTagging_frame extends JFrame {
	private JPanel contentPane;
	//private JTextArea conceptTextArea;
	protected PrintStream diskwriter;
	private JTextArea textArea;
	final DefaultListModel<String> model = new DefaultListModel<String>();
	private JList<String> list;
	private JTextArea classTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POSTagging_frame frame = new POSTagging_frame();
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
	public POSTagging_frame() {
		setResizable(false);
		setTitle("POSTagging Window");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ChiAmaka\\Pictures\\g.jpeg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 679, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 36, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 12, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -26, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -515, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("-->");
		sl_contentPane.putConstraint(SpringLayout.EAST, label, -158, SpringLayout.EAST, contentPane);
		label.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 168, SpringLayout.NORTH, contentPane);
		contentPane.add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_1, -34, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 137, SpringLayout.EAST, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_1, 106, SpringLayout.EAST, scrollPane);
		contentPane.add(scrollPane_1);
		
		JLabel lblConcepts = new JLabel("Concepts");
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_1, 6, SpringLayout.SOUTH, lblConcepts);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblConcepts, -343, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblConcepts, 19, SpringLayout.NORTH, contentPane);
		lblConcepts.setForeground(Color.WHITE);
		contentPane.add(lblConcepts);
		
		JButton btnOk = new JButton("OK");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOk, 6, SpringLayout.SOUTH, scrollPane_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnOk, 116, SpringLayout.EAST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnOk, -10, SpringLayout.EAST, scrollPane_1);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newToken = classTextArea.getText();
				try {
					double num = Math.random();
					diskwriter = new PrintStream("concepts/conceptoutput" + num +".concept");
					diskwriter.print(newToken);
					editFile.edit("conceptoutput" + num +".concept");
					JOptionPane.showMessageDialog(null, "Concept textfile has been created");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		contentPane.add(btnOk);
		
		JLabel lblPostaggedTokens = new JLabel("POSTagged Tokens");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblConcepts, 158, SpringLayout.EAST, lblPostaggedTokens);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPostaggedTokens, 26, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPostaggedTokens, -6, SpringLayout.NORTH, scrollPane);
		lblPostaggedTokens.setForeground(Color.WHITE);
		contentPane.add(lblPostaggedTokens);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_2, 498, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_1, -103, SpringLayout.WEST, scrollPane_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_2, 54, SpringLayout.NORTH, contentPane);
		contentPane.add(scrollPane_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_3, -31, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_3, 0, SpringLayout.NORTH, scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_3, 6, SpringLayout.EAST, label);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_3, -19, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane_3);
		
		classTextArea = new JTextArea();
		scrollPane_3.setViewportView(classTextArea);
		
		JLabel lblClasses = new JLabel("Classes");
		lblClasses.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblClasses, 0, SpringLayout.SOUTH, lblConcepts);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblClasses, -62, SpringLayout.EAST, contentPane);
		contentPane.add(lblClasses);
		
		JButton button = new JButton("==>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String lstItem = list.getSelectedValue().toString();
				classTextArea.append(lstItem+"\n");
				//list.remove(list.getSelectedIndex());
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, button, 29, SpringLayout.EAST, scrollPane_1);
		
		list = new JList<String>(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(list);
		sl_contentPane.putConstraint(SpringLayout.EAST, button, -22, SpringLayout.WEST, scrollPane_3);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("-->");
		sl_contentPane.putConstraint(SpringLayout.NORTH, button, -6, SpringLayout.NORTH, label_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, label_1, 176, SpringLayout.NORTH, contentPane);
		label_1.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.WEST, label_1, 41, SpringLayout.EAST, scrollPane);
		contentPane.add(label_1);
		
		/*conceptTextArea = new JTextArea();
		contentPane.add(conceptTextArea);
		*/
	}
	
	public void setTextArea(String text) {
		textArea.setText(text);
	}
	
	public void setConcept(Object text) {
		List<String> lst = (List<String>) text;
		list.setListData(lst.toArray(new String[lst.size()]));
}

	
}
