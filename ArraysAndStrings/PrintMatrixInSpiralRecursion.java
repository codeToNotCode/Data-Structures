/*
 * To print the given 2D array in a spiral form
 * Recursive Method
 */

package ArraysAndStrings;

public class PrintMatrixInSpiralRecursion
{
	//To print a  given 2D array in spiral format
	public void spiral(int[][] matrix,int rowStart, int colStart, int colLength,  int rowLength)
	{
		//To display from Left to Right
		for( int i = rowStart ; i <= colLength ; i++ )
			System.out.print(matrix[rowStart][i]+" ");
		
		//To display from Top to Bottom
		for( int j = rowStart+1 ; j <= rowLength ; j++ )
			System.out.print(matrix[j][colLength]+ " ");
			
		/*
		 * To display from right to left
		 * If condition checks whether there is only one row 
		 * If there is only one row, then no need to perform the iterations
		 */
		if( rowStart + 1 <= rowLength)
			for(int k = colLength - 1 ; k >= colStart ; k-- )
				System.out.print(matrix[rowLength][k]+" ");
		
		/*
		 * To display from bottom to top
		 * If condition checks whether there is only one column 
		 * If there is only one column, then no need to perform the iterations
		 */
		if( colStart + 1 <= colLength)
			for(int l = rowLength- 1 ; l > rowStart ; l-- )
				System.out.print(matrix[l][colStart]+" ");
		
		/*
		 * Before going into recursion, just check whether the next layer is present or not
		 * If not, Recursion ends
		 */
		if( rowStart+1 <= rowLength-1 && colStart+1 <= colLength-1)
			spiral(matrix, rowStart+1, colStart+1, colLength-1, rowLength-1);
		
	}
	
	//To display contents of the original matrix
	public void showMatrix(int matrix[][])
	{
		for (int i = 0; i < matrix.length; i++) 
		{
			for (int j = 0; j < matrix[0].length; j++) 
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//Driver Function
	public static void main(String[] args) 
	{
		PrintMatrixInSpiralRecursion rm = new PrintMatrixInSpiralRecursion();
		
		int rows = 3;
		int columns =5;
		int[][] matrix = new int[rows][columns];
		int count = 0;
		
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < columns; j++) 
				matrix[i][j] = count++;
		
		System.out.println("Original Matrix");
		rm.showMatrix(matrix);
		System.out.println("\nMatrix Elements in Spiral :\n");
		rm.spiral(matrix,0,0,matrix[0].length-1,matrix.length-1);
	}
}
