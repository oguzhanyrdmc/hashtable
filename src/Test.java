
public class Test {

	public static void main(String[] args) {
		
		// Dosyay� kelime kelime okuyorum ve ard�ndan okudu�um 
		//	her kelime i�in read class� i�inde put fonksiyonunu �a��rarak 
		//	kelimeleri tek tek hastable i�ine yerle�tiriyorum.
		
		Read read = new Read();
		HashTable Htable = new HashTable();
		read.readStory(Htable); 
		System.err.println("TABLE PLACEMENT SUCCESSFUL\n");
		
		//Hashtable'da arama yapmak i�in Htable.get("aranankelime")
		Htable.get("nothing");
		Htable.get("frog");
		Htable.get("O�uzhan");
		Htable.get("was");
	}

}
