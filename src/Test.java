
public class Test {

	public static void main(String[] args) {
		
		// Dosyayý kelime kelime okuyorum ve ardýndan okuduðum 
		//	her kelime için read classý içinde put fonksiyonunu çaðýrarak 
		//	kelimeleri tek tek hastable içine yerleþtiriyorum.
		
		Read read = new Read();
		HashTable Htable = new HashTable();
		read.readStory(Htable); 
		System.err.println("TABLE PLACEMENT SUCCESSFUL\n");
		
		//Hashtable'da arama yapmak için Htable.get("aranankelime")
		Htable.get("nothing");
		Htable.get("frog");
		Htable.get("Oðuzhan");
		Htable.get("was");
	}

}
