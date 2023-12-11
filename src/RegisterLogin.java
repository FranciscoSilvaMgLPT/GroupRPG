import java.util.List;
import java.util.Scanner;

public class RegisterLogin {

    Scanner scan = new Scanner(System.in);
    GameManager gameManager = new GameManager();
    String split = ";";
    String userLogin = "";
    public void register() {
        User user = new User();
        String file = "User.txt";
        System.out.println("Register");
        System.out.println();
        System.out.println("Username");
        user.setPlayerName(scan.nextLine());
        System.out.println("Password");
        user.setPlayerPassword(scan.nextLine());
        DataBaseTxt.writeNewUser(file, user.getPlayerName() + split + user.getPlayerPassword());

    }
    public void login() {
        System.out.println("Login");
        System.out.println();
        System.out.println("Username");
        String username = scan.next();
        System.out.println("Password");
        String password = scan.next();

        UserDataBase database = new UserDataBase();
        List<User> users = database.getAllUsers();

        int userIndex = -1;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPlayerName().equals(username) && users.get(i).getPlayerPassword().equals(password)) {
                userIndex = i;
                userLogin = users.get(i).getPlayerName();
                break;
            }
        }

        boolean isUserExist = userIndex != -1;

        if (isUserExist) {
            System.out.println("Login successfully");
            gameManager.playMenu();
            System.out.println();
        } else {
            System.out.println("Login not successfully");
            gameManager.initialMenu();
            System.out.println();
        }
        System.out.println();
    }
}
