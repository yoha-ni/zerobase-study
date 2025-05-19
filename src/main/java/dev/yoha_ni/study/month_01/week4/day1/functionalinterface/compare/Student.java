package dev.yoha_ni.study.month_01.week4.day1.functionalinterface.compare;

// Comparable
// Comparator
public class Student implements Comparable<Student> {
    private final String name;
    private final int score;

    public
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, o.score);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
