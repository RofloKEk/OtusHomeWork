package tables;

import db.IDBExecutor;
import db.MySqlExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public abstract class AbsTable {

  private String tableName;
  protected IDBExecutor dbExecutor;

  public AbsTable(String tableName, IDBExecutor dbExecutor) {
    this.tableName = tableName;
    this.dbExecutor = dbExecutor;
  }

  public void create(List<String> columns) {
    dbExecutor.execute(String.format("create table %s (%s)", tableName, String.join(",", columns)));
  }

  public void delete() {
    dbExecutor.execute(String.format("drop table %s", tableName));
  }
  public boolean isTableExist(String tableName) throws SQLException {
    ResultSet resultTables =  dbExecutor.executeQuery("show tables");
    while(resultTables.next()) {
      if (resultTables.getString(1).equals(tableName)){
        return true;
      }
    }
    return false;
  }

}
