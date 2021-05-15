package javaPrograms;

public class Sorting {

	public static void main(String[] args) {

		int[] numbers = { 4, 23, 8, 67, 1 };
		Sorting s = new Sorting();
		s.bubbleSort(numbers);
		for (int number : numbers) {
			System.out.println(number);
		}

	}

	public void bubbleSort(int[] numbers) {

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] < numbers[j + 1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

}
