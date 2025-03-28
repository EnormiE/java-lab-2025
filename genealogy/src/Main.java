import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        Person p1 = new Person(
                "Tobiasz",
                "Rzecki",
                LocalDate.of(2001, 1, 1),
                new HashSet<>());
        Person p2 = new Person(
                "Mateusz",
                "Geok",
                LocalDate.of(2002, 2, 2),
                new HashSet<>());
        Person p3 = new Person(
                "Alicja",
                "Nowak",
                LocalDate.of(2003, 3, 3),
                new HashSet<>());
        list.add(p1);
        list.add(p2);
        list.add(p3);
//        System.out.println("p1 adoptuje p1: " + p1.adopt(p1));
//        System.out.println("p1 adoptuje p2: " + p1.adopt(p2));
//        System.out.println(list);

        p1.adopt(p2);
        p1.adopt(p3);

//        System.out.println(p1.getYoungestChild());
        Family family = new Family();
//        System.out.println(family);

        family.add(p1);
        family.add(p2);
        family.add(p3);
        String key1= p1.getFirstName() + " " +  p1.getLastName();
//        String key2= p2.getFirstName() + " " +  p2.getLastName();

        System.out.println(family);

        System.out.println(family.get(key1));
//        System.out.println(family.get(key2));

    }
}