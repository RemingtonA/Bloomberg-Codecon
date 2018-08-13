//Problem        : Base Arithmetic
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

//Your submission should *ONLY* use the following class name
public class Problem {

    //KEY, VALUE 
    private static Map<Character, Integer> bases = new HashMap<>();
    private static ArrayList<String> numbers = new ArrayList<>(); //holds the original values of the number.
    private static ArrayList<Integer> baseAns = new ArrayList<>();
    
    public static void main(String[] args)
    {
    
       fillBases();
       Scanner stdin = new Scanner(System.in);
       
       while(stdin.hasNextLine()) 
       {    
           String temp = stdin.nextLine();
           //stores what base the number is
           whatBase(temp);
           //stores what the original number is 
           numbers.add(temp);
           
       }
       stdin.close();
       
       System.out.println((int)add());
    }

    //Finds what minimum base the number is 
    public static void whatBase(String number) {
        
        char[] compareChar = number.toCharArray(); 
        ArrayList<Integer> allValues = new ArrayList<>(); 
        
        for (int i = 0; i < compareChar.length; i++) {
            
            //Gettomg the value from the key provided             
            allValues.add(bases.get(compareChar[i]));
        }
        
        int base = Collections.max(allValues) + 1;
        
        //System.out.println(base);
        baseAns.add(base);
    }
    
    public static int whatValue(Character number) {
        
       return bases.get(number);
    }
    
    //Returns the number in a baseTen form.
    public static double toTen(char[] charArray, int baseAns) {
        
        double y = 0;
        
        for (int i = 0; i < charArray.length; i++){
            
            double whatValue = whatValue(charArray[i]);
            
            double base = Math.pow(baseAns, charArray.length - (i+1));
            
            //System.out.println(charArray.length);
            //System.out.println("The base is " + baseAns);
            //System.out.println("The base multiplied is " + base);
            //System.out.println("The value is " + whatValue);
            
            y += base*whatValue;
            
            //System.out.println(y); 
        }
        return y;
    }
    
    public static double add() {
        
        char[] numberOne = (numbers.get(0)).toCharArray(); 
        char[] numberTwo = (numbers.get(1)).toCharArray();
        
        double answer = toTen(numberOne, baseAns.get(0)) + toTen(numberTwo, baseAns.get(1));
        
        return answer;
    }
    
    public static void fillBases(){
        
        //KEY, VALUE 
        bases.put('0',0);
        bases.put('1',1);
        bases.put('2',2);
        bases.put('3',3); 
        bases.put('4',4); 
        bases.put('5',5); 
        bases.put('6',6); 
        bases.put('7',7); 
        bases.put('8',8); 
        bases.put('9',9); 
        bases.put('A',10); 
        bases.put('B',11); 
        bases.put('C',12); 
        bases.put('D',13); 
        bases.put('E',14); 
        bases.put('F',15); 
    }
    


}
