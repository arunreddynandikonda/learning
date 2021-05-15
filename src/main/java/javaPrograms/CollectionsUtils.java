package javaPrograms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsUtils {

	public static void main(String args[]) {
		CollectionsUtils c = new CollectionsUtils(); 
		c.collectionsList();
		c.collectionsSet();
//		c.collectionsMap();
		c.collectionsHashTable();

	}

	public void collectionsList() {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(1);
		numbers.add(4);
		numbers.add(1);
		numbers.add(6);
		numbers.add(1);

		Iterator<Integer> num = numbers.iterator();

		while (num.hasNext()) {
			System.out.println(num.next());
		}

//		System.out.println(num.next());
//		System.out.println(num.next());
//		System.out.println(num.next());
//		System.out.println(num.next());
//		System.out.println(num.next());
	}
	/* for(Integer number : numbers) { System.out.println(number); } */

	public void collectionsSet() {

		Set<Integer> numbers2 = new HashSet<Integer>();
		numbers2.add(2);
		numbers2.add(1);
		numbers2.add(4);
		numbers2.add(1);
		numbers2.add(6);
		numbers2.add(1);

		Iterator<Integer> num = numbers2.iterator();
		while (num.hasNext()) {
			System.out.println(num.next());
		}
		/* for(Integer number : numbers2) { System.out.println(number); } */
	}
	// list --- set

	// Map(Hashtable -- hashmap)

	public void collectionsHashTable() {
		Map<String, String> flightDetails = new Hashtable<String, String>();
		flightDetails.put("Origin", "Hyderabad");
		flightDetails.put("Destination", "Goa");
		flightDetails.put("StartDate", "21-Apr-2021");

		System.out.println(flightDetails.values());

	}

	public void collectionsMap() {
		Map<String, ArrayList<String>> details = new Hashtable<String, ArrayList<String>>();
		ArrayList<String> hal = new ArrayList<String>();
		hal.add("aloo");

		details.put("Haldirams", hal);

	}

	List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>();

}
