package curlychecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author oriana.cruz
 */
public class CurlyCheckerIO {

    public static void main(String[] args) {
        //Start here 
        Character [] file;
        Stack<Character> stack = new Stack();
        String s3 = "NotCrash.java";
        
      
        
         //Reads the file
        System.out.println("----Test File----");
        file = getArrayAndLastElement(s3);//Insert name of the file you want to read here. 
        bChecker(file,stack );
        
         //Check if the Stack is balanced 
        if(stack.empty()){
            System.out.println( s3 +" is Balanced! :) ");
        }
        else {
            System.out.println(s3 +" is not balanced :( ");
        }
    }
    
     public static Character[] getArrayAndLastElement(String fileName)
    {
        //Variables
        Character[] ch = new Character[fileName.length()];//fileName.length is to initialize the array, size will get updated later
        Integer count = 0;
        String line = " ";
        ArrayList list = new ArrayList();
        
        //Finds the file
        File file = new File(fileName);
        
        //Try and Catch
       try{
           //Reads the file
            Scanner scan = new Scanner(file); 
            System.out.println("File loaded!");
            while(scan.hasNext())
            {
               line = scan.next();  
               
               if(line.contains("{")){
                 count++;  
                 list.add('{');
               }
               else if (line.contains("}")){
                   count ++;
                   list.add('}');
               }
            } 
            //Making the size of the array accurate by the number of { and } in the file 
            ch = new Character[count];
            //System.out.print(list); just to check if the list was loading properly (tesing purposes)
            scan.close();
            
            //Read the last element on the arrayList. 
            Stack <Character> stack = new Stack();
            stack.addAll(list);//function adds all elements in ArrayList to a stack
            System.out.println("Last element on the array: "+ stack.peek());
            
             //Adding ArrayList values to the Character array, with for loop!
             for (int i = 0; i < count; i++) {
               ch[i] = (Character)list.get(i);
           }
             System.out.println(Arrays.toString(ch));
        }
        catch(FileNotFoundException fne){
            System.out.println(file +" not found.");
        }
      
       return ch ; 
    }
     
      public static void bChecker(Character[] b, Stack s){
        
        for (int i = 0; i < b.length; i++) 
        {
            if(b[i] == '{')
            {
                s.push(b[i]);
                
            }
            else if (b[i] == '}')
            {
               if(!s.empty())
               {
                   s.pop();
                   
               }   
               else {
                   System.out.println("Found } but stack is empty."
                           + " Therefore, cannot be balanced. Ending.");
                   System.exit(0);
               }
            }
            else {
                System.out.println("Not a curly brace AKA {}");
            }
        }
       
    }
}
