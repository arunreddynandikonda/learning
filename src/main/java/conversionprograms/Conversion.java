package conversionprograms;

import java.util.ArrayList;
import java.util.List;

public class Conversion {

	public static void main(String[] args) {
		Conversion c = new Conversion();
//		c.booleanToString();
//		c.stringToBoolean();
//		c.intToChar(); 
//		c.charToInt();
//		c.charToString();
//		c.longToInt();
//		c.intToLong();
//		c.stringToInt();
//		c.intToString();
//		c.stringTodouble();
//		c.doubleToString();
//		c.stringToLong();
//		c.longToString();
//		c.names();
		c.numbers();
		c.prices();
	}

	public void booleanToString() {
		String name = "akhil";
		Boolean b = Boolean.parseBoolean(name);
		System.out.println(b);
	}

	public void stringToBoolean() {
		boolean b = true;
//		String str = String.valueOf(b);
		String str = Boolean.toString(b);
		System.out.println(str);
	}

	public void intToChar() {
		int a = 70;
		char ch = (char) a;
		System.out.println(ch);
	}

	public void charToInt() {
		char ch = 'A';
		int a = (int) ch;
		System.out.println(a);
	}

	public void charToString() {
		char ch = 'A';
		String str = String.valueOf(ch);
		System.out.println(str);
	}

	public void longToInt() {
		long l = 3434;
		int i = (int) l;
		System.out.println(i);
	}

	public void intToLong() {
		int i = 100;
		long l = (long) i;
		System.out.println(l);
	}

	public void stringToInt() {
		String str = "7542";
		int i = Integer.parseInt(str);
		System.out.println(i);
	}

	public void intToString() {
		int i = 100;
		String str = String.valueOf(i);
		System.out.println(str);
	}

	public void stringTodouble() {
		String str = "7542";
		double d = Double.parseDouble(str);
		System.out.println(d);
	}

	public void doubleToString() {
		double d = 9494436;
		String str = String.valueOf(d);
		System.out.println(str);
	}

	public void stringToLong() {
		String str = "7542";
		long l = Long.parseLong(str);
		System.out.println(l);
	}

	public void longToString() {
		long l = 94944360;
		String str = String.valueOf(l);
		System.out.println(str);
	}

	public void names() {

//		int ch = 3;

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

//		switch (ch) {
//
//		case 1:
//			for (String familyName : familyNames) {
//				familyName = familyName.replace(".", " ");
//				System.out.println(familyName);
//			}
//			break;
//
//		case 2:
//			for (String familyName : familyNames) {
//				String name = familyName.replaceAll(familyName, "arun");
//				System.out.println(name);
//			}
//			break;
//
//		case 3:
//			for (String familyName : familyNames) {
//				String[] name = familyName.split(".");
//				String newName = name[0];
//				System.out.println(newName);
//			}
//			break;
//
//		case 4:
//			for (String familyName : familyNames) {
//				String name = familyName.toLowerCase();
//				System.out.println(name);
//			}
//			break;
//
//		case 5:
//			for (String familyName : familyNames) {
//				int name = familyName.length();
//				System.out.println(name);
//			}
//			break;
//
//		case 6:
//			for (String familyName : familyNames) {
//				boolean name = familyName.isEmpty();
//				System.out.println(name);
//			}
//			break;
//
//		case 7:
//			for (String familyName : familyNames) {
//				boolean name = familyName.contains("Nandikonda");
//				System.out.println(name);
//			}
//			break;
//
//		case 8:
//			for (String familyName : familyNames) {
//				String name = familyName.replace('N', 'Z');
//				System.out.println(name);
//			}
//			break;
//
//		case 9:
//			for (String familyName : familyNames) {
//				String name = familyName.toUpperCase();
//				System.out.println(name);
//			}
//			break;
//		}
	}

	public void numbers() {

		List<Integer> nums = new ArrayList<Integer>();

		nums.add(1234);
		nums.add(5678);
		nums.add(90);
		nums.add(3435);
		nums.add(24233);

		List<String> values = new ArrayList<String>();
		for (Integer num : nums) {
			values.add(String.valueOf(num));
		}

		for (String value : values) {
			if (value.contains("3")) {
				System.out.println("The String contain value 3");
			} else {
				System.out.println("The String doesn't contain value 3");
			}
		}

//		System.out.println(values);
	}

	public void prices() {

		List<String> priceElements = new ArrayList<String>();

		priceElements.add("10,30,243");
		priceElements.add("23,34,243");
		priceElements.add("4,32,343");
		priceElements.add("34,53,243");
		priceElements.add("3,10,243");
		priceElements.add("31,10,323");
		priceElements.add("60,10,243");
		priceElements.add("86,10,324");
		priceElements.add("74,10,245");
		priceElements.add("90,10,329");

		List<Integer> prices = new ArrayList<Integer>();
		for (String priceElement : priceElements) {
			priceElement = priceElement.replace(",", "");
			prices.add(Integer.parseInt(priceElement));
		}

		for (Integer price : prices) {
			if (price >= 1000000) {
				System.out.println("The number is greaterthan 10lakhs");
			} else {
				System.out.println("The number is leesthan 10lakhs");
			}
//			System.out.println(price);
		}
	}

}
