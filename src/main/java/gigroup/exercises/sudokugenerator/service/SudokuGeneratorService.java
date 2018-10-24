package gigroup.exercises.sudokugenerator.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SudokuGeneratorService {

	private static final int max = 8;
	private static final int min = 0;

	private static final int digitMax = 9;
	private static final int digitMin = 1;

	public int[][] generate() {

		final int[][] grid = new int[9][9];

		final Difficulty option = Difficulty.MEDIUM;

		final Random random = new Random();

		int row = 0;
		int col = 0;

		int randomNumber = 0;
		int noOfCellsToBeGenerated = 0;

		if (Difficulty.EASY.equals(option)) {
			noOfCellsToBeGenerated = random.nextInt((Difficulty.EASY.max - Difficulty.EASY.min) + 1)
					+ Difficulty.EASY.min;
		} else if (Difficulty.MEDIUM.equals(option)) {
			noOfCellsToBeGenerated = random.nextInt((Difficulty.MEDIUM.max - Difficulty.MEDIUM.min) + 1)
					+ Difficulty.MEDIUM.min;
		} else {
			noOfCellsToBeGenerated = random.nextInt((Difficulty.HARD.max - Difficulty.HARD.min) + 1)
					+ Difficulty.HARD.min;
		}

		for (int i = 1; i <= noOfCellsToBeGenerated; i++) {
			row = random.nextInt((max - min) + 1) + min;
			col = random.nextInt((max - min) + 1) + min;
			randomNumber = random.nextInt((digitMax - digitMin) + 1) + digitMin;

			if ((grid[row][col] == 0) && checkValue(grid, row, col, randomNumber)) {
				grid[row][col] = randomNumber;
			} else {
				i--;
			}

		}

		return grid;

	}

	public boolean checkValue(final int[][] array, final int row, final int col, final int num) {

		for (int i = 0; i < 9; i++) {
			if (array[row][i] == num) {
				return false;
			}
			if (array[i][col] == num) {
				return false;
			}
		}

		final int gridRow = row - (row % 3);
		final int gridColumn = col - (col % 3);
		for (int p = gridRow; p < (gridRow + 3); p++) {
			for (int q = gridColumn; q < (gridColumn + 3); q++) {
				if (array[p][q] == num) {
					return false;
				}
			}
		}
		return true;
	}

	enum Difficulty {
		EASY(36, 49), MEDIUM(32, 35), HARD(22, 27);

		private final int min;
		private final int max;

		Difficulty(final int min, final int max) {
			this.min = min;
			this.max = max;
		}

		public int getMinimum() {
			return min;
		}

		public int getMaximum() {
			return max;
		}
	}

}