package movieInfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mo extends JFrame {
	private MovieInfoDao dao;
	private JPanel mainpanel;
	private JPanel searchingPanel;

	private JTextArea textArea;
	private JTabbedPane jtab;

	private JTextField searchingTextField;

	private JButton btnMovieSearch;
	private JButton btnAllMovieSearch;
	private JButton btnDeleteMovie;
	private JButton btnUpdateMovie;
	private JButton btnInsertMovie;

	Vector<MovieInfoDto> vcList = new Vector<>();
	JList<MovieInfoDto> jList = new JList<>();

	ScrollPane scrollPane = new ScrollPane();
	private JLabel lblMovieInfo;
	private JPanel moviePanel;
	private JTextField fldSearchActor;
	private JLabel lblActorInfo;
	private JButton btnInsertActor;
	private JButton btnUpdateActor;
	private JButton btnDeleteActor;
	private JLabel lblStaffInfo;
	private JTextField fldSearchStaff;
	private JButton btnSearchStaff;
	private JList staffList;
	private JButton btnAllStaffSearch;
	private JButton btnInsertStaff;
	private JButton btnUpdateStaff;
	private JButton btnDeleteStaff;
	private JPanel actorPanel;
	private JPanel staffPanel;
	private JList actorList;
	private JButton btnSearchActor;
	private JButton btnAllActorSearch;
	private JList list;

//	MovieInfoPanel movieInfoPanel = new MovieInfoPanel();
	public Mo() {
//		initData();
		initilaize();
	}

	private void initilaize() {
		setTitle("Movie Information Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 850, 850);
		setResizable(false);

		mainpanel = new JPanel();
		mainpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainpanel.setSize(getWidth(), getHeight());
		mainpanel.setBackground(Color.WHITE);
		mainpanel.setLayout(null);
		setContentPane(mainpanel);

		jtab = new JTabbedPane(JTabbedPane.TOP);
		jtab.setBounds(15, 5, 800, 800);
		mainpanel.add(jtab);

		searchingPanel = new JPanel();
		jtab.addTab("Main", null, searchingPanel, null);
		searchingPanel.setLayout(null);

		// 영화 부분
		moviePanel = new JPanel();
		moviePanel.setBounds(23, 23, 747, 332);
		searchingPanel.add(moviePanel);
		moviePanel.setLayout(null);

		searchingTextField = new JTextField();
		searchingTextField.setFont(new Font("나눔고딕", Font.BOLD, 13));
		searchingTextField.setBounds(12, 47, 287, 25);
		searchingTextField.setText("여기에 조회할 키워드 작성");
		moviePanel.add(searchingTextField);
		moviePanel.add(scrollPane);
		scrollPane.setBounds(12, 84, 577, 226);

		btnMovieSearch = new JButton("Search");
		btnMovieSearch.setBounds(622, 48, 100, 25);
		btnMovieSearch.setBackground(Color.WHITE);
		moviePanel.add(btnMovieSearch);

		btnAllMovieSearch = new JButton("Search All");
		btnAllMovieSearch.setBounds(622, 88, 100, 25);
		btnAllMovieSearch.setBackground(Color.WHITE);
		moviePanel.add(btnAllMovieSearch);

		btnInsertMovie = new JButton("Insert");
		btnInsertMovie.setBounds(622, 134, 100, 25);
		btnInsertMovie.setBackground(Color.WHITE);
		moviePanel.add(btnInsertMovie);

		btnUpdateMovie = new JButton("Update");
		btnUpdateMovie.setBounds(622, 179, 100, 25);
		btnUpdateMovie.setBackground(Color.WHITE);
		moviePanel.add(btnUpdateMovie);

		btnDeleteMovie = new JButton("Delete");
		btnDeleteMovie.setBounds(622, 224, 100, 25);
		btnDeleteMovie.setBackground(Color.WHITE);
		moviePanel.add(btnDeleteMovie);

		lblMovieInfo = new JLabel("Movie Info");
		lblMovieInfo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblMovieInfo.setBounds(12, 10, 168, 27);
		moviePanel.add(lblMovieInfo);

		textArea = new JTextArea();
		textArea.setBounds(12, 88, 573, 222);
		moviePanel.add(textArea);
		
		list = new JList();
		list.setBounds(12, 88, 573, 222);
		moviePanel.add(list);

		// 배우 부분
		actorPanel = new JPanel();
		actorPanel.setBounds(23, 407, 342, 332);
		searchingPanel.add(actorPanel);
		actorPanel.setLayout(null);

		fldSearchActor = new JTextField();
		fldSearchActor.setText("\uBC30\uC6B0 \uC774\uB984 \uAC80\uC0C9");
		fldSearchActor.setBounds(38, 67, 106, 21);
		actorPanel.add(fldSearchActor);
		fldSearchActor.setColumns(10);

		lblActorInfo = new JLabel("Actor Info");
		lblActorInfo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblActorInfo.setBounds(38, 21, 147, 36);
		actorPanel.add(lblActorInfo);

		actorList = new JList();
		actorList.setBounds(38, 98, 253,151);
		actorPanel.add(actorList);

		btnAllActorSearch = new JButton("Search All");
		btnAllActorSearch.setBackground(Color.WHITE);
		btnAllActorSearch.setBounds(38, 266, 100, 21);
		actorPanel.add(btnAllActorSearch);

		btnInsertActor = new JButton("Insert");
		btnInsertActor.setBackground(Color.WHITE);
		btnInsertActor.setBounds(191, 266, 100, 21);
		actorPanel.add(btnInsertActor);

		btnUpdateActor = new JButton("Update");
		btnUpdateActor.setBackground(Color.WHITE);
		btnUpdateActor.setBounds(191, 293, 100, 21);
		actorPanel.add(btnUpdateActor);

		btnDeleteActor = new JButton("Delete");
		btnDeleteActor.setBackground(Color.WHITE);
		btnDeleteActor.setBounds(38, 293, 100, 21);
		actorPanel.add(btnDeleteActor);

		btnSearchActor = new JButton("Search");
		btnSearchActor.setBackground(Color.WHITE);
		btnSearchActor.setBounds(191, 67, 100, 21);
		actorPanel.add(btnSearchActor);

		// 스태프 부분
		staffPanel = new JPanel();
		staffPanel.setBounds(428, 407, 342, 332);
		searchingPanel.add(staffPanel);
		staffPanel.setLayout(null);
		
		lblStaffInfo = new JLabel("Staff Info");
		lblStaffInfo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblStaffInfo.setBounds(38, 21, 137, 36);
		staffPanel.add(lblStaffInfo);

		fldSearchStaff = new JTextField();
		fldSearchStaff.setText("\uC2A4\uD0DC\uD504 \uC774\uB984 \uAC80\uC0C9");
		fldSearchStaff.setColumns(10);
		fldSearchStaff.setBounds(38, 67, 106, 21);
		staffPanel.add(fldSearchStaff);

		btnSearchStaff = new JButton("Search");
		btnSearchStaff.setBackground(Color.WHITE);
		btnSearchStaff.setBounds(191, 67, 100, 21);
		staffPanel.add(btnSearchStaff);

		staffList = new JList();
		staffList.setBounds(38, 98, 253, 151);
		staffPanel.add(staffList);

		btnAllStaffSearch = new JButton("Search All");
		btnAllStaffSearch.setBackground(Color.WHITE);
		btnAllStaffSearch.setBounds(38, 266, 100, 21);
		staffPanel.add(btnAllStaffSearch);

		btnInsertStaff = new JButton("Insert");
		btnInsertStaff.setBackground(Color.WHITE);
		btnInsertStaff.setBounds(191, 266, 100, 21);
		staffPanel.add(btnInsertStaff);

		btnUpdateStaff = new JButton("Update");
		btnUpdateStaff.setBackground(Color.WHITE);
		btnUpdateStaff.setBounds(191, 293, 100, 21);
		staffPanel.add(btnUpdateStaff);

		btnDeleteStaff = new JButton("Delete");
		btnDeleteStaff.setBackground(Color.WHITE);
		btnDeleteStaff.setBounds(38, 293, 100, 21);
		staffPanel.add(btnDeleteStaff);
		
		
		
	}
}
