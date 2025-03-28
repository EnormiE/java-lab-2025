import java.time.LocalDate;
import java.util.*;

public class Person implements Comparable<Person> {
    private String firstName, lastName;
    private LocalDate birthDate;
    private Set<Person> children;

    public Person(String firstName, String lastName, LocalDate birthDate, Set<Person> children) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.children = new HashSet<>();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Person> getChildren() {
        List<Person> list = new ArrayList<>(this.children);
        Collections.sort(list);
//        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    public boolean adopt(Person child) {
        if (child != this) {
            children.add(child);
            return true;
        }
        return false;
    }

    public Person getYoungestChild() {
        if (this.children == null || this.children.isEmpty()) {
            return null;
        }

        Person youngest = this.children.iterator().next();

        for (Person child : this.children) {
//            if (child.getBirthDate().isAfter(youngest.getBirthDate())) {
            if (child.compareTo(youngest) > 0) {
                youngest = child;
            }
        }
        return youngest;
    }

    @Override
    public int compareTo(Person p) {

        if (this.getBirthDate().isAfter(p.getBirthDate())) {
            return 1;
        }
        if (this.getBirthDate().isBefore(p.getBirthDate())) {
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", children=" + children +
                '}';
    }
}
