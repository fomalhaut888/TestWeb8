package test.spring.di;

public class Rectangle5 {
		private Length5 length;
		
		private Width5 width;

		public void setLength(Length5 length) {
			this.length = length;
		}

		public void setWidth(Width5 width) {
			this.width = width;
		}
		
		public double getArea(){
			return length.getValue() * width.getValue();
		}
}
