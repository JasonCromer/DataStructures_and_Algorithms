class Main {
	public static void main(String[] args) {
		String helloString = args[0];
		System.out.println(isUnique(helloString));
	}

	public static boolean isUnique(String s) {
		boolean[] charSet = new boolean[256];
		for(int i = 0; i < s.length(); i++){
			int val = s.charAt(i);
			if(charSet[val]){
				System.out.println("Found duplicate. Duplicate Letter: " + Character.toString((char) val));
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}
}