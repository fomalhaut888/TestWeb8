package test.spring.di;

public class Bean6A {
	
		private Bean6B bean6B;
		
		public Bean6A(){
		}
	
		public Bean6A(Bean6B bean6B){
				this.bean6B = bean6B;
		}
		
		public void setBean6B(Bean6B bean6b) {
				bean6B = bean6b;
		}

		public Bean6B getBean6B() {
				return bean6B;
		}
		
		@Override
		public String toString(){
				return "A object";
		}
}
