package movieInfo;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class MovieInfoDetailFrame {

	private JFrame frame;
	private JTextField fldMovieTitle;
	private JTextField fldMovieDirector;
	private JTextField fldReview1;
	private JTextField fldReview2;
	private JTextField fldReview3;

	public MovieInfoDetailFrame(MovieInfoDto dto) {
		initData(dto);
	}

	private void initData(MovieInfoDto dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 520);
		frame.getContentPane().setLayout(null);
		frame.setTitle("영화정보 상세보기");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 473, 461);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JTextArea moviePlotTextArea = new JTextArea();
		moviePlotTextArea.setBounds(81, 131, 303, 152);
		moviePlotTextArea.setLineWrap(true);	// 자동 줄바꿈
		moviePlotTextArea.setText(dto.getMoviePlot());
		
		JLabel lblMovieTitle = new JLabel("영화이름");
		lblMovieTitle.setBounds(81, 31, 53, 15);
		mainPanel.add(lblMovieTitle);
		
		JLabel lblMoviDirector = new JLabel("감독");
		lblMoviDirector.setBounds(256, 31, 52, 15);
		mainPanel.add(lblMoviDirector);
		
		JLabel lblMoviePlot = new JLabel("줄거리");
		lblMoviePlot.setBounds(81, 87, 52, 15);
		mainPanel.add(lblMoviePlot);
		
		fldMovieTitle = new JTextField();
		fldMovieTitle.setBounds(81, 54, 127, 21);
		fldMovieTitle.setText(dto.getMovieTitle());
		mainPanel.add(fldMovieTitle);
		fldMovieTitle.setColumns(10);
		
		fldMovieDirector = new JTextField();
		fldMovieDirector.setBounds(252, 54, 127, 21);
		fldMovieDirector.setText(dto.getDirectorName());
		mainPanel.add(fldMovieDirector);
		fldMovieDirector.setColumns(10);
		
		JLabel lblReview1 = new JLabel("리뷰1");
		lblReview1.setBounds(81, 285, 52, 15);
		mainPanel.add(lblReview1);
		
		JLabel lblReview1_1 = new JLabel("리뷰2");
		lblReview1_1.setBounds(81, 338, 52, 15);
		mainPanel.add(lblReview1_1);
		
		JLabel lblReview1_1_1 = new JLabel("리뷰3");
		lblReview1_1_1.setBounds(81, 394, 52, 15);
		mainPanel.add(lblReview1_1_1);
		
		fldReview1 = new JTextField();
		fldReview1.setBounds(81, 307, 303, 21);
		fldReview1.setText(dto.getReview1());
		mainPanel.add(fldReview1);
		fldReview1.setColumns(10);
		
		fldReview2 = new JTextField();
		fldReview2.setColumns(10);
		fldReview2.setBounds(81, 363, 303, 21);
		fldReview2.setText(dto.getReview2());
		mainPanel.add(fldReview2);
		
		fldReview3 = new JTextField();
		fldReview3.setColumns(10);
		fldReview3.setBounds(81, 419, 303, 21);
		fldReview3.setText(dto.getReview3());
		mainPanel.add(fldReview3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 112, 303, 152);
		scrollPane.setBorder(new LineBorder(Color.BLACK, 2));
		scrollPane.setViewportView(moviePlotTextArea);
		mainPanel.add(scrollPane);
		
		frame.setVisible(true);
	}
}
