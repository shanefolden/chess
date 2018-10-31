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

public class Screen extends JPanel implements ActionListener
{
  BufferedImage buffered;
  public JButton submit;
  public JTextField t1;
  public JTextField t2;
  Chessboard board;
  UI ui = new UI();
  String s1 = " ";
  String s2 = " ";
  boolean startCheck;
  Move move = new Move();
  int oldScreenPieceLocR;
  int oldScreenPieceLocC;
  int newScreenPieceLocR;
  int newScreenPieceLocC;
  String screenPieceID = "";
  boolean needToStart = true;

  static String[][] currentArray;

  ArrayList<WhitePawn> wpawn =new ArrayList<WhitePawn>();
  ArrayList<WhiteRook> wrook =new ArrayList<WhiteRook>();
  ArrayList<WhiteKnight> wknight =new ArrayList<WhiteKnight>();
  ArrayList<WhiteBishop> wbishop =new ArrayList<WhiteBishop>();
  ArrayList<WhiteKing> wking =new ArrayList<WhiteKing>();
  ArrayList<WhiteQueen> wqueen =new ArrayList<WhiteQueen>();

  ArrayList<BlackPawn> bpawn =new ArrayList<BlackPawn>();
  ArrayList<BlackRook> brook =new ArrayList<BlackRook>();
  ArrayList<BlackKnight> bknight=new ArrayList<BlackKnight>();
  ArrayList<BlackBishop> bbishop =new ArrayList<BlackBishop>();
  ArrayList<BlackKing> bking =new ArrayList<BlackKing>();
  ArrayList<BlackQueen> bqueen =new ArrayList<BlackQueen>();
  Font font = new Font("Arial", Font.PLAIN, 20);
  Checker checker = new Checker();




  public Screen()
  {

    Start start = new Start();
    currentArray = start.setUp();


    UI ui = new UI();
    this.setLayout(null);
    submit = new JButton("Submit");
    submit.setBounds(840,200, 80, 30);
    //sets the location and size
    submit.addActionListener(this); //add the listener
    this.add(submit);

    t1 = new JTextField(20);
    t1.setBounds(770,50, 120, 30);
    this.add(t1);


    t2 = new JTextField(20);
    t2.setBounds(930,50, 120, 30);
    this.add(t2);

    this.setFocusable(true);



    //ui.text();

    for(int i = 0; i<8; i++)
    {
      for(int j=0; j<8; j++)
      {
        String temp = currentArray[i][j];
        temp = temp.substring(0,2);

        if(temp=="wp")
        {
          // System.out.println("White Pawn");
          wpawn.add(0, new WhitePawn());
          wpawn.get(0).getPosition(j, 7-i);
        }

        if(temp=="bp")
        {
          //System.out.println("Black Pawn");
          bpawn.add(0, new BlackPawn());
          bpawn.get(0).getPosition(j, 7-i);
        }

        if(temp=="br")
        {
          // System.out.println("Black Rook");
          brook.add(0, new BlackRook());
          brook.get(0).getPosition(j, 7-i);
        }

        if(temp=="bb")
        {
          // System.out.println("Black Bishop");
          bbishop.add( 0,new BlackBishop());
          bbishop.get(0).getPosition(j, 7-i);
        }

        if(temp=="bn")
        {
          //System.out.println("Black Knight");
          bknight.add(0, new BlackKnight());
          bknight.get(0).getPosition(j, 7-i);
        }

        if(temp=="bk")
        {
          //System.out.println("Black King");
          bking.add( 0, new BlackKing());
          bking.get(0).getPosition(j, 7-i);
        }
        if(temp=="bq")
        {
          //System.out.println("Black Queen");
          bqueen.add(0, new BlackQueen());
          bqueen.get(0).getPosition(j, 7-i);
        }



        if(temp=="wr")
        {
          //System.out.println("White Rook");
          wrook.add(0, new WhiteRook());
          wrook.get(0).getPosition(j, 7-i);
        }

        if(temp=="wb")
        {
          //System.out.println("White Bishop");
          wbishop.add(0, new WhiteBishop());
          wbishop.get(0).getPosition(j, 7-i);
        }

        if(temp=="wn")
        {
          //System.out.println("White Knight");
          wknight.add(0, new WhiteKnight());
          wknight.get(0).getPosition(j, 7-i);
        }

        if(temp=="wk")
        {
          //System.out.println("WhiteKing");
          wking.add(0, new WhiteKing());
          wking.get(0).getPosition(j, 7-i);
        }
        if(temp=="wq")
        {
          //System.out.println("White Queen");
          wqueen.add(0, new WhiteQueen());
          wqueen.get(0).getPosition(j, 7-i);
        }
      }
    }



    board = new Chessboard();
  }
  public Dimension getPreferredSize()
  {
    //Sets the size of the panel
    return new Dimension(1200,1000);
  }
  public void paintComponent(Graphics g)
  {


    super.paintComponent(g);

    if( buffered == null )
    {
      buffered = (BufferedImage)(createImage( getWidth(), getHeight() ) );
    }


    if(needToStart)
    {


      //Create a temporary graphics buffered to draw
      Graphics gBuff = buffered.createGraphics();
      //gBuff.fillrect(50,50,50,50);

      board.drawMe(gBuff);





      for(int i = 0; i<wpawn.size(); i++)
      {
        wpawn.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<wrook.size(); i++)
      {
        wrook.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<wknight.size(); i++)
      {
        wknight.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<wbishop.size(); i++)
      {
        wbishop.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<wqueen.size(); i++)
      {
        wqueen.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<wking.size(); i++)
      {
        wking.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<bpawn.size(); i++)
      {
        bpawn.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<brook.size(); i++)
      {
        brook.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<bknight.size(); i++)
      {
        bknight.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<bbishop.size(); i++)
      {
        bbishop.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<bqueen.size(); i++)
      {
        bqueen.get(i).drawMe(gBuff);
      }

      for(int i = 0; i<bking.size(); i++)
      {
        bking.get(i).drawMe(gBuff);
      }



      gBuff.setFont(font);
      gBuff.setColor(Color.black);
      gBuff.drawString("Starting Position", 770,50);
      gBuff.drawString("Ending Position", 930, 50);


      g.drawImage(buffered,0,0,null);

      needToStart=false;

    }

  }




  public void setPiece()
  {
    System.out.println("this is the thing thing");
    for(int i = 0; i<8; i++)
    {
      for(int j = 0; j<8; j++)
      {
        System.out.print(currentArray[i][j]+" ");
      }
      System.out.println("");
    }
    //System.out.println("ID "+screenPieceID+"loc "+screenPieceLoc);
    //System.out.println("screen piece id is "+screenPieceID);
    if(screenPieceID.equals("wp"))
    {
      //System.out.println
      for(int i = 0; i<wpawn.size(); i++)
      {
        //I KNOW THESE ARE SWITCHED BUT I MIXED THEM UP BEFORE AND IDK WHERE SORRY


        int tempRow = wpawn.get(i).returnRow();
        int tempCol = wpawn.get(i).returnCol();
       //System.out.println("tempRow taken from wpawn"+tempRow+" inputted row "+screenPieceLocC);

      //  System.out.println("tempCol taken from wpawn"+tempCol+" inputted col "+screenPieceLocR);

        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          wpawn.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
  //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }

    if(screenPieceID.equals("bp"))
    {
      //System.out.println
      for(int i = 0; i<bpawn.size(); i++)
      {
        //I KNOW THESE ARE SWITCHED BUT I MIXED THEM UP BEFORE AND IDK WHERE SORRY


        int tempRow = bpawn.get(i).returnRow();
        int tempCol = bpawn.get(i).returnCol();
       //System.out.println("tempRow taken from wpawn"+tempRow+" inputted row "+screenPieceLocC);

      //  System.out.println("tempCol taken from wpawn"+tempCol+" inputted col "+screenPieceLocR);

        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          bpawn.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
  //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }

    if(screenPieceID.equals("wr"))
    {
      //System.out.println
      for(int i = 0; i<wrook.size(); i++)
      {
        int tempRow = wrook.get(i).returnRow();
        int tempCol = wrook.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          wrook.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
  //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }
    if(screenPieceID.equals("br"))
    {
      //System.out.println
      for(int i = 0; i<brook.size(); i++)
      {
        int tempRow = brook.get(i).returnRow();
        int tempCol = brook.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          brook.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
  //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }

    if(screenPieceID.equals("bb"))
    {
      //System.out.println
      for(int i = 0; i<bbishop.size(); i++)
      {
        int tempRow = bbishop.get(i).returnRow();
        int tempCol = bbishop.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          bbishop.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
  //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }
    if(screenPieceID.equals("wb"))
    {
      //System.out.println
      for(int i = 0; i<wbishop.size(); i++)
      {
        int tempRow = wbishop.get(i).returnRow();
        int tempCol = wbishop.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          wbishop.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
  //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }

    if(screenPieceID.equals("wk"))
    {
      //System.out.println
      for(int i = 0; i<wking.size(); i++)
      {
        int tempRow = wking.get(i).returnRow();
        int tempCol = wking.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          wking.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
  //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }
    if(screenPieceID.equals("bk"))
    {
      //System.out.println
      for(int i = 0; i<bking.size(); i++)
      {
        int tempRow = bking.get(i).returnRow();
        int tempCol = bking.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          bking.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
  //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }




  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submit) {
      System.out.println("Button has been clicked");
      needToStart = true;


      s1 = t1.getText();
      s2 = t2.getText();
      boolean pieceExists;

      pieceExists = checker.checkExistence( currentArray, s1,s2);



      if(pieceExists)
      {

        System.out.println("s1 -"+s1);

        System.out.println("s2 -"+s2);
        currentArray = move.movePiece(s1,s2, currentArray);

        screenPieceID = move.getPieceID();
        newScreenPieceLocR = move.getNewPositionR();
        newScreenPieceLocC = move.getNewPositionC();
        oldScreenPieceLocR = move.getOldPositionR();
        oldScreenPieceLocC = move.getOldPositionC();
        //System.out.println("col and row");
        //System.out.println(screenPieceLocC + " "+screenPieceLocR);

        setPiece();

      }

      if(!pieceExists)
      {
        System.out.println("piece does not exist at that position");
      }



      repaint();
    }
  }



}
