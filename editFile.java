package ontology;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class editFile {

	public static void edit(String concept) {
		// TODO Auto-generated method stub
		String spl[], text = "";
		try {
			FileInputStream fis = new FileInputStream(new File(
					"concepts/" + concept));
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));

			String line = null;
			while ((line = br.readLine()) != null) {
				spl = line.split("_");
				text += spl[0] + "\n";

			}

			br.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintStream diskwriter;
		try {
			diskwriter = new PrintStream("concepts/" + concept);
			diskwriter.print(text);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
