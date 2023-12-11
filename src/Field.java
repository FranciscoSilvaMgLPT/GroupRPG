package Map;

public class Field {
    private String symbol;
    private boolean block;
    private boolean completed;
    private boolean mission;
    private boolean start;
    private boolean finish;
    private boolean user;

    public Field() {
        this.block = false;
        this.mission = false;
        this.completed = false;
        this.start = false;
        this.finish = false;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isMission() {
        return mission;
    }

    public void setMission(boolean mission) {
        this.mission = mission;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }
}
