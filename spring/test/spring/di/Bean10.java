package test.spring.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Bean10 {
		private Properties properties;
		
		private List list;
		
		private Map map;
		
		private Set set;

		public Properties getProperties() {
			return properties;
		}

		public void setProperties(Properties properties) {
			this.properties = properties;
		}

		public List getList() {
			return list;
		}

		public void setList(List list) {
			this.list = list;
		}

		public Map getMap() {
			return map;
		}

		public void setMap(Map map) {
			this.map = map;
		}

		public Set getSet() {
			return set;
		}

		public void setSet(Set set) {
			this.set = set;
		}
}
