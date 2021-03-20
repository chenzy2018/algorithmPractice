package main.java.com.org.czy.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较器
 */
public class MyCompare {

    static class IdCom implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    static class HeigtCom implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getHeigh() - o2.getHeigh();
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(10, "c", 180);
        Student student2 = new Student(20, "b", 170);
        Student student3 = new Student(30, "a", 190);

        Student[] students = new Student[]{student1,student2,student3};
        printStu(students);
        Arrays.sort(students, new IdCom());
        printStu(students);
        Arrays.sort(students, new HeigtCom());
        printStu(students);
        Arrays.sort(students, (o1,o2)-> o2.getAge() - o1.getAge());
        printStu(students);
    }

    public static void printStu(Student[] students){
        for(Student s : students){
            System.out.println(s.toString());
        }
        System.out.println("=====================================================");
    }
}
