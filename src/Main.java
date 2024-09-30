//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
/*
* ArrayList and DefaultListModel: The tasks list stores the tasks, while taskListModel manages the data for the GUI. The taskList component displays the tasks.

createAndShowGUI(): This method builds the graphical interface of the to-do list. It uses Swing components such as JFrame, JTextField, JButton, and JList to create the window, input field, and task list display.

ActionListener: When the user clicks the "Add Task" button, the ActionListener is triggered. It retrieves the text from the input field, adds the task to the list, and updates the GUI.

Main Method: This method is the entry point of the application. It uses SwingUtilities.invokeLater() to ensure the GUI is created on the correct thread.*/
