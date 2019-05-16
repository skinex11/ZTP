import java.util.ArrayList;

class Kurs {
    public String name;
    public ArrayList<Student> students;

    public Kurs(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void addStudents(Student student){
        students.add(student);
    }
}
