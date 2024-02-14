package courseManagementSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

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
	private JTable coursetable;
	private JTextField courseSearchf;

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
        
        // Adding course
		coursebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tabbedPane.setSelectedIndex(1);
				
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
				"ID", "Course Name", "Seats", "Batch", "No. of Years"
			}
		));
		
		
		
		courseSearchf = new JTextField();
		courseSearchf.addKeyListener(new KeyAdapter() {
					
			
			  @Override
			    public void keyPressed(KeyEvent e) {
			        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			            // Enter key is pressed
			            String enteredText = courseSearchf.getText();
			            System.out.println("Text entered: " + enteredText);
			            
			            
			         // search course by ID
			    
			                String url = "jdbc:mysql://localhost";
			                String username = "root";
			                String password = "";

			                try {
			                    Connection con = DriverManager.getConnection(url, username, password);

			                    Statement stmt = con.createStatement();

			                    String query = "SELECT * FROM sms.course WHERE id = 23";
			                    ResultSet rs = stmt.executeQuery(query);

			         
			                    if (rs.next()) {
			                        // Retrieve course information
			                        String courseId = rs.getString("id");
			                        String courseName = rs.getString("name");
			                        int courseCredits = rs.getInt("credits");

			                       
			                    }

			                    rs.close();
			                    stmt.close();
			                    con.close();

			                    return course;

			                } catch (SQLException e) {
			                    e.printStackTrace();
			                   
			                }
			            

			            
			            //
			            
			            
			            
			            
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
		
		JButton btnNewButton_7 = new JButton("tutors");
		btnNewButton_7.setBounds(173, 253, 85, 21);
		tutorspanel.add(btnNewButton_7);
		
		JPanel studentspanel = new JPanel();
		tabbedPane.addTab("New tab", null, studentspanel, null);
		
		JPanel mailpanel = new JPanel();
		tabbedPane.addTab("New tab", null, mailpanel, null);
		
		JPanel settingpanel = new JPanel();
		tabbedPane.addTab("New tab", null, settingpanel, null);
	}
}
