package javaPrograms;

import java.util.HashSet;
import java.util.Set;

public class JavaPrograms {

	public static void main(String[] args) {

		JavaPrograms jp = new JavaPrograms();
//		jp.fibonacciSeries_1();
//		jp.oneDimensionalArray_2();
//		jp.twoDimensionalArray_3();
//		jp.primeNumberChecker_4();
//		jp.printingPrimeNumbers_5();
//		jp.armStrongNumber_6();
//		jp.factorial();
//		jp.reverseString();
//		jp.duplicateNumbers();
//		jp.pyramidPattern();
//		jp.duplicateCharecters();
		jp.gcd();
	}

	public void fibonacciSeries_1() {
		int seriesUpTo = 20;
		int num1 = 0, num2 = 1, fibonacci = 1;
		for (int i = 3; i <= seriesUpTo; i++) {
			fibonacci = num1 + num2;
			num1 = num2;
			num2 = fibonacci;
			System.out.print(fibonacci);
			System.out.print(",");
		}
	}

	public void oneDimensionalArray_2() {

		int total = 0;
		int[] numbers = { 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int number : numbers) {
			total = total + number;
//			System.out.println(number);
		}
		System.out.println(total);
	}

	public void twoDimensionalArray_3() {

		int total = 0;
		int[][] numbers = { { 5, 6, 7 }, { 1, 8, 8 }, { 5, 3, 4 } };

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				total = total + numbers[i][j];
//				System.out.println(numbers[i][j]);
			}
		}
		System.out.println(total);
	}

	public void primeNumberChecker_4() {

		int numberToBeChecked = 97;
		int temp = 0;
		for (int i = 2; i < numberToBeChecked; i++) {
			if (numberToBeChecked % i == 0) {
				temp = temp + 1;
			}
		}
		if (temp < 1) {
			System.out.println("The given number " + numberToBeChecked + " is a prime number");
		} else {
			System.out.println("The given number " + numberToBeChecked + " is not a prime number");
		}
	}

	public void printingPrimeNumbers_5() {

		int number = 100;
		int temp = 0;
		for (int i = 1; i <= number; i++) {
			for (int j = 2; j < i - 1; j++) {
				if (i % j == 0) {
					temp = temp + 1;
				}
			}
			if (temp == 0) {
				System.out.print(i);
				System.out.print(",");
				System.out.print(" ");
			} else {
				temp = 0;
			}
		}
	}

	public void armStrongNumber_6() {

		int number = 153;

		int t1 = number;
		int count = 0;
		while (t1 != 0) {
			t1 = t1 / 10;
			count++;
		}

		int t2 = number;
		int arm = 0;
		while (t2 != 0) {
			int mul = 1;
			int rem = t2 % 10;
			for (int i = 0; i < count; i++) {
				mul = mul * rem;
			}
			arm = arm + mul;
			t2 = t2 / 10;
		}

		if (arm == number) {
			System.out.println(" The given number is Armstrong number");
		} else {
			System.out.println(" The given number is not an Armstrong number");
		}

	}

	public void factorial() {

		int number = 14;
		int result = 1;
		while (number != 0) {
			result = result * number;
			number--;
		}
		System.out.println(result);
	}

	public void reverseString() {

		String name = "arun";
		String reversed = "";
		for (int i = name.length() - 1; i >= 0; i--) {
			reversed = reversed + name.charAt(i);
		}
		System.out.println(reversed);
	}

	public void duplicateNumbers() {

		Set<Integer> numbers = new HashSet<Integer>();
		numbers.add(2);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);

		for (Integer number : numbers) {
			System.out.println(number);
		}
	}

	public void pyramidPattern() {

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void duplicateCharecters() {
//		TODO
		String name = "nandikonda";
		for (int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
		}
	}

	public void gcd() {
//		TODO
		int a = 90;
		int b = 70; 
		int c = a % b;
		if (b % c == 0) {
			System.out.println(c);
		} 

	}

}
