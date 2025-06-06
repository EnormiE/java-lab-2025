import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws NegativeLifespanException {

//        List<Person> list = new ArrayList<>();
        Person p1 = new Person(
                "Tobiasz",
                "Nowak",
                LocalDate.of(2001, 1, 1),
                LocalDate.of(2002, 1, 1),
                new HashSet<>(),
                new HashSet<>());
        Person p2 = new Person(
                "Alicja",
                "Nowak",
                LocalDate.of(2002, 2, 2),
                LocalDate.of(2011, 2, 2),
                new HashSet<>(),
                new HashSet<>());
        Person p3 = new Person(
                "Mariusz",
                "Nowak",
                LocalDate.of(2003, 3, 3),
                LocalDate.of(2020, 3, 3),
                new HashSet<>(),
                new HashSet<>());
        Person p4 = new Person(
                "Agata",
                "Bób",
                LocalDate.of(2004, 4, 4),
                null,
                new HashSet<>(),
                new HashSet<>());
        Person p5 = new Person(
                "Tomas",
                "Dłonias",
                LocalDate.of(2005, 5, 5),
                null,
                new HashSet<>(),
                new HashSet<>());
//        list.add(p1);
//        list.add(p2);
//        list.add(p3);
//        System.out.println("p1 adoptuje p1: " + p1.adopt(p1));
//        System.out.println("p1 adoptuje p2: " + p1.adopt(p2));
//        System.out.println(list);
//        Family family = new Family();

//        family.add(p1, p2, p2, p3);
//        family.add(list);
//        String key1= p1.getFirstName() + " " +  p1.getLastName();
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
        p1.adopt(p3);
        p2.adopt(p3);
//        p2.toPlantUML();
//        p1.toPlantUML();
//        Person.listToPlantUML(List.of(p1, p2, p3, p4));
//        System.out.println(Person.filterListBySubstr(List.of(p1, p2, p3, p4), "Bób"));
//        System.out.println(Person.sortListByBirthDate(List.of(p1, p2, p3, p4)));
//        System.out.println(Person.getDeadFromList(List.of(p1, p2, p3, p4, p5)));
//        System.out.println(Person.getOldestAlive(List.of(p1, p2, p3, p4, p5)));

        Function<String, String> yellow = s -> {
            int index = s.indexOf("{\n");
            if (index == -1) { // s.indexOf returns -1 if no occurence found
                return s;
            }
            return s.substring(0, index) + "#Yellow" + s.substring(index);
        };
//        Function<String, String> yellow = s -> {
//            String insertion = "#Yellow";
//            String newS = s;
//            int prevIndex = 0;
//            int index = newS.indexOf("{\n", prevIndex);
//            while (index > -1) { // s.indexOf returns -1 if no occurence found
//                newS = newS.substring(0, index) + insertion + newS.substring(index);
//                prevIndex = index + insertion.length() + 1;
//                index = newS.indexOf("{\n", prevIndex);
//            }
//            return newS;
//        };
        Function<String, String> nothing = s -> s;

        Predicate<Person> isDead = p -> (Person.getDeadFromList(List.of(p1, p2, p3, p4, p5))).contains(p);
        Predicate<Person> isOldestLiving = p -> p.equals(Person.getOldestAlive(List.of(p1, p2, p3, p4, p5)));
        p3.toPlantUML(yellow, isOldestLiving);
        p4.toPlantUML(yellow, isOldestLiving);
        p3.toPlantUML(nothing, isDead);
    }
}