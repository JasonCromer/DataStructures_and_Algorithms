/*
	Solve the triangular numbers problem using recursion (1,3,6,10..).
	Write some function, say solveTriangle, that returns the nth number in the series.
	Example:
		input: n = 5
		output: 15
*/


class TriangularNumbers {

	public static void main(String[] args){
		int nthNumber = 5;
		solveTriangle(nthNumber);
	}

	private static int solveTriangle(int n ){
		if(n == 1){
			return 1;
		}
		else{
			return(n + solveTriangle(n-1));
		}
	}
}