package test.spring.di;

public class Bean13 {
		private Bean13Customer customer;
		
		public Bean13(){
				customer = new Bean13Customer();
				customer.setName(new Bean13Name());
		}

		public Bean13Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Bean13Customer customer) {
			this.customer = customer;
		}
}
