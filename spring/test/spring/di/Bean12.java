package test.spring.di;

public class Bean12 {
		private String product;
		
		private int amount;
		
		private int unitPrice;
		
		private Bean12(){
		}
		
		private Bean12(String product, int amount, int unitPrice){
				this.product = product;
				this.amount = amount;
				this.unitPrice = unitPrice;
		}
		
		public int getTotalPrice(){
				return amount * unitPrice;
		}

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public int getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(int unitPrice) {
			this.unitPrice = unitPrice;
		}
}
