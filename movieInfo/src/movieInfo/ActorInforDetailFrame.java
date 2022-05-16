package movieInfo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActorInforDetailFrame {
	private JFrame frame;
	private JTextField fldActorName;
	private JTextField fldActorBirthYear;
	private JTextField fldrepresentativeMovie;
	private JTextField fldrepresentativeRole;
	private JTextField fldActorTall;
	private JTextField fldActorWeight;
	private JTextField fldActormarriagePartner;

	public ActorInforDetailFrame(ActorInfoDto dto) {
		initData(dto);
	}

	private void initData(ActorInfoDto dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 520);
		frame.getContentPane().setLayout(null);
		frame.setTitle("배우정보 상세보기");

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 473, 461);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel actorName = new JLabel("배우이름");
		actorName.setBounds(61, 34, 53, 15);
		mainPanel.add(actorName);

		fldActorName = new JTextField();
		fldActorName.setBounds(61, 54, 127, 21);
		fldActorName.setText(dto.getActorName());
		mainPanel.add(fldActorName);
		fldActorName.setColumns(10);

		JLabel actorBirthYear = new JLabel("출생연도");
		actorBirthYear.setBounds(61, 84, 52, 15);
		mainPanel.add(actorBirthYear);

		fldActorBirthYear = new JTextField();
		fldActorBirthYear.setBounds(61, 104, 127, 21);
		fldActorBirthYear.setText(dto.getBirthYear());
		mainPanel.add(fldActorBirthYear);
		fldActorBirthYear.setColumns(10);

		JLabel representativeMovie = new JLabel("대표작품");
		representativeMovie.setBounds(61, 134, 52, 15);
		mainPanel.add(representativeMovie);

		fldrepresentativeMovie = new JTextField();
		fldrepresentativeMovie.setBounds(61, 154, 127, 21);
		fldrepresentativeMovie.setText(dto.getRepresentativeMovie());
		mainPanel.add(fldrepresentativeMovie);
		fldrepresentativeMovie.setColumns(10);

		JLabel representativeRole = new JLabel("대표역할");
		representativeRole.setBounds(61, 184, 52, 15);
		mainPanel.add(representativeRole);

		fldrepresentativeRole = new JTextField();
		fldrepresentativeRole.setBounds(61, 204, 303, 21);
		fldrepresentativeRole.setText(dto.getRepresentativeRole());
		mainPanel.add(fldrepresentativeRole);
		fldrepresentativeRole.setColumns(10);

		JLabel actorTall = new JLabel("키");
		actorTall.setBounds(61, 234, 52, 15);
		mainPanel.add(actorTall);

		fldActorTall = new JTextField();
		fldActorTall.setColumns(10);
		fldActorTall.setBounds(61, 254, 303, 21);
		fldActorTall.setText(dto.getActorTall());
		mainPanel.add(fldActorTall);

		JLabel actorWeight = new JLabel("몸무게");
		actorWeight.setBounds(61, 284, 52, 15);
		mainPanel.add(actorWeight);

		fldActorWeight = new JTextField();
		fldActorWeight.setColumns(10);
		fldActorWeight.setBounds(61, 304, 303, 21);
		fldActorWeight.setText(dto.getActorWeight());
		mainPanel.add(fldActorWeight);

		JLabel marriagePartner = new JLabel("배우자");
		marriagePartner.setBounds(61, 334, 52, 15);
		mainPanel.add(marriagePartner);

		fldActormarriagePartner = new JTextField();
		fldActormarriagePartner.setColumns(10);
		fldActormarriagePartner.setBounds(61, 354, 303, 21);
		fldActormarriagePartner.setText(dto.getMarriagePartner());
		mainPanel.add(fldActormarriagePartner);

		frame.setVisible(true);
	}
}
