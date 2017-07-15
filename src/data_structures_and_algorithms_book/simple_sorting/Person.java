package data_structures_and_algorithms_book.simple_sorting;

/**
 * Created by dmitriy on 08.07.17.
 */

public class Person {

    private String lastName;
    private String firstName;
    private int age;

    public Person(String last, String first, int age) {
        this.lastName = last;
        this.firstName = first;
        this.age = age;
    }


    public void displayPerson() {
        System.out.println(
                "lastName = " + lastName + "; " +
                "firstName = " + firstName + "; " +
                "age = " + age);
    }

    public String getLast() {
        return lastName;
    }
}



