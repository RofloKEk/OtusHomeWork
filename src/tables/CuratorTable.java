package tables;

import data.Curator;
import data.Group;
import db.IDBExecutor;

public class CuratorTable extends AbsTable {

    public CuratorTable(IDBExecutor idbExecutor) {
        super("curator", idbExecutor);
    }
    public void insert(Curator curator){
        dbExecutor.execute(String.format("INSERT INTO curator (id, name) VALUES (%d, '%s')",curator.getId(),curator.getName()));

    }
    public static void insertAll(Curator curator){
        curator.add(new Curator(1, "BOB"));
        curator.add(new Curator(2, "Jack"));
        curator.add(new Curator(3, "Tangina"));
        curator.add(new Curator(4, "Bobo"));
    }
}
