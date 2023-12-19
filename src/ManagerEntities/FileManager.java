package ManagerEntities;

import FrontEnd.Colors;
import UserManager.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    final String FILE_PATH = "/Users/mindera/Documents/School/projects/GroupRPG/src/Database/Users.txt";

    protected void saveNewUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(user.toString());
            writer.newLine();
            writer.close();
            System.out.println(Colors.GREEN + user.getPlayerName() + " CREATED AND SAVED TO THE FILE SUCCESSFULY!" + Colors.RESET);
        } catch (IOException e) {
            System.err.println(Colors.RED + "ERROR READING FROM THE FILE: " + e.getMessage() + Colors.RESET);
        }
    }

    public boolean isUsernameTaken(String username) {
        List<User> userList = readDatabase();
        if (userList != null) {
            for (User user : userList) {
                if (user.getPlayerName().equals(username)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<User> readDatabase() {
        try {
            List<User> userList = new ArrayList<>();
            File obj = new File(FILE_PATH);
            Scanner reader = new Scanner(obj);
            while (reader.hasNext()) {
                String currLine = reader.next();
                String[] currLineSerialized = currLine.split("\\|");
                User user = new User(currLineSerialized[0], currLineSerialized[1], currLineSerialized[2], Integer.parseInt(currLineSerialized[3]));
                userList.add(user);
            }
            reader.close();
            return userList;
        } catch (Exception e) {
            System.out.println("An error occurred reading the DB.");
        }
        return null;
    }

    public User findUser(String username, String password) {
        List<User> userList = readDatabase();
        if (userList != null) {
            for (User user : userList) {
                if (user.getPlayerName().equals(username) && user.getPlayerPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    public boolean writeDatabase(List<User> userList){

        try {
            FileWriter fw = new FileWriter(FILE_PATH,false);
            for (int i = 0; i < userList.size(); i++) {
                String toWrite = userList.get(i).toString();
                fw.write(toWrite + "\n");
            }
            fw.close();

        } catch (IOException e) {
            System.out.println("An error occurred writting to the DB.");
            e.printStackTrace();
        }
        return true;
    }
}