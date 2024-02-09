/*
 * Student: contains the student class that stores the name and score
 * compareTo used to compare the names of the students
 * Authors: Justin Pajela and Brody Perlick
 */
package ScoreTrakkerPart1;

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	/*
	 * returns the student name and score
	 */
	public String toString() {
		return name + ' ' + score;
	}
	/*
	 * compares the names of students and sends alphabetical order
	 */
	public int compareTo(Student o) {
        int nameComparison = this.name.compareTo(o.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(this.score, o.score);
    }
}
