/*
 * TO sort a given set of students in decreasing order of their marks using Lambda expression
 */

package CollectionsAndGenerics;

import java.util.ArrayList;
import java.util.Collections;

public class ComparatorLambda
{
	int rollnum;
	int marks;
	
	public ComparatorLambda(int r , int m)
	{
		this.rollnum = r;
		this.marks = m;
	}
	
	/*
	 * This toString() method is overridden because we want to print the object contents as a string
	 * If we do not override this method, then the output is a class name followed by memory address
 	 */
	@Override
	public String toString()
	{
		return "Rollnum :"+rollnum+ "	Marks :"+marks;
	}
	
	
	//Driver Function
	public static void main(String[] args)
	{
		ArrayList<ComparatorLambda> student = new ArrayList<ComparatorLambda>();
		
		student.add(new ComparatorLambda(1, 87));
		student.add(new ComparatorLambda(2, 57));
		student.add(new ComparatorLambda(3, 85));
		student.add(new ComparatorLambda(4, 72));
		student.add(new ComparatorLambda(5, 90));
		
		//Sorting using comparator interface and lambda expression
		Collections.sort(student, (s1,s2) -> 
		{
			return (s1.marks > s2.marks ) ? -1 : 1; 
		});
		
		//To print the students : Uses overridden toString() method
		for( ComparatorLambda s : student)
			System.out.println(s);
	}
}
