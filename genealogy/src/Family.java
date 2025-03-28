import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Family {
    Map<String, List<Person>> familyMap;

    public Family(Map<String, List<Person>> familyMap) {
        this.familyMap = familyMap;
    }

    public Family() {
        this.familyMap = new HashMap<>();
    }

    public void add(Person... persons) {
        for (Person person : persons) {
            String key = person.getFirstName() + " " +  person.getLastName();
            if (this.familyMap.containsKey(key)) {
                familyMap.get(key).add(person);
            }
            else{
                List<Person> sameList = new ArrayList<>();
                sameList.add(person);
                this.familyMap.put(key, sameList);
            }
//            this.familyMap.put(key, person);
        }
    }

    public List<Person> get(String key) {
        return this.familyMap.get(key);
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(hashCode()) + familyMap;
    }
}
