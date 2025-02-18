package homework25;

public class Person {
    String firstName;
    String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void printMe() {
        System.out.println(firstName + " " + lastName);
    }
}

