import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable<Person> {
    private String firstName, lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Set<Person> children;

    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate, Set<Person> children) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = children;
    }

    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new HashSet<>();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getdeathDate() {
        return deathDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
                ", deathDate=" + deathDate +
                ", children=" + children +
                '}';
    }

    public static Person fromCsvLine(String line) throws NegativeLifespanException {
//        "Anna Dąbrowska,07.02.1930,22.12.1991,Ewa Kowalska,Marek Kowalski"
        String[] lineParts = line.split(",");
        String firstName = lineParts[0].split(" ")[0];
        String lastName = lineParts[0].split(" ")[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate = LocalDate.parse(lineParts[1],formatter);
        LocalDate deathDate = null;
        try {
            if (!lineParts[2].isEmpty()) {
                deathDate = LocalDate.parse(line.split(",")[2], formatter);
                if(deathDate.isBefore(birthDate)) {
                    throw new NegativeLifespanException("osoba " + firstName + " " + lastName + " ma negatywny wiek");
                }
            }
        }
        catch (NegativeLifespanException e) {
            System.err.println(e.getMessage());
        }
        return new Person(firstName, lastName, birthDate, deathDate);
    }

    public static List<Person> fromCsv(String fileName) {
        List<Person> pList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            List<String> lines = new ArrayList<>();
            String line = null;
            while ((line = reader.readLine()) != null) {
                pList.add(fromCsvLine(line)) ;
            }
        } catch (IOException | NegativeLifespanException e) {
            System.err.println(e.getMessage());
        }
//        System.out.println(lines.getFirst());

        return pList;
    }
}
