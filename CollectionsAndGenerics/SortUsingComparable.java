/*
 * TO sort a given list of student on the basis of their marks
 * Comparable interface is used here: method to be overriden is compareTo(Object obj);
 * Use comparable interface if you can change the definition of the class, else use comparator interface
 */
package CollectionsAndGenerics;

import java.util.ArrayList;
import java.util.Collections;

public class SortUsingComparable implements Comparable<SortUsingComparable>
{
	int rollnum;
	int marks;
	
	public SortUsingComparable(int r , int m)
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

	@Override
	public int compareTo(SortUsingComparable o)
	{
		return (this.marks > o.marks) ? -1 : 1;
	}
	
	//Driver Function
	public static void main(String[] args)
	{
		ArrayList<SortUsingComparable> student = new ArrayList<SortUsingComparable>();
		
		student.add(new SortUsingComparable(1, 87));
		student.add(new SortUsingComparable(2, 57));
		student.add(new SortUsingComparable(3, 85));
		student.add(new SortUsingComparable(4, 72));
		student.add(new SortUsingComparable(5, 90));
		
		//Sorting using comparable interface
		Collections.sort(student);
		
		//To print the students : Uses overridden toString() method
		for( SortUsingComparable s : student)
			System.out.println(s);
	}

}
