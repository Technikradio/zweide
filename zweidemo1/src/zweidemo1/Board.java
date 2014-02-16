package zweidemo1;

public class Board {
	final int HEIGHT, WIDTH, FIELD_SIZE = 16;
	boolean[] validField;

	Board(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		validField = new boolean[HEIGHT * WIDTH];
		makeRandom();
	}

	void makeRandom() {
		for (int i = 0; i < validField.length; i++) {
			if (Math.random() < 0.2)
				validField[i] = false;
			else
				validField[i] = true;
		}
		printFieldToConsole(validField);
	}

	private void printFieldToConsole(boolean[] field) {
		for (int i = 0; i < field.length; i++) {
			if (field[i])
				System.out.print(".");
			else
				System.out.print("#");
			if (i % WIDTH == WIDTH - 1)
				System.out.println();
		}
	}
}
