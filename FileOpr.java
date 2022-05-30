import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class FileOpr {

	private JFrame frame;
	int objCount;
	private JButton btnAddTextBox;
	ArrayList<Component> objList; 
	private JButton btnMerge;
	private JButton btnNewButton;
	private JButton btnSave;
	private JButton btnRead;
	private JButton btnSave2;
	private JButton btnRead2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileOpr window = new FileOpr();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FileOpr() {
		objList = new ArrayList<Component>();
		objCount=0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Util utl = new Util();
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnAddTextBox = new JButton("New Item");
		btnAddTextBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objCount++;
				JTextField  tempText= new JTextField();
				utl.changeInput(tempText);
				tempText.setBounds(83, 259+(objCount*40) , 398, 39);
				
				objList.add(tempText);
				frame.getContentPane().add(tempText);
				tempText.setColumns(10);
				
				frame.pack();
				frame.setBounds(100, 100, 610, 697);
			}
		});
		btnAddTextBox.setBounds(306, 11, 89, 23);
		frame.getContentPane().add(btnAddTextBox);
		
		JTextArea txtOutput = new JTextArea();
		utl.changeWarning(txtOutput);
		txtOutput.setBounds(109, 45, 388, 160);
		frame.getContentPane().add(txtOutput);
		
		btnMerge = new JButton("Merge of TextBox");
		btnMerge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(Component o:frame.getContentPane().getComponents()) {
					if (o instanceof JTextField) {
						txtOutput.append(((JTextField)o).getText()+"\n");
						txtOutput.append("---------");
						
					}
				}
			}
		});
		btnMerge.setBounds(405, 11, 119, 23);
		frame.getContentPane().add(btnMerge);
		
		
		for(Component o:frame.getContentPane().getComponents()) {
			if (o instanceof JTextField) {
				utl.changeInput(o);
			}
		}
		
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String current = System.getProperty("user.dir");
					txtOutput.append(current+"\n");
					File directory = new File("C:/Users/erenk/Desktop");
					
					
					String filename[] = directory.list();
					for (int i = 0; i < filename.length; i++) {
						
						File temp = new File("C:/Users/erenk/Desktop"+filename[i]);
						
						txtOutput.append(filename[i]+ "(File :"+temp.isFile()+")" +"\n" );
					}
					
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		btnTest.setBounds(83, 11, 89, 23);
		frame.getContentPane().add(btnTest);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JFileChooser chooser = new JFileChooser("C:/JavaPrograms");
				JFileChooser chooser = new JFileChooser( );
				
				int status = chooser.showOpenDialog(null);

				if (status == JFileChooser.APPROVE_OPTION) {
					txtOutput.append("Open is clicked\n");
				} else { //== JFileChooser.CANCEL_OPTION
					txtOutput.append("Cancel is clicked\\n");
				}
				
			}
		});
		btnNewButton.setBounds(182, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File outFile = new File("C:/Users/erenk/Desktop/sample1.data");
				try {
					FileOutputStream outStream = new FileOutputStream(outFile);
					byte[] byteArray = {65, 66, 67, 68, 69, 70, 71, 72};
					outStream.write(byteArray);
					outStream.close();
					
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnSave.setBounds(0, 11, 89, 23);
		frame.getContentPane().add(btnSave);
		
		btnRead = new JButton("Read File");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File inFile = new File("C:/Users/erenk/Desktop/sample1.data");
				try {
					FileInputStream inStream = new FileInputStream(inFile);
					
					int filesize = (int) inFile.length();
					byte[] byteArray = new byte[filesize];
					inStream.read(byteArray);
					for (int i = 0; i < filesize; i++) {
						txtOutput.append((char)byteArray[i]+"");
				   }
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRead.setBounds(0, 41, 89, 23);
		frame.getContentPane().add(btnRead);
		
		btnSave2 = new JButton("Save2");
		btnSave2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File outFile = new File("C:/Users/erenk/Desktop/sample2.data");
				FileOutputStream outFileStream;
				try {
					outFileStream = new FileOutputStream(outFile);
					DataOutputStream outDataStream = new DataOutputStream
							(outFileStream);
					
					//write values of primitive data types to the stream
					outDataStream.writeInt(987654321);
					outDataStream.writeLong(11111111L);
					outDataStream.writeFloat(22222222F);
					outDataStream.writeDouble(3333333D);
					outDataStream.writeChar('A');
					//outDataStream.writeUTF("Fatih");
					outDataStream.writeBoolean(true);
					//output done, so close the stream
					outDataStream.close();
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			}
		});
		btnSave2.setBounds(0, 85, 89, 23);
		frame.getContentPane().add(btnSave2);
		
		btnRead2 = new JButton("Read2");
		btnRead2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File inFile = new File("C:/Users/erenk/Desktop/sample2.data");
				FileInputStream inFileStream;
				try {
					inFileStream = new FileInputStream(inFile);
					DataInputStream inDataStream = new DataInputStream(inFileStream);
					//read values back from the stream and display them
					txtOutput.append(inDataStream.readInt()+"");
					txtOutput.append(inDataStream.readLong()+"");
					txtOutput.append(inDataStream.readFloat()+"");
					txtOutput.append(inDataStream.readDouble()+"");
					txtOutput.append(inDataStream.readChar()+"");
					//txtOutput.append(inDataStream.readUTF()+"");
					txtOutput.append(inDataStream.readBoolean()+"");
					//input done, so close the stream
					inDataStream.close();
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnRead2.setBounds(0, 119, 89, 23);
		frame.getContentPane().add(btnRead2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(54, 287, 101, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(27, 228, 115, 26);
		frame.getContentPane().add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		mnNewMenu.add(mnNewMenu_1);

	
	}
}
