/*
	Write a method that reverses an integer. No extra buffers or space allowed.
	Return 0 for Integer-overflow case
*/



public class ReverseInteger{

	public static void main(String[] args){
		int reversed = reverse(124243245);

		System.out.println(reversed);
	}

	public static int reverse(int num){
		long rev = 0;

		while(num != 0){
			rev = rev*10 + num%10;
			num = num/10;

			if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE){
				return 0;
			}
		}

		if(num < 0){
			return (int) -rev;
		}
		else{
			return (int) rev;
		}
	}
}