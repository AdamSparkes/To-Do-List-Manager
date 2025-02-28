package com.keyin;

public class TaskList {
    private static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;  // Head of the linked list

    public TaskList() {
        head = null;
    }

    public void addTask(String description) {
        Task newTask = new Task(description);
        Node newNode = new Node(newTask);

        if (head == null) {
            // List is empty, so newNode becomes the head
            head = newNode;
        } else {
            // Traverse to the end of the list and add the new node
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void markTaskCompleted(String description) {
        Node current = head;
        while (current != null) {
            if (current.task.getDescription().equalsIgnoreCase(description)) {
                current.task.markCompleted();
                break; // Mark the first matching task as completed, then exit
            }
            current = current.next;
        }
    }

    public void printTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(
                    current.task.getDescription()
                            + " | Completed: " + current.task.isCompleted()
            );
            current = current.next;
        }
    }

    public String[] getTasksAsStringArray() {
        // Count the number of tasks first
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }

        // Create the array of appropriate size
        String[] tasks = new String[count];

        // Fill the array with each task's description plus status
        current = head;
        int i = 0;
        while (current != null) {
            String description = current.task.getDescription();
            boolean completed = current.task.isCompleted();
            tasks[i] = description + (completed ? " (Completed)" : " (Pending)");
            i++;
            current = current.next;
        }

        return tasks;
}
}
