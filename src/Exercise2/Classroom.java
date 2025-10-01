package Exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Classroom {
    private final String name;
    private final List<Student> students;
    private final List<Assignment> assignments;

    public Classroom(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Exercise2.Classroom name cannot be null or empty");
        }
        this.name = name.trim();
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public List<Assignment> getAssignments() {
        return Collections.unmodifiableList(assignments);
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Exercise2.Student cannot be null");
        }
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void addAssignment(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Exercise2.Assignment cannot be null");
        }
        if (!assignments.contains(assignment)) {
            assignments.add(assignment);
        }
    }

    public Optional<Student> findStudentById(String studentId) {
        if (studentId == null) {
            return Optional.empty();
        }
        return students.stream()
                .filter(student -> student.getId().equalsIgnoreCase(studentId))
                .findFirst();
    }

    public Optional<Assignment> findAssignmentByDetails(String assignmentDetails) {
        if (assignmentDetails == null) {
            return Optional.empty();
        }
        return assignments.stream()
                .filter(assignment -> assignment.getDetails().equalsIgnoreCase(assignmentDetails))
                .findFirst();
    }

    public boolean hasStudents() {
        return !students.isEmpty();
    }

    public boolean hasAssignments() {
        return !assignments.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Classroom classroom = (Classroom) obj;
        return name.equalsIgnoreCase(classroom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String toString() {
        return String.format("Exercise2.Classroom{name='%s', students=%d, assignments=%d}",
                name, students.size(), assignments.size());
    }
}