package movieInfo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Data;

@Data
public class StaffInfoPanel extends JPanel {
	private JTextField fldDirectorName;
	private JTextField fldGender; // 성별
	private JTextField fldBirthYear; // 출생년도
	private JTextField fldRepresentativeWork; // 대표작
	private JTextField fldMarriagePartner; // 배우자

	private JLabel lblDirectorName;
	private JLabel lblGender; // 성별
	private JLabel lblBirthYear; // 출생년도
	private JLabel lblRepresentativeWork; // 대표작
	private JLabel lblMarriagePartner; // 배우자

	private JButton btnInsertStaffInfo;
	private JButton btnUpdateStaffInfo;

	public StaffInfoPanel() {
		initObject();
		initSetting();
		setVisible(true);
	}

	private void initObject() {
		fldDirectorName = new JTextField();
		fldGender = new JTextField();
		fldBirthYear = new JTextField();
		fldRepresentativeWork = new JTextField();
		fldMarriagePartner = new JTextField();

		lblDirectorName = new JLabel("감독이름");
		lblGender = new JLabel("성별");
		lblBirthYear = new JLabel("출생년도");
		lblRepresentativeWork = new JLabel("대표작");
		lblMarriagePartner = new JLabel("배우자");

		btnInsertStaffInfo = new JButton("staff정보 추가하기");
		btnUpdateStaffInfo = new JButton("staff정보 수정하기");

	}

	private void initSetting() {
		setSize(getWidth(), getHeight());
		setLayout(null);

		lblDirectorName.setBounds(130, 80, 50, 20);
		fldDirectorName.setBounds(130, 100, 250, 25);

		lblGender.setBounds(420, 80, 50, 20); // 성별
		fldGender.setBounds(420, 100, 250, 25); // 성별

		lblBirthYear.setBounds(130, 150, 50, 20); // 출생년도
		fldBirthYear.setBounds(130, 170, 250, 25); // 출생년도

		lblRepresentativeWork.setBounds(420, 150, 50, 20); // 대표작
		fldRepresentativeWork.setBounds(420, 170, 250, 25); // 대표작

		lblMarriagePartner.setBounds(130, 220, 50, 20); // 배우자
		fldMarriagePartner.setBounds(130, 240, 250, 25); // 배우자

		btnInsertStaffInfo.setBounds(400, 30, 140, 30);
		btnUpdateStaffInfo.setBounds(560, 30, 140, 30);

		add(fldDirectorName);
		add(fldGender);
		add(fldBirthYear);
		add(fldRepresentativeWork);
		add(fldMarriagePartner);

		add(lblDirectorName);
		add(lblGender);
		add(lblBirthYear);
		add(lblRepresentativeWork);
		add(lblMarriagePartner);

		add(btnInsertStaffInfo);
		add(btnUpdateStaffInfo);

	}

}
