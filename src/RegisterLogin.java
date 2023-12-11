import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterLogin {

    Scanner scan = new Scanner(System.in);
    GameManager gameManager = new GameManager();
    String split = ";";
    String userLogin = "";
    User user = new User();
    public void register() {

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
         user.setPlayerName(scan.next());
        System.out.println("Password");
        user.setPlayerPassword(scan.next());


        List<User> users = getAllUsers();

        int userIndex = -1;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPlayerName().equals(user.getPlayerName()) && users.get(i).getPlayerPassword().equals(user.getPlayerPassword())) {
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

    public List<User> getAllUsers() {
        List<User> usersLIst = new ArrayList<>();

        String file = DataBaseTxt.Read("User.txt");
        String[] splitUser = file.split("\n");

        for (int i = 0; i < splitUser.length; i++) {
            String[] data = splitUser[i].split(";");
            User tempUser = new User(data[0], data[1]);
            usersLIst.add(tempUser);
        }

        return usersLIst;
    }
}

