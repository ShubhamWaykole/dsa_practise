package DesignPatterns.Creational;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ProtypeDesignPattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        StudentDetails student1 = new StudentDetails("Kanchan",1,"VIIT","Kondhwa","Pune university");
        StudentDetails student2 = (StudentDetails) student1.clone();
        student2.setName("Shubham");
        student2.setRollNo(2);
        System.out.println("Student1 details: " + student1.toString());
        System.out.println("Student2 details: " + student2.toString());
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class StudentDetails implements Cloneable {
    String name;
    int rollNo;
    String clg;
    String clgAddress;
    String university;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        StudentDetails newStudent = new StudentDetails();
        newStudent.clg = this.clg;
        newStudent.clgAddress = this.clgAddress;
        newStudent.university = this.university;
        return newStudent;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", clg='" + clg + '\'' +
                ", clgAddress='" + clgAddress + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}