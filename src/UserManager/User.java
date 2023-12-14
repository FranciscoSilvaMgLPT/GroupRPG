package UserManager;

import FrontEnd.Colors;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String playerName;
    private String playerPassword;
    private Colors playerBackgroundColor;
    private int playerPoints;
    private List<Medal> playerMedals;
    private int x;
    private int y;

    private final String SEPARATOR = ";";

    public User() {
    }

    public User(String playerName, String playerPassword) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.playerBackgroundColor = Colors.BLUE_BACKGROUND_BRIGHT;
        this.playerPoints = 0;
        this.playerMedals = new ArrayList<>();
    }

    public User(String playerName, String playerPassword, Colors playerBackgroundColor, int playerPoints) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.playerBackgroundColor = playerBackgroundColor;
        this.playerPoints = playerPoints;
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

    public Colors getPlayerBackgroundColor() {
        return playerBackgroundColor;
    }

    public void setPlayerBackgroundColor(Colors playerBackgroundColor) {
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

    public List<Medal> getPlayerMedals() {
        return playerMedals;
    }

    public void setPlayerMedals(ArrayList<Medal> playerMedals) {
        this.playerMedals = playerMedals;
    }

    @Override
    public String toString() {
        return playerName + SEPARATOR + playerPassword + SEPARATOR + playerBackgroundColor.name() + SEPARATOR + playerPoints;
    }
}
