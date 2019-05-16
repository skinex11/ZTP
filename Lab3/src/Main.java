import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String args[]){
        Wydzial iz = new Wydzial("IZ");
        Wydzial ppt = new Wydzial("PPT");
        Student s1 = new Student("Konopka",237980);
        Student s2 = new Student("Serwata",137280);
        Student s3 = new Student("Wasielewski",217930);
        Student s4 = new Student("Hanowski",235680);
        Student s5 = new Student("Wesolowski",251234);
        ArrayList<Student> allStudents = new ArrayList<>();
        Kurs ztp = new Kurs("Zaawansowane Techniki Programowania");
        Kurs ick = new Kurs("Interakcja Czlowiek Komputer");

        iz.addStudent(s1);
        iz.addStudent(s2);
        iz.addStudent(s3);
        ppt.addStudent(s4);
        ppt.addStudent(s5);

        for (Student student:iz.students){
            allStudents.add(student);
        }

        for (Student student:ppt.students){
            allStudents.add(student);
        }

        iz.addToModule(ztp);
        ppt.addToModule(ick);

        ArrayList<Student> studentsWithSki = ppt.filter("ski");
        System.out.print("Studenci z 'ski' w nazwisku: ");
        System.out.println(studentsWithSki);

        Comparator<Student> comparator = Comparator.comparingInt(Student::getIndex);
        System.out.println("Student o najnowszym indeksie to: "+allStudents.stream().max(comparator).get());
        System.out.println("Student o najstarszym indeksie to: "+allStudents.stream().min(comparator).get());
    }
}
