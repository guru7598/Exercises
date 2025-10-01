package Exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student {
    private final String id;
    private final List<Assignment> submittedAssignments;

    public Student(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Exercise2.Student ID cannot be null or empty");
        }
        this.id = id.trim();
        this.submittedAssignments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Assignment> getSubmittedAssignments() {
        return Collections.unmodifiableList(submittedAssignments);
    }

    public void submitAssignment(Assignment assignment) {
        if (assignment == null) {
            throw new IllegalArgumentException("Exercise2.Assignment cannot be null");
        }
        submittedAssignments.add(assignment);
    }

    public boolean hasSubmitted(Assignment assignment) {
        return submittedAssignments.contains(assignment);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id.equalsIgnoreCase(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id.toLowerCase());
    }

    @Override
    public String toString() {
        return "Exercise2.Student{id='" + id + "', submittedAssignments=" + submittedAssignments.size() + "}";
    }
}