/*
 * Mao interface enables us to have key,value pairing
 * Here the elements are accessed on the basis of their keys instead of index values
 * 
 * Classes that implement Map interface are HashMap, Hashtable, TreeMAp and LinkedHashMap
 * HashMap is Fast and not synchrnized 
 * HAshTable is slow, synchronized and thread safe
 * 
 * 		HashMap											Hashtable
 * 		Introduced in java 1.2							Introduced in java 1.0
 * 		Not Thread Safe									Is thread safe
 * 		Not synchronized								synchronized
 * 		Faster											Slower
 * 		Used for single threads							Used for multiple threads
 * 		One key can be null								Does not allow for null keys
 * 
 * Most commonly used is HashMap
 * 
 * Insertion order in HashMap and Hashtable is never fixed because it depends on the Hash function
 * LinkedHashMap - The order of insertion of elements into the map is preserved using LinkedHashMap
 * TreeMap - The elements are inserted in an increasing order 
 * 
 * Map.Entry - Entry is an interface inside the interface Map. So this is an example of interface nesting.
 * An Entry is a key value pair. Two functions - getKey() and getValue()
 * 
 * HAshMap stores only unique keys. No duplicate keys are allowed in Hashmap
 * HashSet stores only unique elements . No duplicate elements are allowed in a HashSet
 */
package CollectionsAndGenerics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapInterface
{
	
	public static void main(String[] args)
	{
		Map<String,String> details = new HashMap<>();

		//Insert values in the details HashMAp using key-value pair
		details.put("myName", "Prasan");
		details.put("favColor", "Black");
		details.put("favMusic", "Punjabi");
		details.put("favSport", "Squash");
		details.put("favColor", "White");
		details.put("newColor", "Black");
		
		
		//The values that will be displayed using HashMap will not be in a proper order
		System.out.println(details);
		
		/*
		 * TO get a specific value from the HashMap, use get(key) function 
		 * If the key is not present in the HashMap, the get() function will return null
		 */
		System.out.println(details.get("myName"));
		System.out.println(details.get("myNameIs"));
		
		/*
		 * Instead of printing the elements one by one, we can use enhanced for loop
		 * But for this , we need to have all the keys of the HashMap
		 * The keySet() function returns a set of all the keys in the map
		 * 
		 * If we are using Set interface to store all the keys, then we cannot have 2 keys with the same kryName
		 * The value of the previous key would get replaced by the value of the new key
		 * Hence, keys cannot repeat, but the values can repeat
		 */
		Set<String> keys = details.keySet();
		for( String k : keys )
			System.out.println(k+"        "+details.get(k));
		
		/*
		 * To print the  contents of the Map using Entry interface
		 */
		Set<Map.Entry<String,String>> val = details.entrySet();
		for( Map.Entry<String, String> e : val )
			System.out.println("Key :"+e.getKey()+"    Value :"+e.getValue());
	}

	
}	
