import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NegativeLifespanException {

        List<Person> list = new ArrayList<>();
        Person p1 = new Person(
                "Tobiasz",
                "Rzecki",
                LocalDate.of(2001, 1, 1),
                LocalDate.of(2005, 1, 1),
                new HashSet<>(),
                new HashSet<>());
        Person p2 = new Person(
                "Mateusz",
                "Geok",
                LocalDate.of(2002, 2, 2),
                LocalDate.of(2003, 2, 2),
                new HashSet<>(),
                new HashSet<>());
        Person p3 = new Person(
                "Alicja",
                "Nowak",
                LocalDate.of(2003, 3, 3),
                LocalDate.of(2004, 3, 3),
                new HashSet<>(),
                new HashSet<>());
        list.add(p1);
        list.add(p2);
        list.add(p3);
//        System.out.println("p1 adoptuje p1: " + p1.adopt(p1));
//        System.out.println("p1 adoptuje p2: " + p1.adopt(p2));
//        System.out.println(list);

        p1.adopt(p2);
        p3.adopt(p2);
        Family family = new Family();

        family.add(p1, p2, p2, p3);
//        family.add(list);
        String key1= p1.getFirstName() + " " +  p1.getLastName();
//        System.out.println(family.get(key1));

//        System.out.println(Person.fromCsvLine("Marek Kowalski,15.05.1899,25.06.1890,,"));
//        System.out.println(Person.fromCsv("resources/family.csv"));
//// L06_Z07
//        System.out.println("\n--- Zadanie 7: Testowanie zapisu i odczytu binarnego ---");
//        List<Person> peopleToBinary = new ArrayList<>();
//        peopleToBinary.add(new Person("Karol", "Nowak", LocalDate.of(2000, 1, 1), null));
//        peopleToBinary.add(new Person("Zofia", "Kowalska", LocalDate.of(1985, 5, 10), LocalDate.of(2022, 12, 25)));
//
//        Person.toBinaryFile(peopleToBinary, "people.bin");
//        List<Person> readPeopleBinary = Person.fromBinaryFile("people.bin");
//        for (Person person : readPeopleBinary) {
//            System.out.println(person);
//        }

//        PlantUMLRunner.generateScheme("@startuml\nAlice -> Bob: Authentication Request\n@enduml", "new", "new_file");
        p2.toPlantUML();
        p1.toPlantUML();
    }
}