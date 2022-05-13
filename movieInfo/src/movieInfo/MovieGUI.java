package movieInfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MovieGUI extends JFrame implements ActionListener {

	private MovieInfoDao dao;
	private JPanel mainpanel;
	private JPanel searchingPanel;

	private JTextArea textArea;
	private JTabbedPane jtab;

	private JTextField searchingTextField;

	private JButton searchingBtn;
	private JButton allSearchingBtn;
	private JButton deleteBtn;
	private JButton setBtn;
	private JButton addBtn;

	Vector<MovieInfoDto> vcList = new Vector<>();
	JList<MovieInfoDto> jList = new JList<>();

	ScrollPane scrollPane = new ScrollPane();
	MovieInfoPanel movieInfoPanel = new MovieInfoPanel();

	//
	int movieinfoNum;

	public MovieGUI() {
		initData();
		addEventlistener();
	}

	private void initData() {

		setTitle("Movie Information Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 850, 850);
		setResizable(false);

		mainpanel = new JPanel();
		mainpanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainpanel.setSize(getWidth(), getHeight());
		mainpanel.setLayout(null);
		setContentPane(mainpanel);

		jtab = new JTabbedPane(JTabbedPane.TOP);
		jtab.setBounds(5, 5, 800, 800);
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
		searchingBtn.setBounds(560, 20, 100, 25);
		searchingBtn.setBackground(Color.WHITE);
		searchingPanel.add(searchingBtn);

		allSearchingBtn = new JButton("Search All");
		allSearchingBtn.setBounds(560, 60, 100, 25);
		allSearchingBtn.setBackground(Color.WHITE);
		searchingPanel.add(allSearchingBtn);

		addBtn = new JButton("Insert");
		addBtn.setBounds(560, 100, 100, 25);
		addBtn.setBackground(Color.WHITE);
		searchingPanel.add(addBtn);

		setBtn = new JButton("Update");
		setBtn.setBounds(560, 140, 100, 25);
		setBtn.setBackground(Color.WHITE);
		searchingPanel.add(setBtn);

		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(560, 180, 100, 25);
		deleteBtn.setBackground(Color.WHITE);
		searchingPanel.add(deleteBtn);

		setVisible(true);
	}

	private void addEventlistener() {
		searchingBtn.addActionListener(this);
		searchingTextField.addActionListener(this);
		allSearchingBtn.addActionListener(this);
		addBtn.addActionListener(this);
		setBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		movieInfoPanel.getBtnInsertMovieInfo().addActionListener(this);
		movieInfoPanel.getBtnUpdateMovieInfo().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dao = new MovieInfoDao();

		// Search 버튼 
		if (e.getSource() == searchingBtn) {

			Vector<MovieInfoDto> selectMoviTitleResult = dao.selectMovieTitle(searchingTextField.getText());

			for (int i = 0; i < selectMoviTitleResult.size(); i++) {
				vcList.add(selectMoviTitleResult.get(i));
			}

			jList.setListData(vcList);
			scrollPane.add(jList);

			jList.setSelectedValue(null, false);
		} 
		
		// Search All 버튼
		else if (e.getSource() == allSearchingBtn) {

			vcList.removeAllElements();

			Vector<MovieInfoDto> selectAllMovieInfoResult = dao.selectAllMovieInfo();

			for (int i = 0; i < selectAllMovieInfoResult.size(); i++) {
				vcList.add(selectAllMovieInfoResult.get(i));
			}

			jList.setListData(vcList);
			scrollPane.add(jList);

			jList.setSelectedValue(null, false);
		} 
		
		// Insert 버튼
		else if (e.getSource() == addBtn) {
			
			String[] options = { "MOVIE", "PERSON", "STEP", "CREW" };
			int option = JOptionPane.showOptionDialog(null, "추가할 항목을 선택해주세요", "INSERT", JOptionPane.DEFAULT_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

			if (option == 0) {
				
				movieInfoPanel.getBtnUpdateMovieInfo().setEnabled(false);
				movieInfoPanel.getBtnInsertMovieInfo().setEnabled(true);

				jtab.addTab("insert", null, movieInfoPanel, null);
				jtab.setSelectedComponent(movieInfoPanel);
				
			}
			
			jList.setSelectedValue(null, false);
			
		} 
		
		// Update 버튼
		else if (e.getSource() == setBtn) {
			
			if (jList.getSelectedValue() == null) {
				
				System.out.println("업데이트 항목을 선택해주세요");
				JOptionPane.showMessageDialog(null, "수정하려는 항목을 선택해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (jList.getSelectedValue() != null) {
				
				movieInfoPanel.getBtnUpdateMovieInfo().setEnabled(true);
				movieInfoPanel.getBtnInsertMovieInfo().setEnabled(false);
				
				MovieInfoDto dto = jList.getSelectedValue();

				movieInfoPanel.getFldMovieTitle().setText(dto.getMovieTitle());
				movieInfoPanel.getFldDirectorName().setText(dto.getDirectorName());

				movieInfoPanel.getFldTotalIncome().setText(dto.getTotalIncome() + "");
				movieInfoPanel.getFldAudience().setText(dto.getAudience() + "");
				movieInfoPanel.getFldRating().setText(dto.getRating() + "");

				movieInfoPanel.getFldReleaseYear().setText(dto.getReleaseYear() + "");
				movieInfoPanel.getFldReleaseMonth().setText(dto.getReleaseMonth() + "");

				movieInfoPanel.getFldMoviePlot().setText(dto.getMoviePlot());
				movieInfoPanel.getFldReview1().setText(dto.getReview1());
				movieInfoPanel.getFldReview2().setText(dto.getReview2());
				movieInfoPanel.getFldReview3().setText(dto.getReview3());

				movieinfoNum = dto.getMovieInfoNum();
				
				jList.setSelectedValue(null, false);
				
				jtab.addTab("update", null, movieInfoPanel, null);
				jtab.setSelectedComponent(movieInfoPanel);

			}

			

		} else if (e.getSource() == deleteBtn) {
			
			if (jList.getSelectedValue() == null) {
				
				System.out.println("삭제할 데이터가 없습니다.");
				JOptionPane.showMessageDialog(null, "삭제하려는 항목을 선택해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);
				
			} else {
				
				if (vcList.size() != 0) {
					
					int index = jList.getSelectedIndex();
					vcList.remove(index);
					jList.ensureIndexIsVisible(index);
					jList.repaint();
					
				}
			}
			jList.setSelectedValue(null, false);
			
		} 
		
		// MovieInfoPanel - 영화정보 등록하기 버튼
		else if (e.getSource() == movieInfoPanel.getBtnInsertMovieInfo()) {
			
			Field[] atr = movieInfoPanel.getClass().getFields();

			if(atr.length != 11) {
				
				System.out.println("빈칸을 전부 입력해주세요");
				JOptionPane.showMessageDialog(null, "빈칸을 전부 입력해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);
				
			} else {
				
				MovieInfoDto dto = new MovieInfoDto();
				addDtoMovieInfo(dto);
				dao.insertMovieInfo(dto);
				
			}
		} 
		
		// MovieInfoPanel - 영화정보 수정하기 버튼
		else if (e.getSource() == movieInfoPanel.getBtnUpdateMovieInfo()) {
			
			Field[] atr = movieInfoPanel.getClass().getFields();

			if(atr.length != 11) {
				
				System.out.println("빈칸을 전부 입력해주세요");
				JOptionPane.showMessageDialog(null, "빈칸을 전부 입력해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);
				
			} else {

				MovieInfoDto dto = new MovieInfoDto();
				addDtoMovieInfo(dto);
				dao.updateMovieInfo(movieinfoNum, dto);
				
			}

		}
	}
	
	// MovieInfo 정보를 Dto로 밀어 넣는 메소드 ( insert, update 에서 사용 )
	private void addDtoMovieInfo(MovieInfoDto dto) {

		dto.setMovieTitle(movieInfoPanel.getFldMovieTitle().getText());
		dto.setDirectorName(movieInfoPanel.getFldDirectorName().getText());

		dto.setReleaseYear(Integer.parseInt(movieInfoPanel.getFldReleaseYear().getText()));
		dto.setReleaseMonth(Integer.parseInt(movieInfoPanel.getFldReleaseMonth().getText()));

		dto.setMoviePlot(movieInfoPanel.getFldMoviePlot().getText());

		dto.setTotalIncome(Integer.parseInt(movieInfoPanel.getFldTotalIncome().getText()));
		dto.setAudience(Integer.parseInt(movieInfoPanel.getFldAudience().getText()));
		dto.setRating(Float.parseFloat((movieInfoPanel.getFldRating().getText())));

		dto.setReview1(movieInfoPanel.getFldReview1().getText());
		dto.setReview2(movieInfoPanel.getFldReview2().getText());
		dto.setReview3(movieInfoPanel.getFldReview3().getText());
	}

	public static void main(String[] args) {
		new MovieGUI();

	}
}
