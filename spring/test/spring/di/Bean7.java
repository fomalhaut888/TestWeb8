package test.spring.di;

import java.util.Properties;

public class Bean7 {
	
		private String name;
		
		private String mobile;
		
		private int reservation;
		
		private boolean smoke;
		
		private Properties properties;
	
		public Bean7(){
		}

		public void setName(String name) {
				this.name = name;
		}

		public void setMobile(String mobile) {
				this.mobile = mobile;
		}

		public void setReservation(int reservation) {
				this.reservation = reservation;
		}

		public void setSmoke(boolean smoke) {
				this.smoke = smoke;
		}

		public void setProperties(Properties properties) {
				this.properties = properties;
				this.name = this.properties.getProperty("name");
				this.mobile = this.properties.getProperty("mobile");
				this.reservation = Integer.parseInt(this.properties.getProperty("reservation"));
				this.smoke = Boolean.parseBoolean(this.properties.getProperty("smoke"));
		}
		
		public void print(){
				String s = name + "(mobile: " + mobile + ") made a reservation for " + reservation;
				s += (smoke?" in the smoking area." : " in the non-smoking area.");
				System.out.println(s);
		}
}
