package homework25;

public class MultiLinePerson extends Person {

    public MultiLinePerson(Person person) {
        super(person.firstName, person.lastName);
    }

    @Override
    public void printMe() {
        System.out.println();
        super.printMe();
        System.out.println();
    }
}

