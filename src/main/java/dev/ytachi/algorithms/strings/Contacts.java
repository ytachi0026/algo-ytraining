package dev.ytachi.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/contacts/problem
 *
 * @author ytachi
 */
public class Contacts {

    private Set<String> contacts;

    Contacts() {
        contacts = new HashSet<>();
    }

    public Set<String> getContacts() {
        return contacts;
    }

    public void setContacts(final Set<String> contacts) {
        this.contacts = contacts;
    }


    public static void main(String[] args) {
        final Contacts contacts = new Contacts();
        contacts.getContacts().add("hack");
        contacts.getContacts().add("hackerrank");

        // fint partial
        System.out.println(contacts.getContacts().stream()
                .filter((__) -> {
                    return __.startsWith("hack");
                })
                .count());

        System.out.println(contacts.getContacts().stream()
                .filter((__) -> {
                    return __.startsWith("hak");
                })
                .count());


    }
}
