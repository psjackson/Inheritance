package com.example.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);
        //create a variable to use a condition for a while loop
        boolean response = true;
        //while the variable is true show menu to the user
        while (response) {
            System.out.println("Option 1: Commercial Contract.");
            System.out.println("Option 2: Residential Contract.");
            System.out.println("Option 3: Done.");
            System.out.print("Please select an option (1-3):");
            //ask for input from the user that corresponds to a menu option
            int choice = scanner.nextInt();

            //switch statement based on the choice
            switch (choice){
                //selecting 1 will prompt the user to set up a commercial client
                case 1:
                    //call the commercial method
                    commercial();
                    //set the response variable to false to break out of the while loop
                    response = false;
                    //break out of the switch statement
                    break;
                //selecting 2 will prompt the user to set up a residential client
                case 2:
                    //call the residential method
                    residential();
                    //set the response variable to false to break out of the while loop
                    response = false;
                    //break out of the switch statement
                    break;
                //selecting 3 will end the application
                case 3:
                    //display an exit message to the user
                    System.out.println("\nHave a nice day.");
                    //set the response variable to false to break out of the while loop
                    response = false;
                    //break out of the switch statement
                    break;
                //if none of the options are selected the menu options will repeat as the variable is left as true
                default:
                    //display a message to request the user selects a menu option
                    System.out.println("\n\nPlease enter the number of the option you wish to select.");
            }
        }
    }

    private static void commercial() {
        //create a multiProperty variable that will hold if a multi-property discount is applicable for the client
        boolean multiProperty;
        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);

        //display a series of questions to the user, and save the answers as variables using the scanner
        System.out.println("\nCommercial Customer:");
        //get and save the name of client to a variable
        System.out.print("Please enter the name of the customer: ");
        String customerName = scanner.nextLine();
        //get and save the phone number of the client as a variable
        System.out.print("Please enter the phone number of the customer: ");
        String customerPhone = scanner.nextLine();
        //get and save the address of the client as a variable
        System.out.print("Please enter the address of the customer: ");
        String customerAddress = scanner.nextLine();
        //get and save the name of the property as a variable
        System.out.print("Please enter the name of the property to be mowed: ");
        String propertyName = scanner.nextLine();
        //get and save the area to be mowed as a variable, get as a string then parse and save as a double
        System.out.print("Please enter the total square footage to be mowed: ");
        String footage = scanner.nextLine();
        Double squareFootage = Double.parseDouble(footage);
        //get and save if a multi-property discount is applicable in the form of y or n
        System.out.print("Please enter if there is a multi-property discount (y/n): ");
        String discount = scanner.nextLine();

        //if the user entered y or Y multiProperty variable is set to true
        multiProperty = (discount.equals("y")) || (discount.equals("Y"));

        //create a instance of the Commercial class and pass all the collected variables to it
        Commercial comCustomer = new Commercial(customerName, customerPhone, customerAddress, squareFootage, propertyName, multiProperty);
        //call the commercialCharges method with the instance just created
        comCustomer.commercialCharges();
    }

    private static void residential() {
        //create a senior variable that will hold if a senior discount is applicable for the client
        boolean senior;
        //initiate scanner to be able to get input from the user
        Scanner scanner = new Scanner(System.in);

        //display a series of questions to the user, and save the answers as variables using the scanner
        System.out.println("\nResidential Customer:");
        //get and save the name of client to a variable
        System.out.print("Please enter the name of the customer: ");
        String customerName = scanner.nextLine();
        //get and save the phone number of the client as a variable
        System.out.print("Please enter the phone number of the customer: ");
        String customerPhone = scanner.nextLine();
        //get and save the address of the client as a variable
        System.out.print("Please enter the address of the customer: ");
        String customerAddress = scanner.nextLine();
        //get and save the area to be mowed as a variable, get as a string then parse and save as a double
        System.out.print("Please enter the total square footage to be mowed: ");
        String footage = scanner.nextLine();
        Double squareFootage = Double.parseDouble(footage);
        //get and save if a multi-property discount is applicable in the form of y or n
        System.out.print("Is the customer applicable for a senior rate discount (y/n): ");
        String discount = scanner.nextLine();

        //if the user entered y or Y senior variable is set to true
        senior = (discount.equals("y")) || (discount.equals("Y"));

        //create a instance of the residential class and pass all the collected variables to it
        Residential resCustomer = new Residential(customerName, customerPhone, customerAddress, squareFootage, senior);
        //call the residentialCharges method with the instance just created
        resCustomer.residentialCharges();
    }
}
