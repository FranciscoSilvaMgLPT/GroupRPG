import java.util.ArrayList;

public class User {
    private String playerName;
    private String playerPassword;
    private String playerBackgroundColor;
    private int playerPoints;
    private ArrayList<Medal> playerMedals;
    private int x = 3;
    private int y = 5;

    public User() {
    }

    public User(String playerName, String playerPassword) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
    }

    public User(String playerName, String playerPassword, String playerBackgroundColor) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.playerBackgroundColor = playerBackgroundColor;
        this.playerPoints = 0;
        this.playerMedals= new ArrayList<>();
    }

    //====== PLAYER METHODS ======\\
    public void move(String move) {
        switch (move) {
            case "W":
                y++;
                System.out.println(y);
                break;
            case "S":
                y--;
                System.out.println(y);
                break;
            case "A":
                x--;
                System.out.println(x);
                break;
            case "D":
                x++;
                System.out.println(x);
                break;
            case "0":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("\nInvalid movement!");
        }
    }

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

}
