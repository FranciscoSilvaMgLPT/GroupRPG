package GameMap;

public class Field {
    private String symbol;
    private boolean block;
    private boolean completed;
    private boolean mission;
    private boolean start;
    private boolean nextFloor;
    private boolean finish;
    private boolean user;
    private int missionQuizz;

    public Field() {
        this.symbol = "";
        this.block = false;
        this.completed = false;
        this.mission = false;
        this.start = false;
        this.nextFloor = false;
        this.finish = false;
        this.user = false;
        this.missionQuizz = 0;
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
        if(isNextFloor()){
            this.block=false;
        }else {
            this.block = block;
        }
    }

    public int getMissionQuizz() {
        return missionQuizz;
    }

    public void setMissionQuizz(int missionQuizz) {
        this.missionQuizz = missionQuizz;
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
    public void setMission(boolean mission, int missionQuizz) {
        this.missionQuizz=missionQuizz;
        this.mission = mission;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        if(finish){
            this.setBlock(false);
        }
        this.finish = finish;
    }

    public void setStart(boolean start) {
        if (start) {
            this.setUser(true);
            this.setBlock(true);
        }
        this.start = start;
    }

    public boolean isNextFloor() {
        return nextFloor;
    }

    public void setNextFloor(boolean nextFloor) {
        if(nextFloor){
            this.setBlock(false);
        }
        this.nextFloor = nextFloor;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }
}
