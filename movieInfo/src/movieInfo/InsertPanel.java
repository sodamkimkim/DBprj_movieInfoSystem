package movieInfo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Data;

@Data
public class InsertPanel extends JPanel {

	private JTextField inputData1;
	private JTextField inputData2;
	private JTextField inputData3;
	private JTextField inputData4;
	private JTextField inputData5;

	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;

	private JButton button1;


	public InsertPanel() {
		initObject();
		initSetting();
	}

	private void initObject() {
		inputData1 = new JTextField();
		inputData2 = new JTextField();
		inputData3 = new JTextField();
		inputData4 = new JTextField();
		inputData5 = new JTextField();

		label1 = new JLabel("영화이름");
		label2 = new JLabel("영화번호");
		label3 = new JLabel("개봉날짜");
		label4 = new JLabel("감독");
		label5 = new JLabel("배우");

		button1 = new JButton("추가하기");
	}

	private void initSetting() {
		// 프레임 관련 세팅
		setSize(getWidth(), getHeight());
		setLayout(null);

		label1.setBounds(50, 30, 50, 20);
		inputData1.setBounds(50, 50, 300, 30);

		label2.setBounds(50, 80, 50, 20);
		inputData2.setBounds(50, 100, 300, 30);

		label3.setBounds(50, 130, 50, 20);
		inputData3.setBounds(50, 150, 300, 30);

		label4.setBounds(50, 180, 50, 20);
		inputData4.setBounds(50, 200, 300, 30);

		label5.setBounds(50, 230, 50, 20);
		inputData5.setBounds(50, 250, 300, 30);

		button1.setBounds(380, 50, 90, 30);

		add(inputData1);
		add(inputData2);
		add(inputData3);
		add(inputData4);
		add(inputData5);
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(button1);

	}
}
