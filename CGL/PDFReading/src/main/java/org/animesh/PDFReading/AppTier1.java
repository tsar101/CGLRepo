package org.animesh.PDFReading;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * @author animesh
 *
 */
public class AppTier1 {

	public static void main(String[] args) {
		PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        COSDocument cosDoc = null;
        File file = new File(args[0]);
        Pattern p = Pattern.compile("("
    			+ "([ ]{1,})"		//Blank Space at beginning
    			+ "([0-9]{1,10})"   //Serial Number
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([0-9]{10})"		//10 Digit Roll-Number
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([A-Z ]{1,})"	//Candidate Name
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([0-9 ]{1})"		//Cat-1-code	
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([0-9 ]{1})"		//Cat-2-code
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([0-9 ]{1})"		//Cat-3-code
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "(\\S+)"			//Post preference String
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([0-9]{1})"		//SIC	
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([0-9]{1})"		//EQSIC
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([0-9]{1})"		//AAO
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([0-9]{1})"		//EQAAO
    			+ "([ ]{1,})"		//Blank Spaces in between
    			+ "([0-9]{1,}.[0-9]{1,})" //Marks :-)
    			+ ".*)"); 
        try {
            pdDoc = PDDocument.load(file);
            System.out.println("USE CGL_Tier1Result;");
            //System.out.println(pdDoc.getNumberOfPages());
            Splitter splitter = new Splitter();
            splitter.setSplitAtPage(1000);
            List <PDDocument> splitFiles = splitter.split(pdDoc);
           
            for(PDDocument iterableList:splitFiles)
            {
            	
            	//System.out.println(iterableList.getNumberOfPages());
            String contents =   new PDFTextStripper().getText(iterableList);
            
            String[] newLineSeprated = contents.split("\n");
            iterableList.close();
            //System.out.println(contents.length());
            for(String line:newLineSeprated)
            {
            	
            	Matcher m = p.matcher(line); 
            	if (m.matches()) {   
            		//System.out.println(line);
//            		System.out.println("Roll No			 : "+ m.group(5));
//            		System.out.println("Name    		 : "+ m.group(7));
//            		System.out.println("CAT1   			 : "+ m.group(9));
//            		System.out.println("CAT2  			 : "+ m.group(11));
//            		System.out.println("CAT3    		 : "+ m.group(13));
//            		System.out.println("Post-preference  : "+ m.group(15));
//            		System.out.println("SIC				 : "+ m.group(17));
//            		System.out.println("EQSIC			 : "+ m.group(19));
//            		System.out.println("AAO 			 : "+ m.group(21));
//            		System.out.println("EQAAO			 : "+ m.group(23));
//            		System.out.println("Marks            : "+ m.group(25));
            		System.out.format("INSERT INTO TIER1_RESUT Values (%s,'%s',%s,%s,%s,'%s',%s,%s,%s,%s,%s);",
            				m.group(5),
            				m.group(7).trim(),
            				(m.group(9).contains((" "))?"NULL":m.group(9)),
            				(m.group(11).contains((" "))?"NULL":m.group(11)),
            				(m.group(13).contains((" "))?"NULL":m.group(13)),
            				m.group(15),
            				m.group(17),
            				m.group(19),
            				m.group(21),
            				m.group(23),
            				m.group(25));
            		System.out.println();
//            	   for(int i=1;i<=m.groupCount();i++)
//            	  {System.out.println(m.group(i) + " : " + i);}  
//            	  // m.group(0) is the entire matched item, not the first group.
//            	  // etc... 
//            	}
            	//System.out.println(line);
//            	if(line.matches(".*[0-9]{10}.*")){
//            		System.out.println(line);
//            	}
            					} 
            	else{
            		//System.out.println("Did not match");
            		//System.out.println(line);
            	}
            }}
            pdDoc.close();
            	}
            	catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
	}

}
