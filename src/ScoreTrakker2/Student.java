package ScoreTrakker2;

public class Student implements Comparable<Student>{
	private String name;
	private int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String toString() {
		return name + ' ' + score;
	}
	public int compareTo(Student o) {
		//compare by name first
        int nameComparison = this.name.compareTo(o.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        // if names are same then compare by score in ascending order
        return Integer.compare(this.score, o.score);
    }
}
