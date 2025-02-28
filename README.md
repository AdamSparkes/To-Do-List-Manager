# To-Do List Manager (with GUI)

## Overview

This project is a **simple to-do list manager** implemented in Java. Each user has their own **to-do list**, stored as a **singly linked list** of tasks. The program demonstrates:
- Managing an array of users (`User[]`).
- Maintaining a singly linked list of tasks for each user (`TaskList`).
- Providing basic operations to add tasks, mark them as completed, and display them in a **Swing GUI**.

## Features

1. **User Management**  
   - Create and store users in an array (up to a fixed limit).  
   - Each user has a unique name.

2. **Task Management**  
   - Add tasks (description + status) to a user’s to-do list.  
   - Tasks are stored in a singly linked list.

3. **Mark Tasks as Completed**  
   - Mark a task as completed by updating its status (Pending → Completed).

4. **View Tasks**  
   - View all tasks in the currently selected user’s to-do list, including each task’s completion status.

5. **Graphical User Interface**  
   - A Swing-based GUI allows for:
     - Adding new users.
     - Selecting a user to view/add tasks.
     - Marking tasks as completed.

## Requirements

- **Java 8** or higher (for Swing utilities).
- **Maven** (optional). If you’re using Maven, include a basic `pom.xml` with standard compiler plugins.

## Installation & Running

1. **Clone or Download** the project to your local machine.
2. If you’re using **Maven**:
   - Open a terminal in the project’s directory.
   - Run `mvn clean install` to compile.
   - Run `mvn exec:java -Dexec.mainClass="ToDoListGUI"` (adjust the main class name if needed).
3. If you’re **not** using Maven:
   - Ensure the `.java` files (`Task.java`, `TaskList.java`, `User.java`, `ToDoListGUI.java`) are all in the same (or appropriate) directory structure.
   - Compile them with `javac *.java`.
   - Run the GUI with `java ToDoListGUI`.

After these steps, a window should appear with input fields and lists for managing users and tasks.

## Usage Instructions

Once the GUI is open, you’ll see the following components:

1. **Add User Section**  
   - A text field labeled “Username”.
   - Click the **Add User** button to create a new user.
   - The user’s name will appear in the **Users** list once added.

2. **Users List**  
   - Displays the names of all added users.
   - Select a user from this list to view or manage their tasks.

3. **Add Task Section**  
   - A text field labeled “Task”.
   - Click the **Add Task** button to add a new task for the selected user.
   - The task will appear in the **Tasks for Selected User** list once added.

4. **Tasks for Selected User**  
   - Shows all tasks for the currently highlighted user.
   - Each task is displayed with its description and status, e.g., “Buy groceries (Pending)” or “Buy groceries (Completed)”.

5. **Mark Completed Button**  
   - Select a task in the tasks list.
   - Click **Mark Completed** to update the status of that task.

### Example Workflow

1. **Add a User**  
   - In the “Username” field, type “Alice”.
   - Click **Add User** → “Alice” appears in the Users list.

2. **Select Alice**  
   - Click on “Alice” in the Users list.

3. **Add Tasks for Alice**  
   - Type “Buy groceries” in the “Task” field → click **Add Task**.
   - Type “Finish homework” in the “Task” field → click **Add Task**.
   - Both tasks appear under “Tasks for Selected User”.

4. **Mark a Task Completed**  
   - Select “Buy groceries (Pending)” from the tasks list.
   - Click **Mark Completed** → The task now displays as “Buy groceries (Completed).”

## Project Structure

- **Task.java**  
  Represents an individual task, storing its description and status (completed or not).

- **TaskList.java**  
  A singly linked list to store `Task` objects.  
  Contains methods to add tasks, mark tasks as completed, and retrieve tasks as an array for display.

- **User.java**  
  Stores user information (name) and an associated `TaskList`.  
  Offers methods for adding tasks and marking tasks as completed.

- **ToDoListGUI.java** (Main GUI)  
  - Extends `JFrame` and sets up Swing components: `JList`, `JTextField`, and `JButton`.
  - Maintains an array of `User` objects.
  - Provides interaction logic for adding users, selecting users, adding tasks, marking tasks as completed, and displaying tasks.

## Troubleshooting

- **No User Selected**: If you try to add a task or mark a task as completed without selecting a user first, you’ll get a warning dialog. Make sure to select a user from the list.
- **Array is Full**: By default, the code uses a fixed-size array for users. If you exceed this limit (e.g., 10), you’ll see an error message. Consider using an `ArrayList<User>` if you need dynamic sizing.
- **Task Not Marking Completed**: Ensure the task name in the tasks list matches exactly what was entered. In the code, we split the string to find the description. If you run into issues, you might want to debug the string parsing logic.
- **No Window Appears**: Double-check your `main` method in `ToDoListGUI` is correct. Also ensure you’re calling `SwingUtilities.invokeLater(...)` to start the GUI on the Event Dispatch Thread.

## License

*(Replace this section with your actual license if applicable, e.g., MIT, Apache 2.0, etc.)*

No User Selected: If you try to add a task or mark a task as completed without selecting a user first, you’ll get a warning dialog. Make sure to select a user from the list.
Array is Full: By default, the code uses a fixed-size array for users. If you exceed this limit (e.g., 10), you’ll see an error message. Consider using an ArrayList<User> if you need dynamic sizing.
Task Not Marking Completed: Ensure the task name in the tasks list matches exactly what was entered. In the code, we split the string to find the description. If you run into issues, you might want to debug the string parsing logic.
No Window Appears: Double-check your main method in ToDoListGUI is correct. Also ensure you’re calling SwingUtilities.invokeLater(...) to start the GUI on the Event Dispatch Thread.
