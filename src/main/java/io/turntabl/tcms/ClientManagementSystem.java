package io.turntabl.tcms;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;


public class ClientManagementSystem {

    public static void main (String[] args) {
        // declare a variable that will store the client details
        String userInput;

        String clientId;
        String clientName;
        String clientAddress;
        String clientTelephoneNumber;
        String clientEmailAddress;



        //declare a scanner object to read the command line input by user
        Scanner sn = new Scanner(System.in);

        //loop the utility in loop until the user makes the choice to exit
        while(true){
            //Print the options for the user to choose from
            System.out.println("*****Welcome, Sam Moorhouse.*****");

            System.out.println("*****Available Options*****");
            System.out.println("*.\033[1;34m Press 1 to Enter User Details.\033[0m");
            System.out.println("*. \033[1;34mPress 2 to View List of Clients.\033[0m");
            System.out.println("*. \033[1;34mPress 3 to Search for a Client.\033[0m");
            System.out.println("*. \033[1;34mPress 4 to Delete a User.\033[0m");
            System.out.println("*. \033[1;34mPress 5 to Exit from the application.\033[0m");
            // Prompt the user to make a choice
            System.out.println("\033[1;31mEnter your choice:\033[0m");

            //Capture the user input in scanner object and store it in a pre declared variable
            userInput = sn.nextLine();

            //Check the user input
            switch(userInput){
                case "1":
                    //Enter Client Details;

                    System.out.println("\033[1;32m*.Enter Client Name. *\033[0m");
                    String userName = sn.nextLine();

                    System.out.println("\033[1;32m*.Enter Client Telephone. *\033[0m");
                    String phone = sn.nextLine();

                    System.out.println("\033[1;32m*.Enter Email Address. *\033[0m");
                    String email = sn.nextLine();

                    System.out.println("\033[1;32m*.Enter Address. *\033[0m");
                    String address = sn.nextLine();

                    int line = Utils.length() +1;
                    String newId = String.valueOf(line);
                    Client newClient = new Client(newId, userName, phone, email, address);
                    newClient.writeToFile();
                    System.out.println("\n");

                    boolean proceed = Validation.isword(clientEmailAddress=email);
                    while(proceed == false){
                       System.out.println("\033[1;32m*.Enter Email Address. *\033[0m");
                       clientEmailAddress = sn.nextLine();
                       proceed = Validation.isword(clientEmailAddress);
                   }

                   System.out.println("\033[1;37mDetails saved successfully.\033[0m");
                    break;
                case "2":
                    DataStore.getAllClients();
                    break;
//                case "3":
//                    System.out.println("\033[1;37m*. Enter your clients name*\033[0m");
//                    String searchName = sn.nextLine();
//                    try {
//                        System.out.println(Utils.searchByName(searchName));
//                    } catch (Exception clientNotFound) {
//                        System.out.println(clientNotFound.getMessage());
//                    }
//                    break;
                case "3":
                    System.out.println("\033[1;37m*. Enter your clients name*\033[0m");
                    String searchName = sn.nextLine();
                    try {
                        System.out.println("---------------------------------------------------------------------------------------------");
                        System.out.printf("%5s %20s %15s %20s %20s", "CLIENT_ID", "CLIENT_NAMES", "PHONE", "EMAIL", "ADDRESS");
                        System.out.println();
                        System.out.println("---------------------------------------------------------------------------------------------");
//                        System.out.println(Utils.searchByName(searchName));
                        for(Client client:Utils.searchByName(searchName) ){
                            System.out.format("%8s %20s %20s %20s %20s",
                                    client.getId(), client.getName(), client.getPhone(), client.getEmail(), client.getAddress());
                            System.out.println();
                        }
                        System.out.println("---------------------------------------------------------------------------------------------");
                        System.out.println();
                        System.out.println();

                    } catch (Exception clientNotFound) {
                        System.err.println(clientNotFound.getMessage());
                        System.out.println();
                    }
//                   Client searchClient = searchClient.searchClient(1,"Jude");

                    //Search for a Client
//                    System.out.println("Clienqt found or not ...");
                    break;
                case "4":
                    //List of Clients
                    String fileName = "clients.csv";
                    File file = new File(fileName);
                    DataStore.getAllClients();

                    //Delete a Client

                    System.out.println("Enter Client by ID to delete");
                    String idToDelete = sn.nextLine();
                    DataStore.deleteClients(idToDelete);
                    System.out.println("Client has been Deleted Successfully");
                    break;
                case "5":
                    //Exit from the application
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    //Inform user in case of invalid choice.
                    System.out.println("Invalid choice. Read the options carefully...");
            }
        }
    }
}