import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Move
{
  static  String pieceID = "";
  static String movedPos = "";
  static int oldCol;
  static int oldRow;
  static int newCol;
  static int newRow;

    public static String[][] movePiece(String oldLoc, String newLoc, String[][] arr)
    {
        System.out.println("oldloc "+oldLoc);
        System.out.println("newloc "+ newLoc);




        oldCol = -1;
        newCol = -1;

        String a = oldLoc;
        String b = newLoc;
        movedPos = newLoc;

        String checker = a.substring(0,2);
        pieceID = checker;

          if(a.charAt(2)=='A'||a.charAt(2)=='a')
          {
            oldCol=0;
          }
          else if(a.charAt(2)=='B'||a.charAt(2)=='b')
          {
            oldCol=1;
          }
          else if(a.charAt(2)=='C'||a.charAt(2)=='c')
          {
            oldCol=2;
          }
          else if(a.charAt(2)=='D'||a.charAt(2)=='d')
          {
            oldCol=3;
          }
          else if(a.charAt(2)=='E'||a.charAt(2)=='e')
          {
            oldCol=4;
          }
          else if(a.charAt(2)=='F'||a.charAt(2)=='f')
          {
            oldCol=5;
          }
          else if(a.charAt(2)=='G'||a.charAt(2)=='g')
          {
              oldCol=6;
          }
          else if(a.charAt(2)=='H'||a.charAt(2)=='h')
          {
            oldCol=7;
          }



          String toNum =  Character.toString(a.charAt(3));
          oldRow = 8-(Integer.parseInt(toNum));

          System.out.println("old row "+oldRow+" old col "+oldCol);



          if(b.charAt(0)=='A'||b.charAt(0)=='a')
          {
            newCol=0;
          }
          else if(b.charAt(0)=='B'||b.charAt(0)=='b')
          {
            newCol=1;
          }
          else if(b.charAt(0)=='C'||b.charAt(0)=='c')
          {
            newCol=2;
          }
          else if(b.charAt(0)=='D'||b.charAt(0)=='d')
          {
            newCol=3;
          }
          else if(b.charAt(0)=='E'||b.charAt(0)=='e')
          {
            newCol=4;
          }
          else if(b.charAt(0)=='F'||b.charAt(0)=='f')
          {
            newCol=5;
          }
          else if(b.charAt(0)=='G'||b.charAt(0)=='g')
          {
              newCol=6;
          }
          else if(b.charAt(0)=='H'||b.charAt(0)=='h')
          {
            newCol=7;
          }



          String toNum2 =  Character.toString(b.charAt(1));
          newRow = 8-(Integer.parseInt(toNum2));

          System.out.println(oldRow+" "+oldCol+" "+newRow+" "+newCol);

          arr[oldRow][oldCol] = "xx";
          arr[newRow][newCol] = checker;


        return arr;

    }

    public String getPieceID()
    {
      return pieceID;
    }

    public int getNewPositionR()
    {
        return 7-newRow;
    }
    public int getNewPositionC()
    {

        return newCol;
    }
    public int getOldPositionR()
    {
        return oldRow;
    }
    public int getOldPositionC()
    {

        return oldCol;
    }



}
