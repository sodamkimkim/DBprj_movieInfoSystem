package movieInfo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdatePanel extends InsertPanel {

	public UpdatePanel(CallBack callBack) {
		super(callBack);
		getButton1().setText("수정하기");
		getButton1().addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				setData1(getInputData1().getText());
				setData2(getInputData2().getText());
				setData3(getInputData3().getText());
				setData4(getInputData4().getText());
				setData5(getInputData5().getText());
				callBack.update(getData1(), getData2(), getData3(), getData4(), getData5());
			}
		});
	}
	
}
