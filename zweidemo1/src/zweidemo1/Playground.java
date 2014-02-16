package zweidemo1;

import javax.swing.JFrame;

public class Playground extends JFrame {

	final int HEIGTH, WIDTH, FIELD_SIZE = 16;
	boolean[] validField;

	public static void main(String[] args) {
		Playground frame = new Playground(64, 32);
	}

	Playground(int width, int height) {
		HEIGTH = height;
		WIDTH = width;
		validField = new boolean[HEIGTH * WIDTH];
		
		for(int i=0; i<validField.length; i++) {
			if(Math.random()<0.2)
				validField[i]=false;
			else
				validField[i]=true;
		}
		printFieldToConsole(validField);
		
		this.setResizable(false);
		this.setBounds(100, 50, WIDTH*FIELD_SIZE, HEIGTH*FIELD_SIZE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void printFieldToConsole(boolean[] field) {
		for(int i=0; i<field.length; i++) {
			if(field[i])
				System.out.print(".");
			else
				System.out.print("#");
			if(i%WIDTH==WIDTH-1)
				System.out.println();
		}
	}

}
