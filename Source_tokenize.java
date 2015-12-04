package ontology;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ontology.AnaphoraResolution;

public class Source_tokenize {
	public static ArrayList<String> source_tokens;

	public static void main(String args[]) {
		tokenize("");
	}

	public static ArrayList<String> tokenize(String Reqs_file) {
		source_tokens = new ArrayList<String>();
		File file = new File(Reqs_file);
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		StringBuilder This_sentence;
		// String detail="";

		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			BufferedReader dis = new BufferedReader(new InputStreamReader(bis));
			char[] th_sentences = {};
			while (dis.ready()) {
				String line = dis.readLine();
				if (line.length() > 1) {
					th_sentences = line.toCharArray();
					This_sentence = new StringBuilder();

					for (char c : th_sentences) {
						if (c == '/') {
							System.out.println("/");
						}
						if (c != '.') {
							This_sentence.append(c);
						} // endif
						else {
							This_sentence = new StringBuilder(
									This_sentence.toString());
							if (This_sentence.length() > 1) {
								source_tokens.add(This_sentence.toString());
								This_sentence.append(System
										.getProperty("line.separator"));
							} // endif
							This_sentence = new StringBuilder();
						} // end else
					}// end for

					if (This_sentence.length() > 1) {
						This_sentence = new StringBuilder(
								AnaphoraResolution.resolve(This_sentence
										.toString()));
						source_tokens.add(This_sentence.toString());
						This_sentence.append(System
								.getProperty("line.separator"));
						System.out.println(This_sentence);
						This_sentence = new StringBuilder();
					} // endif

				}
			} // end while dis.ready()

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();

		} // end try
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return source_tokens;
	}

}
