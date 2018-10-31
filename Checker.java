public class Checker
{
    public Checker()
    {

    }

    public boolean checkExistence(String[][] game, String a)
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

        System.out.println("charNum "+charNum);

        String toNum =  Character.toString(a.charAt(3));

        int num2 = 8-(Integer.parseInt(toNum));

        if(game[num2][charNum].equals(checker))
        {
          System.out.println("true");
          return true;
        }


        else
        {
          System.out.println("false");
          return false;

        }

      }
}
