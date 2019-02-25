public class Yakobi {
  private final Double eps = 0.00001;
  private int razm = 4;
  private boolean check = true;
  int n =0;
  Double norma = 10.0;
  Double [][] matrix = {{3.738, 0.195, 0.275, 0.136},
                         {0.519, 5.002, 0.405, 0.283},
                         {0.306, 0.381, 4.812, 0.418},
                         {0.272, 0.142, 0.314, 3.935}};
  Double [] coef = {0.815, 0.191, 0.423, 0.352};
  Double [] priblij = new Double[razm];
  void checking()//проверка на сходимость метода Якоби
  {
    System.out.println("Решение системы методом Якоби");
    Double sum;
    for(int i = 0; i < razm; i++)
    {
      sum = 0.0;
      priblij[i] = 1.0;//приближённый вектор единичный
      for(int j = 0; j < razm; j++)
      {
        if(i != j)
        {
          sum += matrix[i][j];
        }
      }
      if(matrix[i][i] <= sum)
      {
        check = false;
      }
    }
    if(!check)
    {
      System.out.println("Итерационный метод Якоби не сходится");
    }
    else
    {
      System.out.println("Итерационный метод Якоби сходится");
    }
  }
  void solving()//поиск корней СЛАУ
  {
    Double [] vector = new Double[razm];
    while (norma > eps)
    {
      for(int i = 0; i < razm; i++)
      {
        vector[i] = coef[i];
        for(int j = 0; j < razm; j++)
        {
          if(i != j)
          {
            vector[i] -= matrix[i][j]*priblij[j];
          }
        }
        vector[i] /= matrix[i][i];

      }
      norma = Math.abs(priblij[0] - vector[0]);
      for(int j = 0; j < razm; j++)
      {
        if(Math.abs(priblij[j] - vector[j]) > norma)
        {
          norma = (Math.abs(priblij[j] - vector[j]));
        }
        priblij[j] = vector[j];
      }
      n++;
    }
    for(int i = 0; i < razm; i++)
    {
      System.out.print(i+1+" root is ");
      System.out.format("%.5f \n", priblij[i]);
      System.out.println(n);
    }
  }
}
