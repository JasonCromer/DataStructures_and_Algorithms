//Binary search for an array



Class Main {
	
	public static void main(String[] args){
		int[] myArray = new int[256];
		for(i = 0; i < myArray.length; i++){
			myArray[i] = i;
		}

		binarySearch(myArray, 35); //should return the int 34

	}


	public static int binarySearch(int[] array, int value){
		int median;
		int lowerbound = 0;
		int upperbound = array.length - 1

		while(lowerbound < upperbound){
			median = (lowerbound + upperbound) / 2;

			if(value == array[median]){
				return array.indexOf(median)
			}
			else{
				if(value < array[median]){
					upperBound = median - 1;
				}
				else if(value > array[median]){
					lowerBound = median + 1;
				}
			}
		}
		return -1;
	}

}