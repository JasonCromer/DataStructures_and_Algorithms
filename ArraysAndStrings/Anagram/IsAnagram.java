import java.util.*;


//Determine if one string is an anagram of another


class Main {

	public static void main(String[] args){
		boolean isAnagram = anagram("some", "emos");
		System.out.println(String.valueOf(isAnagram));
	}

	public static boolean anagram(String s, String t) {
		return sort(s) == sort(t);
	}
}