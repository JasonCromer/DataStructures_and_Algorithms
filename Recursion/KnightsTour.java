



public class KnightsTour {

	private static final int N = 8;
	private static int sol[][];
	
	public static void main(String[] args){
		KnightsTour kt = new KnightsTour();
		kt.solveKT();
	}


	public KnightsTour(){
		sol = new int[N][N];
	}


	//Utility function to check if i,j are valid indexes for N*N chessboard
	private boolean isSafe(int x, int y){
		if(x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1){
			return true;
		}
		else{
			return false;
		}
	}


	//Utility function to print solution matrix
	private void printSolution(){
		for(int x = 0; x < N; x++){
			for(int y = 0; y < N; y++){
				System.out.print(sol[x][y] + " ");
			}
			System.out.println();
		}
	}


	/*
		This function solves the problem by Backtracking using the solveKTUtil() function.
		It returns false if there is no complete tour possible, else, it returns true and
		prints one of the solutions.
	*/
	public boolean solveKT(){

		//initialize the solution matrix
		for(int x = 0; x < N; x++){
			for(int y = 0; y < N; y++){
				sol[x][y] = -1;
			}
		}

		//define the moves the knight can make
		int xMove[] = {2,1,-1,-2,-2,-1,1,2};
		int yMove[] = {1,2,2,1,-1,-2,-2,-1};

		//Start our knight at the first block
		sol[0][0] = 0;

		//Start from 0,0 and try all tours using solveKTUtil()
		if(!solveKTUtil(0,0,1,xMove,yMove)){
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
		if(moveI == N * N){
			return true;
		}

		//Try all next moves from current coordinate
		for(k = 0; k < 8; k++){
			nextX = x + xMove[k];
			nextY = y + yMove[k];
			if(isSafe(nextX, nextY)){
				sol[nextX][nextY] = moveI;
				if(solveKTUtil(nextX, nextY, moveI + 1,
								xMove, yMove)){
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