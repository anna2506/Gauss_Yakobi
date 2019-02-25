
public class Gauss {
  Double[][] extendedMatrix = {{3.738, 0.195, 0.275, 0.136, 0.815},
          {0.519, 5.002, 0.405, 0.283, 0.191},
          {0.306, 0.381, 4.812, 0.418, 0.423},
          {0.272, 0.142, 0.314, 3.935, 0.352}};

  int razm = 4;
  Double help;
  Double[] res = new Double[razm];
  public void init()
  {
    for (int i = 0; i < razm; i++)
    {
      res[i] = 0.0;
    }
  }
  public void transformation()//трансформируем матрицу в верхнюю треугольную
  {
    for(int j = 0; j < razm; j++)
    {
      for(int i = razm - 1; i > 0; i--)
      {
        if(i == j)
        {
          break;
        }
        else
        {
          help = extendedMatrix[i][j]/extendedMatrix[i - 1][j];
          for(int k = j; k < 5; k++)
          {
            extendedMatrix[i][k] = extendedMatrix[i][k] - help*extendedMatrix[i - 1][k];
          }
        }
      }
    }
  }
  public  void printing()//выводим трансформированную матрицу
  {
    System.out.println("Решение системы методом Гаусса");
    System.out.println("Трансформированная матрица:");
    for(int i = 0; i < razm; i++)
    {
      for (int j = 0; j < razm + 1; j++)
      {
        System.out.format("%.3f ", extendedMatrix[i][j]);
      }
      System.out.println("\n");
    }
  }
  public void korni()
  {
    for(int i = razm - 1; i > -1; i--)
    {
      Double sum = 0.0;
      for(int j = razm - 1; j > i; j--)
      {
        sum = sum + extendedMatrix[i][j]*res[j];
      }
      res[i] = (extendedMatrix[i][razm] - sum)/extendedMatrix[i][i];
    }
    for (int i = 0; i < razm; i++)
    {
      System.out.print(i+1+" root is ");
      System.out.format("%.5f \n", res[i]);
    }
  }

}
