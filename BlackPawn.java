import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BlackPawn extends JPanel
{
   BufferedImage buffered;
    private BufferedImage bpawnImg;
    int row;
    int col;

    public BlackPawn()
    {

      try {
           bpawnImg = ImageIO.read(new File("bpawn.png"));
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public void getPosition(int a, int b)
    {
        row = a;
        col = b;
        //System.out.println(row+" "+col);
    }

    public void drawMe(Graphics g)
    {
         //super.paintComponent(g);
         g.setColor(Color.black);
         g.drawImage(bpawnImg, 60 + 79*row, 610-(78*col), 75,75,null);

         //System.out.println("check");

    }

}
