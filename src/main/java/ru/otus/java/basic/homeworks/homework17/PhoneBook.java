package ru.otus.java.basic.homeworks.homework17;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<Integer, String> phones = new HashMap<>();

    public void add(String name, Integer phoneNumber) throws IllegalArgumentException {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("Fields name and phoneNumber must not be empty");
        }
        this.phones.putIfAbsent(phoneNumber, name);
    }

    public Map<Integer, String> find(String name) throws IllegalArgumentException {

        if (name == null) {
            throw new IllegalArgumentException("Argument \"name\" must not be null");
        }
        Map<Integer, String> foundPhones = new HashMap<>();
        for (Map.Entry<Integer, String> phone : phones.entrySet()) {
            if (phone.getValue().equals(name)) {
                foundPhones.put(phone.getKey(), phone.getValue());
            }
        }
        return foundPhones;
    }

    public boolean containsPhoneNumber(Integer phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("");
        }
        return this.phones.containsKey(phoneNumber);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phones=" + phones +
                '}';
    }
}
