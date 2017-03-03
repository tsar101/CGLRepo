package org.animesh.PDFReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String args[]) {
        PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        COSDocument cosDoc = null;
        File file = new File("/home/animesh/workspace/PDFReading/LIST2_cgletierii_28022017.pdf");
        try {
            pdDoc = PDDocument.load(file);
          
            String contents =   new PDFTextStripper().getText(pdDoc);
            String[] newLineSeprated = contents.split("\n");
            for(String line:newLineSeprated)
            {
            	//System.out.println(line);
            	if(line.matches(".*[0-9]{10}.*"))
            	{
            		for(String candidateLine:line.split("[0-9]+[.]"))
            		{
            			if(!candidateLine.matches(".*[A-B].*"))
            			{
            				continue;
            			}
            			queryPrinter(candidateLine);
            		}
            	}
            		//}
            }
              } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
	
	public static void queryPrinter(String candidateLine)
	{
		
			StringBuilder candidateName = new StringBuilder();
			String candidateName1="NULL" ;
			String rollNo = "NULL";
			String categoryId = "NULL";
			for(String categoryKidIndex:candidateLine.split(" "))
			{
				if(categoryKidIndex.matches("[0-9]{1}"))
					categoryId = categoryKidIndex;
				if(categoryKidIndex.matches("[0-9]{10}"))
					rollNo = categoryKidIndex;
				if(categoryKidIndex.matches(".*[A-Z].*"))
				{
					candidateName.append(categoryKidIndex+" ");
				}
			}
			//System.out.println(candidateLine);
			candidateName1 = (String) candidateName.subSequence(0,candidateName.length()-1);
            System.out.format("INSERT INTO LIST2 values (%s,%s,'%s')\n",rollNo,categoryId,candidateName1);   		
		
	}
}
