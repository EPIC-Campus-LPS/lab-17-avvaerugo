package lab17;

import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
	private int capacity;
	private List<Score> scoreboard = new ArrayList<>();
	public Leaderboard(int c) {
		capacity = c;
	}
	public void addScore(Score score) {
		boolean unadded = true;
		for (int i = 0; i < scoreboard.size(); i++) {
			if (score.getScore() > scoreboard.get(i).getScore()) {
				scoreboard.add(i, score);
				unadded = false;
				break;
			}
		}
		if (unadded) {scoreboard.add(score);}
		if (scoreboard.size() > capacity) {
			scoreboard.remove(capacity);
		}
	}
	public void addScore(String name, int score) {
		addScore(new Score(name, score));
	}
	public int getHighScore() {
		return scoreboard.get(0).getScore();
	}
	public double getAverageScore() {
		double avg = 0;
		for (Score i : scoreboard) {
			avg += (double) i.getScore() / scoreboard.size();
		}
		return avg;
	}
	public boolean break1000() {
		return scoreboard.get(0).getScore() >= 1000;
	}
	public void printLeaderboard() {
		for (Score i : scoreboard) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {  
	    Leaderboard board = new Leaderboard(5);  
	  
	    board.addScore("ABC", 100);  
	    board.addScore("DEF", 200);  
	    board.addScore("GHI", 250);  
	    board.addScore("JKL", 300);  
	    board.addScore("MNO", 205);  
	  
	    System.out.println("High Score: " + board.getHighScore());  
	    System.out.println("Average Score: " + board.getAverageScore());  
	    System.out.println("Did a player break 1000 points?: " + board.break1000());  
	  
	    System.out.println("\nLeaderboard: ");  
	    board.printLeaderboard();  
	  
	    System.out.println("\nLeaderboard: ");  
	    board.addScore("PQR", 150);  
	  
	    board.printLeaderboard();  
	  
	}
}
