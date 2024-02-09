/*
 * ScoreTrakker class: contains the file load, print, process, and the main call.
 * Looks for number exceptions and file not found exceptions
 * Authors: Justin Pajela and Brody Perlick
 * Collaborators: none
 * Sources: Stack Overflow on collections and parsing
 */

package ScoreTrakkerPart2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScoreTrakker {
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

/*
 * loadDataFile takes the file name, finds the name of the person(first and last)
 * then finds score and stores in studentList
 * number exceptions checked in a second try catch statement in the loop
 */

    public void loadDataFile(String fileName) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String name = fileScanner.nextLine();
                if (fileScanner.hasNextLine()) {
                    String scoreStr = fileScanner.nextLine(); 
                    try {
                        int score = Integer.parseInt(scoreStr);													//splits the string
                        Student student = new Student(name, score);												
                        studentList.add(student);																
                    } catch (NumberFormatException e) {															//NumberException check for the score		
                        System.out.println("Incorrect format for " + name + ", not a valid score: " + scoreStr);
                    }
                }
            }
            System.out.println("Student Score List");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
    }
/*
 * prints out students based on name
 */
    public void printInOrder() {
        Collections.sort(studentList);
        
        for (Student student : studentList) {
            System.out.println(student);
        }
        studentList.clear();
    }
/*
 * sorts through the files and prints out the order
 */
    public void processFiles() {
        for (String fileName : files) {
            loadDataFile(fileName);
            printInOrder();
            System.out.println();
        }
    }
    public static void main(String[] args) {
    
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}
