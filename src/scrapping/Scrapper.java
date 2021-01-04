package scrapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Scrapper {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		final String BASE_URL = "https://www.google.com/search?q=JHipster";
			Document doc = Jsoup.connect(BASE_URL).get();
			createFile();
			fillFile(doc.toString());
		
	}
	
	private static void createFile() {
		try {
			 File myObj = new File("scrappingGoogle.txt");
			 if (myObj.createNewFile()) {
			   System.out.println("File created: " + myObj.getName());
			 } else {
			   System.out.println("File already exists.");
			 }
		} catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
	}
	
	private static void fillFile(String data) {
		 try {
		      FileWriter myWriter = new FileWriter("scrappingGoogle.txt");
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

}
