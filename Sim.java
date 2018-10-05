public class Sim{
  public static void main(String[] args) {
    double average = 0.0;
    double singleScore;
    int players = 1000;
    for(int i = 1; i <= players; i++){
          singleScore = Thrice.fullGameNoRetire();
          average = average + (singleScore/players);
          System.out.println("Player " + i + " scored " + singleScore);
    }
    System.out.println("Average of " + players + " games is: " + average);
  }
}
