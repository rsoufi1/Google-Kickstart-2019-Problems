import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

public class Training {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int T = s.nextInt(); //number of tests
		
		for(int i = 0; i < T; i++) {
			int N = s.nextInt(); //number of students
			int P = s.nextInt(); //number of students to pick
			
			//Get all skill scores
			int[] skillOfAllStudents = new int[N];
			for(int j = 0; j < N; j++) {
				skillOfAllStudents[j] = s.nextInt();
			}
			
			//Sort
			Arrays.sort(skillOfAllStudents);
			
			//Find min number of hours to get a fair team
			//Go from largest down to smallest. take however many needed from the right and calculate amount needed for fair team
			int numHours = Integer.MAX_VALUE;
			
			for(int l = N-1; l > P-2; l--) {
				int tempSkill = 0;
				
				int highest = skillOfAllStudents[l];
				for(int k = l-1; k > l - P; k--) {
					tempSkill += (highest - skillOfAllStudents[k]);
					//System.out.println("intermediate #1: " + tempSkill );
				}
				
				if(tempSkill < numHours) {
					numHours = tempSkill;
				}
			}
			
			//Print solution
			System.out.println("Case #" + (i+1) + ": " + numHours);
		}
	}

	public static void PrintArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
