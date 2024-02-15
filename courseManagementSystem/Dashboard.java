package courseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private static JTable coursetable;
	private JTextField courseSearchf;
	private JTextField searchStudentf;
	private static JTable stdtable;
	private JTextField txtSearchTutor;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	
	
	
	public static void getCourse() {
		
		
		// inserting course data in table		
		DefaultTableModel tmodel = (DefaultTableModel)coursetable.getModel();
		
		// clear row for avoiding duplicate data entry
		 tmodel.setRowCount(0);
		
	       String url = "jdbc:mysql://localhost"; 
	       String username = "root";
	       String password = "";
	       
	       try {
	           Connection con = DriverManager.getConnection(url, username, password);			           
	           Statement stmt = con.createStatement();

	           String query = "select * from sms.course";
	           ResultSet rs = stmt.executeQuery(query);			    	   
	    	  			    	   
	           while(rs.next()) {
	        	   
	        	   String did = rs.getString(1);
	        	   String dcourse = rs.getString(2);
	        	   String dseats = rs.getString(3);
	        	   String dbatch = rs.getString(4);
	        	   String dyear = rs.getString(5);

	        	   String data[]= {did, dcourse,  dseats, dbatch, dyear};
	        	   tmodel.addRow(data);	        	   
	           }
	       }
			
			catch (SQLException e1) {
	     	
	           e1.printStackTrace();

	       }
	
		
	}
	
	
	public static void getStudent() {
		
		
		// inserting course data in table		
		DefaultTableModel tmodel = (DefaultTableModel)stdtable.getModel();
		
		// clear row for avoiding duplicate data entry
		 tmodel.setRowCount(0);
		
	       String url = "jdbc:mysql://localhost"; 
	       String username = "root";
	       String password = "";
	       	       
	       
	       try {
	           Connection con = DriverManager.getConnection(url, username, password);			           
	           Statement stmt = con.createStatement();

	           String query = "select * from sms.students_data";
	           ResultSet rs = stmt.executeQuery(query);			    	   
	    	  			    	   
	           while(rs.next()) {
	        	   
	        	   String did = rs.getString(1);
	        	   String dname = rs.getString(2);
	        	   String demail = rs.getString(3);
	        	   String dphone = rs.getString(4);
	        	   String dcourse = rs.getString(5);

	        	   String data[]= {did, dname,  demail, dphone, dcourse};
	        	   tmodel.addRow(data);	        	   
	           }
	       }
			
			catch (SQLException e1) {
	     	
	           e1.printStackTrace();

	       }	
		
	}
	
	
	
	
	
	
	public Dashboard() {
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1073, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bg = new JPanel();
		bg.setBounds(-14, -14, 1104, 623);
		contentPane.add(bg);
		bg.setLayout(null);
		
		JPanel left = new JPanel();
		left.setBounds(10, 0, 241, 613);
		left.setBackground(new Color(0, 102, 102));
		bg.add(left);
		left.setLayout(null);
		
		JButton dashboradbtn = new JButton("  Dashboard");
		dashboradbtn.addMouseListener(new MouseAdapter() {			
			
		});
		dashboradbtn.addFocusListener(new FocusAdapter() {
					
		});
		dashboradbtn.setIcon(new ImageIcon("D:\\java IDE\\Project\\src\\logo\\dashboard.png"));
		
		dashboradbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		dashboradbtn.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		dashboradbtn.setBackground(new Color(240, 240, 240));
				
		
		dashboradbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				
			}
		});
		dashboradbtn.setBounds(37, 183, 171, 35);
		left.add(dashboradbtn);
		
		JButton logoutbtn = new JButton("  Logout");
		logoutbtn.setIcon(new ImageIcon("D:\\java IDE\\Project\\src\\logo\\log-out.png"));
		

		logoutbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		logoutbtn.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		logoutbtn.setBackground(new Color(240, 240, 240));
		
		
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login l = new Login();
				l.setVisible(true);
				dispose();
				
			
			}
		});
		
		logoutbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		logoutbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		logoutbtn.setBackground(new Color(240, 240, 240));
		
		
		logoutbtn.setBounds(37, 519, 171, 35);
		left.add(logoutbtn);
		
		JButton mailbtn = new JButton("  Email");
		mailbtn.setIcon(new ImageIcon("D:\\java IDE\\Project\\src\\logo\\email.png"));
		
		mailbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		mailbtn.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		mailbtn.setBackground(new Color(240, 240, 240));
		
		mailbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 Desktop.getDesktop().browse(new URI("https://mail.google.com/mail/u/0/#inbox?compose=new"));
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		mailbtn.setBounds(37, 407, 171, 35);
		left.add(mailbtn);
		
		JButton settingbtn = new JButton("  Settings");
		settingbtn.setIcon(new ImageIcon("D:\\java IDE\\Project\\src\\logo\\gear.png"));
		
		settingbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		settingbtn.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		settingbtn.setBackground(new Color(240, 240, 240));
		
		settingbtn.setBounds(37, 463, 171, 35);
		left.add(settingbtn);
		
		JButton coursebtn = new JButton("  Courses");
		coursebtn.setIcon(new ImageIcon("D:\\java IDE\\Project\\src\\logo\\book.png"));
		coursebtn.setBackground(new Color(240, 240, 240));
		coursebtn.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        
        // All course data
		coursebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(1);
				
				getCourse();
				
				
				
//				// inserting course data in table
//				
//				DefaultTableModel tmodel = (DefaultTableModel)coursetable.getModel();
//				
//				// clear row for avoiding duplicate data entry
//				 tmodel.setRowCount(0);
//				
//			       String url = "jdbc:mysql://localhost"; 
//			       String username = "root";
//			       String password = "";
//
//			       
//			       try {
//			           Connection con = DriverManager.getConnection(url, username, password);			           
//			           Statement stmt = con.createStatement();
//
//			           String query = "select * from sms.course";
//			           ResultSet rs = stmt.executeQuery(query);			    	   
//			    	  			    	   
//			           while(rs.next()) {
//			        	   
//			        	   String did = rs.getString(1);
//			        	   String dcourse = rs.getString(2);
//			        	   String dseats = rs.getString(3);
//			        	   String dbatch = rs.getString(4);
//			        	   String dyear = rs.getString(5);
//
//			        	   String data[]= {did, dcourse,  dseats, dbatch, dyear};
//			        	   tmodel.addRow(data);
//			        	   
//			           }
//
//			       }
//					
//					catch (SQLException e1) {
//			     	
//			           e1.printStackTrace();
//
//			       }
				
				
				
			}
		});
		coursebtn.setBounds(37, 239, 171, 35);
		left.add(coursebtn);
		
		JButton tutorbtn = new JButton("  Tutors");
		tutorbtn.setIcon(new ImageIcon("D:\\java IDE\\Project\\src\\logo\\teacher (1).png"));
		

		tutorbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		tutorbtn.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		tutorbtn.setBackground(new Color(240, 240, 240));
		
		tutorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				tabbedPane.setSelectedIndex(2);
			}
		});
		tutorbtn.setBounds(37, 295, 171, 35);
		left.add(tutorbtn);
		
		JButton studbtn = new JButton("  Students");
		studbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(3);
				
				getStudent();
			}
		});
		studbtn.setIcon(new ImageIcon("D:\\java IDE\\Project\\src\\logo\\students.png"));
		
	
		studbtn.setForeground(UIManager.getColor("Button.disabledShadow"));
		studbtn.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		studbtn.setBackground(new Color(240, 240, 240));
		
		studbtn.setBounds(37, 351, 171, 35);
		left.add(studbtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\biki kumar\\Desktop\\Test\\Registration_System\\register\\FINAL PROJECT\\CourseManagementSystem\\src\\coursemanagementsystem\\training.png"));
		lblNewLabel.setBounds(103, 66, 128, 69);
		left.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course Management System");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(26, 135, 215, 22);
		left.add(lblNewLabel_1);
		
		JPanel notif = new JPanel();
		notif.setBounds(876, 10, 218, 603);
		notif.setBackground(new Color(255, 255, 255));
		bg.add(notif);
		notif.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(224, -65, 664, 678);
		bg.add(tabbedPane);
		
		JPanel dashpanel = new JPanel();
		tabbedPane.addTab("New tab", null, dashpanel, null);
		dashpanel.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("dash");
		btnNewButton_3.setBounds(146, 147, 85, 21);
		dashpanel.add(btnNewButton_3);
		
		JPanel coursepanel = new JPanel();
		tabbedPane.addTab("New tab", null, coursepanel, null);
		coursepanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Course");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(57, 83, 133, 43);
		coursepanel.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(57, 125, 574, 2);
		coursepanel.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 191, 577, 408);
		coursepanel.add(scrollPane);
		
		coursetable = new JTable();
		coursetable.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollPane.setViewportView(coursetable);
		coursetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Course ID", "Course Name", "Seats", "Batch", "No. of Years"
			}
		));
		
				
		courseSearchf = new JTextField();
		courseSearchf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 courseSearchf.setText("");
				
			}
		});
		courseSearchf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		courseSearchf.setText("Search Course");
		courseSearchf.setToolTipText("");
		courseSearchf.addKeyListener(new KeyAdapter() {
					
			
			  @Override
			    public void keyPressed(KeyEvent e) {
				  
				  // Check for Enter key is pressed
			        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			          
			            String enteredText = courseSearchf.getText();
			            System.out.println("Text entered: " + enteredText);
			            
			            
			            // search course by ID			    
			                String url = "jdbc:mysql://localhost";
			                String username = "root";
			                String password = "";
				
							DefaultTableModel tmodel = (DefaultTableModel)coursetable.getModel();
							
							// clear row for avoiding duplicate data entry
							 tmodel.setRowCount(0);

			                try {
			                    Connection con = DriverManager.getConnection(url, username, password);
			                    Statement stmt = con.createStatement();
			                    
			                    String query = "SELECT * FROM sms.course WHERE coursename = '" + enteredText + "'";

			                    ResultSet rs = stmt.executeQuery(query);

			         
			                    if (rs.next()) {
						        	   String did = rs.getString(1);
						        	   String dcourse = rs.getString(2);
						        	   String dseats = rs.getString(3);
						        	   String dbatch = rs.getString(4);
						        	   String dyear = rs.getString(5);

						        	   String data[]= {did, dcourse,  dseats, dbatch, dyear};
						        	   tmodel.addRow(data);
						        	   			                       
			                    }
			                    rs.close();
			                    stmt.close();
			                    con.close();			                    

			                } catch (SQLException e1111) {
			                    e1111.printStackTrace();
			                   
			                }			            
			        }
			    }

		
			
		});
		courseSearchf.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			// test input
			public void inputMethodTextChanged(InputMethodEvent event) {
				
			}
		});
		courseSearchf.setBounds(53, 140, 197, 31);
		coursepanel.add(courseSearchf);
		courseSearchf.setColumns(10);
		
		JButton addcourse = new JButton("Add Course");
		
		addcourse.setForeground(new Color(0, 0, 0));
		addcourse.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		addcourse.setBackground(new Color(240, 240, 240));
		
			
				
				addcourse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
											
						AddCourse ad = new AddCourse();
						ad.setVisible(true);
								
						
					}
				});
				addcourse.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
				addcourse.setBounds(260, 140, 118, 30);
				coursepanel.add(addcourse);
				
				JButton editcourse = new JButton("Edit Course");
				editcourse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						EditCourse  obj = new EditCourse();							
						obj.setVisible(true);
																					
					}
				});
				editcourse.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
				editcourse.setBounds(387, 140, 118, 30);
				coursepanel.add(editcourse);
				
				editcourse.setBackground(new Color(240, 240, 240));
				
				editcourse.setForeground(UIManager.getColor("Button.disabledShadow"));
				
					JButton deletecourse = new JButton("Delete Course");
					deletecourse.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							DeleteCourse del = new DeleteCourse();
							del.setVisible(true);
								
							
						}
					});
					deletecourse.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
					deletecourse.setBounds(514, 140, 118, 30);
					
					deletecourse.setBackground(new Color(240, 240, 240));
					
					deletecourse.setForeground(UIManager.getColor("Button.disabledShadow"));
					
					
					
					coursepanel.add(deletecourse);
		
		JPanel tutorspanel = new JPanel();
		tabbedPane.addTab("New tab", null, tutorspanel, null);
		tutorspanel.setLayout(null);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tutors");
		lblNewLabel_2_1_1.setBounds(55, 89, 180, 43);
		lblNewLabel_2_1_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		tutorspanel.add(lblNewLabel_2_1_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(55, 131, 574, 2);
		tutorspanel.add(separator_1_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(52, 197, 581, 408);
		tutorspanel.add(scrollPane_1_1);
		
		table = new JTable();
		scrollPane_1_1.setViewportView(table);
		
		txtSearchTutor = new JTextField();
		txtSearchTutor.setBounds(51, 146, 194, 31);
		txtSearchTutor.setToolTipText("");
		txtSearchTutor.setText("Search Tutor");
		txtSearchTutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearchTutor.setColumns(10);
		tutorspanel.add(txtSearchTutor);
		
		JButton btnAddTutors = new JButton("Add Tutors");
		btnAddTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddTutors.setBounds(256, 146, 118, 30);
		btnAddTutors.setForeground(UIManager.getColor("Button.disabledShadow"));
		btnAddTutors.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnAddTutors.setBackground(new Color(240, 240, 240));
		

		
		tutorspanel.add(btnAddTutors);
		
		JButton btnEditTutors = new JButton("Edit  Tutors");
		btnEditTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditTutors.setBounds(383, 146, 118, 30);
		btnEditTutors.setForeground(UIManager.getColor("Button.disabledShadow"));
		btnEditTutors.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnEditTutors.setBackground(new Color(240, 240, 240));
		

		
		
		
		tutorspanel.add(btnEditTutors);
		
		JButton btnDeleteTutors = new JButton("Delete  Tutors");
		btnDeleteTutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteTutors.setBounds(510, 146, 121, 30);
		btnDeleteTutors.setForeground(UIManager.getColor("Button.disabledShadow"));
		btnDeleteTutors.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		btnDeleteTutors.setBackground(new Color(240, 240, 240));
		tutorspanel.add(btnDeleteTutors);
		
		JPanel studentspanel = new JPanel();
		tabbedPane.addTab("New tab", null, studentspanel, null);
		studentspanel.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enroled Students");
		lblNewLabel_2_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(51, 83, 180, 43);
		studentspanel.add(lblNewLabel_2_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(51, 125, 574, 2);
		studentspanel.add(separator_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(48, 191, 577, 408);
		studentspanel.add(scrollPane_1);
		
		stdtable = new JTable();
		stdtable.setFont(new Font("Tahoma", Font.BOLD, 10));
		stdtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student ID", "Full Name", "Email", "Phone No.", "Enlored Course"
			}
		));
		stdtable.getColumnModel().getColumn(0).setPreferredWidth(65);
		stdtable.getColumnModel().getColumn(1).setPreferredWidth(122);
		stdtable.getColumnModel().getColumn(2).setPreferredWidth(165);
		stdtable.getColumnModel().getColumn(3).setPreferredWidth(91);
		stdtable.getColumnModel().getColumn(4).setPreferredWidth(163);
		scrollPane_1.setViewportView(stdtable);
		
		searchStudentf = new JTextField();
		searchStudentf.addKeyListener(new KeyAdapter() {
		
			
			  @Override
			    public void keyPressed(KeyEvent e) {
				  
				  // Check for Enter key is pressed
			        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			          
			            String enteredText = searchStudentf.getText();
			            System.out.println("Text entered: " + enteredText);
			            
			            
			            // search course by ID			    
			                String url = "jdbc:mysql://localhost";
			                String username = "root";
			                String password = "";
				
							DefaultTableModel tmodel = (DefaultTableModel)stdtable.getModel();
							
							// clear row for avoiding duplicate data entry
							 tmodel.setRowCount(0);

			                try {
			                    Connection con = DriverManager.getConnection(url, username, password);
			                    Statement stmt = con.createStatement();
			                    
			                    String query = "SELECT * FROM sms.students_data WHERE name = '" + enteredText + "'";

			                    ResultSet rs = stmt.executeQuery(query);

			                    
			                    if (rs.next()) {
			    	        	   
			    	        	   String did = rs.getString(1);
			    	        	   String dname = rs.getString(2);
			    	        	   String demail = rs.getString(3);
			    	        	   String dphone = rs.getString(4);
			    	        	   String dcourse = rs.getString(5);

			    	        	   String data[]= {did, dname,  demail, dphone, dcourse};
			    	        	   tmodel.addRow(data);	        	   
			    	           }
			                    
			                    
			                    rs.close();
			                    stmt.close();
			                    con.close();			                    

			                } catch (SQLException e1111) {
			                    e1111.printStackTrace();
			                   
			                }			            
			        }
			    }
			
			
			
		});
		searchStudentf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchStudentf.setText("");
			}
		});
		searchStudentf.setToolTipText("");
		searchStudentf.setText("Search Student");
		searchStudentf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchStudentf.setColumns(10);
		searchStudentf.setBounds(47, 140, 194, 31);
		studentspanel.add(searchStudentf);
		
		JButton addStudents = new JButton("Add Student");
		addStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AddStudents ads = new AddStudents();
				ads.setVisible(true);
			}
		});
		addStudents.setForeground(UIManager.getColor("Button.disabledShadow"));
		addStudents.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		addStudents.setBackground(new Color(240, 240, 240));
		addStudents.setBounds(252, 140, 118, 30);
		studentspanel.add(addStudents);
			
		
		
		JButton editStudents = new JButton("Edit Student");
		editStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditStudent es = new EditStudent();
				es.setVisible(true);
				
			}
		});
		editStudents.setForeground(UIManager.getColor("Button.disabledShadow"));
		editStudents.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		editStudents.setBackground(new Color(240, 240, 240));
		
		editStudents.setBounds(379, 140, 118, 30);
				
		
		studentspanel.add(editStudents);
		
		JButton deleteStudents = new JButton("Delete Student");
		deleteStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteStudent del = new DeleteStudent();
				del.setVisible(true);
			}
		});
		deleteStudents.setForeground(UIManager.getColor("Button.disabledShadow"));
		deleteStudents.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		deleteStudents.setBackground(new Color(240, 240, 240));
		deleteStudents.setBounds(506, 140, 124, 30);
		
				
		
		studentspanel.add(deleteStudents);
		
		JPanel settingpanel = new JPanel();
		tabbedPane.addTab("New tab", null, settingpanel, null);
	}
}
