/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.micedre.bingo.ihm;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import net.micedre.bingo.BingoStrip;
import net.micedre.bingo.pdf.BingoPdf;
import net.micedre.bingo.pdf.BingoPdfOnShot;

/**
 * 
 * @author micedre
 */
public class Test {
	public static void main(String args[]) throws DocumentException,
			FileNotFoundException {
		Map<String, BaseColor> colors = new HashMap<String, BaseColor>();
		colors.put("white", BaseColor.WHITE);
		List<BingoStrip> strips = new ArrayList<BingoStrip>();
		int numero=1;
		for(String s : colors.keySet()){
			strips.clear();
			for (int i = 0; i < 6; i++) {
				strips.add(new BingoStrip(numero));
				numero++;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			BingoPdf b = new BingoPdf(new File("E:/dev/bingo/"), s+".pdf", "",
					BaseColor.BLACK, null,colors.get(s));
			
			for(int j=0;j<6;j++){
				b.build(strips,j+1);
			}
		}
		

	}
}
