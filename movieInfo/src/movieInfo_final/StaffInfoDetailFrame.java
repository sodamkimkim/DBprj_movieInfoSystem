package movieInfo_final;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StaffInfoDetailFrame {
	private JFrame frame;
	private JTextField directorName;
	private JTextField representativeWork;
	private JTextField gender;
	private JTextField birthYear;
	private JTextField marriagePartner;
	
	public StaffInfoDetailFrame(StaffInfoDto dto) {
		initData(dto);
	}

	private void initData(StaffInfoDto dto) {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 520);
		frame.getContentPane().setLayout(null);
		frame.setTitle("스태프정보 상세보기");

		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 473, 461);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel lbldirectorName = new JLabel("스태프이름");
		lbldirectorName.setBounds(61, 34, 150, 15);
		mainPanel.add(lbldirectorName);

		directorName = new JTextField();
		directorName.setBounds(61, 54, 127, 21);
		directorName.setText(dto.getDirectorName ());
		mainPanel.add(directorName);
		directorName.setColumns(10);

		JLabel lblrepresentativeWork = new JLabel("대표작품");
		lblrepresentativeWork.setBounds(61, 84, 52, 15);
		mainPanel.add(lblrepresentativeWork);

		representativeWork = new JTextField();
		representativeWork.setBounds(61, 104, 127, 21);
		representativeWork.setText(dto.getRepresentativeWork());
		mainPanel.add(representativeWork);
		representativeWork.setColumns(10);

		JLabel lblgender = new JLabel("성별");
		lblgender.setBounds(61, 134, 52, 15);
		mainPanel.add(lblgender);

		gender = new JTextField();
		gender.setBounds(61, 154, 127, 21);
		gender.setText(dto.getGender());
		mainPanel.add(gender);
		gender.setColumns(10);

		JLabel lblbirthYear = new JLabel("출생년도");
		lblbirthYear.setBounds(61, 184, 52, 15);
		mainPanel.add(lblbirthYear);

		birthYear = new JTextField();
		birthYear.setBounds(61, 204, 303, 21);
		birthYear.setText(Integer.toString(dto.getBirthYear()));
		mainPanel.add(birthYear);
		birthYear.setColumns(10);

		JLabel lblmarriagePartner = new JLabel("배우자");
		lblmarriagePartner.setBounds(61, 234, 52, 15);
		mainPanel.add(lblmarriagePartner);

		marriagePartner = new JTextField();
		marriagePartner.setColumns(10);
		marriagePartner.setBounds(61, 254, 303, 21);
		marriagePartner.setText(dto.getMarriagePartner());
		mainPanel.add(marriagePartner);

		frame.setVisible(true);
	}
}
