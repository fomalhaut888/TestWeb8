package test.spring.di;

public class Circle5 {
	
		private Radius5 radius;
		
		private double pi;
	
		public Circle5(Radius5 radius, double pi){
				this.radius = radius;
				this.pi = pi;
		}
		
		public double getArea(){
				return radius.getValue() * radius.getValue() * pi;
		}
}
