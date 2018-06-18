//Problem        : Mug Color
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet; 
import java.util.Set;

//Your submission should *ONLY* use the following class name
public class Problem {
    
    private static ArrayList<String> mugs = new ArrayList<>();
    
    public static void main(String[] args) {

       Scanner stdin = new Scanner(System.in);
       while(stdin.hasNextLine()) 
       {
           //System.out.println(stdin.nextLine());
            mugs.add(stdin.nextLine());
       }
       stdin.close();
       
       clearDuplicates();
       System.out.println(result());
       
    }
    
    public static void clearDuplicates() {
		
		Set<String> clearDupes = new HashSet<>(); 
		clearDupes.addAll(mugs);
		mugs.clear();
		mugs.addAll(clearDupes);

	}
	
	public static String result() {
		
		String result = "";
		
		String colours[] = {"Black", "Yellow", "Red", "Blue", "White"};
		
		for (int i = 0; i < colours.length; i++) {
			
			if (!(mugs.contains(colours[i]))) {
				result = colours[i];
			
			} 
			
		}
		
		return result; 
	}
	

}
