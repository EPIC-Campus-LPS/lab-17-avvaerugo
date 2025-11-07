package lab17;

public class Score {
	private String name;
	private int score;
	public Score(String n, int a) {
		name = n;
		score = a;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public void setName(String n) {
		name = n;
	}
	public void setScore(int n) {
		score = n;
	}
	public String toString() {
		return name + ": " + score;
	}
}
