
public class HashTable extends HashMap {

	private MapEntry[] table;

	public HashTable() { // constructer
		super();
	}

	@Override
	protected void createTable() {
		table = new MapEntry[capacity];
	}

	@Override
	protected int bucketGet(int index, int key, String value) { // Search Function in the hashtable
		while (!nodeIsEmpty(index)) {
			if (table[index].getValue().equals(value)) {
				printGet(index);
				return index;
			} else {
				index = nodeFind(index, key);
			}
		}
		printGet(-1); //no value
		return -1;
	}

	protected void printGet(int index) {
		if (index == -1)
			System.out.println("There is no this value in hastable\n");
		else
			System.out.println("Key: " + table[index].getKey() +"\nIndex: "+index + "\nValue: " + table[index].getValue() + "\nCount: "
					+ table[index].getCount() + "\n");
	}

	@Override
	protected void bucketPut(int index, int key, String value) { // Adding Function in the hashtable

		if (nodeIsEmpty(index)) { // hashtable is slot empty
			table[index] = new MapEntry(key, value); // adding
			size++;
		} else {
			int primeIndex = index;
			int primary = 0;
			int i = 1;
			int j = 1;
			boolean flag = true;
			while (!nodeIsEmpty(primeIndex)) { // primary chain
				if (table[primeIndex].getValue().equals(value)) { // if there is value, count++
					table[primeIndex].setCount(table[primeIndex].getCount() + 1);
					flag = false;
					break;
				} else { // primechain		
					primeIndex = nodeFind(primeIndex, key);
					i++;
					primary = i + j;
				}
			}

			if (flag == true) {
				int secondary = 9999999, minIndex = 0, changeindex = 0, secondIndex = 0;
				i = 1;
				
				for (int t = 0; t < primary - 2; t++) { // secondary chain
					secondIndex = index;
					j = 1; 
					while (!nodeIsEmpty(secondIndex)) {
			
						secondIndex = nodeFind(secondIndex, table[index].getKey());
						j++;
					}
					if ((i + j) < secondary) {						
						secondary = i + j;
						minIndex = secondIndex; // minimumsecondary
						changeindex = index; // minumumsecondarynýn primary indexi
					}
					i++;					
					index = nodeFind(index, key);
				}
				
				if (minIndex < primary) {
					// CHANGE YAPILACAK
					// changeindex minindex kýsýmýna yerleþtirilecek 
					// primary changeindex kýsýmýna yerleþtirilecek
					table[minIndex] = new MapEntry(table[changeindex].getKey(), table[changeindex].getValue(), table[changeindex].getCount());
					table[changeindex].setKey(key);
					table[changeindex].setValue(value);
					table[changeindex].setCount(1);
				} else {
					// primaindex kýsýmýna yerleþtir 
					table[primeIndex] = new MapEntry(key, value);
					size++;
				}
			}
		}
	}

	private int nodeFind(int index, int key) { // where is the next index
		return (index + incrementing(key)) % capacity;
	}

	private boolean nodeIsEmpty(int index) {// is node empty?
		return (table[index] == null);
	}
}
