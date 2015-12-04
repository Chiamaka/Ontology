package ontology;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class POSTagging {
	public static Object[] POSTag(String file) throws IOException {
		String POSTags = "", POSTags2 = "";
		List<String> lstPOS = new ArrayList<>();
		
		// String file ="tikaoutput.txt";
		String input = Tokenizer.tokenizer(file);
		// POSModel model = new POSModelLoader().load(new
		// File("en-pos-maxent.bin"));
		// PerformanceMonitor perfMon = new PerformanceMonitor(System.err,
		// "sent");
		InputStream is = new FileInputStream("en-pos-maxent.bin");
		POSModel model = new POSModel(is);
		POSTaggerME tagger = new POSTaggerME(model);

		// String input = "I am Chiamaka Glory Nwolisa";
		ObjectStream<String> lineStream = new PlainTextByLineStream(
				new StringReader(input));

		// perfMon.start();
		String line;
		while ((line = lineStream.read()) != null) {

			String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE
					.tokenize(line);
			String[] tags = tagger.tag(whitespaceTokenizerLine);

			POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
			POSTags += sample.toString() + "\n";

			if (sample.toString().length() >= 4) {
				if (sample.toString().charAt(sample.toString().length() - 2) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 1) == 'N'
						|| sample.toString().charAt(
								sample.toString().length() - 3) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 2) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 1) == 'S'
						|| sample.toString().charAt(
								sample.toString().length() - 3) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 2) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 1) == 'P'
						|| sample.toString().charAt(
								sample.toString().length() - 4) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 3) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 2) == 'P'
						&& sample.toString().charAt(
								sample.toString().length() - 1) == 'S') {
					POSTags2 += sample.toString() + "\n";
					lstPOS.add(sample.toString());
				}
			} else if (sample.toString().length() >= 3) {
				if (sample.toString().charAt(sample.toString().length() - 2) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 1) == 'N'
						|| sample.toString().charAt(
								sample.toString().length() - 3) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 2) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 1) == 'S'
						|| sample.toString().charAt(
								sample.toString().length() - 3) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 2) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 1) == 'P') {
					POSTags2 += sample.toString() + "\n";
					lstPOS.add(sample.toString());
				}

			} else if (sample.toString().length() >= 2) {
				if (sample.toString().charAt(sample.toString().length() - 2) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 1) == 'N'
						|| sample.toString().charAt(
								sample.toString().length() - 3) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 2) == 'N'
						&& sample.toString().charAt(
								sample.toString().length() - 1) == 'S') {
					POSTags2 += sample.toString() + "\n";
					lstPOS.add(sample.toString());
				}

			}
			// perfMon.incrementCounter();
		}

		// perfMon.stopAndPrintFinalResult();
		Object pt[] = new Object[3];
		pt[0] = POSTags;
		pt[1] = POSTags2;
		pt[2] = lstPOS;
		return pt;
	}

	public static void main(String[] args) throws IOException {
		// POSTag();
	}
}
