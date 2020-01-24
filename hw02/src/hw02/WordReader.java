package hw02;

import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class WordReader {
    public WordReader(String filename){
        String hiddenWord = "";
    }

    public static List<String> dict = new ArrayList<String>();

    //PICK HIDDEN WORD FUNC
    private static String pickhiddenWord(){
        Random index = new Random();
        String word = dict.get(index.nextInt(dict.size()));
        return word;
    }

    //READ FILE FUNC
    private static void readFile(String filename){
        try{
            File obj = new File(filename);
            Scanner myreader = new Scanner(obj);
            
            while(myreader.hasNextLine()){
                String data = myreader.nextLine();
                dict.add(data);
            }  
            myreader.close();
        }
        catch(FileNotFoundException e){
            System.err.println("Failed To Read");
            e.printStackTrace();
        } 
    }
    //test2
    //TESTING FOR MAIN
    public static void main(String []args){
        readFile("D:\\SchoolWork\\Spring2020\\CSCI.605.01_Adv_OO_Programming_Concepts\\hw02\\dict_hard.txt");
        String hidden = pickhiddenWord();
        System.out.println(hidden);
    }
 }

