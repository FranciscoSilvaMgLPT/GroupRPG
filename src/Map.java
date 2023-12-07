public class Map {
    private Field[][] map;

    public Map() {
        this.map = new Field[15][30];
    }

    public void createMap() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                map[i][j] = new Field();
            }
        }
    }

    public void showMap() {
        updateMap();
        for (int i = 14; i >= 0; i--) {
            for (int j = 0; j < 30; j++) {
                System.out.print(map[i][j].getSymbol());
            }
            System.out.println();
        }
    }

    private void updateMap() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {
                if (map[i][j].isBlock()) {
                    map[i][j].setSymbol("🟫");
                } else {
                    map[i][j].setSymbol("◻️");
                }
                if (map[i][j].isMission()) {
                    map[i][j].setSymbol("🎁");
                }
                if (map[i][j].isCompleted()) {
                    map[i][j].setSymbol("✅");
                }
                if (map[i][j].isStart()) {
                    map[i][j].setSymbol("🟦");
                }
                if (map[i][j].isFinish()) {
                    map[i][j].setSymbol("🎄");
                }
                if(map[i][j].isUser()){
                    map[i][j].setSymbol("BACKGROUND COLOR"+map[i][j].getSymbol()+"RESET");
                }
            }
        }
    }

    public void CreateLimits(){
        for (int i = 0; i < 15; i++) {
            map[i][0].setBlock(true);
            map[i][29].setBlock(true);
        }
        for (int i = 0; i < 30; i++) {
            map[0][i].setBlock(true);
            map[14][i].setBlock(true);
        }
        map[0][3].setStart(true);
        map[11][29].setFinish(true);
    }

    public Field[][] getMap() {
        return map;
    }
}
