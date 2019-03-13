
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ToyStore {
	private ArrayList<Toy> toyList;

	public ToyStore() {
	}

	public ToyStore(String toys) {
		loadToys(toys);
	}

	public void loadToys(String toys) {
		toyList = new ArrayList<>();
		HashMap<String, Integer> amount = new HashMap<>();
		for (String s : toys.split("\\s+")) {
			if(amount.containsKey(s)) {
				amount.put(s, new Integer(amount.get(s).intValue() + 1));
			} 
			else {
				amount.put(s, new Integer(1));
			}
		}
		
		for(String s : amount.keySet()) {
			toyList.add(new Toy(s, amount.get(s)));
		}
	}

	public Toy getThatToy(String nm) {
		for (Toy toy : toyList) {
			if(toy.getName().equals(nm)) {
				return toy;
			}
		}
		throw new RuntimeException("Toy Not Found");
	}
	
	public String getMostFrequentToy() {
		int most = Integer.MIN_VALUE;
		String mostWord = "";
		for (Toy toy : toyList) {
			if(toy.getCount() > most) {
				most = toy.getCount();
				mostWord = toy.getName();
			}
		}
		return mostWord;
	}

	public void sortToysByCount() {
		toyList = (ArrayList<Toy>) toyList.stream().sorted(Comparator.comparing((Toy::getCount))).collect(Collectors.toList());
	}

	public String toString() {
		String output = "[";
		for (Toy toy : toyList) {
			output = output + toy.getName() + " " + toy.getCount() + ", ";
		}
		return output.substring(0,output.length()-2) + "]";
	}
}
