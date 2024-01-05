package com.Booking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;
import java.util.Random;

public class Booking {

    public static  void displayMessage(){
        System.out.println("Hotel Booking Management");
        System.out.println("Please select your preferred choice");
        System.out.println("1. Register account");
        System.out.println("2. Book reservation");
        System.out.println("3. Generate bill");
        System.out.println("4. Feedback");
    }
    private static JSONObject createJsonContent() {
        // Create a sample JSON object

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter number: ");
        String number = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        // Create a JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("phoneNumber", number);
        jsonObject.put("email", email);
        jsonObject.put("address", address);


        return jsonObject;
    }

    public static void registerAccount(){
        File theDir = new File("C:\\Users\\likit\\Documents\\Java Learnings\\Hotel Management\\hotel-management\\Register");
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        // Generate a random number
        double randomNumber = Math.random();

        // Create JSON content
        JSONObject jsonContent = createJsonContent();

        // Define the filename
        String fileName = "ACC_" + randomNumber + ".json";

        try (FileWriter fileWriter = new FileWriter(theDir+"//"+fileName)) {
            fileWriter.write(jsonContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void bookReservation(){
        String folderPath = "C:\\Users\\likit\\Documents\\Java Learnings\\Hotel Management\\hotel-management\\Register";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you have an account? Please type yes or no");
        String option = scanner.nextLine();
        if(option.equals("yes")){
            System.out.println("Please enter the account number");
            String accountNo = scanner.nextLine();
            String fileName = "ACC_" + accountNo + ".json";
            File fileToCheck = new File(folderPath, fileName);

            if (fileToCheck.exists()) {
                System.out.println("Account exists");
                System.out.println("Please select following options:");
                System.out.println("1. Book Hotel");
                System.out.println("2. Book Villa");
                System.out.println("3. Book Flat");


            }else{
                System.out.println("Account does not exist");
            }
        }
        else{
//            registerAccount();
            System.out.println("exit");
        }
    }
    public static void main(String [] args){
        displayMessage();
        Scanner myObj = new Scanner(System.in);
        String option = myObj.nextLine();
        System.out.println(option);


        switch (option){
            case "1" :
                       registerAccount();
                       break;
            case "2" :
                       bookReservation();
                       break;
        }

    }
}
