public class GameManager {
    public void gameManager(){
        while (true) {
            Menus menus = new Menus();
            menus.menuRegisterLogin();
        }
    }
    public static void showMap(){
        Map map = new Map();
        map.createMap();
        map.CreateLimits();
        map.showMap();
    }

}
