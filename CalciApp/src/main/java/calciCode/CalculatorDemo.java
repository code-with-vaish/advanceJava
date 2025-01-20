package calciCode;

public class CalculatorDemo {

	public int add(int num1,int num2)
	{
		return num1+num2;
		
	}
	
	public int subtract(int num1,int num2)
	{
		return num1-num2;
		
	}
	
	public int divide(int a,int b)
	{
		if(b==0)
		{
			throw new ArithmeticException("Cannot divide by zero");
		}
		return a/b;
	}
}
