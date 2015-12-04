package ontology;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.eclipse.core.runtime.IPath;

import cesar.sacbr.plugin.Activator;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class AnaphoraResolution {

	public static String resolve(String line) {
		String resolved_line = "";

		try {
			Writer output = null;
			String text = line;
			File file = new File("write.txt");
			output = new BufferedWriter(new FileWriter(file));
			output.write(text);
			output.close();

			IPath pathy = Activator.getDefault().getStateLocation();
			MaxentTagger tagger = new MaxentTagger(Activator.getDefault()
					.getStateLocation() + "/models/left3words-wsj-0-18.tagger");
			// String taggerDir=
			// "C:/J2E/Cesar-Plugin-Workspace/Cesar.SACBR.plugin/models/left3words-wsj-0-18.tagger";

			List<Sentence<? extends HasWord>> sentences = MaxentTagger
					.tokenizeText(new BufferedReader(
							new FileReader("write.txt")));
			for (Sentence<? extends HasWord> sentence : sentences) {
				Sentence<TaggedWord> tSentence = MaxentTagger
						.tagSentence(sentence);

				String recent_entity = null;
				boolean previous_sibbling_is_entity = false;

				for (TaggedWord tw : tSentence) {
					String word = tw.word();

					String tag = tw.tag();
					if (isEntityTag(tag)) {
						if (previous_sibbling_is_entity) {
							recent_entity = recent_entity + " " + word;
						}// endif -2
						else {
							recent_entity = word;
						} // else-2
						previous_sibbling_is_entity = true;
					} // endif-1
					else {
						previous_sibbling_is_entity = false;
					}
					if (isPronoun(tag, word) & recent_entity != null) {
						resolved_line = resolved_line + " " + recent_entity;
					} else {
						if (word.equals("-LRB-")) {
							word = "(";
							resolved_line = resolved_line + word;
						} else if (word.equals("-RRB-")) {
							word = ")";
							resolved_line = resolved_line + word;
						} else {
							resolved_line = resolved_line + " " + word;
						}
					}
				} // end for

			} // end while
		} // end try
		catch (Exception e) {
			e.printStackTrace();
		} // end catch
		System.out.println(line);
		System.out.println("Resolved: " + resolved_line);
		return resolved_line;
	} // end resolve

	public static boolean isEntityTag(String tag) {
		if (tag.equals("NNS") | tag.equals("NN")) {
			return true;
		}
		return false;
	}

	public static boolean isPronoun(String tag, String word) {
		if (tag.equals("WP") | tag.equals("PRN") | tag.equals("PRP")) {
			return true;
		} else if (tag.equals("PRP$")) {
			if (word.toLowerCase().equals("its")) {
				return false;
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		resolve(" The inventory has already been ordered from suppliers who are generally able to supply tapes and disks within one week");
	}

}
