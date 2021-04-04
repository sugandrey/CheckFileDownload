import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OutputFromFile {
	
	private File file;
	private BufferedReader reader;

	public String getStringFromFile() throws IOException {
		file = new File("C:\\Users\\user\\Desktop\\fileUpload.au3");
		reader = new BufferedReader(new FileReader(file));
		String string = "";
		StringBuffer buffer = new StringBuffer(string);
		while((string = reader.readLine()) != null) {
				//System.out.println(string);
				buffer.append(string);
		}
		string = buffer.toString();
		return string;
	}

}
