package test.spring.di;


public class Bean2 {
	
		private String productId;
		
		private int amount;
	
		//@ConstructorProperties({"productId", "amount"}) //add it if you can’t compile your code with debug flag.
		public Bean2(String productId, int amount){
				this.productId = productId;
				this.amount = amount;
				System.out.println("A Bean2 object initialized!");
		}
		
		public void print(){
				System.out.println(amount + " product of " + productId + " bought!");
		}
}
