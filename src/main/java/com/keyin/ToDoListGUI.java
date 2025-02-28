package com.keyin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListGUI extends JFrame {

    private User[] users = new User[10];
    private int userCount = 0;

    private DefaultListModel<String> userListModel;
    private JList<String> userList;

    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    private JTextField userNameField;
    private JButton addUserButton;

    private JTextField taskField;
    private JButton addTaskButton;

    private JButton markCompletedButton;

    public ToDoListGUI() {
        super("To-Do List Manager");

        userListModel = new DefaultListModel<>();
        userList = new JList<>(userListModel);
        userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        userNameField = new JTextField(10);
        addUserButton = new JButton("Add User");

        taskField = new JTextField(10);
        addTaskButton = new JButton("Add Task");

        markCompletedButton = new JButton("Mark Completed");

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(5, 5, 5, 5);

        gc.gridx = 0;
        gc.gridy = 0;
        add(new JLabel("Username:"), gc);
        gc.gridx = 1;
        add(userNameField, gc);

        gc.gridx = 2;
        add(addUserButton, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 3;
        add(new JLabel("Users:"), gc);

        // Row 2: User List
        gc.gridy = 2;
        gc.gridwidth = 3;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 0.3;
        gc.weighty = 0.5;
        add(new JScrollPane(userList), gc);

        // Row 3: Label + Task input
        gc.gridy = 3;
        gc.gridwidth = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.weighty = 0;
        gc.weightx = 0;
        gc.gridx = 0;
        add(new JLabel("Task:"), gc);

        gc.gridx = 1;
        add(taskField, gc);

        gc.gridx = 2;
        add(addTaskButton, gc);

        gc.gridx = 0;
        gc.gridy = 4;
        gc.gridwidth = 3;
        add(new JLabel("Tasks for Selected User:"), gc);

        gc.gridy = 5;
        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 0.7;
        gc.weighty = 0.5;
        add(new JScrollPane(taskList), gc);

        gc.gridy = 6;
        gc.gridwidth = 3;
        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.anchor = GridBagConstraints.CENTER;
        add(markCompletedButton, gc);

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameField.getText().trim();
                if (!userName.isEmpty()) {
                    if (userCount < users.length) {
                        users[userCount] = new User(userName);
                        userCount++;
                        userListModel.addElement(userName);
                        userNameField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(ToDoListGUI.this,
                                "User array is full!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        userList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                updateTaskListForSelectedUser();
            }
        });

        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = userList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    String taskDescription = taskField.getText().trim();
                    if (!taskDescription.isEmpty()) {
                        User selectedUser = users[selectedIndex];
                        selectedUser.addTask(taskDescription);
                        updateTaskListForSelectedUser();
                        taskField.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(ToDoListGUI.this,
                            "Please select a user first.",
                            "No User Selected",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        markCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedUserIndex = userList.getSelectedIndex();
                int selectedTaskIndex = taskList.getSelectedIndex();

                if (selectedUserIndex >= 0 && selectedTaskIndex >= 0) {

                    User selectedUser = users[selectedUserIndex];

                    String selectedTaskString = taskListModel.getElementAt(selectedTaskIndex);

                    String taskDescription = selectedTaskString.split("\\(")[0].trim();

                    selectedUser.markTaskCompleted(taskDescription);

                    updateTaskListForSelectedUser();
                }
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateTaskListForSelectedUser() {
        taskListModel.clear();
        int index = userList.getSelectedIndex();
        if (index >= 0) {
            User selectedUser = users[index];
            String[] tasks = selectedUser.getToDoList().getTasksAsStringArray();
            for (String taskString : tasks) {
                taskListModel.addElement(taskString);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListGUI();
            }
        });
    }
}
