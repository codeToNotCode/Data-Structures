/*
 * To find transpose of any given 2D matrix
 * Each row of the original matrix will be transformed into a column
 * Each column of the original matrix will be transformed into a row
 */
package ArraysAndStrings;

public class TransposeOfAMatrix 
{
	
	//To find transpose a given 2D array
	public int[][] transpose(int matrix[][])
	{
		/*
		 * Number of rows in thr rotated matrix will be equal to the number of columns in the original matrix
		 * Number of columns in thr rotated matrix will be equal to the number of rows in the original matrix
		 */
		int newRows = matrix[0].length;
		int newColumns = matrix.length;
		
		//Get memory for the new rotated matrix with newRows and Columns
		int transpose[][] = new int[newRows][newColumns];
		
		//Run the double loop to access all elements of the original matrix
		for(int i = 0 ; i < newColumns ; i++)
			for(int j = 0 ; j < newRows ; j++)
				transpose[j][i] = matrix[i][j];
		
		//Return the transposed matrix
		return transpose;
	}
	
	//To display contents of a matrix
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

	
	//Driver function
	public static void main(String[] args) 
	{
		
		TransposeOfAMatrix rm = new TransposeOfAMatrix();
		
		int rows = 10;
		int columns = 15;
		int[][] matrix = new int[rows][columns];
		int count = 0;
		
		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < columns; j++) 
			{
				matrix[i][j] = count++;
			}
			
		}
		
		System.out.println("Original Matrix");
		rm.showMatrix(matrix);
		System.out.println("\nRotated Matrix");
		rm.showMatrix(rm.transpose(matrix));
	}

}
