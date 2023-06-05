package tables;

import data.Student;
import db.IDBExecutor;

import java.awt.*;
import java.util.ArrayList;

public class StudentTable extends AbsTable {

  public StudentTable(IDBExecutor idbExecutor) {
    super("student", idbExecutor);
  }

  public void insert(Student student) {
    String temp =  String.format("INSERT INTO student (id, name, age, sex) VALUES (%d, '%s', %d, '%s')", student.getId(),
            student.getName(), student.getAge(), student.getSex());

    System.out.println(temp);

    dbExecutor.execute(temp);

  }

 public static void insertAll(Student student) {
    student.add(new Student(1, "tim", 20, "Male"));
    student.add(new Student(2, "bin", 22, "Female"));
    student.add(new Student(3, "bum", 22, "male"));
    student.add(new Student(4, "kum", 23, "male"));
    student.add(new Student(5, "trun", 24, "Female"));
    student.add(new Student(6, "bam", 21, "male"));
    student.add(new Student(7, "den", 22, "male"));
    student.add(new Student(8, "jen", 33, "Female"));
    student.add(new Student(9, "kim", 22, "male"));
    student.add(new Student(10, "wat", 22, "male"));
    student.add(new Student(11, "kat", 59, "Female"));
    student.add(new Student(12, "yat", 22, "Female"));
    student.add(new Student(13, "mat", 22, "male"));
    student.add(new Student(14, "kok", 33, "male"));
    student.add(new Student(15, "sok", 27, "male"));
    StudentTable.insertAll(student);
  }
}


// написать запрос в консольке и проверить что он работает,