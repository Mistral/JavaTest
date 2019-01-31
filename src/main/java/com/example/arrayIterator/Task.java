package com.example.arrayIterator;

public class Task {

	public ArrayIterator<Integer> getIterator(int[][] arr) {
		return new ArrayIterator<Integer>() {

			private int column = 0;

			private int row = 0;

			@Override
			public boolean hasNext() {
				return isIndexInExistRow() && isIndexInExistColumn();
			}

			@Override
			public Integer next() {
				int value;

				if (isIndexInExistRow()) {
					value = arr[row][column];
					if (isLastColumn()) {
						moveIndexToNextRow();
					}
					else {
						moveIndexToNextColumn();
					}
				}
				else {
					throw new IllegalStateException("Iterator out of bounds");
				}

				return value;
			}

			private boolean isIndexInExistColumn() {
				return column < arr[row].length;
			}

			private boolean isIndexInExistRow() {
				return row < arr.length;
			}

			private void moveIndexToNextColumn() {
				column++;
			}

			private void moveIndexToNextRow() {
				row++;
				column = 0;
			}

			private boolean isLastColumn() {
				return column == arr[row].length - 1;
			}
		};
	}

}