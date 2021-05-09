package conversionprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;

//import java.util.Arrays;
//import java.util.List;

public class ListExapmles {

	public static void main(String args[]) {

		ListExapmles le = new ListExapmles();
		le.runningSum();
		le.twoSum();
		le.elementavailabilityTest();
		le.duplicateElementTest();
		le.alphabetsSort();
		le.integerSort();
		le.sum();

//		Integer[] input = { 1, 2, 3, 4 };

//		List<Integer> numbers = Arrays.asList(numbersArray);
//		
//		for(Integer number : numbers) {
//			System.out.println(number);
//		}

		// find duplicate
		// remove duplicate
		// sort
		// find if an element exists

	}

	public void runningSum() {

		int[] a = { 1, 2, 3, 4 };
		int[] b = { 0, 0, 0, 0, };

		b[0] = b[0] + a[0];
		b[1] = b[1] + a[0] + a[1];
		b[2] = b[2] + a[0] + a[1] + a[2];
		b[3] = b[3] + a[0] + a[1] + a[2] + a[3];

		for (int i : b) {
			System.out.print((i));
			System.out.print((","));
			System.out.print((" "));
		}

	}

	public void twoSum() {

		int[] input = { 2, 7, 11, 15 };
		int target = 9;

		if (target == input[0] + input[1]) {
			System.out.println("0,1");
		} else if (target == input[0] + input[2]) {
			System.out.println("0,2");
		} else if (target == input[0] + input[3]) {
			System.out.println("0,3");
		}

	}

	public void elementavailabilityTest() {

		List<String> familyNames = new ArrayList<String>();

		familyNames.add("Nandikonda.KondalReddy");
		familyNames.add("Nandikonda.Bhulakshmi");
		familyNames.add("Nandikonda.PrabhakarReddy");
		familyNames.add("Nandikonda.Vasantha");
		familyNames.add("Nandikonda.SrinivasReddy");
		familyNames.add("Nandikonda.Swarupa");
		familyNames.add("Nandikonda.BhoopathiReddy");
		familyNames.add("Nandikonda.Sunitha");
		familyNames.add("Nandikonda.AnjiReddy");
		familyNames.add("Nandikonda.Roja");
		Assert.assertFalse( familyNames.contains("Nandikonda.ArunReddy"));
		int expected = 10;
		int actual = 11;

		Assert.assertEquals( expected, actual);

	}

	public void duplicateElementTest() {

		List<String> familyNames = new ArrayList<String>();

		familyNames.add("Nandikonda.KondalReddy");
		familyNames.add("Nandikonda.Bhulakshmi");
		familyNames.add("Nandikonda.PrabhakarReddy");
		familyNames.add("Nandikonda.Vasantha");
		familyNames.add("Nandikonda.SrinivasReddy");
		familyNames.add("Nandikonda.Swarupa");
		familyNames.add("Nandikonda.BhoopathiReddy");
		familyNames.add("Nandikonda.BhoopathiReddy");
		familyNames.add("Nandikonda.Sunitha");
		familyNames.add("Nandikonda.AnjiReddy");
		familyNames.add("Nandikonda.Roja");

	}

	public void alphabetsSort() {

		List<String> familyNames = new ArrayList<String>();

		familyNames.add("Nandikonda.KondalReddy");
		familyNames.add("Nandikonda.Bhulakshmi");
		familyNames.add("Nandikonda.PrabhakarReddy");
		familyNames.add("Nandikonda.Vasantha");
		familyNames.add("Nandikonda.SrinivasReddy");
		familyNames.add("Nandikonda.Swarupa");
		familyNames.add("Nandikonda.BhoopathiReddy");
		familyNames.add("Nandikonda.BhoopathiReddy");
		familyNames.add("Nandikonda.Sunitha");
		familyNames.add("Nandikonda.AnjiReddy");
		familyNames.add("Nandikonda.Roja");

		Collections.sort(familyNames);
		System.out.println(familyNames);

		Collections.sort(familyNames, Collections.reverseOrder());
		System.out.println(familyNames);
	}

	public void integerSort() {

		List<Integer> ages = new ArrayList<Integer>();
		ages.add(1996);
		ages.add(1993);
		ages.add(1994);
		ages.add(1990);
		ages.add(1992);
		ages.add(1986);
		ages.add(1996);
		ages.add(1984);
		ages.add(1998);

		Collections.sort(ages);
		System.out.println(ages);

		Collections.sort(ages, Collections.reverseOrder());
		System.out.println(ages);

	}

	public void sum() {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(1);

		int total = 0;
		for (int number : numbers) {
			total = total + number;
		}
		System.out.println(total);
	}

}