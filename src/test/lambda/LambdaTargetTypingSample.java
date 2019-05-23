package test.lambda;

public class LambdaTargetTypingSample {
		public static void main(String args[]){
				//Compiler error: The method invoke(LambdaTargetTypingSample.A) is ambiguous 
				//		for the type LambdaTargetTypingSample
				//invoke1(s -> System.out.println(s));
				//The data type that these methods expect is called the target type.
				//It follows that you can only use lambda expressions in situations 
				//		in which the Java compiler can determine a target type:
				//		Variable declarations
				//		Assignments
				//		Return statements
				//		Array initializers
				//		Method or constructor arguments
				//		Lambda expression bodies
				//		Conditional expressions, ?:
				//		Cast expressions
				//****************************************
				//1. Variable declarations
				//invoke1(s -> System.out.println(s));//Compiler error because of two overloading methods with a paremeter of a funtional interface.
				invoke1((String s) -> System.out.println(s));
				//invoke1((Integer i) -> System.out.println(i));//Compiler error, autoboxing cannot be used in lambda declaration.
				invoke1((int i) -> System.out.println(i));
				invoke2((Integer c) -> System.out.println(c));
				invoke2((String d) -> System.out.println(d));
				//2.Method or constructor arguments
				invoke3((h, b) -> System.out.println(h + ":" + b), "May", "18");
				invoke3((h) -> System.out.println(h + ": "), "Kevin", "22");
				//3.Return statements
				invoke4(() -> "X");
				invoke4(() -> 8);
				//...
		}
		
		//###########
		
		public static void invoke1(A a){
				a.methodA("A");
		}
		
		public static void invoke1(B b){
		//public static void invoke1(String s) {
				b.methodB(10);
				//System.out.println(s);
		}
		
		private interface A{
				public void methodA(String s);
		}
		
		private interface B{
				public void methodB(int i);
		}
		
		//###########
		
		public static void invoke2(C<Integer> c){
				System.out.println("Run C:");
				c.methodC(10);
		}
		
		public static void invoke2(D<String> d){
				System.out.println("Run D:");
				d.methodD("D");
		}
		
		private interface C<T>{
				public void methodC(T t);
		}
		
		private interface D<T>{
				public void methodD(T t);
		}
		
		//###########
		
		public static void invoke3(E e, String header, String body){
				e.methodE(header, body);
		}
		
		public static void invoke3(F f, String header, String body){
				f.methodF(header);
		}
		
		private interface E{
				public void methodE(String header, String body);
		}
		
		private interface F{
				public void methodF(String header);
		}
		
		//###########
		
		public static void invoke4(G g){
				System.out.println("G:" + g.methodG());
		}
		
		public static void invoke4(H h){
				System.out.println("H:" + h.methodH());
		}
		
		private interface G{
				public String methodG();
		}
		
		private interface H{
				public int methodH();
		}
}
