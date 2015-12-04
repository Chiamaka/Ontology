/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ontology;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.URL;

import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

class TextExtractor {
	private OutputStream outputstream;
	private ParseContext context;
	private Detector detector;
	private Parser parser;
	private Metadata metadata;
	private String extractedText;
	
	//Constructor Class
	public TextExtractor() {
		context = new ParseContext();
		detector = new DefaultDetector();
		parser = new AutoDetectParser(detector);
		context.set(Parser.class, parser);
		outputstream = new ByteArrayOutputStream();
		metadata = new Metadata();
	}
	
	//to parsse the file
	public void process(String filename) throws Exception {
		URL url;
		File file = new File(filename);
		if (file.isFile()) {
			url = file.toURI().toURL();
		} else {
			url = new URL(filename);
		}
		InputStream input = TikaInputStream.get(url, metadata);
		ContentHandler handler = new BodyContentHandler(outputstream);
		parser.parse(input, handler, metadata, context);
		input.close();
	}
	
	//method to return the text extracted from the document as a string
	public String getString() throws IOException {
		// Get the text into a String object
		extractedText = outputstream.toString();
		// Do whatever you want with this String object.
	
		return extractedText;
	}
	
	//method to creat a text file from the inputed document
	public double createTextFile() throws IOException{
		double num = Math.random();
		PrintStream diskwriter = new PrintStream("nlp/tikaoutput" + num + ".txt");
		diskwriter.print(this.getString());
		
		return num;
		
	}
	
	public static void main(String args[]) throws Exception {

		TextExtractor textExtractor = new TextExtractor();
		textExtractor.process("sample.pdf");
		textExtractor.getString();

	}
}
