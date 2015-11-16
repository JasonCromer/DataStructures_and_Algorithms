


class Permutations{
	
	public static void main(String[] args){
		permutateString("", "Hello");

	}

	public static void permutateString(String start, String end){
		if(end.length() <= 1){
			System.out.println(start + end);
		}
		else{
			for(int i = 0; i < end.length(); i++){

				String newString = end.substring(0,i) + end.substring(i+1);

				permutateString(start + end.charAt(i), newString);
			}
		}
	}
}