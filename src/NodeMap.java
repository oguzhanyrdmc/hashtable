

public abstract class NodeMap implements Map {

	public boolean isEmpty() {
		return size() == 0;
	}

	protected static class MapEntry implements Entry {
		private int key;
		private String value;
		private int count;

		public MapEntry(int key, String value) { //NODE oluþturuyoruz
			this.key = key;
			this.value = value;
			count = 1;
		}
		
		public MapEntry(int key, String value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}

		public int getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}

		public int getCount() {
			return count;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public void setCount(int count) {
			this.count = count;
		}

	}

}
