package com.keyin;

public class Main {
    public static void main(String[] args) {

        // Create an array to store users (adjust size as needed)
        User[] users = new User[3];

        // Create some users
        users[0] = new User("Alice");
        users[1] = new User("Bob");
        users[2] = new User("Charlie");

        // Add tasks to Alice
        users[0].addTask("Buy groceries");
        users[0].addTask("Finish homework");

        // Add tasks to Bob
        users[1].addTask("Go to the gym");
        users[1].addTask("Email boss");

        // Add tasks to Charlie
        users[2].addTask("Read a book");
        users[2].addTask("Clean the house");

        // Mark a task for Bob as completed
        users[1].markTaskCompleted("Go to the gym");

        // Print tasks for each user
        for (User user : users) {
            user.printTasks();
            System.out.println("-----------------------------");
        }
    }
}
