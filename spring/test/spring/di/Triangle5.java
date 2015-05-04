package test.spring.di;

public class Triangle5 {
	
		private Base5 base;
		
		private Height5 height;
	
		private Triangle5(Base5 base, Height5 height){
				this.base = base;
				this.height = height;
		}
		
		public static Triangle5 createInstance(Base5 base, Height5 height){
				Triangle5 triangle = new Triangle5(base, height);
				return triangle;
		}
		
		public double getArea(){
				return base.getValue() * height.getValue() / 2 ;
		}
}
