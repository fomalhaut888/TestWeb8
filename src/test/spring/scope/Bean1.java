package test.spring.scope;

public class Bean1 {
		private static int sequence = -1;
		
		private int id;
		
		public Bean1(){
				sequence++;
				id = sequence;
		}

		public int getId() {
			return id;
		}
}
