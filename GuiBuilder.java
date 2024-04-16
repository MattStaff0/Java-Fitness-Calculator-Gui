//  imports 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiBuilder {
    //no fields want this to be static to be used at all times while building app

    public static JLabel makeLabel(String text){
        return new JLabel(text);
    }

    public static JButton makeButton(String text){
        return new JButton(text);
    }

    public static JTextField makeTextField(int space){
        return new JTextField(space);
    }

    

    public static double roundToDecmialPlaces(double val, int places){
        double scale = Math.pow(10, places);
        return Math.round(val * scale) / scale;
    }

    public static double calcFatMass(double weight, double bodyFat){
        return bodyFat * weight; }

    public static double calcLeanMass(double weight, double FatMass){
        return weight - FatMass; }

  
}
