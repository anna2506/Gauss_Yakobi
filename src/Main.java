public class Main {
  public static void main(String[] args)
  {
    Gauss gauss = new Gauss();
    gauss.init();
    gauss.transformation();
    gauss.printing();
    gauss.korni();
    Yakobi yakobi = new Yakobi();
    yakobi.checking();
    yakobi.solving();
  }
}
