//A recursive binary search (using arrays in this example)
//The function recSearch returns the index at which the dataKey is in


class RecursiveBinarySearch {

	public static void main(String[] args){
		int[] myArray = {1,3,4,5,7,8,11,15,17,23,26,28,35,47,58};
		int result = recSearch(1, 0, myArray.length, myArray);
		System.out.println(""+result);
	}

	public static int recSearch(int dataKey, int lowerBound, int upperBound, int[] array){
		int median = (lowerBound + upperBound) / 2;

		if(array[median] == dataKey){
			return median;
		}
		else if(lowerBound > upperBound){
			return -1;
		}
		else{
			//Search the upper half
			if(array[median] < dataKey){
				return recSearch(dataKey, median+1, upperBound, array);
			}
			//Search lower half
			else{
				return recSearch(dataKey, lowerBound, median-1, array);
			}
		}
	}
}