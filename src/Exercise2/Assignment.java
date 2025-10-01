package Exercise2;

import java.util.Objects;

public class Assignment {
    private final String details;

    public Assignment(String details) {
        if (details == null || details.trim().isEmpty()) {
            throw new IllegalArgumentException("Exercise2.Assignment details cannot be null or empty");
        }
        this.details = details.trim();
    }

    public String getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Assignment that = (Assignment) obj;
        return details.equalsIgnoreCase(that.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(details.toLowerCase());
    }

    @Override
    public String toString() {
        return "Exercise2.Assignment{details='" + details + "'}";
    }
}