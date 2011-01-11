package org.loreii;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.SourceLocator;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;


public class Trs {


	public static void main (String [] args){

		String infile  = args[0];
		String outfile = args[1];
		String xslfile1 = args[2];
		//String xslfile2 = args[3];

		xsl(infile, outfile, xslfile1);
		//xsl(infile, outfile, xslfile2);


	}
	
	
	public static void xsl(String inFilename, String outFilename, String xslFilename) {
        try {
            // Create transformer factory
            TransformerFactory factory = TransformerFactory.newInstance();

            // Use the factory to create a template containing the xsl file
            Templates template = factory.newTemplates(new StreamSource(
                new FileInputStream(xslFilename)));

            // Use the template to create a transformer
            Transformer xformer = template.newTransformer();

            // Prepare the input and output files
            Source source = new StreamSource(new FileInputStream(inFilename));
            
            Result result = new StreamResult(new FileOutputStream(outFilename,false));
            
            // Apply the xsl file to the source file and write the result to the output file
            
            xformer.transform(source, result);
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            // An error occurred in the XSL file
        	e.printStackTrace();
        } catch (TransformerException e) {
        	e.printStackTrace();
            // An error occurred while applying the XSL file
            // Get location of error in input file
            SourceLocator locator = e.getLocator();
            int col = locator.getColumnNumber();
            int line = locator.getLineNumber();
            String publicId = locator.getPublicId();
            String systemId = locator.getSystemId();
        }
    }
	

	
	public static Document xsl(String src, String xsl) {
        try {
            // Create transformer factory
            TransformerFactory factory = TransformerFactory.newInstance();

            // Use the factory to create a template containing the xsl file
            Templates template = factory.newTemplates(new StreamSource( new ByteArrayInputStream(xsl.getBytes())));

            // Use the template to create a transformer
            Transformer xformer = template.newTransformer();

            // Prepare the input and output files
            Source source = new StreamSource( new ByteArrayInputStream(src.getBytes()));
            
            // Create a new document to hold the results
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            Result result = new DOMResult(doc);
            
            // Apply the xsl file to the source file and write the result to the output file
            
            xformer.transform(source, result);
            return doc;
        } catch (TransformerConfigurationException e) {
            // An error occurred in the XSL file
        	e.printStackTrace();
        } catch (TransformerException e) {
        	e.printStackTrace();
            // An error occurred while applying the XSL file
            // Get location of error in input file
            SourceLocator locator = e.getLocator();
            int col = locator.getColumnNumber();
            int line = locator.getLineNumber();
            String publicId = locator.getPublicId();
            String systemId = locator.getSystemId();
        } catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	

}
