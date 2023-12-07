import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private int points;
    private String backgroundColor;
    private int x;

    private int y;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
