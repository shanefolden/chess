import java.util.Arrays;

public class Start
{
  static String[][] game = new String[8][8];
  public Start()
  {

  }

  public String[][] setUp()
  {
    String[][] game = new String[8][8];

    game[0][0] = "br";
    game[0][1] = "bn";
    game[0][2] = "bb";
    game[0][3] = "bq";
    game[0][4] = "bk";
    game[0][5] = "bb";
    game[0][6] = "bn";
    game[0][7] = "br";
    for(int i = 0; i<8; i++)
    {
      game[1][i] = "bp";
    }
    for(int i = 2; i<6; i++)
    {
      for(int j = 0; j<8; j++)
      {
        game[i][j] = "xx";
      }
    }
    game[7][0] = "wr";
    game[7][1] = "wn";
    game[7][2] = "wb";
    game[7][3] = "wq";
    game[7][4] = "wk";
    game[7][5] = "wb";
    game[7][6] = "wn";
    game[7][7] = "wr";
    for(int i = 0; i<8; i++)
    {
      game[6][i] = "wp";
    }



    return game;
  }



}
