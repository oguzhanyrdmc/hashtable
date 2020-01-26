
public abstract class HashMap extends NodeMap {
	protected int size = 0;
	protected int capacity;

	public HashMap() {
		this.capacity = 5000;
		createTable();
	}

	protected abstract void createTable();

	@Override
	public int size() {
		return size;
	}

	private int castKey(String value) { // Value deðerini key deðerine dönüþtüren fonksiyon
		int count = 0;
		for (int i = 0; i < value.toString().length(); i++) {
			count = count + ((capacity + 1) * (int) value.charAt(i));		
		}
		count = Math.abs(count);
		return count;
	}

	private int hash(int key) { // Hash Function
		return key % capacity;
	}

	protected int incrementing(int key) { // Incrementing Function
		return (key / capacity) % capacity;
	}

	@Override
	public void put(String value) { 
		int key = castKey(value);
		bucketPut(hash(key), key, value);
	}

	@Override
	public void get(String value) {
		int key = castKey(value);
		bucketGet(hash(key), key, value);
	}

	protected abstract int bucketGet(int index, int key, String value);

	protected abstract void bucketPut(int index, int key, String value);

}
