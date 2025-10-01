package Exercise2;

import java.util.ArrayList;
import java.util.List;

public class VirtualClassroomManager {
    private static VirtualClassroomManager instance;
    private List<Classroom> classrooms;

    private VirtualClassroomManager() {
        classrooms = new ArrayList<>();
    }

    public static VirtualClassroomManager getInstance() {
        if (instance == null) {
            instance = new VirtualClassroomManager();
        }
        return instance;
    }

    public void addClassroom(String name) {
        if (getClassroom(name) != null) {
            System.out.println("Exercise2.Classroom already exists.");
            return;
        }
        classrooms.add(new Classroom(name));
        System.out.println("Exercise2.Classroom " + name + " has been created.");
    }

    public Classroom getClassroom(String name) {
        for (Classroom c : classrooms) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void addStudent(String studentId, String classroomName) {
        Classroom classroom = getClassroom(classroomName);
        if (classroom == null) {
            System.out.println("Exercise2.Classroom not found.");
            return;
        }
        Student student = new Student(studentId);
        classroom.addStudent(student);
        System.out.println("Exercise2.Student " + studentId + " has been enrolled in " + classroomName + ".");
    }

    public void scheduleAssignment(String classroomName, String assignmentDetails) {
        Classroom classroom = getClassroom(classroomName);
        if (classroom == null) {
            System.out.println("Exercise2.Classroom not found.");
            return;
        }
        Assignment assignment = new Assignment(assignmentDetails);
        classroom.addAssignment(assignment);
        System.out.println("Exercise2.Assignment for " + classroomName + " has been scheduled.");
    }

    public void submitAssignment(String studentId, String classroomName, String assignmentDetails) {
        Classroom classroom = getClassroom(classroomName);
        if (classroom == null) {
            System.out.println("Exercise2.Classroom not found.");
            return;
        }
        Student student = null;
        for (Student s : classroom.getStudents()) {
            if (s.getId().equalsIgnoreCase(studentId)) {
                student = s;
                break;
            }
        }
        if (student == null) {
            System.out.println("Exercise2.Student not found in this classroom.");
            return;
        }
        Assignment assignment = null;
        for (Assignment a : classroom.getAssignments()) {
            if (a.getDetails().equalsIgnoreCase(assignmentDetails)) {
                assignment = a;
                break;
            }
        }
        if (assignment == null) {
            System.out.println("Exercise2.Assignment not found in classroom.");
            return;
        }
        student.submitAssignment(assignment);
        System.out.println("Exercise2.Assignment submitted by Exercise2.Student " + studentId + " in " + classroomName + ".");
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
            return;
        }
        System.out.println("Classrooms:");
        for (Classroom c : classrooms) {
            System.out.println("- " + c.getName());
        }
    }

    public void listStudents(String classroomName) {
        Classroom classroom = getClassroom(classroomName);
        if (classroom == null) {
            System.out.println("Exercise2.Classroom not found.");
            return;
        }
        if (classroom.getStudents().isEmpty()) {
            System.out.println("No students in classroom " + classroomName);
            return;
        }
        System.out.println("Students in " + classroomName + ":");
        for (Student s : classroom.getStudents()) {
            System.out.println("- " + s.getId());
        }
    }

    public void listAssignments(String classroomName) {
        Classroom classroom = getClassroom(classroomName);
        if (classroom == null) {
            System.out.println("Exercise2.Classroom not found.");
            return;
        }
        if (classroom.getAssignments().isEmpty()) {
            System.out.println("No assignments in classroom " + classroomName);
            return;
        }
        System.out.println("Assignments in " + classroomName + ":");
        for (Assignment a : classroom.getAssignments()) {
            System.out.println("- " + a.getDetails());
        }
    }
}
