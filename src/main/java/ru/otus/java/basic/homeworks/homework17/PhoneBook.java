package ru.otus.java.basic.homeworks.homework17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<Integer>> phones = new HashMap<>();

    public void add(String name, Integer phoneNumber) throws IllegalArgumentException {
        if (phoneNumber == null || name == null) {
            throw new IllegalArgumentException("Fields name and phoneNumber must not be empty");
        }
        if (phones.containsKey(name)) {
            phones.get(name).add(phoneNumber);
        } else {
            Set<Integer> phones = new HashSet<>();
            phones.add(phoneNumber);
            this.phones.putIfAbsent(name, phones);
        }

    }

    public Set<Integer> find(String name) throws IllegalArgumentException {

        if (name == null) {
            throw new IllegalArgumentException("Argument \"name\" must not be null");
        }
        return phones.get(name);
    }

    public boolean containsPhoneNumber(Integer phoneNumber) {
        if (phoneNumber == null) {
            throw new IllegalArgumentException("");
        }
        for (Map.Entry<String, Set<Integer>> element:phones.entrySet()){
            for(Integer number: element.getValue()){
                if(number.equals(phoneNumber)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phones=" + phones +
                '}';
    }
}
