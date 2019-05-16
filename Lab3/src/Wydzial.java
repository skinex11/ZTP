import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Wydzial {
    public String name;
    public ArrayList<Student> students;

    public Wydzial(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public ArrayList<Student> filter(String str){
        List<Student> list = this.students.stream().filter(
                student->
                        student.surname.contains(str)
        ).collect(
                Collectors.toList()
        );
        return new ArrayList<>(list);
    }

    public void addToModule(Kurs module){
        this.students.stream().map(
                student -> {
                    module.addStudents(student);
                    return 0;
                }
        );
    }
}