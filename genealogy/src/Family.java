import java.util.HashMap;
import java.util.Map;

public class Family {
    Map<String, Person> familyMap;

    public Family(Map<String, Person> familyMap) {
        this.familyMap = familyMap;
    }

    public Family() {
        this.familyMap = new HashMap<>();
    }

    public void add(Person person) {
        String key = person.getFirstName() + " " +  person.getLastName();
        this.familyMap.put(key, person);
    }

    public Person get(String key) {
        return this.familyMap.get(key);
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode()) + familyMap;
    }
}
