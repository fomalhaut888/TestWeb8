package test.spring.di;

public class Bean15 {
	
		private String name;
		
		private Bean15 mother;
	
		public Bean15(String name){
				this.name = name;
				System.out.println("name:" + name + " initialized!");
		}
		
		public Bean15(String name, Bean15 mother){
				this.name = name;
				this.mother = mother;
				System.out.println("name:" + name + " initialized and mother " + mother.getName() + " set up!");
		}

		public String getName() {
				return name;
		}

		public Bean15 getMother() {
			return mother;
		}

		public void setName(String name) {
			this.name = name;
		}
}
