package homework25;

public class Decorator {
    public static void main(String[] args) {
        Person person = new Person("Bogdan", "Kanov");

        Person multiLinePerson = new MultiLinePerson(person);
        multiLinePerson.printMe();

        Person titledPerson = new TitledPerson(person, "Student");
        titledPerson.printMe();

        Person multiLineTitledPerson = new MultiLinePerson(new TitledPerson(person, "Professor"));
        multiLineTitledPerson.printMe();
    }
}
