package main.java.com.org.czy.compare;

public class Student {

    private int age;
    private String name;
    private int heigh;

    public Student(int age, String name, int heigh) {
        this.age = age;
        this.name = name;
        this.heigh = heigh;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", heigh=" + heigh +
                '}';
    }
}
