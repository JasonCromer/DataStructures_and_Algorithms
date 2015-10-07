import java.util.*;

/*
	Design an algorithm to remove the duplicate characters in a string without using any additional buffer.
	One or two additional variables are fine, but an extra copy of the array is not.
*/

class Main {
	
	public static void main(String[] args){
		String myString = "asdfnsdfnsdfksdf";
		removeDuplicateChars(myString);
	}



	public static void removeDuplicateChars(String str){
		//Convert string to char array (we could always use str.charAt as well)
		char[] chars = str.toCharArray();

		if (chars == null) return;
		if(chars.length < 2) return;

		//Using a HashSet only enters non-duplicates. Making it linked retains the order
		Set<Character> charSet = new LinkedHashSet<Character>();
		for(char c : chars){
			charSet.add(c);
		}


		//Print out the non-duplicates
		Iterator<Character> itr = charSet.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}