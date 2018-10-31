import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Chessboard extends JPanel
{
   BufferedImage buffered;
    private BufferedImage chessboardImg;
    int row;
    int col;

    public Chessboard()
    {

      try {
           chessboardImg = ImageIO.read(new File("chessboard.png"));
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public void drawMe(Graphics g)
    {
         //super.paintComponent(g);
         g.setColor(Color.black);
         g.drawImage(chessboardImg, 0,0, 750,750,null);
         //g.drawImage(buffered,0,0,null);
         //System.out.println("check");

    }
  }
