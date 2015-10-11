import java.util.*;


//Assume you have a method isSubstring that checks if one word is a substring of another. Given
//Two string, s1 and s2, wrote code to check if s2 is a rotation of s1 using only one call to
//isSubstring


class Main {

	public static void main(String[] args){
		isRotation("apple", "pleap");
	}

	public static boolean isRotation(String s1, String s2){
		int len = s1.length();

		if(len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
}