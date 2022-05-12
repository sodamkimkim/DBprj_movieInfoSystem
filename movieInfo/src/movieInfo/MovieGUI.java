package movieInfo;

import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MovieGUI extends JFrame implements ActionListener, CallBack {

	EmployeesDao2 dao;
	private JPanel mainpanel;
	private JPanel searchingPanel;
	private JPanel addpanel;
	private JPanel setPanel;

	private JTextArea textArea;

	private JTextField searchingTextField;
	private JTextField textField2;
	private JTextField textField3;

	private JButton searchingBtn;
	private JButton allSearchingBtn;
	private JButton deleteBtn;
	private JButton setBtn;
	private JButton addBtn;

	Vector vcList = new Vector();
	JList jList = new JList();

	ScrollPane scrollPane = new ScrollPane();
	InsertPanel insertPanel = new InsertPanel();

	public MovieGUI() {
		initData();
		addEventlistener();
	}

	private void initData() {
		setTitle("Movie Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainpanel = new JPanel();
		setBounds(0, 0, 700, 650);
		mainpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainpanel);
		mainpanel.setLayout(null);
		setResizable(false);

		JTabbedPane jtab = new JTabbedPane(JTabbedPane.TOP);
		jtab.setBounds(5, 5, 675, 600);
		mainpanel.add(jtab);

		searchingPanel = new JPanel();
		jtab.addTab("Main", null, searchingPanel, null);
		searchingPanel.setLayout(null);

		searchingTextField = new JTextField();
		searchingTextField.setFont(new Font("나눔고딕", Font.BOLD, 13));
		searchingTextField.setBounds(20, 20, 525, 25);
		searchingTextField.setText("여기에 조회할 키워드 작성");
		searchingPanel.add(searchingTextField);

		textArea = new JTextArea();
		scrollPane.add(textArea);
		searchingPanel.add(scrollPane);
		scrollPane.setBounds(20, 60, 525, 500);

		searchingBtn = new JButton("Search");
		searchingPanel.add(searchingBtn);
		searchingBtn.setBounds(560, 20, 100, 25);

		allSearchingBtn = new JButton("Search All");
		searchingPanel.add(allSearchingBtn);
		allSearchingBtn.setBounds(560, 60, 100, 25);

		addBtn = new JButton("Insert");
		searchingPanel.add(addBtn);
		addBtn.setBounds(560, 100, 100, 25);

		deleteBtn = new JButton("Delet");
		searchingPanel.add(deleteBtn);
		deleteBtn.setBounds(560, 140, 100, 25);

		jtab.addTab("insert", null, insertPanel, null);

		setVisible(true);
	}

	private void addEventlistener() {
		searchingBtn.addActionListener(this);
		searchingTextField.addActionListener(this);
		allSearchingBtn.addActionListener(this);
		insertPanel.getButton1().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dao = new EmployeesDao2();

		if (e.getSource() == allSearchingBtn) {
			vcList.add(dao.empolyeesInfo());
			jList.setListData(vcList);
			scrollPane.add(jList);
		}
		if (e.getSource() == insertPanel.getButton1()) {

			dao.insert(insertPanel.getInputData1().getText(), insertPanel.getInputData2().getText(),
					insertPanel.getInputData3().getText(), insertPanel.getInputData4().getText(),
					insertPanel.getInputData5().getText());

		}
	}

	public static void main(String[] args) {
		new MovieGUI();

	}
}
