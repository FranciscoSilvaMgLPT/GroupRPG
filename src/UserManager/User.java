package UserManager;

import FrontEnd.Colors;

public class User {
    private String playerName;
    private String playerPassword;
    private Colors playerBackgroundColor;
    private int playerPoints;
    private int playerGifts;
    private int cheats;
    private int x;
    private int y;

    private final String SEPARATOR = "|";

    public User() {
    }

    public User(String playerName, String playerPassword) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.playerBackgroundColor = Colors.BLUE_BACKGROUND_BRIGHT;
        this.playerPoints = 0;
        this.playerGifts=0;
        this.cheats=1;
    }

    public User(String playerName, String playerPassword, String playerBackgroundColor, int playerPoints) {
        this.playerName = playerName;
        this.playerPassword = playerPassword;
        this.playerBackgroundColor = Colors.valueOf(playerBackgroundColor);
        this.playerPoints = playerPoints;
        this.cheats=1;
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

    public int getPlayerGifts() {
        return playerGifts;
    }

    public void setPlayerGifts(int playerGifts) {
        this.playerGifts = playerGifts;
    }

    public int getCheats() {
        return cheats;
    }
    public void setCheats(int cheats) {
        this.cheats = cheats;
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

    @Override
    public String toString() {
        return playerName + SEPARATOR + playerPassword + SEPARATOR + playerBackgroundColor.name() + SEPARATOR + playerPoints;
    }
}