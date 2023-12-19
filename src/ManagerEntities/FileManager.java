package ManagerEntities;

import FrontEnd.Colors;
import UserManager.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    final String usersPath = "src/Database/Users.txt";

    protected void saveUserLog(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(usersPath, true))) {
            writer.write(user.toString());
            writer.newLine();
            writer.close();
            System.out.println(Colors.GREEN + user.getPlayerName() + " CREATED AND SAVED TO THE FILE SUCCESSFULY!" + Colors.RESET);
        } catch (IOException e) {
            System.err.println(Colors.RED + "ERROR READING FROM THE FILE: " + e.getMessage() + Colors.RESET);
        }
    }

    protected User findUser(String username, String password) {
        String[] lineSplited;
        try (BufferedReader reader = new BufferedReader(new FileReader(usersPath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineSplited = line.split(";");
                if (lineSplited[0].equals(username) && lineSplited[1].equals(password)) {
                    System.out.println(Colors.GREEN_BOLD_BRIGHT + "USER " + username + " FOUND!\n" + Colors.RESET);
                    reader.close();
                    return new User(lineSplited[0], lineSplited[1], Colors.valueOf(lineSplited[2]), Integer.parseInt(lineSplited[3]));
                }
            }
            System.out.println(Colors.RED + "\nUSER " + username + " NOT FOUND!" + Colors.RESET);
        } catch (IOException e) {
            System.err.println(Colors.RED + "ERROR READING FROM THE FILE: " + e.getMessage() + Colors.RESET);
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
                    System.out.println(Colors.RED + username + " ALREADY EXISTS!!!\n" + Colors.RESET);
                    reader.close();
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println(Colors.RED + "ERROR READING FROM THE FILE: " + e.getMessage() + Colors.RESET);
        }
        return false;
    }

    protected void updateUser(User user) {
        String[] lineSplited;
        List<String> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(usersPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineSplited = line.split(";");
                if (lineSplited[0].equals(user.getPlayerName())) {

                    reader.close();
                }
            }
        } catch (IOException e) {
            System.err.println(Colors.RED + "ERROR READING FROM THE FILE: " + e.getMessage() + Colors.RESET);
        }
    }
}
