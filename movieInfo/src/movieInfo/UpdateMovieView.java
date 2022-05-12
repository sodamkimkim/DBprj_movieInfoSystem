package movieInfo;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dto.MovieDto;

class A {
	
}

public class UpdateMovieView extends JFrame {

	private JLabel jLabel;
	A a;
	
	public UpdateMovieView() {
		initDate();
		initSetLayout();
	}
	
	public void click() {
		a = new A();
		
	}

	private void initDate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(null);
		setVisible(true);
		jLabel.setSize(200, 200);
		jLabel.setLocation(100, 100);

	}

	private void initSetLayout() {
		add(jLabel);

	}
	
	

	public static void main(String[] args) {
		new UpdateMovieView();
	}
}
