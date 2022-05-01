import java.util.*;

public class SortingComparator {
    public static void main(String... args){

        Person p1 = new Person("amy",100);
        Person p2 = new Person("david",100);
        Person p3 = new Person("heraldo",50);
        Person p4 = new Person("aakansha",75);
        Person p5 = new Person("aleksa",150);
        List<Person> list = new ArrayList<>();
        list.add(p1);list.add(p2);list.add(p3);list.add(p4);list.add(p5);
        list.stream().map(person -> person.name).forEach(System.out::println);
        System.out.println("-----------------");
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                int nameComp = a.name.compareTo(b.name);
                if(nameComp!=0){
                    return nameComp;
                }
                Integer aInt = a.score;
                Integer bInt = b.score;
                return aInt.compareTo(bInt);
            }
        });
        list.stream().map(person -> person.name).forEach(System.out::println);
    }
}
