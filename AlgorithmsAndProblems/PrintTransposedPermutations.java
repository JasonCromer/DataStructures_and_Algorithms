import java.util.Arrays;

class PrintTransposedPermutations{
	
	public static void main(String[] args){
		String[] start = "ACADBB123";
		String[] desired = "DC1BA32BA";
	}

	public static void printTranspositions(String start, String desired){
		String temp;
		int size = desired.length();
		int j, i = 0;

		while(n > i){
			j = i;
			System.out.println(Arrays.toString(start));

			while(start[j] != desired[i]){
				j++;
			}

			while(j > i){
				temp = start[j];
				start[j] = start[j-1];
				start[j-1] = temp;

				System.out.println(Arrays.toString(start));
				j--;
			}

			i++;
		}
	}
}