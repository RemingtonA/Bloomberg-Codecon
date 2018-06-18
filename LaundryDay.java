//Problem        : Laundry Day
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_75
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList; 
import java.util.Set; 
import java.util.HashSet; 
import java.util.Collections;


//Your submission should *ONLY* use the following class name
public class Problem {

private static ArrayList<String> rawData = new ArrayList<>();
private static ArrayList<String> result = new ArrayList<>();



    public static void main(String[] args)
        {
    
           Scanner stdin = new Scanner(System.in);
           while(stdin.hasNextLine()) 
           {
               //System.out.println(stdin.nextLine());
               rawData.add(stdin.nextLine());
           }
           sort();
           print();
           stdin.close();
        }
        
    public static void sort() {
                
                ArrayList<String> searchWords = new ArrayList<>();
                Set<String> temp = new HashSet<>();
                searchWords.addAll(rawData);
                temp.addAll(searchWords);
                
                searchWords.clear();
                searchWords.addAll(temp);
                
                 Collections.sort(searchWords, String.CASE_INSENSITIVE_ORDER);
                
                String output = "";            
                String searchWord = "";
                
                for (int i = 0; i < searchWords.size(); i++) {
                  
                  int count = 0;
                  int sockCount = 0;
                
                  searchWord = searchWords.get(i);
                
                   count = Collections.frequency(rawData, searchWord);
                   sockCount = Collections.frequency(rawData, searchWord);
                   
    
                if (searchWord.contains(" sock")) { 

                    if (sockCount == 1) {
                        
                        result.add("0|" + searchWord);
                    }
                    else if(sockCount % 2 == 0) {
                        //the sock count can be easily calculated
                        output = sockCount/2 + "|" + searchWord; 
                        result.add(output);
                    
                    //otherwise if the number is bigger than 2     
                    } else if (sockCount % 2 == 1) {
                        
                        output = (sockCount-1)/2 + "|" + searchWord;
                        result.add(output);
                        result.add("0|" + searchWord);
                        
                    } else {
                        
                        output = (sockCount-1)/2 + "|" + searchWord;
                        result.add(output);
                    }
                    
                } else {
                    
                    output = count + "|" + searchWord;
                    result.add(output);
        
                } 
        
            }
    
    }
    
    public static void print() { 
        
        
        for (int i = 0; i < result.size(); i++) {
            
            String output = "";
            output = result.get(i);
            System.out.println(output);
        }
    }
    
}
