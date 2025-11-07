package lab17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatRecorder {
	public static void main(String[] args) {
		List<String> log = new ArrayList<>();
		boolean isRunning = true;
		Scanner sc = new Scanner(System.in);
		boolean lower = true;
		while (isRunning) {
			System.out.println("Input: ");
			String[] msg = sc.nextLine().split(" ");
			if (!(msg.length == 1 && msg[0].equals("STOP"))) {
				for (String i : msg) {
					if (!i.equals(i.toLowerCase())) {
						lower = false;
						i = i.toLowerCase();
					}
		    		log.add(i);
				}
			} else {
				isRunning = false;
			}
		}
		System.out.println("\nChat Record:");
		System.out.println("You used " + log.size() + " words.");
		int uniquecount = 0;
		int thecount = 0;
		String longest = "";
		List<String> condensed = new ArrayList<>();
		int i = -1;
		for (String j : log) {
			i++;
			if (j != j.toLowerCase()) {
				lower = false;
				j = j.toLowerCase();
			}
			if (log.indexOf(j) == i) {
				uniquecount++;
				if (j.length() > 3) {
					condensed.add(j);
				}
			}
			if (j.equals("the")) {thecount++;}
			if (j.length() > longest.length()) {longest = j;}
		}
		System.out.println("You used " + uniquecount + " unique words.");
		System.out.println("You used \"the\" " + thecount + " times.");
		System.out.println("\"" + longest + "\" was the longest word.");
		System.out.println("Are all words lowercase? " + lower);
		System.out.println("\nCondensed Chat History:");
		for (String j : condensed) {
			System.out.println(j);
		}
	}
}
