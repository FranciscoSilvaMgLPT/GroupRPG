package ManagerEntities;

import FrontEnd.Colors;
import UserManager.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    final String usersPath = "src/Database/Users.txt";
    final String userPath = "src/Database/UserObjects";

    protected void saveUserLog(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersPath, true))) {
            writer.write(user.toString());
            writer.newLine();
            writer.close();
            System.out.println(Colors.GREEN + user.getPlayerName() + " created, saved to the file successfully." + Colors.RESET);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    protected User findUser(String username, String password) {
        String[] lineSplited;
        try (BufferedReader reader = new BufferedReader(new FileReader(usersPath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineSplited = line.split(";");
                if (lineSplited[0].equals(username) && lineSplited[1].equals(password)) {
                    System.out.println("User " + username + " found!!!\n");
                    reader.close();
                    return new User(lineSplited[0], lineSplited[1], Colors.valueOf(lineSplited[2]), Integer.parseInt(lineSplited[3]));
                }
            }
            System.out.println(Colors.RED + "\n" + username + " not found." + Colors.RESET);
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
        return null;
    }

    protected boolean isUsernameTaken(String username) {
        String[] lineSplited;
        try (BufferedReader reader = new BufferedReader(new FileReader(usersPath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineSplited = line.split(";");
                if (lineSplited[0].equals(username)) {
                    System.out.println(Colors.RED + username + " already exists!!!\n" + Colors.RESET);
                    reader.close();
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
        return false;
    }

    protected void updateUser(User user) {
        String[] lineSplited;
        List<String> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(usersPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userList.add(line);
            }
            for (int i = 0; i < userList.size(); i++) {
                lineSplited = userList.get(i).split(";");
                if (lineSplited[0].equals(user.getPlayerName()) && lineSplited[1].equals(user.getPlayerPassword())) {
                    userList.set(i, user.toString());
                    System.out.println("Updated!");
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersPath, false))) {
                writer.write(user.toString());
                writer.newLine();
                writer.close();
                System.out.println(Colors.GREEN + user.getPlayerName() + " created, saved to the file successfully." + Colors.RESET);
            } catch (IOException e) {
                System.err.println("Error writing to the file: " + e.getMessage());
            }


        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
    }
}
