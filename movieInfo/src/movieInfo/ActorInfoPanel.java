package movieInfo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Data;

@Data
public class ActorInfoPanel extends JPanel {
	private JTextField fldActorRepresentativeMovie; // 대표영화
	private JTextField fldActorRepresentativeRole; 	// 대표역할
	private JTextField fldActorName; 				// 배우이름
	private JTextField fldActorBirthYear; 			// 출생연도
	private JTextField fldatorTall; 				// 키
	private JTextField fldActorWieght; 				// 몸무게
	private JTextField fldActorMarriagePartner; 	// 배우자
	private JTextField fldActorGender; 				// 주민등록성별

	private JLabel lblActorRepresentativeMovie;		// 대표영화
	private JLabel lblActorRepresentativeRole; 		// 대표역할
	private JLabel lblActorName; 					// 배우이름
	private JLabel lblatorTall; 					// 키
	private JLabel lblActorWieght; 					// 몸무게
	private JLabel lblActorBirthYear; 				// 출생연도
	private JLabel lblActorMarriagePartner; 		// 배우자
	private JLabel lblActorGender; 					// 주민등록성별

	private JButton btnInsertActorInfo;
	private JButton btnUpdateActorInfo;

	public ActorInfoPanel() {
		initObject();
		initSetting();
		setVisible(true);
	}

	private void initObject() {
		fldActorRepresentativeMovie = new JTextField();
		fldActorRepresentativeRole = new JTextField();
		fldActorName = new JTextField();
		fldActorBirthYear = new JTextField();
		fldActorMarriagePartner = new JTextField();
		fldatorTall = new JTextField();
		fldActorWieght = new JTextField();
		fldActorGender = new JTextField();

		lblActorRepresentativeMovie = new JLabel("대표영화");
		lblActorRepresentativeRole = new JLabel("대표역할");
		lblActorName = new JLabel("배우이름");
		lblActorBirthYear = new JLabel("출생연도");
		lblActorMarriagePartner = new JLabel("배우자");
		lblatorTall = new JLabel("키");
		lblActorWieght = new JLabel("몸무게");
		lblActorGender = new JLabel("주민등록성별");

		btnInsertActorInfo = new JButton("배우정보 추가하기");
		btnUpdateActorInfo = new JButton("배우정보 수정하기");

	}

	private void initSetting() {
		setSize(getWidth(), getHeight());
		setLayout(null);

		lblActorName.setBounds(130, 80, 50, 20);					// 배우이름
		fldActorName.setBounds(130, 100, 250, 25);					// 배우이름

		lblActorBirthYear.setBounds(420, 80, 50, 20); 				// 출생연도
		fldActorBirthYear.setBounds(420, 100, 250, 25); 			// 출생연도
		
		lblActorRepresentativeMovie.setBounds(130, 150, 50, 20); 	// 대표작품
		fldActorRepresentativeMovie.setBounds(130, 170, 250, 25); 	// 대표작품
		
		lblActorRepresentativeRole.setBounds(420, 150, 50, 20); 	// 대표역할
		fldActorRepresentativeRole.setBounds(420, 170, 250, 25); 	// 대표역할
		
		lblatorTall.setBounds(130, 220, 50, 20);					// 키
		fldatorTall.setBounds(130, 240, 250, 25);					// 키
		
		lblActorWieght.setBounds(420, 220, 50, 20);					// 몸무게
		fldActorWieght.setBounds(420, 240, 250, 25);				// 몸무게
		
		lblActorGender.setBounds(420, 290, 80, 20);					// 주민등록성별
		fldActorGender.setBounds(420, 310, 250, 25);				// 주민등록성별
		
		lblActorMarriagePartner.setBounds(130, 290, 50, 20); 		// 배우자
		fldActorMarriagePartner.setBounds(130, 310, 250, 25); 		// 배우자
		
		btnInsertActorInfo.setBounds(420, 30, 140, 30);				// 추가버튼
		btnInsertActorInfo.setBackground(Color.WHITE);
		btnUpdateActorInfo.setBounds(580, 30, 140, 30);				// 수정버튼
		btnUpdateActorInfo.setBackground(Color.WHITE);
		
		add(fldActorRepresentativeMovie);
		add(fldActorRepresentativeRole);
		add(fldActorName);
		add(fldActorBirthYear);
		add(fldActorMarriagePartner);
		add(fldatorTall);
		add(fldActorWieght);
		add(fldActorGender);
		
		add(lblActorRepresentativeMovie);
		add(lblActorRepresentativeRole);
		add(lblActorName);
		add(lblActorBirthYear);
		add(lblActorMarriagePartner);
		add(lblatorTall);
		add(lblActorWieght);
		add(lblActorGender);

		add(btnInsertActorInfo);
		add(btnUpdateActorInfo);

	}
}
