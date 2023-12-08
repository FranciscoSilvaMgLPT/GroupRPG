import java.util.ArrayList;

public class User {
    private String playerName;
    private String playerPassword;
    private String playerBackgroundColor;
    private int playerPoints;
    private ArrayList<Medal> playerMedals;

    public User() {
    }

    public User(String playerName, String playerPassword, String playerBackgroundColor) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.playerBackgroundColor = playerBackgroundColor;
        this.playerPoints = 0;
        this.playerMedals= new ArrayList<>();
    }

    //====== PLAYER METHODS ======\\
    /*public void move(String move) {
        switch (move) {
            case "W":
                return y+1;
                break;
            case "S":
                return y-1;
                break;
            case "A":
                return x-1;
                break;
            case "D":
                return x+1;
                break;
            default:
                System.out.println("\nInvalid movement!");
        }
    }*/

    //====== GETTER & SETTER ======\\
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerPassword() {
        return playerPassword;
    }

    public void setPlayerPassword(String playerPassword) {
        this.playerPassword = playerPassword;
    }

    public String getPlayerBackgroundColor() {
        return playerBackgroundColor;
    }

    public void setPlayerBackgroundColor(String playerBackgroundColor) {
        this.playerBackgroundColor = playerBackgroundColor;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(int playerPoints) {
        this.playerPoints = playerPoints;
    }

    public ArrayList<Medal> getPlayerMedals() {
        return playerMedals;
    }

    public void setPlayerMedals(ArrayList<Medal> playerMedals) {
        this.playerMedals = playerMedals;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
