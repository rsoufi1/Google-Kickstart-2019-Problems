import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

public class Training2 {

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
			
			//Find the min number of hours needed to get
			//A fair team
			int numHours = Integer.MAX_VALUE;//Min number of training hours
			int currentSkill = 0; //Sum all all skill levels in a window 
			int windowSize = 0; //Size of window
			
			//Using sliding window 
			/*	For example, take the sorted set {1 2 3 4 5 5}
			 * 	To find the num of hours it takes to train each 
			 * 	window (startin from rightmost):
			 * 		(5-5) + (5-5) = 0
			 * 		(5-5) + (5-4) = 1
			 * 		(4-4) + (4-3) = 1
			 * 		...
			 * 		(2-2) + (2-1) = 1
			 * So for a window of size P, where the right most
			 * element is x and all other elements are y1...yP, 
			 * The number of training hours is:
			 * 		(x-y1) + (x-y2) + ... + (x-yp)
			 * 		= Px - Sum(y1...yp)
			 * 
			 * The window will remove the rightmost element, 
			 * and add the leftmost element as it traverses 
			 * down the array. Each time the window is
			 * equal to the size of the number of students
			 * on the team, the number of training hours is
			 * calculated. If the number of training hours 
			 * for that group (temp) is less than the current 
			 * min for number of training hours (numHours),
			 * then numHours = temp. 
			 */
			
			for(int l = N-1; l >=0; l--) {
				//Add leftmost element
				currentSkill+=skillOfAllStudents[l];
				windowSize++;
				
				if(windowSize == P) {
					//Calculate the number of training hours
					int temp = P*skillOfAllStudents[l+P-1] - currentSkill;
					
					//If the temp is less than the current minimum,
					//Set the current min to temp
					if(temp < numHours) {
						numHours = temp;
					}
					
					//Decrement window size and remove rightmost
					//Element
					windowSize--;
					currentSkill-=skillOfAllStudents[l+P-1];
				}
				
			}
			
			//Print solution
			System.out.println("Case #" + (i+1) + ": " + numHours);
		}
		s.close();
	}

}
