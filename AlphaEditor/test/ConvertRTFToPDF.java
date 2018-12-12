/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alfredo Silva
 */
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.rtf.parser.RtfParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// usar a biblioteca iText

public class ConvertRTFToPDF {
    public static void main(String[] args) {
        String inputFile = "sample.rtf";
        String outputFile = "sample_converted.pdf";

        // create a new document
        Document document = new Document();
        try {
            // create a PDF writer to save the new document to disk
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
            // open the document for modifications
            document.open();
            // create a new parser to load the RTF file
            RtfParser parser = new RtfParser(null);
            // read the rtf file into a compatible document
            parser.convertRtfDocument(new FileInputStream(inputFile), document);
            // save the pdf to disk
            document.close();
            System.out.println("Finished");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
