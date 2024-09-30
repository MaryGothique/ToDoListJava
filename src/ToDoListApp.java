import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToDoListApp {
    // List to store the tasks
    private ArrayList<String> tasks;
    // Model that manages the list of tasks for the GUI
    private DefaultListModel<String> taskListModel;
    // JList is the visual component that displays the tasks
    private JList<String> taskList;
    // JTextField where the user types a new task
    private JTextField taskInput;

    // Constructor to initialize the task list and the list model
    public ToDoListApp() {
        tasks = new ArrayList<>();
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
    }

    // Method to create the GUI and make it visible
    public void createAndShowGUI() {
        // Create the main window frame with the title "To-Do List"
        JFrame frame = new JFrame("To-Do List");
        // Set the behavior to exit the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the size of the window
        frame.setSize(400, 300);
        // Use a BorderLayout to arrange components
        frame.setLayout(new BorderLayout());

        // Create a text field for user input
        taskInput = new JTextField();
        // Create a button labeled "Add Task"
        JButton addButton = new JButton("Add Task");

        // Define the action that happens when the add button is clicked
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the task from the text input
                String task = taskInput.getText();
                // If the task is not empty, add it to the list
                if (!task.isEmpty()) {
                    tasks.add(task);
                    // Add the task to the list model, which will update the GUI
                    taskListModel.addElement(task);
                    // Clear the input field after adding the task
                    taskInput.setText("");
                }
            }
        });

        // Create a panel to hold the text input and the add button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        // Add the text input to the center of the panel
        inputPanel.add(taskInput, BorderLayout.CENTER);
        // Add the add button to the right side of the panel
        inputPanel.add(addButton, BorderLayout.EAST);

        // Add the input panel to the top of the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        // Add the task list (inside a scroll pane) to the center of the frame
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Use the SwingUtilities.invokeLater to ensure that the GUI is created
        // on the event-dispatching thread (best practice for Swing)
        SwingUtilities.invokeLater(() -> {
            ToDoListApp app = new ToDoListApp();
            // Call the method to create and show the GUI
            app.createAndShowGUI();
        });
    }
}
