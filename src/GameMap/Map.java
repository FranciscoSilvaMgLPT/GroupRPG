package GameMap;

import FrontEnd.Colors;
import UserManager.User;

public class Map {
    private Field[][] map;


    public Map() {
    }

    public Map(int y, int x) {
        this.map = new Field[y][x];
    }

    public void createMap(User user) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = new Field();
            }
        }
    }

    public void showMap(User user) {
        updateMap(user);
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j].getSymbol());
            }
            System.out.println();
        }
    }

    public void updateMap(User user) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
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
                if (map[i][j].isNextFloor()) {
                    map[i][j].setSymbol("▍");
                }
                if(map[i][j].isFinish()){
                    map[i][j].setSymbol("🎄");
                }
                if (map[i][j].isUser()) {
                    map[i][j].setSymbol(user.getPlayerBackgroundColor() + map[i][j].getSymbol() + Colors.RESET);
                }
            }
        }
    }

    public void createLimits() {
        for (int i = 0; i < map.length; i++) {
            map[i][0].setBlock(true);
            map[i][map[0].length - 1].setBlock(true);
        }
        for (int i = 0; i < map[0].length; i++) {
            map[0][i].setBlock(true);
            map[map.length - 1][i].setBlock(true);
        }
    }

    public void checkUserMove(User user, String move) {
        int tempX = user.getX();
        int tempY = user.getY();

        if (move.equals("W")) {
            tempY++;
        }
        if (move.equals("S")) {
            tempY--;
        }
        if (move.equals("A")) {
            tempX--;
        }
        if (move.equals("D")) {
            tempX++;
        }
            if ((!map[tempY][tempX].isBlock() && tempY > 0 && tempX > 0) || map[tempY][tempX].isFinish() ) {
                map[user.getY()][user.getX()].setUser(false);
                user.setY(tempY);
                user.setX(tempX);
                map[user.getY()][user.getX()].setUser(true);
            } else {
                System.out.println(Colors.RED + "\nYou cant go there!\n" + Colors.RESET);
            }
    }

    public Field[][] getMap() {
        return map;
    }
    public void level1Map(User user){
        map = new Map(15,30).getMap();
        createMap(user);
        createLimits();
        user.setX(3);
        user.setY(0);
        map[user.getY()][user.getX()].setStart(true);
        map[11][29].setNextFloor(true);
        map[7][9].setMission(true,1);
        map[12][20].setMission(true,2);
        map[7][23].setMission(true,3);
        createVerticalWall(6,1,10);
        createHorizontalWall(10,6,25);
    }

    public void level2Map(User user){
        map = new Map(15,30).getMap();
        createMap(user);
        createLimits();
        user.setX(3);
        user.setY(0);
        map[user.getY()][user.getX()].setStart(true);
        map[12][2].setFinish(true);
        map[9][9].setMission(true,4);
        map[4][19].setMission(true,5);
        map[13][28].setMission(true,6);
        createVerticalWall(25,4,14);
        createHorizontalWall(12,27,28);
        createHorizontalWall(8,27,28);
        createHorizontalWall(4,27,28);
        createHorizontalWall(10,26,27);
        createHorizontalWall(6,26,27);
        createHorizontalWall(6,1,14);
        createHorizontalWall(8,1,10);
        createHorizontalWall(10,1,19);

    }

    public void createHorizontalWall(int y, int x1, int x2){
        for (int i = x1; i <= x2; i++) {
            map[y][i].setBlock(true);
        }
    }

    public void createVerticalWall(int x, int y1, int y2){
        for (int i = y1; i <= y2; i++) {
            map[i][x].setBlock(true);
        }
    }

}
