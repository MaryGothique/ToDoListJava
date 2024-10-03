import javax.swing.*; // Used to bring in Swing components (JFrame, JButton, JTextField, etc.) for building the GUI
import java.awt.*; // AWT classes used for layouts and GUI components
import java.awt.event.ActionEvent; // ActionEvent class used to handle events like button clicks
import java.awt.event.ActionListener; // ActionListener interface to handle button click events
import java.util.ArrayList; // ArrayList class to dynamically store a list of tasks

public class ToDoListApp { // Defines the ToDoListApp class that contains the application logic and user interface
    private ArrayList<String> tasks; // An ArrayList to store tasks as a resizable list of String objects
    private DefaultListModel<String> taskListModel; // Model for the JList to manage task data (Model in MVC)
    private JList<String> taskList; // A component to display the list of tasks visually to the user
    private JTextField taskInput; // A text field where users can type in tasks

    public ToDoListApp() { // Constructor to initialize the task list and model
        tasks = new ArrayList<>(); // Initialize an ArrayList to hold the tasks
        taskListModel = new DefaultListModel<>(); // Initialize the DefaultListModel to manage task data for JList
        taskList = new JList<>(taskListModel); // Link the list model to the taskList (JList) component for display
    }

    public void createAndShowGUI() { // Method to set up and display the graphical user interface (GUI)
        JFrame frame = new JFrame("To-Do List"); // Create the main window (JFrame) with title "To-Do List"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the close operation to exit the program
        frame.setSize(400, 300); // Set the window size to 400x300 pixels
        frame.setLayout(new BorderLayout()); // Use a BorderLayout to position components in the window

        taskInput = new JTextField(); // Create the text field where the user types tasks
        JButton addButton = new JButton("Add Task"); // Create the "Add Task" button

        // Add an ActionListener to the "Add Task" button that defines the behavior when it's clicked
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // The method to handle the button click (ActionEvent)
                String task = taskInput.getText(); // Get the text input by the user
                if (!task.isEmpty()) { // Check if the input is not empty
                    tasks.add(task); // Add the task to the ArrayList of tasks
                    taskListModel.addElement(task); // Add the task to the DefaultListModel (updates JList)
                    taskInput.setText(""); // Clear the input field after the task is added
                }
            }
        });

        // Create a panel to hold the text input field and "Add Task" button
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout()); // Use BorderLayout to position input and button
        inputPanel.add(taskInput, BorderLayout.CENTER); // Add text input in the center
        inputPanel.add(addButton, BorderLayout.EAST); // Add the "Add Task" button to the right (east)

        frame.add(inputPanel, BorderLayout.NORTH); // Add the input panel to the top of the window
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER); // Add the scrollable task list to the center

        frame.setVisible(true); // Make the window visible to the user
    }

    public static void main(String[] args) { // Main method where the program starts
        // Use SwingUtilities.invokeLater to ensure the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            ToDoListApp app = new ToDoListApp(); // Create an instance of the ToDoListApp class
            app.createAndShowGUI(); // Set up and display the GUI
        });
    }
}
