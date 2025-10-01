package Exercise2;

import java.util.Scanner;

public class Main {
    private static final String SEPARATOR = "==========================================";

    public static void main(String[] args) {
        VirtualClassroomManager manager = VirtualClassroomManager.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        displayWelcomeMessage();

        while (isRunning) {
            displayMenu();
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            isRunning = processCommand(manager, input);
            System.out.println();
        }

        scanner.close();
        displayExitMessage();
    }

    private static void displayWelcomeMessage() {
        System.out.println(SEPARATOR);
        System.out.println("   Virtual Exercise2.Classroom Manager");
        System.out.println(SEPARATOR);
        System.out.println();
    }

    private static void displayMenu() {
        System.out.println("Available Commands:");
        System.out.println("  1. add_classroom <name>");
        System.out.println("  2. add_student <studentId> <className>");
        System.out.println("  3. schedule_assignment <className> <assignmentDetails>");
        System.out.println("  4. submit_assignment <studentId> <className> <assignmentDetails>");
        System.out.println("  5. list_classrooms");
        System.out.println("  6. list_students <className>");
        System.out.println("  7. list_assignments <className>");
        System.out.println("  8. exit");
        System.out.print("\nEnter command: ");
    }

    private static boolean processCommand(VirtualClassroomManager manager, String input) {
        String[] parts = input.split("\\s+", 2);
        String command = parts[0].toLowerCase();

        try {
            switch (command) {
                case "add_classroom":
                    handleAddClassroom(manager, parts);
                    break;

                case "add_student":
                    handleAddStudent(manager, parts);
                    break;

                case "schedule_assignment":
                    handleScheduleAssignment(manager, parts);
                    break;

                case "submit_assignment":
                    handleSubmitAssignment(manager, parts);
                    break;

                case "list_classrooms":
                    manager.listClassrooms();
                    break;

                case "list_students":
                    handleListStudents(manager, parts);
                    break;

                case "list_assignments":
                    handleListAssignments(manager, parts);
                    break;

                case "exit":
                case "quit":
                    return false;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Please check your command format and try again.");
        }

        return true;
    }

    private static void handleAddClassroom(VirtualClassroomManager manager, String[] parts) {
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            System.out.println("Usage: add_classroom <name>");
            return;
        }
        manager.addClassroom(parts[1].trim());
    }

    private static void handleAddStudent(VirtualClassroomManager manager, String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: add_student <studentId> <className>");
            return;
        }

        String[] args = parts[1].split("\\s+", 2);
        if (args.length < 2) {
            System.out.println("Usage: add_student <studentId> <className>");
            return;
        }

        String studentId = args[0].trim();
        String className = args[1].trim();
        manager.addStudent(studentId, className);
    }

    private static void handleScheduleAssignment(VirtualClassroomManager manager, String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: schedule_assignment <className> <assignmentDetails>");
            return;
        }

        String[] args = parts[1].split("\\s+", 2);
        if (args.length < 2) {
            System.out.println("Usage: schedule_assignment <className> <assignmentDetails>");
            return;
        }

        String className = args[0].trim();
        String assignmentDetails = args[1].trim();
        manager.scheduleAssignment(className, assignmentDetails);
    }

    private static void handleSubmitAssignment(VirtualClassroomManager manager, String[] parts) {
        if (parts.length < 2) {
            System.out.println("Usage: submit_assignment <studentId> <className> <assignmentDetails>");
            return;
        }

        String[] args = parts[1].split("\\s+", 3);
        if (args.length < 3) {
            System.out.println("Usage: submit_assignment <studentId> <className> <assignmentDetails>");
            return;
        }

        String studentId = args[0].trim();
        String className = args[1].trim();
        String assignmentDetails = args[2].trim();
        manager.submitAssignment(studentId, className, assignmentDetails);
    }

    private static void handleListStudents(VirtualClassroomManager manager, String[] parts) {
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            System.out.println("Usage: list_students <className>");
            return;
        }
        manager.listStudents(parts[1].trim());
    }

    private static void handleListAssignments(VirtualClassroomManager manager, String[] parts) {
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            System.out.println("Usage: list_assignments <className>");
            return;
        }
        manager.listAssignments(parts[1].trim());
    }

    private static void displayExitMessage() {
        System.out.println(SEPARATOR);
        System.out.println("Thank you for using Virtual Exercise2.Classroom Manager!");
        System.out.println("Goodbye!");
        System.out.println(SEPARATOR);
    }
}