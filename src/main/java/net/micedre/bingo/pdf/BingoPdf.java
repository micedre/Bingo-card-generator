/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.micedre.bingo.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.micedre.bingo.BingoStrip;

/**
 *
 * @author micedre
 */
public class BingoPdf extends Observable {

    private File outputFolder;
    private String filename;
    private String author;
    private BaseColor color;
    private BaseColor emptyColor;
    private Image image;

    public BingoPdf(File outputFolder, String filename, String author, BaseColor color, Image image,BaseColor emptyColor) {
        this.outputFolder = outputFolder;
        this.filename = filename;
        this.author = author;
        this.color = color;
        this.image = image;
        this.emptyColor=emptyColor;
    }

    public BingoPdf(File outputFolder, String filename) {
        this.outputFolder = outputFolder;
        this.filename = filename;
    }

    public boolean build(List<BingoStrip> strips, int nbGrilleParPage) throws DocumentException, FileNotFoundException {
        Document document = new Document(PageSize.A4, 6, 6, 13, 5);
        
        PdfWriter.getInstance(document,
                new FileOutputStream(outputFolder + File.separator + filename));
        document.open();

        int i = 0;
        float pageHeight = document.getPageSize().getHeight();
    	float cellHeight = (pageHeight - 6 - 6 - (3*30))/(3*nbGrilleParPage);
        for (BingoStrip strip : strips) {
        	
            document.add(getPdfPage(strip.getPage(),  strip.getSerial(),nbGrilleParPage,cellHeight));
            //document.newPage();
            this.setChanged();
            this.notifyObservers(i+1);
            i++;
        }
        document.close();
        return true;

    }

    private Element getPdfPage(int[][] page, int serial,int nbGrilleParPage,float cellHeight) {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

        for (int i = 0; i < 6 ; i++) {
            PdfPTable grille = new PdfPTable(1);
            grille.setWidthPercentage(100);
            grille.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            grille.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            grille.getDefaultCell().setPadding(0);
             grille.getDefaultCell().setPaddingBottom(0);
              grille.getDefaultCell().setPaddingTop(0);
            grille.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            for (int j = 3 * i; j < 3 * (i + 1); j++) {
                grille.addCell(getTableLine(page[j],cellHeight));
                
            }
            grille.addCell(getTableSeparator(i+1, serial));
            table.addCell(grille);
        }
       
        return table;
    }

    private PdfPTable getTableLine(int[] line, float cellHeight) {
        PdfPTable grille = new PdfPTable(line.length);
        grille.setWidthPercentage(100);
        grille.getDefaultCell().setPadding(0);
        grille.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        grille.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
        grille.getDefaultCell().setFixedHeight(cellHeight );
        
        grille.getDefaultCell().setBorderColor(color);
        grille.getDefaultCell().setBorderWidth(2);
        
        Font font = new Font(Font.FontFamily.HELVETICA,(cellHeight/70f) +35,Font.BOLD);
        
        for (int i = 0; i < line.length; i++) {
            
            if(line[i]==0){
                if(image!=null){
                  grille.addCell(image);
                }
                else if(emptyColor!=null)
                {
                    PdfPCell cell = new PdfPCell();
                    cell.setBackgroundColor(emptyColor);
                    cell.setBorderWidth(2);
                    grille.addCell(cell);
                }else{
                	PdfPCell cell = new PdfPCell();
                    cell.setBackgroundColor(BaseColor.WHITE);
                    cell.setBorderWidth(2);
                    grille.addCell(cell);
                }
             
            }else{
                  Phrase phrase = new Phrase(String.valueOf(line[i]),font);
                  grille.addCell(phrase);
            }
                
         
     
        }
        return grille;

    }

    private PdfPTable getTableSeparator(int number, int serial) {
        PdfPTable grille = new PdfPTable(3);
        grille.setWidthPercentage(100);
      
        
        Font font = new Font(Font.FontFamily.COURIER);
        font.setSize(6);
              
        Phrase pnumber = new Phrase(String.valueOf(number),font); 
        PdfPCell cNumber = new PdfPCell(pnumber);
       cNumber.setHorizontalAlignment(Element.ALIGN_LEFT);
        cNumber.setVerticalAlignment(Element.ALIGN_TOP);
        cNumber.setBorder(PdfPCell.NO_BORDER);
        cNumber.setFixedHeight(10);
        
        
        Phrase pAuthor = new Phrase(author,font);
        PdfPCell cAuthor = new PdfPCell(pAuthor);
       cAuthor.setHorizontalAlignment(Element.ALIGN_CENTER);
        cAuthor.setVerticalAlignment(Element.ALIGN_TOP);
        cAuthor.setBorder(PdfPCell.NO_BORDER);
       cAuthor.setFixedHeight(10);
        
                
                
        Phrase pSerial = new Phrase("N° de série : "+String.valueOf(serial),font);
        PdfPCell cellserial = new PdfPCell(pSerial);
     cellserial.setHorizontalAlignment(Element.ALIGN_RIGHT);
  cellserial.setVerticalAlignment(Element.ALIGN_TOP);
       cellserial.setBorder(PdfPCell.NO_BORDER);
        cellserial.setFixedHeight(10);
        
        grille.addCell(cNumber);
        grille.addCell(cAuthor);
        grille.addCell(cellserial);
        return grille;
        
    }
    
}
