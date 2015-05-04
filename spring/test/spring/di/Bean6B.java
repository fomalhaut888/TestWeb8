package test.spring.di;

public class Bean6B {
	
		private Bean6A bean6A;
		
		public Bean6B(){
		}
	
		public Bean6B(Bean6A bean6A){
				this.bean6A = bean6A;
		}
		
		public void setBean6A(Bean6A bean6a) {
				bean6A = bean6a;
		}
		
		public Bean6A getBean6A() {
				return bean6A;
		}
		
		@Override
		public String toString(){
				return "B object";
		}
}
