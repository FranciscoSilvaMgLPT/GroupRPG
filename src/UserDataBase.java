import java.util.ArrayList;
import java.util.List;

public class UserDataBase {

    public List<User> getAllUsers(){
        List<User> usersLIst = new ArrayList<>();

        String file = DataBaseTxt.Read("User.txt");
        String[] splitUser = file.split("\n");

        for (int i = 0; i < splitUser.length ; i++) {
            String[] data = splitUser[i].split(";");
            User tempUser = new User(data[0],data[1]);
            usersLIst.add(tempUser);
        }

        return usersLIst;
    }
}
