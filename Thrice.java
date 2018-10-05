import java.util.Scanner;

public class Thrice{
  public static double tally = 0.0;

  public static void main(String[] args) {
    fullGame();
    System.out.println("Full game score: " + finalScore());
  }

  public static void fullGame(){
    int worth = firstTurn();
    System.out.println("After round 1 tally: " + tally);
    System.out.println("Round 1 worth: " + worth);
    secondTurn(worth);
    System.out.println("After round 2 tally: " + tally);
    thirdTurn(isRetiring(), worth);
    System.out.println("Final tally: " + tally);
  }

  public static double fullGameNoRetire(){
    int worth = firstTurn();
    //System.out.println("Round 1 tally: " + tally);
    //System.out.println("Round 1 worth: " + worth);
    secondTurn(worth);
    //System.out.println("Round 2 worth: " + tally);
    thirdTurn(false, worth);
    return tally;
  }

  public static int diceRoll(){
    int die = (int)(Math.random()*6+1);
    return die;

  }

  public static double finalScore(){
    return tally;
  }

  public static int firstTurn(){

    int roll = 1;
    int die1 = diceRoll();
    int die2 = diceRoll();
    int die3 = diceRoll();

    while ( !(die1 == die2 && die2 == die3)){
      if (roll % 3 == 0){
        tally = tally - (die1 + die2 + die3);
      } else {
        tally = tally + (die1 + die2 + die3);
      }
      roll += 1;
      die1 = diceRoll();
      die2 = diceRoll();
      die3 = diceRoll();

    }
    return die1;

  }

  public static void secondTurn(int worth){

    int die1;
    int die2;
    int die3;

    for (int i = 0; i < worth; i++){
      die1 = diceRoll();
      die2 = diceRoll();
      die3 = diceRoll();

      tally = tally + (die1 * die2 * die3);
    }
  }

  public static boolean isRetiring(){
    Scanner scan = new Scanner(System.in);
    String retire;
    String answer = "";

    while( !(answer.equals("n") || answer.equals("y")) ){
      System.out.println("Do you want to retire? y/n ");
      retire = scan.nextLine();

      if (retire.equals("y")){
        return true;
      }  else if(retire.equals("n")){
        return false;
      } else {
        System.out.println("Invalid input, enter 'y' for yes and 'n' for no");
      }
    }
    System.out.println("this shouldn't be seen");
    return false;
  }

  public static void thirdTurn(boolean retiring, int worth){
    if(retiring == false){
      int die1 = diceRoll();
      int die2 = diceRoll();
      int die3 = diceRoll();
      double powerOf3 = 1;
      int rolls = 1;

      while( !(die1 == die2 && die2 == die3) ){
        die1 = diceRoll();
        die2 = diceRoll();
        die3 = diceRoll();
        //System.out.println("Roll " + rolls + " worth: " + powerOf3);
        tally = tally + powerOf3;
        powerOf3 = powerOf3 * 3;
        rolls++;
      }
      //System.out.println("Die 1,2,3: " + die1 + ", " + die2 + ", " + die3);
      if(worth == die1){
        tally = tally * 3;
      } else {
        tally = die1;
      }
    }
  }

}
