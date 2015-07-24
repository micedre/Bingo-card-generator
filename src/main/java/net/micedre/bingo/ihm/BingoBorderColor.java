/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.micedre.bingo.ihm;

import com.itextpdf.text.BaseColor;

/**
 *
 * @author micedre
 */
public enum BingoBorderColor {
   BLACK(BaseColor.BLACK,"Noir"),
   GREY(BaseColor.GRAY,"Gris"),
   RED(BaseColor.RED,"Rouge"),
   BLUE(BaseColor.BLUE,"Bleu"),
   PINK(BaseColor.PINK,"Rose"),
   YELLOW(BaseColor.YELLOW,"Jaune"),
   GREEN(BaseColor.GREEN,"Vert"),
    WHITE(BaseColor.WHITE,"Blanc");
    private BaseColor color;
    private String name;
    
    private BingoBorderColor(BaseColor color,String name){
        this.color=color;
        this.name=name;
    }

    public BaseColor getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        String s = this.getName();
        return s;
    }
}
