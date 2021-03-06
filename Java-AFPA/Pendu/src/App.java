import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) throws IOException {
		String path = new File("src/words.txt").getAbsolutePath();

		List<String> words = Files.readAllLines(FileSystems.getDefault().getPath(path));

		Random rndNum = new Random();

		String randomWord = words.get(rndNum.nextInt(words.size()));

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame(randomWord);
			}
		});
	}

}
