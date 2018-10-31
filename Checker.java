import java.lang.Math;

public class Checker
{

  int newRow;
  int newCol;
  int oldRow;
  int oldCol;
    public Checker()
    {

    }

    public boolean wpRules(String[][] game, int newRow, int newCol, int oldRow, int oldCol)
    {

      if(oldRow==6)
      {
        if(newRow!=5&&newRow!=4)
        {

          System.out.println("exited here 1");
          return false;
        }
        if(newRow==4)
        {
          if(newCol!=oldCol)
          {
                System.out.println(newCol+"new old"+oldCol);
            return false;

          }
          if(!game[newRow][newCol].equals("xx"))
          {
              if(!game[5][newCol].equals("xx")){
                System.out.println("exited here 3");
              return false;

              }

          }
          else{
            return true;}
        }
      }

      if(newRow!=oldRow-1)
      {
        return false;
      }

      if(newCol==oldCol)
      {
          if(!game[newRow][newCol].equals("xx"))
          {
            return false;
          }
      }
      if(newCol-oldCol==1||newCol-oldCol==-1)
      {
          String x = game[newRow][newCol];
          System.out.println("x = "+x);
          if(x.charAt(0)!='b')
          {
            return false;
          }
      }
      return true;
    }

    public boolean brRules(String[][] game, int newRow, int newCol, int oldRow, int oldCol)
    {
      if(newRow!=oldRow && newCol!=oldCol)
      {
        return false;
      }

      if(newRow>oldRow)
      {
        for(int i = oldRow+1; i<newRow; i++)
        {
          if(!game[i][newCol].equals("xx"))
          {
            return false;
          }
        }
      }
      if(oldRow>newRow)
      {
        for(int i = newRow; i<oldRow; i++)
        {
          if(!game[i][newCol].equals("xx"))
          {
            return false;
          }
        }
      }

      if(newCol>oldCol)
      {
        for(int i = oldCol+1; i<newCol; i++)
        {
          if(!game[newRow][i].equals("xx"))
          {
            System.out.println("newRow "+newRow+" i "+i);
            System.out.println(game[newRow][i]);
            return false;
          }
        }
      }
      if(oldCol>newCol)
      {
        for(int i = newCol; i<oldCol; i++)
        {
          if(!game[newRow][i].equals("xx"))
          {
            return false;
          }
        }
      }

      String x = game[newRow][newCol];
      System.out.println("x = "+x);
      if(x.charAt(0)=='b')
      {
        return false;
      }





      return true;
    }

    public boolean wrRules(String[][] game, int newRow, int newCol, int oldRow, int oldCol)
    {
      if(newRow!=oldRow && newCol!=oldCol)
      {
        return false;
      }

      if(newRow>oldRow)
      {
        for(int i = oldRow+1; i<newRow; i++)
        {
          if(!game[i][newCol].equals("xx"))
          {
            return false;
          }
        }
      }
      if(oldRow>newRow)
      {
        for(int i = newRow; i<oldRow; i++)
        {
          if(!game[i][newCol].equals("xx"))
          {
            return false;
          }
        }
      }

      if(newCol>oldCol)
      {
        for(int i = oldCol+1; i<newCol; i++)
        {
          if(!game[newRow][i].equals("xx"))
          {
            System.out.println("newRow "+newRow+" i "+i);
            System.out.println(game[newRow][i]);
            return false;
          }
        }
      }
      if(oldCol>newCol)
      {
        for(int i = newCol; i<oldCol; i++)
        {
          if(!game[newRow][i].equals("xx"))
          {
            return false;
          }
        }
      }

      String x = game[newRow][newCol];
      System.out.println("x = "+x);
      if(x.charAt(0)=='w')
      {
        return false;
      }





      return true;
    }

    public boolean wbRules(String[][] game, int newRow, int newCol, int oldRow, int oldCol)
    {
      if(Math.abs(newCol-oldCol)!=Math.abs(newRow-oldRow))
      {
        return false;
      }

      if(newCol>oldCol)
      {
        if(newRow>oldRow)
        {
            int j = 1;
            for(int i = oldCol+1; i<newCol; i++)
            {
              if(!game[oldRow+j][oldCol+j].equals("xx"))
              {
                return false;
              }
              j++;
            }
        }
        else if(oldRow>newRow)
        {
          int j = 1;
          for(int i = oldCol+1; i<newCol; i++)
          {
            if(!game[oldRow-j][oldCol+j].equals("xx"))
            {
              return false;
            }
            j++;
          }
        }
      }
      if(oldCol>newCol)
      {
        if(newRow>oldRow)
        {
          int j = 1;
          for(int i = newCol+1; i<oldCol; i++)
          {
            if(!game[oldRow+j][oldCol-j].equals("xx"))
            {
              return false;
            }
            j++;
          }
        }
        else if(oldRow>newRow)
        {
          int j = 1;
          for(int i = newCol+1; i<oldCol; i++)
          {
            if(!game[oldRow-j][oldCol-j].equals("xx"))
            {
              return false;
            }
            j++;
          }
        }
      }
      return true;
    }
    public boolean bbRules(String[][] game, int newRow, int newCol, int oldRow, int oldCol)
    {
      if(Math.abs(newCol-oldCol)!=Math.abs(newRow-oldRow))
      {
        return false;
      }

      if(newCol>oldCol)
      {
        if(newRow>oldRow)
        {
            int j = 1;
            for(int i = oldCol+1; i<newCol; i++)
            {
              if(!game[oldRow+j][oldCol+j].equals("xx"))
              {
                return false;
              }
              j++;
            }
        }
        else if(oldRow>newRow)
        {
          int j = 1;
          for(int i = oldCol+1; i<newCol; i++)
          {
            if(!game[oldRow-j][oldCol+j].equals("xx"))
            {
              return false;
            }
            j++;
          }
        }
      }
      if(oldCol>newCol)
      {
        if(newRow>oldRow)
        {
          int j = 1;
          for(int i = newCol+1; i<oldCol; i++)
          {
            if(!game[oldRow+j][oldCol-j].equals("xx"))
            {
              return false;
            }
            j++;
          }
        }
        else if(oldRow>newRow)
        {
          int j = 1;
          for(int i = newCol+1; i<oldCol; i++)
          {
            if(!game[oldRow-j][oldCol-j].equals("xx"))
            {
              return false;
            }
            j++;
          }
        }
      }
      return true;
    }



    public boolean bpRules(String[][] game, int newRow, int newCol, int oldRow, int oldCol)
    {

      if(oldRow==1)
      {
        if(newRow!=3&&newRow!=2)
        {

          System.out.println("exited here 1");
          return false;
        }
        if(newRow==3)
        {
          if(newCol!=oldCol)
          {
                System.out.println(newCol+"new old"+oldCol);
            return false;

          }
          if(!game[newRow][newCol].equals("xx"))
          {
              if(!game[2][newCol].equals("xx")){
                System.out.println("exited here 3");
              return false;

              }

          }
          else{
            return true;}
        }
      }

      if(newRow!=oldRow+1)
      {
        return false;
      }

      if(newCol==oldCol)
      {
          if(!game[newRow][newCol].equals("xx"))
          {
            return false;
          }
      }
      if(newCol-oldCol==1||newCol-oldCol==-1)
      {
          String x = game[newRow][newCol];
          System.out.println("x = "+x);
          if(x.charAt(0)!='w')
          {
            return false;
          }
      }
      return true;
    }

    public boolean checkExistence(String[][] game, String a, String b )
    {
      int charNum = -1;

      System.out.println("input = "+a);

        String checker = a.substring(0,2);

        System.out.println("checker = "+checker);

        if(a.charAt(2)=='A'||a.charAt(2)=='a')
        {
          charNum=0;
        }
        else if(a.charAt(2)=='B'||a.charAt(2)=='b')
        {
          charNum=1;
        }
        else if(a.charAt(2)=='C'||a.charAt(2)=='c')
        {
          charNum=2;
        }
        else if(a.charAt(2)=='D'||a.charAt(2)=='d')
        {
          charNum=3;
        }
        else if(a.charAt(2)=='E'||a.charAt(2)=='e')
        {
          charNum=4;
        }
        else if(a.charAt(2)=='F'||a.charAt(2)=='f')
        {
          charNum=5;
        }
        else if(a.charAt(2)=='G'||a.charAt(2)=='g')
        {
          charNum=6;
        }
        else if(a.charAt(2)=='H'||a.charAt(2)=='h')
        {
          charNum=7;
        }


//string 2
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

        System.out.println("charNum "+charNum);


        String toNum =  Character.toString(a.charAt(3));

        int num2 = 8-(Integer.parseInt(toNum));
        oldRow = num2;
        oldCol = charNum;
         newRow = 8-(Integer.parseInt( Character.toString(b.charAt(1))));

        if(game[num2][charNum].equals(checker))
        {
          if(checker.equals("wp"))
          {
            return wpRules(game, newRow, newCol, oldRow, oldCol);
          }
          if(checker.equals("bp"))
          {
            return bpRules(game, newRow, newCol, oldRow, oldCol);
          }
          if(checker.equals("wr"))
          {
            return wrRules(game, newRow, newCol, oldRow, oldCol);
          }
          if(checker.equals("br"))
          {
            return brRules(game, newRow, newCol, oldRow, oldCol);
          }
          if(checker.equals("wb"))
          {
            return wbRules(game, newRow, newCol, oldRow, oldCol);
          }
          if(checker.equals("bb"))
          {
            return bbRules(game, newRow, newCol, oldRow, oldCol);
          }




          return true;
        }


        else
        {
          System.out.println("false");
          return false;

        }

      }
}
