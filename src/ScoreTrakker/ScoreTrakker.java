/*
 * ScoreTrakker class: contains the file load, print, process, and the main call. 
 * Authors: Justin Pajela and Brody Perlick
 * Collaborators: none
 * Sources: Stack Overflow on collections and parsing
 */
		
package ScoreTrakker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScoreTrakker {
    private ArrayList<Student> studentList = new ArrayList<Student>();


/*
 * loadDataFile takes the file name, finds the name of the person(first and last)
 * then finds score and stores in studentList
 */

    public void loadDataFile(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0] + " " + parts[1];				// 
                int score = Integer.parseInt(parts[2]);
                Student student = new Student(name, score);
                studentList.add(student);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
    
/*
 * printInOrder sorts the student list by score
 */
    public void printInOrder() {
        Collections.sort(studentList);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
/*
 * processFiles loads in scores.txt
 */
    public void processFiles() {
        loadDataFile("scores.txt");
        printInOrder();
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}
