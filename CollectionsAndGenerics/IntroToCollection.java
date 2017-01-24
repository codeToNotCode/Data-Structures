/*
 * Introduction to collections
 * Collection is an interface
 * Collections is a class
 * 
 * Collection provides a dynamic array : memory can be increased or decreased with Collection
 * To see the heirarchy in collection interface and all the classes that implements this interface : http://learnwithharsha.com/wp-content/uploads/2013/03/java-collection.jpg
 * You cannot add an element at a particular index in the collection: elements are always added/removed to/from the end
 * ie - accessing elements with indexes is not possible with the Collection interface . Moreover, you cannot use .sort function to sort
 * the elements of the Collection. For all these funcitons, use LIST interface
 * 
 * To add an element in between, we can use List interface.
 *  List interface has all the functionalities of Collection with extra features
 *  Index access is possible
 *  Collections.sort() works with List interface 
 *  COllections.reverse() is used to print all the elements in the descending order
 * 
 * Iterator - Also an interface in java - old technique
 * Enhanced for loop
 */


package CollectionsAndGenerics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IntroToCollection
{
	public static void main(String[] args)
	{
		/*
		 * define a collection
		 * If you do not mention <Object>, it will by default take Object 
		 * You can mention any other data type classes like <Integer>, <String> etc
		 */
		Collection<Object> values = new ArrayList<Object>();

		/*
		 * Insert values to the collection values
		 * We can also remove elements from the collection
		 * Since we have not defined any data types for the collection: we can add any value we wish to add
		 */
		values.add(5142);
		values.add("Prasan");
		values.add(4.3f);
		
		/*
		 * Display a collection
		 * Iterator 
		 * Enhanced for loop
		 */
		Iterator<Object> i = values.iterator();
		while( i.hasNext())
			System.out.println(i.next());
	
		values.remove(4.3f);
		
		for( Object j : values)
			System.out.println(j);
		
		
		List<Object> listValues = new ArrayList<>();
		listValues.add(5142);
		listValues.add("Prasan");
		listValues.add(4.3f);
		
		System.out.println("\nList elements :");
		for( Object l : listValues)
			System.out.println(l);
		
		listValues.add(2, "Deep");
		for( Object l : listValues)
			System.out.println(l);

		//One more way to print the List elements --- Uses Stream API....LAMBDA EXPRESSION
		listValues.forEach(System.out::println);
		
		List<Integer> num = new LinkedList<Integer>();
		num.add(5);	num.add(562); num.add(15); num.add(55); num.add(52);
		
		Collections.reverse(num);
		
		for(Integer k : num )
			System.out.print(k + " ");
	}
	
}
