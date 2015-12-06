/*
This is a variation of Knights Tour, known as Knights Dialer, where you are given a 
phone pad layed out like so:

1  2  3
4  5  6
7  8  9
*  0  #

Given a Knight object from the game Chess, you are to figure out a way that the 
Knight can move on all numbers except the * and #, without repeating numbers.

The original Knights Tour problem uses a full N*N or N*M chess board, with the 
same concept.

*/



public class KnightsTour {

	private static final int N = 4;
	private static final int M = 3;
	private static final int MAX_MOVES = 7;
	private static int sol[][];
	private int count = 0;
	private int checked = 0;
	private int tried = 0;
		
	public static void main(String[] args){
		KnightsTour kt = new KnightsTour();
		kt.solveKT();
	}


	public KnightsTour(){
		sol = new int[N][M];
	}


	//Utility function to check if i,j are valid indexes for N*N chessboard
	private boolean isSafe(int x, int y){
		if(x == 3 && (y == 0 || y == 2)){
			return false;
		}
		if(x >= 0 && x < N && y >= 0 && y < M && sol[x][y] == -1){
			return true;
		}
		else{
			return false;
		}
	}


	//Utility function to print solution matrix
	private void printSolution(){
		for(int x = 0; x < N; x++){
			for(int y = 0; y < M; y++){
				System.out.print(sol[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println("Checked " + checked + " different moves");
		System.out.println("Tried " + tried + " different moves");
		System.out.println("Done in " + count + " moves");
	}


	/*
		This function solves the problem by Backtracking using the solveKTUtil() function.
		It returns false if there is no complete tour possible, else, it returns true and
		prints one of the solutions.
	*/
	public boolean solveKT(){

		//initialize the solution matrix
		for(int x = 0; x < N; x++){
			for(int y = 0; y < M; y++){
				sol[x][y] = -1;
			}
		}

		//define the moves the knight can make
		int xMove[] = {2,1,-1,-2,-2,-1,1,2};
		int yMove[] = {1,2,2,1,-1,-2,-2,-1};

		//Start our knight at the first block
		sol[2][1] = 0;

		//Start from 0,0 and try all tours using solveKTUtil()
		if(!solveKTUtil(2,1,1,xMove,yMove)){
			System.out.println("Solution doesn't exist");
			return false;
		}
		else{
			printSolution();
		}

		return true;
	}


	//Recursive function to solve the tours
	private boolean solveKTUtil(int x, int y, int moveI, 
								int xMove[], int yMove[]){

		int k, nextX, nextY;
		if(moveI == MAX_MOVES){
			return true;
		}

		//Try all next moves from current coordinate
		for(k = 0; k < 8; k++){
			nextX = x + xMove[k];
			nextY = y + yMove[k];
			checked++;
			if(isSafe(nextX, nextY)){
				sol[nextX][nextY] = moveI;
				tried++;
				if(solveKTUtil(nextX, nextY, moveI + 1,
								xMove, yMove)){
					count++;
					return true;
				}
				else{
					sol[nextX][nextY] = -1; //backtracking
				}
			}
		}

		return false;
	}


}