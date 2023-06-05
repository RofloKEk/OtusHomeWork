import data.Curator;
import data.Group;
import data.Student;
import db.IDBExecutor;
import db.MySqlExecutor;
import tables.AbsTable;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

  public static void main(String... args) throws SQLException {
    IDBExecutor dbExecutor = new MySqlExecutor();
    try {
      AbsTable studentTable = new StudentTable(dbExecutor);
      if (studentTable.isTableExist("student")) {
        studentTable.delete();
      }

      AbsTable curatorTable = new CuratorTable(dbExecutor);
      if (curatorTable.isTableExist("curator")) {
        curatorTable.delete();

      }

      AbsTable groupTable = new GroupTable(dbExecutor);
      if (groupTable.isTableExist("students_group")) {
        groupTable.delete();
      }

      {
        List<String> columnsStudentTable = new ArrayList<>();
        columnsStudentTable.add("id int primary key");
        columnsStudentTable.add("name varchar(50)");
        columnsStudentTable.add("age int");
        columnsStudentTable.add("sex varchar(10)");

        studentTable.create(columnsStudentTable);


        List<String> columnsGroupTable = new ArrayList<>();
        columnsGroupTable.add("id int primary key");
        columnsGroupTable.add("name varchar(50)");
        columnsGroupTable.add("id_curator int");


        groupTable.create(columnsGroupTable);


        List<String> columnsCuratorTable = new ArrayList<>();
        columnsCuratorTable.add("id int primary key");
        columnsCuratorTable.add("name varchar(50)");

        curatorTable.create(columnsCuratorTable);
      }
     StudentTable students = new StudentTable(dbExecutor);
      students.insert(new Student(1, "tim", 20, "Male"));
        students.insert(new Student(2, "bin", 22, "Female"));
        students.insert(new Student(3, "bum", 22, "Male"));
        students.insert(new Student(4, "kum", 23, "Male"));
        students.insert(new Student(5, "trun", 24, "Female"));
        students.insert(new Student(6, "bam", 21, "Male"));
        students.insert(new Student(7, "den", 22, "Male"));
        students.insert(new Student(8, "jen", 33, "Female"));
        students.insert(new Student(9, "kim", 22, "Male"));
        students.insert(new Student(10, "wat", 22, "Male"));
        students.insert(new Student(11, "kat", 59, "Female"));
        students.insert(new Student(12, "yat", 22, "Female"));
        students.insert(new Student(13, "mat", 22, "Male"));
        students.insert(new Student(14, "kok", 33, "Male"));
        students.insert(new Student(15, "sok", 27, "Male"));




      CuratorTable curators = new CuratorTable(dbExecutor);
      curators.insert(new Curator(1, "BOB"));
        curators.insert(new Curator(2, "Jack"));
        curators.insert(new Curator(3, "Tangina"));
        curators.insert(new Curator(4, "Bobo"));

      GroupTable groups = new GroupTable(dbExecutor);
      groups.insert (new Group(1, "kaa", 10));
        groups.insert (new Group(2, "maa", 11));
        groups.insert (new Group(3, "baa", 12));






      } catch (SQLException e) {
        e.printStackTrace();
      }finally
      {
        dbExecutor.close();
      }
    }
  }
