package tables;

import data.Group;
import data.Student;
import db.IDBExecutor;

public class GroupTable extends AbsTable {

    public GroupTable(IDBExecutor idbExecutor) {
        super("students_group", idbExecutor);
    }

    public void insert(Group group) {
        dbExecutor.execute(String.format("INSERT INTO students_group (id, name, id_curator) VALUES (%d, '%s', %d)", group.getId(), group.getName(), group.getId_curator()));

    }

    private static void insertAll(Group group) {
        group.add(new Group(1, "kaa", 10));
        group.add(new Group(2, "maa", 11));
        group.add(new Group(3, "baa", 12));

        GroupTable.insertAll(group);
    }
}