package ontology;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SpringLayout;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

import java.awt.SystemColor;
import javax.swing.JSeparator;

public class index extends JFrame {
	private JTextField textField;
	private double num;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public index() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ChiAmaka\\Pictures\\g.jpeg"));
		//getContentPane().setBackground(new Color(128, 0, 128));
		setTitle("G Ontology Creator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 351);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		BufferedImage img = ImageIO.read(new File("res/stones.png"));
		JLabel l1=new JLabel(new ImageIcon(img));
		panel.add(l1);
		l1.setLayout(new SpringLayout());

		// Adding the MenuBar for our Menus
		JMenuBar File = new JMenuBar();
		setJMenuBar(File);

		// Adding the Menu "File"
		JMenu mnFile = new JMenu("File");
		File.add(mnFile);

		final JMenuItem mntmOpenFile = new JMenuItem("Open File...\r\n");

		// Action for "Open File". It pops out a filechooser and stores the path
		// in file_name
		mntmOpenFile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == mntmOpenFile) {
					final JFileChooser fc = new JFileChooser();
					int returnVal = fc.showOpenDialog(mntmOpenFile);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						String file_name = file.toString();
			
						textField.setText(file_name);

					}
				}
			}
		});

		mnFile.add(mntmOpenFile);
		mnFile.addSeparator();

		JMenuItem mntmExit = new JMenuItem("Exit");

		// Action for exit to simply close the window
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(ABORT);
			}
		});

		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		File.add(mnHelp);
		
		JSeparator separator = new JSeparator();
		mnHelp.add(separator);
		
		JMenuItem mntmHowToUse = new JMenuItem("How to Use this System");
		mnHelp.add(mntmHowToUse);
		
		JMenuItem mntmAboutGOntology = new JMenuItem("About G Ontology Creator");
		mntmAboutGOntology.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				about abt = new about();
				abt.setVisible(true);
			}
		});
		mnHelp.add(mntmAboutGOntology);

		// layouts and other gooey stuff
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		Box verticalBox = Box.createVerticalBox();
		springLayout.putConstraint(SpringLayout.NORTH, verticalBox, 17,
				SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, verticalBox, 151,
				SpringLayout.WEST, getContentPane());
		getContentPane().add(verticalBox);
		//end of File Path Label
		
		//TextField
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, verticalBox);
		springLayout.putConstraint(SpringLayout.WEST, textField, 170, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -87, SpringLayout.EAST, getContentPane());
		getContentPane().add(textField);
		textField.setColumns(20);
		//end of TextField
		
		//Preview Button
		JButton btnPreview = new JButton("Preview");
		springLayout.putConstraint(SpringLayout.WEST, btnPreview, 20, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnPreview, -423, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnPreview);
		
		//end of Preview Button
		
		//Action performed by the Preview Button
		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Hello");
				String file = textField.getText();

				preview_frame preview;
				try {
					preview = new preview_frame(file);
					preview.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		//Preprocess Button
		JButton btnPreprocess = new JButton("Preprocess");
		springLayout.putConstraint(SpringLayout.WEST, btnPreprocess, 256, SpringLayout.EAST, btnPreview);
		springLayout.putConstraint(SpringLayout.EAST, btnPreprocess, -28, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnPreview, 0, SpringLayout.NORTH, btnPreprocess);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPreprocess, -89, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnPreprocess);
		//end of Preprocess Button
		
		//Action performed by the Preprocess button
		btnPreprocess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Preprocess_frame preprocess;
				try{
					preprocess = new Preprocess_frame(num);
					preprocess.setVisible(true);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		
		//CreateTextFile Button
		JButton btnCreateTextFile = new JButton("Create Text File");
		springLayout.putConstraint(SpringLayout.NORTH, btnCreateTextFile, -47, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnCreateTextFile, 216, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCreateTextFile, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnCreateTextFile);
		
		JButton btnFilePath = new JButton("File Path:");
		springLayout.putConstraint(SpringLayout.NORTH, btnFilePath, 0, SpringLayout.NORTH, verticalBox);
		springLayout.putConstraint(SpringLayout.WEST, btnFilePath, -83, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, btnFilePath, 20, SpringLayout.NORTH, verticalBox);
		springLayout.putConstraint(SpringLayout.EAST, btnFilePath, -6, SpringLayout.WEST, textField);
		getContentPane().add(btnFilePath);
		//end of CreateTextFile Button
		
		//Action Performed by the CreateTextFile Button 
		btnCreateTextFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TextExtractor te = new TextExtractor();
				String file = textField.getText();
				try {
					te.process(file);
					
					num = te.createTextFile();
					JOptionPane.showMessageDialog(null, "Text file successfully created!");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Text file unsuccessful");
				}
			}
		});
	}
}
