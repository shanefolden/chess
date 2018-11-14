import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BlackKnight extends JPanel
{
  BufferedImage buffered;
  private BufferedImage bknightImg;
  int row;
  int col;

  public BlackKnight()
  {

    try {
      bknightImg = ImageIO.read(new File("bknight.png"));
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
  public int returnRow()
  {
    return row;
  }
  public int returnCol()
  {
    return 7-col;
  }



  public void drawMe(Graphics g)
  {
    //super.paintComponent(g);
    g.setColor(Color.black);
    g.drawImage(bknightImg, 60 + 79*row, 610-(78*col), 70,70,null);

    //System.out.println("check");

  }

}
