import java.util.*;
import java.lang.*;
import java.io.*;

/*Parse through the matrix by each row and column, then decrement them as you
  spiral around. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[][] matrix = {{1,2},{3,4}};
		System.out.println("" +solution(matrix));
	}
	
	public static List<Integer> solution(int[][] matrix){
		
        List<Integer> items = new ArrayList<>();
        
        if(matrix == null || matrix.length == 0){
            return items;
        }
        int topRow = 0;
        int bottomRow = matrix.length-1;
        int leftCol = 0;
        int rightCol = matrix[0].length-1;
        
        
        while(topRow <= bottomRow && leftCol <= rightCol){
            
            if(bottomRow == 0){
                for(int i = leftCol; i < rightCol+1; i++){
                	System.out.println("value:" + matrix[topRow][i]);
                    items.add(matrix[topRow][i]);
                }
                System.out.println("Returning #1");
                return items;
            }
            else if(rightCol == 0){
                for(int i = topRow; i < bottomRow+1; i++){
                    items.add(matrix[i][rightCol]);
                }
                System.out.println("Returning #2");
                return items;
            }
            
            //Top row
            for(int i = leftCol; i <= rightCol; i++){
                items.add(matrix[topRow][i]);
            }
            topRow++;
            
            //Right col
            for(int i = topRow; i <= bottomRow; i++){
                items.add(matrix[i][rightCol]);
            }
            rightCol--;
            
            //bottom row
            if(topRow <= bottomRow){
                for(int i = rightCol; i <= leftCol; i--){
                    items.add(matrix[bottomRow][i]);
                }
                bottomRow--;   
            }
            
            //left col
            if(leftCol <= rightCol){
                for(int i = bottomRow; i <= topRow; i--){
                    items.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }
        System.out.println("Returning #3");
        return items;
	}
}
