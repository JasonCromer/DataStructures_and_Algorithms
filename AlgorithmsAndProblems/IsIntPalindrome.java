
/* This algorithm returns true if the inputted integer is a palindrome,
	and false if not.
*/


class IsIntPalindrome {

	public static void main(String[] args){
		int number = 12321;
		boolean palindrome = isPalindrome(number);
		System.out.println(palindrome);
	}

	public static boolean isPalindrome(int n){
		//Negative numbers can't be palindromes
		if(n < 0){
			return false;
		}

		//Initiliaze amount of zero's the number should contain
		int divider = 1;
		while(n / divider >= 10){
			divider *= 10;
		}

		while(n != 0){
			int left = n / divider;
			int right = n % 10;

			if(left != right){
				return false;
			}

			n = (n % divider) / 10;
			divider /= 100;
		}

		return true;
	}

}