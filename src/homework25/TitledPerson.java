package homework25;

public class TitledPerson extends Person {
    private String title;

    public TitledPerson(Person person, String title) {
        super(person.firstName, person.lastName);
        this.title = title;
    }

    @Override
    public void printMe() {
        System.out.println(title + " " + super.firstName + " " + super.lastName);
    }
}

