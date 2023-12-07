import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private int points;
    private ArrayList<Medal> medals;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.points = 0;
        this.medals= new ArrayList<Medal>();
    }

    public User(String name, String password, int points, ArrayList<Medal> medals) {
        this.name = name;
        this.password = password;
        this.points = points;
        this.medals = medals;
    }
}
