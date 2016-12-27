/*
 * To rotate a N*M matrix clockwise using extra memory
 * Each row of the original matrix will be transformed into a column
 * Each column of the original matrix will be transformed into a row
 */
package ArraysAndStrings;

public class RotateNCrossMMatrix 
{
	
	//To rotate a given 2D array
	public int[][] rotateMatrix(int matrix[][])
	{
		/*
		 * Number of rows in thr rotated matrix will be equal to the number of columns in the original matrix
		 * Number of columns in thr rotated matrix will be equal to the number of rows in the original matrix
		 */
		int newRows = matrix[0].length;
		int newColumns = matrix.length;
		
		//Get memory for the new rotated matrix with newRows and Columns
		int rotatedMatrix[][] = new int[newRows][newColumns];
		
		//Run the double loop to access all elements of the original matrix
		for(int i = 0 ; i < newColumns ; i++)
		{
			for(int j = 0 ; j < newRows ; j++)
			{
				//Formula for rotating 90 degrees in the clockwise direction
				rotatedMatrix[j][(newColumns-1) - i] = matrix[i][j];
				
				/*
				 * Formula for rotating 90 degrees in the anit-clockwise direction
				 * rotatedMatrix[(newRows - 1) - j][i] = matrix[i][j];
				 */
			}
		}
		
		//Return the rotated matrix
		return rotatedMatrix;
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
		
		RotateNCrossMMatrix rm = new RotateNCrossMMatrix();
		
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
		rm.showMatrix(rm.rotateMatrix(matrix));
	}

}
