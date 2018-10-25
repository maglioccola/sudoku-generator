package gigroup.exercises.sudokugenerator.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Params {

	private int[][] matrix;
	private int row;
	private int col;
	private int num;

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(final int[][] matrix) {
		this.matrix = matrix;
	}

	public int getRow() {
		return row;
	}

	public void setRow(final int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(final int col) {
		this.col = col;
	}

	public int getNum() {
		return num;
	}

	public void setNum(final int num) {
		this.num = num;
	}
}
