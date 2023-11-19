public class Player{
    double money;
    int bet;
    int points;

    public Player() {
        money = 1000;
        bet = 0;
        points = 0;
    }

    public void addPoints(int pointsToAdd){
        points += pointsToAdd;
    }

    public int getPoints(){ return points; }
}
