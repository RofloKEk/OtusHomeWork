package data;

public class Group {
    private int id;
    private String name;
    private int id_curator;


    public Group(int id, String name, int id_curator) {
        this.id = id;
        this.name = name;
        this.id_curator = id_curator;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getId_curator() {
        return id_curator;
    }

    public void add(Group group) {
    }
}
