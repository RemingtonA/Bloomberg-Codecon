//Problem        : Expecto Palindronum
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
import java.lang.StringBuilder;
//Your submission should *ONLY* use the following class name
public class Problem
{
    public static String input;
    public static int result;
    
    public static void main(String[] args)
    {

       Scanner stdin = new Scanner(System.in);
       while(stdin.hasNextLine()) 
       {
           //System.out.println(stdin.nextLine());
           
           input = stdin.nextLine();
       }
       stdin.close();
       System.out.println(returnPalindrome(input));
       
    }
    
    public static boolean isPalindrome(String input) {
        
        StringBuilder sb = new StringBuilder();
        String reversedString = "";
        
        sb.append(input);
        sb.reverse();
        reversedString = sb.toString();
        
        if (reversedString.equals(input)) {
            
            return true;
            
        } else {
            
            return false; 
        }
        
    }
    
    public static int returnPalindrome(String input) {
        
        StringBuilder sb = new StringBuilder();
        String baseString = input;
        String palindromeString = input;
        
        
        baseString.toLowerCase();
        sb.append(baseString);
        sb.reverse();

        int i = 0;
        
        while (!isPalindrome(palindromeString)){
            
            palindromeString = sb.substring(0,i) + baseString;
            //System.out.println(palindromeString + " " + i);
            i++; 
        }
        
        return palindromeString.length();
    }

}
