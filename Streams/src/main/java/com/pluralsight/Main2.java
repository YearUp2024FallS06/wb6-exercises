package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {

        // Step 1: Create a list of people
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Smith", 28));
        people.add(new Person("Jane", "Doe", 34));
        people.add(new Person("John", "Doe", 38));
        people.add(new Person("Alice", "Johnson", 19));
        people.add(new Person("Peter", "Johnson", 17));
        people.add(new Person("Michael", "Brown", 45));
        people.add(new Person("Emily", "Davis", 23));
        people.add(new Person("Daniel", "Martinez", 30));
        people.add(new Person("Sophia", "Garcia", 40));
        people.add(new Person("Lucas", "Miller", 21));
        people.add(new Person("Olivia", "Wilson", 32));
        people.add(new Person("Liam", "Taylor", 29));

        // Step 2: Prompt the user for a name to search
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a first or last name to search: ");
        String searchName = scanner.nextLine();

        List<Person> matchingPeople = people.stream()
                .filter( person ->  person.getFirstName().equalsIgnoreCase(searchName) ||
                                    person.getLastName().equalsIgnoreCase(searchName))
                .collect(Collectors.toList());


        // Display matches
        if (matchingPeople.isEmpty()) {
            System.out.println("No matches found for the name: " + searchName);
        } else {
            System.out.println("Matching people:");
            matchingPeople.forEach( person -> System.out.println(person));
        }

        // Step 3: Calculate and display average age, oldest and youngest person
        if (!people.isEmpty()) {

            int totalAge = people.stream()
                    .map( person -> person.getAge())
                    .reduce(0, (previousOutput, age) -> previousOutput + age );

            long count = people.stream().count();

            double averageAge = (double) totalAge / count;

            int oldestAge = people.stream()
                    .map( person -> person.getAge())
                    .reduce(0, (previousResult, age) -> ( previousResult < age) ? previousResult : age );

            int youngestAge = people.get(0).getAge();




            System.out.printf("Average Age: %.2f%n", averageAge);
            System.out.println("Oldest Age: " + oldestAge);
            System.out.println("Youngest Age: " + youngestAge);
        }

    }
}
