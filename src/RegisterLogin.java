import java.util.List;
import java.util.Scanner;

public class RegisterLogin {

    Scanner scan = new Scanner(System.in);
    Menus menus = new Menus();
    String split = ";";
    String userLogin = "";
    public void register() {
        User user = new User();
        String file = "User.txt";
        System.out.println("Register");
        System.out.println();
        System.out.println("Username");
        user.setName(scan.nextLine());
        System.out.println("Password");
        user.setPassword(scan.nextLine());
        DataBaseTxt.writeNewUser(file, user.getName() + split + user.getPassword());

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
            if (users.get(i).getName().equals(username) && users.get(i).getPassword().equals(password)) {
                userIndex = i;
                userLogin = users.get(i).getName();
                break;
            }
        }

        boolean isUserExist = userIndex != -1;

        if (isUserExist) {
            System.out.println("Login successfully");
            System.out.println();
            GameManager.showMap();
        } else {
            System.out.println("Login not successfully");
            menus.menuRegisterLogin();
            System.out.println();
        }
        System.out.println();
    }
}