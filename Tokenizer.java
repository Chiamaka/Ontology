package ontology;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class Tokenizer {
	public static String tokenizer(String file) throws InvalidFormatException,
			IOException {
		Scanner scan = new Scanner(new File("nlp/" + file));
		String line = "";
		List<String> tokenList = new ArrayList<>();
		while (scan.hasNext()) {
			line += scan.nextLine() + "\n";
		}
		// String paragraph =
		// "Hi. How are you? This is Mike. Hope you are feeling better now tho? Just said to say hi";

		InputStream is = new FileInputStream("en-token.bin");
		TokenizerModel model = new TokenizerModel(is);
		TokenizerME tokenizer = new TokenizerME(model);

		String tokens[] = tokenizer.tokenize(line);
		// String token
		String token = "";
		for (int i = 0; i < tokens.length; i++) {
			// concatenates the token array items to token String
			// token += tokens[i] + "\n";
			tokenList.add(tokens[i]);
		}
		
		//stemming process
		for (int i = 0; i < tokenList.size(); i++) {
			if (tokenList.get(i).contains(",")
					|| tokenList.get(i).contains(".")
					|| tokenList.get(i).contains("_")
					|| tokenList.get(i).contains("-")
					|| tokenList.get(i).contains(":")
					|| tokenList.get(i).contains("?")
					|| tokenList.get(i).contains("”")
					|| tokenList.get(i).contains("©")
					|| tokenList.get(i).contains("’")
					|| tokenList.get(i).contains("—")
					|| tokenList.get(i).contains("“")
					|| tokenList.get(i).contains("•")
					|| tokenList.get(i).contains("”")
					|| tokenList.get(i).contains("&")
					|| tokenList.get(i).contains("!")
					|| tokenList.get(i).contains(")")
					|| tokenList.get(i).contains("(")
					|| tokenList.get(i).contains("”")){//
				tokenList.remove(i);
		}
		}
		token = "";
		for (int i = 0; i < tokenList.size(); i++) {
			token += tokenList.get(i) + "\n";
		}
		is.close();
		return token;
	}

	public static void main(String[] args) throws InvalidFormatException,
			IOException {
		// tokenizer();
	}
}
