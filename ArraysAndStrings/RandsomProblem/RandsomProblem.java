//Randsom Problem


class Main {

	public static void main(String[] args){
		String magazine = "This is a magazine that has a lot of different letters";
		String note = "He is mine";
		boolean isPossible = isNotePossible(note.toLowerCase(), magazine.toLowerCase());
		System.out.println(String.valueOf(isPossible));
	}


	public static boolean isNotePossible(String note, String magazine) {

		int[] containsLetters = new int[256];

		for(int i = 0; i < magazine.length(); i++){
			int val = (int) (magazine.charAt(i));
			containsLetters[val]++;
		}

		for(int j = 0; j < note.length(); j++){
			int val = (int) (note.charAt(j));
			containsLetters[val]--;
			if(containsLetters[val] < 0){
				return false;
			}
		}
		return true;
	}



}