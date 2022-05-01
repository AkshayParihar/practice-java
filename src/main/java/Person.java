public class Person {
    String name;
    int score;

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public static void main(String... args){
        Person p = new Person("Akshay",100);
        System.out.println(Math.abs(p.hashCode()%16));
    }
}
