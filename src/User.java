import java.util.ArrayList;

public class User {
    private String playerName;
    private String playerPassword;
    private String playerBackgroundColor;
    private int playerPoints;
    private ArrayList<Medal> playerMedals;
    private int x;
    private int y;

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
