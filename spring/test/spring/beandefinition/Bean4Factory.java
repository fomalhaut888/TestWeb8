package test.spring.beandefinition;

public class Bean4Factory {
	
		private Bean4 sunBean;
		
		private Bean4 frankBean;
		
		public Bean4 getSunBean(){
				if(sunBean == null){
						sunBean = new Bean4();
						sunBean.setName("Sun");
				}
				return sunBean;
		}
		
		public Bean4 getFrankBean(){
				if(frankBean == null){
						frankBean = new Bean4();
						frankBean.setName("Frank");
				}
				return frankBean;
		}
}
