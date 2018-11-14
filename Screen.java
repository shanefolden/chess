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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

public class Screen extends JPanel implements ActionListener, MouseListener
{
  BufferedImage buffered;
  public JButton submit;
  public JButton start2;
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
  String capturedPieceID = "";
  boolean needToStart = true;
  boolean needFirstClick = true;
  boolean needSecondClick = false;
  int firstRowClicked;
  int firstColClicked;
  int secondRowClicked;
  int secondColClicked;
  int[] clickValues = new int[4];
  boolean clickity = false;



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
    for(int i = 0; i<4; i++)
    {
      clickValues[i]=-1;
    }


    UI ui = new UI();
    this.setLayout(null);
    start2 = new JButton("Start");
    start2.setBounds(840,200, 80, 30);
    submit = new JButton("Submit");
    submit.setBounds(840,400, 80, 30);

    //sets the location and size
    start2.addActionListener(this);
    addMouseListener(this);
    //add the listener
    this.add(start2);

    submit.addActionListener(this);
    addMouseListener(this);
    //add the listener
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

      System.out.println("fjkhdgsklafnbmkjl;nbmkl");
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
    if(capturedPieceID.equals("wp"))
    {
      //System.out.println
      for(int i = 0; i<wpawn.size(); i++)
      {
        //I KNOW THESE ARE SWITCHED BUT I MIXED THEM UP BEFORE AND IDK WHERE SORRY
        int tempRow = wpawn.get(i).returnRow();
        int tempCol = wpawn.get(i).returnCol();
        //System.out.println("tempRow taken from wpawn"+tempRow+" inputted row "+screenPieceLocC);

        //  System.out.println("tempCol taken from wpawn"+tempCol+" inputted col "+screenPieceLocR);

        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          wpawn.remove(i);
        }
      }
    }

    if(capturedPieceID.equals("bp"))
    {
      for(int i = 0; i<bpawn.size(); i++)
      {
        int tempRow = bpawn.get(i).returnRow();
        int tempCol = bpawn.get(i).returnCol();


        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          System.out.println("we made it to the if statement");
          bpawn.remove(i);
        }
      }
    }

    if(capturedPieceID.equals("wr"))
    {
      //System.out.println
      for(int i = 0; i<wrook.size(); i++)
      {
        int tempRow = wrook.get(i).returnRow();
        int tempCol = wrook.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          wrook.remove(i);
        }
      }
    }
    if(capturedPieceID.equals("br"))
    {
      //System.out.println
      for(int i = 0; i<brook.size(); i++)
      {
        int tempRow = brook.get(i).returnRow();
        int tempCol = brook.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          brook.remove(i);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }

    if(capturedPieceID.equals("bb"))
    {
      //System.out.println
      for(int i = 0; i<bbishop.size(); i++)
      {
        int tempRow = bbishop.get(i).returnRow();
        int tempCol = bbishop.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          bbishop.remove(i);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }
    if(capturedPieceID.equals("wb"))
    {
      //System.out.println
      for(int i = 0; i<wbishop.size(); i++)
      {
        int tempRow = wbishop.get(i).returnRow();
        int tempCol = wbishop.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          wbishop.remove(i);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }

    if(capturedPieceID.equals("wk"))
    {
      //System.out.println
      for(int i = 0; i<wking.size(); i++)
      {
        int tempRow = wking.get(i).returnRow();
        int tempCol = wking.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          wking.remove(i);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }
    if(capturedPieceID.equals("bk"))
    {
      //System.out.println
      for(int i = 0; i<bking.size(); i++)
      {
        int tempRow = bking.get(i).returnRow();
        int tempCol = bking.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          bking.remove(i);
        }
      }
    }

    if(capturedPieceID.equals("bq"))
    {
      //System.out.println
      for(int i = 0; i<bqueen.size(); i++)
      {
        int tempRow = bqueen.get(i).returnRow();
        int tempCol = bqueen.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          bqueen.remove(i);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }

    if(capturedPieceID.equals("wq"))
    {
      //System.out.println
      for(int i = 0; i<wqueen.size(); i++)
      {
        int tempRow = wqueen.get(i).returnRow();
        int tempCol = wqueen.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          wqueen.remove(i);
        }
      }
    }
    if(capturedPieceID.equals("wn"))
    {
      //System.out.println
      for(int i = 0; i<wknight.size(); i++)
      {
        int tempRow = wknight.get(i).returnRow();
        int tempCol = wknight.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          wknight.remove(i);
        }
      }
    }
    if(capturedPieceID.equals("bn"))
    {
      //System.out.println
      for(int i = 0; i<bknight.size(); i++)
      {
        int tempRow = bknight.get(i).returnRow();
        int tempCol = bknight.get(i).returnCol();
        if(tempCol==7-newScreenPieceLocR && tempRow==newScreenPieceLocC)
        {
          bknight.remove(i);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
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

    if(screenPieceID.equals("bq"))
    {
      //System.out.println
      for(int i = 0; i<bqueen.size(); i++)
      {
        int tempRow = bqueen.get(i).returnRow();
        int tempCol = bqueen.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          bqueen.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }

    if(screenPieceID.equals("wq"))
    {
      //System.out.println
      for(int i = 0; i<wqueen.size(); i++)
      {
        int tempRow = wqueen.get(i).returnRow();
        int tempCol = wqueen.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          wqueen.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }
    if(screenPieceID.equals("wn"))
    {
      //System.out.println
      for(int i = 0; i<wknight.size(); i++)
      {
        int tempRow = wknight.get(i).returnRow();
        int tempCol = wknight.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          wknight.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }
    if(screenPieceID.equals("bn"))
    {
      //System.out.println
      for(int i = 0; i<bknight.size(); i++)
      {
        int tempRow = bknight.get(i).returnRow();
        int tempCol = bknight.get(i).returnCol();
        if(tempRow==oldScreenPieceLocC && tempCol==oldScreenPieceLocR)
        {
          bknight.get(i).getPosition(newScreenPieceLocC, newScreenPieceLocR);
          //        System.out.println("splc"+screenPieceLocC+"splr "+screenPieceLocR);
        }
      }
    }






  }

  public void mouseClicked(MouseEvent e){

  }
  public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
      public void mouseReleased(MouseEvent e){

      }
      public void mousePressed(MouseEvent e)
      {
        if(clickity){



          int x= e.getX();
          int y = e.getY();

          for(int i = 0; i<8; i++)
          {
            if(y>(63+75*i)&&(y<(63+75*(i+1))))
            {
              for(int j = 0; j<4; j++)
              {
                System.out.println("row "+i);
                if(clickValues[j]==-1)
                {
                  clickValues[j]= i;
                  break;
                }
              }
            }
          }
          for(int i = 0; i<8; i++)
          {
            if(x>(56+75*i)&&(x<(56+75*(i+1))))
            {
              for(int j = 0; j<4; j++)
              {
                System.out.println("col "+i);
                if(clickValues[j]==-1)
                {
                  clickValues[j]=i;
                  break;
                }
              }
            }
          }

          boolean full = true;
          for(int i = 0; i<4; i++)
          {
            if(clickValues[i]==-1)
            {
              full=false;
            }
          }
          if(full)
          {
            converter(clickValues);
            for(int i = 0; i<4; i++)
            {
              clickValues[i]=-1;
            }
          }
        }
      }


      public void converter(int[] values)
      {
        needToStart = true;
        int r1 = values[0];
        int c1 = values[1];
        int r2 = values[2];
        int c2 = values[3];
        String piece = currentArray[r1][c1];
        System.out.println(piece);
        String n1 = piece;
        if(c1==0)
        {
          n1+="a";
        }
        else if(c1==1)
        {
          n1+="b";
        }
        else if(c1==2)
        {
          n1+="c";
        }
        else if(c1==3)
        {
          n1+="d";
        }
        else if(c1==4)
        {
          n1+="e";
        }
        else if(c1==5)
        {
          n1+="f";
        }
        else if(c1==6)
        {
          n1+="g";
        }
        else if(c1==7)
        {
          n1+="h";
        }
        String n2 = "";
        if(c2==0)
        {
          n2+="a";
        }
        else if(c2==1)
        {
          n2+="b";
        }
        else if(c2==2)
        {
          n2+="c";
        }
        else if(c2==3)
        {
          n2+="d";
        }
        else if(c2==4)
        {
          n2+="e";
        }
        else if(c2==5)
        {
          n2+="f";
        }
        else if(c2==6)
        {
          n2+="g";
        }
        else if(c2==7)
        {
          n2+="h";
        }
        r1 = 8-r1;
        r2 = 8-r2;
        n2+=Integer.toString(r2);
        n1+=Integer.toString(r1);
        System.out.println("lol if this works");
        System.out.println(n1+" "+n2);
        boolean pieceExists;

        pieceExists = checker.checkExistence( currentArray, n1,n2);



        if(pieceExists)
        {



          currentArray = move.movePiece(n1,n2, currentArray);

          screenPieceID = move.getPieceID();
          capturedPieceID = move.getCapturedPieceID();
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




      public void actionPerformed(ActionEvent e) {

        if (e.getSource() == start2) {
          needToStart = true;
        }
        if (e.getSource() == submit) {
          clickity = true;
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
