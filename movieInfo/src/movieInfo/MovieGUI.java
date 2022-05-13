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

	private JTextArea textArea;
	private JTabbedPane jtab;

	private JTextField searchingTextField;
	private JTextField textField2;
	private JTextField textField3;

	private JButton searchingBtn;
	private JButton allSearchingBtn;
	private JButton deleteBtn;
	private JButton setBtn;
	private JButton addBtn;

	Vector vcList = new Vector();
	JList<EmployeesDto2> jList = new JList<>();

	ScrollPane scrollPane = new ScrollPane();
	InsertPanel insertPanel = new InsertPanel();
	UpdatePanel updatePanel = new UpdatePanel();

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

		jtab = new JTabbedPane(JTabbedPane.TOP);
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

		setBtn = new JButton("Update");
		searchingPanel.add(setBtn);
		setBtn.setBounds(560, 140, 100, 25);

		deleteBtn = new JButton("Delet");
		searchingPanel.add(deleteBtn);
		deleteBtn.setBounds(560, 180, 100, 25);

		jtab.addTab("insert", null, insertPanel, null);
		jtab.addTab("update", null, updatePanel, null);

		setVisible(true);
	}

	private void addEventlistener() {
		searchingBtn.addActionListener(this);
		searchingTextField.addActionListener(this);
		allSearchingBtn.addActionListener(this);
		addBtn.addActionListener(this);
		setBtn.addActionListener(this);
		insertPanel.getButton1().addActionListener(this);
		updatePanel.getButton1().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dao = new EmployeesDao2();

		if (e.getSource() == allSearchingBtn) {
			for (int i = 0; i < dao.empolyeesInfo().size(); i++) {
				vcList.add(dao.empolyeesInfo().get(i));
			}

			jList.setListData(vcList);
			scrollPane.add(jList);
		} else if (e.getSource() == addBtn) {
			jtab.setSelectedComponent(insertPanel);
		} else if (e.getSource() == setBtn) {
			EmployeesDto2 dto2 = jList.getSelectedValue();
			updatePanel.getInputData1().setText(dto2.getLast_name());
			updatePanel.getInputData2().setText(dto2.getEmp_no() + "");
			updatePanel.getInputData3().setText(dto2.getLast_name());
			updatePanel.getInputData4().setText("M");
			updatePanel.getInputData5().setText(dto2.getEmp_no() + "");
			jtab.setSelectedComponent(updatePanel);
		} else if (e.getSource() == deleteBtn) {
			if (vcList.size() == 0) {
				textArea.append("삭제할 데이터가 없습니다.");
			} else if (vcList.size() != 0) {
				int index = jList.getSelectedIndex();
				{
					vcList.remove(index);
					jList.ensureIndexIsVisible(index);
					jList.repaint();
				}

			}
		}

		if (e.getSource() == insertPanel.getButton1()) {

			dao.insert(insertPanel.getInputData1().getText(), insertPanel.getInputData2().getText(),
					insertPanel.getInputData3().getText(), insertPanel.getInputData4().getText(),
					insertPanel.getInputData5().getText());

		}
		if (e.getSource() == updatePanel.getButton1()) {
			dao.update(updatePanel.getInputData1().getText(), updatePanel.getInputData2().getText(),
					updatePanel.getInputData3().getText(), updatePanel.getInputData4().getText(),
					updatePanel.getInputData5().getText());
			System.out.println(updatePanel.getInputData1().getText());
		}
	}

	public static void main(String[] args) {
		new MovieGUI();

	}
}
