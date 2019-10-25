package testCMD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestCMD {

	public static void main(String[] args) {
		String path = "C:\\Users\\CDA1\\Desktop\\Projets\\Java\\Java-AFPA\\algoExercises\\src\\testCMD\\properties.props";
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(path));
			if (properties.keySet().contains("hiddenWord")) {
				System.out.println(properties.getProperty("hiddenWord"));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
