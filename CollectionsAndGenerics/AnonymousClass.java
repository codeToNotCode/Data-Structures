/*
 * Anonymous class is nothing but an inner class 
 * Since it is anonymous(without any name) its object is created and its body is defined at the same place
 * HEnce the anonymous class will have only one object that is created
 * Its behaviiour is similar to that of a subclass in inheritance
 */


package CollectionsAndGenerics;


class Greeting{
	public void sayHI()
	{
		System.out.println("Hi");
	}
}
public class AnonymousClass
{
	/*
	 * Creating an anonymous class here with its body included
	 * the object of the anonymous class has to be accessed via some reference variable
	 * Since the object being created is of anonymous class, we dont have any reference variable that we can create of this class
	 * Hence we use the parent class ( class which is used to create the anonymous class ) as the reference variable type
	 * All the functions in the anonymous class should be the ones which are overidden from the parent class
	 * This is because we have reference variable of the parent class, and with this reference you can only access functions
	 * that have been overridden. 
	 */
	Greeting g = new Greeting(){
		
		public void sayHI()
		{
			System.out.println("Hanji");
		}
	};
	
	public static void main(String[] args)
	{
		AnonymousClass a = new AnonymousClass();
		a.g.sayHI();
	}
}
