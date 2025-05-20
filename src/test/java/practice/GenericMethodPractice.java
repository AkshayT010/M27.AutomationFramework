package practice;

public class GenericMethodPractice {

	public static void main(String[] args) { //caller function
	
		int sum = add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,40));
		System.out.println(add(30,50));
		System.out.println(add(10,20,30));
		System.out.println(sub(10,5));
		System.out.println(div(50,5));
		

	}
	
	public static int add(int a, int b)//called function - generic method
	{
		int c = a+b;
		return c;
	}
	
	public static int add(int a, int b, int c)
	{
		int d= a+b+c;
		return d;
	}

	public static int sub(int a, int b)
	{
		int c = a-b;
		return c;
		
	}
	
	public static int div(int a, int b)
	{
		int c = a/b;
		return c;
	}
}
