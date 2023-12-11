import FrontEnd.Colors;

import java.io.*;

public class FileManager {
    final String usersPath = "src/Database/Users.txt";
    final String userPath = "src/Database/UserObjects";

    protected void saveUserLog(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersPath, true))) {
            writer.write(user.getPlayerName() + ";");
            writer.write(user.getPlayerPassword());
            writer.newLine();
            writer.close();
            System.out.println(Colors.GREEN + "User \"" + user.getPlayerName() + "\" created, saved to the file successfully." + Colors.RESET);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    protected boolean findUser(String username, String password) {
        String[] lineSplited;
        try (BufferedReader reader = new BufferedReader(new FileReader(usersPath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineSplited = line.split(";");
                if (lineSplited[0].equals(username) && lineSplited[1].equals(password)) {
                    System.out.println("User \""+username+"\" found!!!");
                    reader.close();
                    return true;
                }
            }
            System.out.println(Colors.RED + "\nUser not found." + Colors.RESET);
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
        return false;
    }

    protected void saveUser(User user) {
        String filePath = userPath.concat(user.getPlayerName().concat(".txt"));
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(user);
            System.out.println("Saved successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while saving the object to a file.");
            e.printStackTrace();
        }
    }

    protected User loadUser(User user1) {
        String filePath = userPath.concat(user1.getPlayerName().concat(".txt"));
        User user = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            user = (User) objectInputStream.readObject();
            System.out.println("User " + user.getPlayerName() + " loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("An error occurred while loading the object from a file.");
            e.printStackTrace();
        }
        return user;
    }
}
