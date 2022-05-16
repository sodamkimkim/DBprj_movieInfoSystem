package movieInfo;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MovieFrame extends JFrame implements ActionListener {

	private MovieInfoDao dao;
	private ActorDao actorDao;
	private StaffInfoDao staffDao;

	private JPanel mainpanel;
	private JTabbedPane jtab;

	private JPanel searchPanel;

	// 영화 패널 부분
	private JPanel moviePanel;
	private JLabel lblMovieInfo;

	private ScrollPane movieScrollPane;
	private JTextArea movieTextArea;
	private JTextField fldSearchMovie;

	private JButton btnMovieSearch;
	private JButton btnAllMovieSearch;
	private JButton btnDeleteMovie;
	private JButton btnUpdateMovie;
	private JButton btnInsertMovie;

	private Vector<MovieInfoDto> movieDtos = new Vector<>();
	private JList<MovieInfoDto> movieInfoList = new JList<>();

	// 패널들
	MovieInfoPanel movieInfoPanel = new MovieInfoPanel();
	ActorInfoPanel actorInfoPanel = new ActorInfoPanel();
	StaffInfoPanel staffInfoPanel = new StaffInfoPanel();

	// 배우 패널 부분
	private JPanel actorPanel;
	private JLabel lblActorInfo;

	private ScrollPane actorScrollPane;
	private JTextField fldSearchActor;

	private JButton btnInsertActor;
	private JButton btnUpdateActor;
	private JButton btnDeleteActor;
	private JButton btnSearchActor;
	private JButton btnAllActorSearch;

	private Vector<ActorInfoDto> vcActor = new Vector<>();
	private JList<ActorInfoDto> actorjList = new JList<>();

	// 스태프 패널 부분
	private JPanel staffPanel;
	private JLabel lblStaffInfo;

	private ScrollPane staffScrollPane;
	private JTextField fldSearchStaff;

	private JButton btnSearchStaff;
	private JButton btnAllStaffSearch;
	private JButton btnInsertStaff;
	private JButton btnUpdateStaff;
	private JButton btnDeleteStaff;

	// 스태프 dto타입 private JList<>안에 넣어주기

	private Vector<StaffInfoDto> vcStaff = new Vector<>();
	private JList<StaffInfoDto> staffJlist = new JList<>();

	int movieinfoNum;
	int actcorNum;
	int staffinfoNum;
	int personInfoNum;

	public MovieFrame() {
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
		mainpanel.setBackground(Color.WHITE);
		mainpanel.setLayout(null);
		setContentPane(mainpanel);

		jtab = new JTabbedPane(JTabbedPane.TOP);
		jtab.setBounds(15, 5, 800, 800);
		mainpanel.add(jtab);

		searchPanel = new JPanel();
		jtab.addTab("Main", null, searchPanel, null);
		searchPanel.setLayout(null);

		// 영화 부분
		moviePanel = new JPanel();
		moviePanel.setBounds(23, 23, 747, 332);
		searchPanel.add(moviePanel);
		moviePanel.setLayout(null);

		lblMovieInfo = new JLabel("Movie Info");
		lblMovieInfo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblMovieInfo.setBounds(12, 10, 168, 27);
		moviePanel.add(lblMovieInfo);

		fldSearchMovie = new JTextField();
		fldSearchMovie.setFont(new Font("나눔고딕", Font.BOLD, 13));
		fldSearchMovie.setBounds(12, 47, 287, 25);
		fldSearchMovie.setText("영화 이름 검색");
		moviePanel.add(fldSearchMovie);

		movieScrollPane = new ScrollPane();
		movieScrollPane.setBounds(12, 84, 577, 226);
		moviePanel.add(movieScrollPane);

		movieTextArea = new JTextArea();
		movieTextArea.setBounds(12, 88, 573, 222);
		movieScrollPane.add(movieTextArea);

		movieInfoList = new JList();
		movieInfoList.setBounds(12, 88, 573, 222);
		movieTextArea.add(movieInfoList);

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

		// 배우 부분
		actorPanel = new JPanel();
		actorPanel.setBounds(23, 407, 342, 332);
		searchPanel.add(actorPanel);
		actorPanel.setLayout(null);

		fldSearchActor = new JTextField();
		fldSearchActor.setText("배우 이름 검색");
		fldSearchActor.setBounds(38, 67, 106, 21);
		actorPanel.add(fldSearchActor);
		fldSearchActor.setColumns(10);

		actorScrollPane = new ScrollPane();
		actorScrollPane.setBounds(38, 98, 253, 151);
		actorPanel.add(actorScrollPane);

		lblActorInfo = new JLabel("Actor Info");
		lblActorInfo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblActorInfo.setBounds(38, 21, 147, 36);
		actorPanel.add(lblActorInfo);

		actorjList = new JList();
		actorjList.setBounds(38, 98, 253, 151);
		actorScrollPane.add(actorjList);

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
		searchPanel.add(staffPanel);
		staffPanel.setLayout(null);

		lblStaffInfo = new JLabel("Staff Info");
		lblStaffInfo.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblStaffInfo.setBounds(38, 21, 250, 36);
		staffPanel.add(lblStaffInfo);

		staffScrollPane = new ScrollPane();
		staffScrollPane.setBounds(38, 98, 253, 151);
		staffPanel.add(staffScrollPane);

		fldSearchStaff = new JTextField();
		fldSearchStaff.setText("스태프 이름 검색");
		fldSearchStaff.setColumns(10);
		fldSearchStaff.setBounds(38, 67, 106, 21);
		staffPanel.add(fldSearchStaff);

		btnSearchStaff = new JButton("Search");
		btnSearchStaff.setBackground(Color.WHITE);
		btnSearchStaff.setBounds(191, 67, 100, 21);
		staffPanel.add(btnSearchStaff);

		staffJlist = new JList();
		staffJlist.setBounds(38, 98, 253, 151);
		staffScrollPane.add(staffJlist);

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

		setVisible(true);

	}

	private void addEventlistener() {
		staffInfoPanel.getBtnUpdateStaffInfo().addActionListener(this);
		staffInfoPanel.getBtnInsertStaffInfo().addActionListener(this);
		btnDeleteStaff.addActionListener(this);
		btnUpdateStaff.addActionListener(this);
		btnInsertStaff.addActionListener(this);
		btnAllStaffSearch.addActionListener(this);
		btnSearchStaff.addActionListener(this);
		btnUpdateActor.addActionListener(this);
		btnDeleteActor.addActionListener(this);
		actorInfoPanel.getBtnInsertActorInfo().addActionListener(this);
		actorInfoPanel.getBtnUpdateActorInfo().addActionListener(this);
		btnInsertActor.addActionListener(this);
		btnAllActorSearch.addActionListener(this);
		btnMovieSearch.addActionListener(this);
		btnSearchActor.addActionListener(this);
		fldSearchMovie.addActionListener(this);
		btnAllMovieSearch.addActionListener(this);
		btnInsertMovie.addActionListener(this);
		btnUpdateMovie.addActionListener(this);
		btnDeleteMovie.addActionListener(this);
		movieInfoPanel.getBtnInsertMovieInfo().addActionListener(this);
		movieInfoPanel.getBtnUpdateMovieInfo().addActionListener(this);
		fldSearchMovie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (fldSearchMovie.getText().equals("영화 이름 검색")) {
					fldSearchMovie.setText(null);
				}
			}
		});
		movieInfoList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (e.getClickCount() == 2) {
					MovieInfoDto dto = movieInfoList.getSelectedValue();
					new MovieInfoDetailFrame(dto);
				}
			}
		});
		actorjList.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (e.getClickCount() == 2) {
					ActorInfoDto dto = actorjList.getSelectedValue();
					new ActorInforDetailFrame(dto);
				}
			}

		});
		staffJlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (e.getClickCount() == 2) {
					StaffInfoDto dto = staffJlist.getSelectedValue();
					new StaffInfoDetailFrame(dto);
					staffJlist.setSelectedValue(null, false);
				}
			}
		});
		// 배우 정보 관련 이벤트
		fldSearchActor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (fldSearchActor.getText().equals("배우 이름 검색")) {
					fldSearchActor.setText(null);
				}
			}
		});
		// 스태프 정보 관련 이벤트
		fldSearchStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (fldSearchStaff.getText().equals("스태프 이름 검색")) {
					fldSearchStaff.setText(null);
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		dao = new MovieInfoDao();
		actorDao = new ActorDao();
		staffDao = new StaffInfoDao();
		// Search 버튼
		if (e.getSource() == btnMovieSearch) {

			if (fldSearchMovie.getText().equals("")) {
				System.out.println("영화이름을 입력해주세요");
				JOptionPane.showMessageDialog(null, "영화이름을 입력해주세요.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

			movieDtos.removeAllElements();

			Vector<MovieInfoDto> selectMoviTitleResult = dao.selectMovieTitle(fldSearchMovie.getText());

			for (int i = 0; i < selectMoviTitleResult.size(); i++) {
				movieDtos.add(selectMoviTitleResult.get(i));
			}

			movieInfoList.setListData(movieDtos);
			movieScrollPane.add(movieInfoList);

			movieInfoList.setSelectedValue(null, false);
		}

		// Search All 버튼
		else if (e.getSource() == btnAllMovieSearch) {

			movieDtos.removeAllElements();

			Vector<MovieInfoDto> selectAllMovieInfoResult = dao.selectAllMovieInfo();

			for (int i = 0; i < selectAllMovieInfoResult.size(); i++) {
				movieDtos.add(selectAllMovieInfoResult.get(i));
			}

			movieInfoList.setListData(movieDtos);
			movieScrollPane.add(movieInfoList);

			movieInfoList.setSelectedValue(null, false);
		} else if (e.getSource() == btnInsertMovie) {
			jtab.addTab("Moive", null, movieInfoPanel, null);
			jtab.setSelectedComponent(movieInfoPanel);
			movieInfoPanel.getBtnUpdateMovieInfo().setEnabled(false);
			movieInfoPanel.getBtnInsertMovieInfo().setEnabled(true);
		}

		// Update 버튼
		else if (e.getSource() == btnUpdateMovie) {

			if (movieInfoList.getSelectedValue() == null) {

				System.out.println("업데이트 항목을 선택해주세요");
				JOptionPane.showMessageDialog(null, "수정하려는 항목을 선택해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (movieInfoList.getSelectedValue() != null) {

				movieInfoPanel.getBtnUpdateMovieInfo().setEnabled(true);
				movieInfoPanel.getBtnInsertMovieInfo().setEnabled(false);

				MovieInfoDto dto = movieInfoList.getSelectedValue();

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

				movieInfoList.setSelectedValue(null, false);

				jtab.addTab("Movie", null, movieInfoPanel, null);
				jtab.setSelectedComponent(movieInfoPanel);

			}

		} else if (e.getSource() == btnDeleteMovie) {

			if (movieInfoList.getSelectedValue() == null) {

				System.out.println("삭제할 데이터가 없습니다.");
				JOptionPane.showMessageDialog(null, "삭제하려는 항목을 선택해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else {

				if (movieDtos.size() != 0) {

					boolean doubleCheck = dao.selectMovieDoubleCheck(movieInfoList.getSelectedValue().getMovieTitle(),
							movieInfoList.getSelectedValue().getDirectorName());

					if (!doubleCheck) {

						int deleteCheck = dao.deleteMovieInfo(movieInfoList.getSelectedValue().getMovieTitle(),
								movieInfoList.getSelectedValue().getDirectorName());

						if (deleteCheck == 1) {

							int index = movieInfoList.getSelectedIndex();
							movieDtos.remove(index);
							movieInfoList.ensureIndexIsVisible(index);
							movieInfoList.repaint();

							System.out.println("삭제완료");
							JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.", "INFORMATION",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						System.out.println("삭제할 데이터가 없습니다.");
						JOptionPane.showMessageDialog(null, "삭제하려는 정보가 존재하지 않습니다", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			movieInfoList.setSelectedValue(null, false);
		}

		// MovieInfoPanel - 영화정보 등록하기 버튼
		else if (e.getSource() == movieInfoPanel.getBtnInsertMovieInfo()) {

			// 패널에 있는 텍스트 필드에 전부 입력을 했는지 체크하는 과정

			if (movieInfoPanel.getFldMovieTitle() != null && movieInfoPanel.getFldDirectorName() != null
					&& movieInfoPanel.getFldTotalIncome() != null && movieInfoPanel.getFldAudience() != null
					&& movieInfoPanel.getFldRating() != null && movieInfoPanel.getFldReleaseYear() != null
					&& movieInfoPanel.getFldReleaseMonth() != null) {

				boolean doubleCheck = dao.selectMovieDoubleCheck(movieInfoPanel.getFldMovieTitle().getText(),
						movieInfoPanel.getFldDirectorName().getText());
				System.out.println(movieInfoPanel.getFldMovieTitle().getText());
				System.out.println(movieInfoPanel.getFldDirectorName().getText());

				// 중복이 아닐때 1
				if (doubleCheck) {

					MovieInfoDto dto = new MovieInfoDto();
					addDtoMovieInfo(dto);
					int insertCheck = dao.insertMovieInfo(dto);

					if (insertCheck == 1) {
						System.out.println("인설트 완료");
						JOptionPane.showMessageDialog(null, "추가가 정상적으로 완료되었습니다.", "ERROR",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						System.out.println("INSERT 오류");
						JOptionPane.showMessageDialog(null, "인설트가 정상적으로 처리되지 않았습니다.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					System.out.println("입력하신 감독의 영화정보가 이미 존재합니다.");
					JOptionPane.showMessageDialog(null, "입력하신 감독의 영화정보기 이미 존재합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				System.out.println("영화이름, 감독, 매출액, 관객수, 평점, 개뵹연도, 개봉월은 빈칸없이 입력해주세요");
				JOptionPane.showMessageDialog(null, "영화이름, 감독, 매출액, 관객수, 평점, 개뵹연도, 개봉월은 빈칸없이 입력해주세요", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		// MovieInfoPanel - 영화정보 수정하기 버튼
		else if (e.getSource() == movieInfoPanel.getBtnUpdateMovieInfo()) {

			if (movieInfoPanel.getFldMovieTitle() != null && movieInfoPanel.getFldDirectorName() != null
					&& movieInfoPanel.getFldTotalIncome() != null && movieInfoPanel.getFldAudience() != null
					&& movieInfoPanel.getFldRating() != null && movieInfoPanel.getFldReleaseYear() != null
					&& movieInfoPanel.getFldReleaseMonth() != null) {

				MovieInfoDto dto = new MovieInfoDto();
				addDtoMovieInfo(dto);
				int updateCheck = dao.updateMovieInfo(movieinfoNum, dto);

				if (updateCheck == 1) {

					System.out.println("업데이트 완료");
					JOptionPane.showMessageDialog(null, "업데이트가 정상적으로 완료되었습니다.", "INFORMATION",
							JOptionPane.INFORMATION_MESSAGE);
					resetMovieInfoTextField();

				} else {

					System.out.println("업데이트 오류");
					JOptionPane.showMessageDialog(null, "업데이트가 정상적으로 처리되지 않았습니다", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			} else {

				System.out.println("영화이름, 감독, 매출액, 관객수, 평점, 개뵹연도, 개봉월은 빈칸없이 입력해주세요");
				JOptionPane.showMessageDialog(null, "영화이름, 감독, 매출액, 관객수, 평점, 개뵹연도, 개봉월은 빈칸없이 입력해주세요", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnSearchActor) {

			vcActor.removeAllElements();

			Vector<ActorInfoDto> selectActorInfor = actorDao.selectActorInfor(fldSearchActor.getText());

			for (int i = 0; i < selectActorInfor.size(); i++) {
				vcActor.add(selectActorInfor.get(i));

			}

			actorjList.setListData(vcActor);
			actorScrollPane.add(actorjList);

			actorjList.setSelectedValue(null, false);

		}
		// Search All 버튼
		else if (e.getSource() == btnAllActorSearch) {

			vcActor.removeAllElements();

			Vector<ActorInfoDto> selectAllActorInfoResult = actorDao.selectAllActorInfor();

			for (int i = 0; i < selectAllActorInfoResult.size(); i++) {
				vcActor.add(selectAllActorInfoResult.get(i));
			}

			actorjList.setListData(vcActor);
			actorScrollPane.add(actorjList);

			actorjList.setSelectedValue(null, false);
		}
		if (e.getSource() == btnInsertActor) {
			jtab.addTab("Actor", null, actorInfoPanel, null);
			jtab.setSelectedComponent(actorInfoPanel);
			actorInfoPanel.getBtnUpdateActorInfo().setEnabled(false);
			actorInfoPanel.getBtnInsertActorInfo().setEnabled(true);

		}
		// MovieInfoPanel - 영화정보 등록하기 버튼
		else if (e.getSource() == actorInfoPanel.getBtnInsertActorInfo()) {

			Field[] atr = actorInfoPanel.getClass().getFields();

			// 패널에 있는 텍스트 필드에 전부 입력을 했는지 체크하는 과정
			if (atr.length != 7) {
				System.out.println("빈칸을 전부 입력해주세요");
				JOptionPane.showMessageDialog(null, "빈칸을 전부 입력해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else {

				boolean doubleCheck = actorDao.selectActorDoubleCheck(actorInfoPanel.getFldActorName().getText());

				// 중복이 아닐때 1
				if (doubleCheck) {

					ActorInfoDto dto = new ActorInfoDto();
					addDtoActorInfo(dto);
					actorDao.insertActorInfo(dto);

				} else {
					System.out.println("입력하신 감독의 영화정보기 이미 존재합니다.");
					JOptionPane.showMessageDialog(null, "입력하신 감독의 영화정보기 이미 존재합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		if (e.getSource() == btnDeleteActor) {

			if (actorjList.getSelectedValue() == null) {

				System.out.println("삭제할 데이터가 없습니다.");
				JOptionPane.showMessageDialog(null, "삭제하려는 항목을 선택해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else {

				if (vcActor.size() != 0) {

					boolean doubleCheck = actorDao.selectActorDoubleCheck(actorjList.getSelectedValue().getActorName());

					if (!doubleCheck) {

						int deleteCheck = actorDao.deleteActorInfo(actorjList.getSelectedValue().getPersonNum());

						if (deleteCheck == 1) {

							int index = actorjList.getSelectedIndex();
							vcActor.remove(index);
							actorjList.ensureIndexIsVisible(index);
							actorjList.repaint();

							System.out.println("삭제완료");
							JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.", "INFORMATION",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						System.out.println("삭제할 데이터가 없습니다.");
						JOptionPane.showMessageDialog(null, "삭제하려는 정보가 존재하지 않습니다", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			movieInfoList.setSelectedValue(null, false);
		}
		// Update 버튼
		if (e.getSource() == btnUpdateActor) {

			if (actorjList.getSelectedValue() == null) {

				System.out.println("업데이트 항목을 선택해주세요");
				JOptionPane.showMessageDialog(null, "수정하려는 항목을 선택해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (actorjList.getSelectedValue() != null) {

				actorInfoPanel.getBtnUpdateActorInfo().setEnabled(true);
				actorInfoPanel.getBtnInsertActorInfo().setEnabled(false);

				ActorInfoDto dto = actorjList.getSelectedValue();

				actorInfoPanel.getFldActorName().setText(dto.getActorName());
				actorInfoPanel.getFldActorRepresentativeMovie().setText(dto.getRepresentativeMovie());
				actorInfoPanel.getFldActorRepresentativeRole().setText(dto.getRepresentativeRole());
				actorInfoPanel.getFldActorBirthYear().setText(dto.getBirthYear());
				actorInfoPanel.getFldatorTall().setText(dto.getActorTall());
				actorInfoPanel.getFldActorWieght().setText(dto.getActorWeight());
				actorInfoPanel.getFldActorMarriagePartner().setText(dto.getMarriagePartner());

				actcorNum = dto.getPersonNum();

				jtab.addTab("Actor", null, actorInfoPanel, null);
				jtab.setSelectedComponent(actorInfoPanel);

			}

		}
		// ActorInfoPanel - 영화정보 수정하기 버튼
		else if (e.getSource() == actorInfoPanel.getBtnUpdateActorInfo()) {

			ActorInfoDto dto = new ActorInfoDto();
			addDtoActorInfo(dto);
			int updateCheck = actorDao.updateActorInfo(actcorNum, dto);

			if (updateCheck == 1) {

				System.out.println("업데이트 완료");
				JOptionPane.showMessageDialog(null, "업데이트가 완료되었습니다.", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);

			} else {
				// 여기로 바로들어간다 이말이지.
				System.out.println("업데이트 오류");
				JOptionPane.showMessageDialog(null, "업데이트가 정상적으로 처리되지 않았습니다", "ERROR", JOptionPane.ERROR_MESSAGE);

			}

			resetActorInfoTextField();

		}
		if (e.getSource() == btnSearchStaff) {

			vcStaff.removeAllElements();

			Vector<StaffInfoDto> selectDirectorNameResult = staffDao.selectDirectorName(fldSearchStaff.getText());

			for (int i = 0; i < selectDirectorNameResult.size(); i++) {
				vcStaff.add(selectDirectorNameResult.get(i));
			}

			staffJlist.setListData(vcStaff);
			staffScrollPane.add(staffJlist);

			staffJlist.setSelectedValue(null, false);

		}

		else if (e.getSource() == btnAllStaffSearch) {

			vcStaff.removeAllElements();

			Vector<StaffInfoDto> selectAllStaffInfoResult = staffDao.selectAllStaffInfo();

			for (int i = 0; i < selectAllStaffInfoResult.size(); i++) {
				vcStaff.add(selectAllStaffInfoResult.get(i));
			}

			staffJlist.setListData(vcStaff);
			staffScrollPane.add(staffJlist);

			staffJlist.setSelectedValue(null, false);
		}
		// Insert 버튼
		else if (e.getSource() == btnInsertStaff) {

			resetMovieInfoTextField();

			staffInfoPanel.getBtnInsertStaffInfo().setEnabled(true);
			staffInfoPanel.getBtnUpdateStaffInfo().setEnabled(false);

			jtab.addTab("insert", null, staffInfoPanel, null);
			jtab.setSelectedComponent(staffInfoPanel);

			staffJlist.setSelectedValue(null, false);

		}
		if (e.getSource() == btnUpdateStaff) {

			if (staffJlist.getSelectedValue() == null) {

				System.out.println("업데이트 항목을 선택해주세요");
				JOptionPane.showMessageDialog(null, "수정하려는 항목을 선택해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (staffJlist.getSelectedValue() != null) {

				staffInfoPanel.getBtnUpdateStaffInfo().setEnabled(true);
				staffInfoPanel.getBtnInsertStaffInfo().setEnabled(false);

				StaffInfoDto dto = staffJlist.getSelectedValue();

				staffInfoPanel.getFldDirectorName().setText(dto.getDirectorName());
				staffInfoPanel.getFldGender().setText(dto.getGender());
				staffInfoPanel.getFldBirthYear().setText(dto.getBirthYear() + "");
				staffInfoPanel.getFldMarriagePartner().setText(dto.getMarriagePartner());
				staffInfoPanel.getFldRepresentativeWork().setText(dto.getRepresentativeWork());
				staffinfoNum = dto.getStaffNum();
				personInfoNum = dto.getPersonNum();

				staffJlist.setSelectedValue(null, false);

				jtab.addTab("update", null, staffInfoPanel, null);
				jtab.setSelectedComponent(staffInfoPanel);

			}

		}
		if (e.getSource() == btnDeleteStaff) {

			if (staffJlist.getSelectedValue() == null) {

				System.out.println("삭제할 데이터가 없습니다.");
				JOptionPane.showMessageDialog(null, "삭제하려는 항목을 선택해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else {

				if (vcStaff.size() != 0) {
					boolean doubleCheck = staffDao.selectStaffInfoDoubleCheck(
							staffJlist.getSelectedValue().getDirectorName(),
							staffJlist.getSelectedValue().getBirthYear());

					if (!doubleCheck) {

						int deleteCheck = staffDao.deleteStaffInfo(staffJlist.getSelectedValue().getStaffNum());

						System.out.println(deleteCheck);

						System.out.println("deleteCheck");
						int index = staffJlist.getSelectedIndex();
						vcStaff.remove(index);
						staffJlist.ensureIndexIsVisible(index);
						staffJlist.repaint();

						System.out.println("삭제완료");
						JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.", "INFORMATION",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					System.out.println("삭제할 데이터가 없습니다.");
					JOptionPane.showMessageDialog(null, "삭제하려는 정보가 존재하지 않습니다", "ERROR", JOptionPane.ERROR_MESSAGE);

				}
			}
		}
		if (e.getSource() == staffInfoPanel.getBtnInsertStaffInfo()) {

//			Field[] atr = staffInfoPanel.getClass().getFields();
//			if (atr.length <= 6) {
			String a = staffInfoPanel.getFldBirthYear().getText();
			String b = staffInfoPanel.getFldDirectorName().getText();
			String c = staffInfoPanel.getFldGender().getText();
			String d = staffInfoPanel.getFldMarriagePartner().getText();
			String f = staffInfoPanel.getFldRepresentativeWork().getText();

			if (a == null || b == null || c == null || d == null || f == null) {

				System.out.println("빈칸을 전부 입력해주세요");
				JOptionPane.showMessageDialog(null, "빈칸을 전부 입력해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				// true면 존재하는 정보 없음
				boolean doubleCheck = staffDao.selectStaffInfoDoubleCheck(staffInfoPanel.getFldDirectorName().getText(),
						Integer.parseInt(staffInfoPanel.getFldBirthYear().getText()));
				System.out.println("ddd");
				System.out.println(doubleCheck);

				if (doubleCheck) {

					StaffInfoDto dto = new StaffInfoDto();
					addDtoStaffInfo(dto);
					staffDao.insertStaffInfo(dto);

				} else {
					System.out.println("입력하신 감독정보가 이미 존재합니다.");
					JOptionPane.showMessageDialog(null, "입력하신 감독정보가 이미 존재합니다.", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (e.getSource() == staffInfoPanel.getBtnUpdateStaffInfo()) {
//			Field[] atr = staffInfoPanel.getClass().getFields();
//			if (atr.length <= 6) {
			String a = staffInfoPanel.getFldBirthYear().getText();
			String b = staffInfoPanel.getFldDirectorName().getText();
			String c = staffInfoPanel.getFldGender().getText();
			String d = staffInfoPanel.getFldMarriagePartner().getText();
			String f = staffInfoPanel.getFldRepresentativeWork().getText();

			if (a == null || b == null || c == null || d == null || f == null) {
				System.out.println("빈칸을 전부 입력해주세요");
				JOptionPane.showMessageDialog(null, "빈칸을 전부 입력해주세요", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else {

				StaffInfoDto dto = new StaffInfoDto();
				addDtoStaffInfo(dto);
				int updateCheck = -1;

				updateCheck = staffDao.updateStaffInfo(staffinfoNum, dto);
				System.out.println("updateCheck : " + updateCheck);
				if (updateCheck == 1) {

					System.out.println("업데이트 완료");
					JOptionPane.showMessageDialog(null, "업데이트가 완료되었습니다.", "INFORMATION",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					System.out.println("업데이트 오류");
					JOptionPane.showMessageDialog(null, "업데이트가 정상적으로 처리되지 않았습니다", "ERROR", JOptionPane.ERROR_MESSAGE);

				}

			}

			resetStaffInfoTextField();
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

	private void addDtoActorInfo(ActorInfoDto dto) {

		dto.setActorNum(actorjList.getSelectedValue().getActorNum());
		dto.setActorName(actorInfoPanel.getFldActorName().getText());
		dto.setRepresentativeMovie(actorInfoPanel.getFldActorRepresentativeMovie().getText());
		dto.setRepresentativeRole(actorInfoPanel.getFldActorRepresentativeRole().getText());
		dto.setBirthYear(actorInfoPanel.getFldActorBirthYear().getText());
		dto.setActorTall(actorInfoPanel.getFldatorTall().getText());
		dto.setActorWeight(actorInfoPanel.getFldActorWieght().getText());
		dto.setMarriagePartner(actorInfoPanel.getFldActorMarriagePartner().getText());
		actorjList.setSelectedValue(null, false);
	}

	// staffInfo 정보를 Dto로 밀어 넣는 메소드 ( insert, update 에서 사용 )
	private void addDtoStaffInfo(StaffInfoDto dto) {
		dto.setStaffNum(staffinfoNum);
		dto.setPersonNum(personInfoNum);
		dto.setDirectorName(staffInfoPanel.getFldDirectorName().getText());
		dto.setGender(staffInfoPanel.getFldGender().getText());
		dto.setBirthYear(Integer.parseInt(staffInfoPanel.getFldBirthYear().getText()));
		dto.setRepresentativeWork(staffInfoPanel.getFldRepresentativeWork().getText());
		dto.setMarriagePartner(staffInfoPanel.getFldMarriagePartner().getText());
	}

	private void resetMovieInfoTextField() {
		movieInfoPanel.getFldMovieTitle().setText("");
		movieInfoPanel.getFldDirectorName().setText("");

		movieInfoPanel.getFldTotalIncome().setText("");
		movieInfoPanel.getFldAudience().setText("");
		movieInfoPanel.getFldRating().setText("");

		movieInfoPanel.getFldReleaseYear().setText("");
		movieInfoPanel.getFldReleaseMonth().setText("");

		movieInfoPanel.getFldMoviePlot().setText("");
		movieInfoPanel.getFldReview1().setText("");
		movieInfoPanel.getFldReview2().setText("");
		movieInfoPanel.getFldReview3().setText("");
	}

	private void resetStaffInfoTextField() {

		staffInfoPanel.getFldDirectorName().setText("");
		staffInfoPanel.getFldGender().setText("");
		staffInfoPanel.getFldBirthYear().setText("");
		staffInfoPanel.getFldRepresentativeWork().setText("");
		staffInfoPanel.getFldMarriagePartner().setText("");
	}

	private void resetActorInfoTextField() {
		actorInfoPanel.getFldActorName().setText("");
		actorInfoPanel.getFldActorRepresentativeMovie().setText("");
		actorInfoPanel.getFldActorRepresentativeRole().setText("");
		actorInfoPanel.getFldActorBirthYear().setText("");
		actorInfoPanel.getFldatorTall().setText("");
		actorInfoPanel.getFldActorWieght().setText("");
		actorInfoPanel.getFldActorMarriagePartner().setText("");
	}

	public static void main(String[] args) {
		new MovieFrame();

	}
}
