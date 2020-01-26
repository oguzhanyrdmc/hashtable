import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read {

	public void readStory(HashTable table) { // dosyadan inputtxt dosyas� okunuyor

		File file = new File("story.txt");
		Scanner scanner, line;

		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) { // read line by line
				line = new Scanner(scanner.nextLine());
				while (line.hasNext()) { //read word by word
					String word = line.next();
					table.put(word); //okunan deper hemen table yerle�tiriliyor
				}
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
