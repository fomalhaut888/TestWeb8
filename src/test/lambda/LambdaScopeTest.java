package test.lambda;

import java.util.function.Consumer;

//Accessing Local Variables of the Enclosing Scope
public class LambdaScopeTest {
		
		public int x = 0;
		
		class FirstLevel{
				public int x = 1;
				
				void methodInFirstLevel(int x){//effectively final
					
						// The following statement causes the compiler to generate
			            // the error "local variables referenced from a lambda expression
			            // must be final or effectively final" in statement A:
			            //
			            //x = 99;
						
						Consumer<Integer> myConsumer = y -> {
								System.out.println("x = " + x); // Statement A
								System.out.println("y = " + y);
								System.out.println("this.x = " + this.x);
								System.out.println("LambdaScopeTest.this.x = " +
										LambdaScopeTest.this.x);
						};
						
						myConsumer.accept(x);
				}
		}
		
		public static void main(String... args) {
				LambdaScopeTest st = new LambdaScopeTest();
				LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
				fl.methodInFirstLevel(23);
		}
}

//My try: Different compile results  by JRE 7 and JRE 8 
//		about a inner class use the variable of the outer method.
class AnonymousClassTest2{
		public void method(String arg){//effectively final
				A a = new A(){
						@Override
						public void aprint(String s) {
								System.out.println("s=" + s);
								//This line has a comile error(Cannot refer to the non-final local variable arg defined in an enclosing scope) 
								//		in the JRE 7 but not in JRE 8.
								System.out.println("arg=" + arg);//This variable 'arg' will be taken as a final one in JRE 8.
								//This line will has a comile error(Local variable arg defined in an enclosing scope must be final or effectively final)
								//		in JRE 8 if unmarked.
								//arg = "c";
						}
				};
				a.aprint(arg);
		}
		
		interface A{
				void aprint(String s);
		}
}
