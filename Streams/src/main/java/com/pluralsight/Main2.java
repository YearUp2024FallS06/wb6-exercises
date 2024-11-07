package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        // Find matches
        List<Person> matchingPeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(searchName) ||
                    person.getLastName().equalsIgnoreCase(searchName)) {
                matchingPeople.add(person);
            }
        }

        // Display matches
        if (matchingPeople.isEmpty()) {
            System.out.println("No matches found for the name: " + searchName);
        } else {
            System.out.println("Matching people:");
            for (Person person : matchingPeople) {
                System.out.println(person);
            }
        }

        // Step 3: Calculate and display average age, oldest and youngest person
        if (!people.isEmpty()) {
            int totalAge = 0;
            int oldestAge = people.get(0).getAge();
            int youngestAge = people.get(0).getAge();

            for (Person person : people) {
                int age = person.getAge();
                totalAge += age;

                if (age > oldestAge) {
                    oldestAge = age;
                }
                if (age < youngestAge) {
                    youngestAge = age;
                }
            }

            double averageAge = (double) totalAge / people.size();
            System.out.printf("Average Age: %.2f%n", averageAge);
            System.out.println("Oldest Age: " + oldestAge);
            System.out.println("Youngest Age: " + youngestAge);
        }

    }
}
