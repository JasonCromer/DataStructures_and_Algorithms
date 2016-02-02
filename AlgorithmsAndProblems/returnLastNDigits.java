import java.io.*;
import java.util.*;

public class returnLastNDigits{

	public static void main(String[] args){

		String myString = "Hello, I am a nice, long string type.";

		String answer = returnLastTenDigits(myString);

		System.out.println(answer);
	}

	private static String returnLastTenDigits(String input){
		int length = input.length();

		String substring = input.substring(length - 10);

		return substring;
	}
}