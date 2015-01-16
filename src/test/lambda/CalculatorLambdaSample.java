package test.lambda;

//Syntax of Lambda Expressions
public class CalculatorLambdaSample {
		interface IntegerMath{
				int operation(int a, int b);//a method has two arguments in the functional interface
		}
		
		public int operateBinary(int a, int b, IntegerMath op){
				return op.operation(a, b);
		}
		
		public static void main(String args[]){
				CalculatorLambdaSample myApp = new CalculatorLambdaSample();
				IntegerMath addition = (a, b) -> a + b;//a lambda expression of two arguments.
				IntegerMath subtraction = (a, b) -> a - b;//a lambda expression of two arguments.
				System.out.println("40 + 2 = " +
						myApp.operateBinary(40, 2, addition));
			    System.out.println("20 - 10 = " +
			    		myApp.operateBinary(20, 10, subtraction));  
		}
}
