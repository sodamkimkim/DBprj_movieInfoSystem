package movieInfo_final;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lombok.Data;

@Data
public class MovieInfoPanel extends JPanel {

	private JTextField fldMovieTitle;
	private JTextField fldDirectorName;
	private JTextArea fldMoviePlot;	// 줄거리
	private JTextField fldTotalIncome;	// 매출액
	private JTextField fldAudience;	// 관객수
	private JTextField fldRating;	// 영화평점
	private JTextField fldReview1;
	private JTextField fldReview2;
	private JTextField fldReview3;
	private JTextField fldReleaseYear; 
	private JTextField fldReleaseMonth; 

	private JLabel lblMovieTitle;
	private JLabel lblDirectorName;
	private JLabel lblMoviePlot;	// 줄거리
	private JLabel lblTotalIncome;	// 매출액
	private JLabel lblAudience;	// 관객수
	private JLabel lblRating;	// 영화평점
	private JLabel lblReview1;
	private JLabel lblReview2;
	private JLabel lblReview3;
	private JLabel lblReleaseYear; 
	private JLabel lblReleaseMonth;

	private JButton btnInsertMovieInfo;
	private JButton btnUpdateMovieInfo;

	public MovieInfoPanel() {
		initObject();
		initSetting();
	}

	private void initObject() {
		fldMovieTitle = new JTextField();
		fldDirectorName = new JTextField();
		fldMoviePlot = new JTextArea();
		fldTotalIncome = new JTextField();
		fldAudience = new JTextField();
		fldRating = new JTextField();
		fldReview1 = new JTextField();
		fldReview2 = new JTextField();
		fldReview3 = new JTextField();
		fldReleaseYear = new JTextField();
		fldReleaseMonth = new JTextField();

		lblMovieTitle = new JLabel("영화이름");
		lblDirectorName = new JLabel("감독");
		lblMoviePlot = new JLabel("줄거리");
		lblTotalIncome = new JLabel("매출액");
		lblAudience = new JLabel("관객수");
		lblRating = new JLabel("평점");
		lblReview1 = new JLabel("리뷰1");
		lblReview2 = new JLabel("리뷰2");
		lblReview3 = new JLabel("리뷰3");
		lblReleaseYear = new JLabel("개봉연도");
		lblReleaseMonth = new JLabel("개봉월");

		btnInsertMovieInfo = new JButton("영화정보 추가하기");
		btnUpdateMovieInfo = new JButton("영화정보 수정하기");
	}

	private void initSetting() {
		// 프레임 관련 세팅
		setSize(getWidth(), getHeight());
		setLayout(null);

		lblMovieTitle.setBounds(130, 80, 50, 20);
		fldMovieTitle.setBounds(130, 100, 250, 25);

		lblDirectorName.setBounds(420, 80, 50, 20);
		fldDirectorName.setBounds(420, 100, 250, 25);

		lblTotalIncome.setBounds(130, 150, 50, 20);
		fldTotalIncome.setBounds(130, 170, 250, 25);

		lblAudience.setBounds(130, 220, 50, 20);
		fldAudience.setBounds(130, 240, 250, 25);
		
		lblRating.setBounds(130, 290, 50, 20);
		fldRating.setBounds(130, 310, 250, 25);
		
		lblReleaseYear.setBounds(420, 150, 50, 20);
		fldReleaseYear.setBounds(420, 170, 250, 25);
		
		lblReleaseMonth.setBounds(420, 220, 50, 20);
		fldReleaseMonth.setBounds(420, 240, 250, 25);
		
		lblMoviePlot.setBounds(130, 360, 50, 20);
		fldMoviePlot.setBounds(130, 380, 540, 125);
		fldMoviePlot.setLineWrap(true);
		
		lblReview1.setBounds(130, 535, 50, 20);
		fldReview1.setBounds(130, 555, 540, 25);
		
		lblReview2.setBounds(130, 605, 50, 20);
		fldReview2.setBounds(130, 625, 540, 25);
		
		lblReview3.setBounds(130, 675, 50, 20);
		fldReview3.setBounds(130, 695, 540, 25);
		
		btnInsertMovieInfo.setBounds(400, 30, 140, 30);
		btnInsertMovieInfo.setBackground(Color.WHITE);
		btnUpdateMovieInfo.setBounds(560, 30, 140, 30);
		btnUpdateMovieInfo.setBackground(Color.WHITE);

		add(fldMovieTitle);
		add(fldDirectorName);
		add(fldMoviePlot);
		add(fldTotalIncome);
		add(fldAudience);
		add(fldRating);
		add(fldReview1);
		add(fldReview2);
		add(fldReview3);
		add(fldReleaseYear);
		add(fldReleaseMonth);
		
		add(lblMovieTitle);
		add(lblDirectorName);
		add(lblMoviePlot);
		add(lblTotalIncome);
		add(lblAudience);
		add(lblRating);
		add(lblReview1);
		add(lblReview2);
		add(lblReview3);
		add(lblReleaseYear);
		add(lblReleaseMonth);
		
		add(btnInsertMovieInfo);
		add(btnUpdateMovieInfo);
	}
}
