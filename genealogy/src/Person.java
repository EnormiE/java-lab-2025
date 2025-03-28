import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Person {
    private String firstName, lastName;
    private LocalDate birthDate;
    private Set<Person> children;

    public Person(String firstName, String lastName, LocalDate birthDate, Set<Person> children) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.children = new HashSet<>();
    }

    public boolean adopt(Person child) {
        if (child != this) {
            children.add(child);
            return true;
        }
        return false;
    }
}
