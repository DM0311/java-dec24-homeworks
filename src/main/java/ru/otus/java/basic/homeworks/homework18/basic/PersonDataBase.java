package ru.otus.java.basic.homeworks.homework18.basic;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, Person> personMap = new HashMap<>();

    public Person findById(Long id) throws RuntimeException {
        if (personMap.containsKey(id)) {
            return personMap.get(id);
        }
        throw new RuntimeException("В базе нет такого сотрудника");
    }

    public void add(Person person) {
        personMap.put(person.getId(), person);
    }

    public boolean isManager(Person person) throws RuntimeException {
        if (!personMap.containsKey(person.getId())) {
            throw new RuntimeException("В базе нет такого сотрудника");
        }
        Position currentPosition = person.getPosition();
        if (currentPosition == Position.MANAGER || currentPosition == Position.DIRECTOR
                || currentPosition == Position.BRANCH_DIRECTOR || currentPosition == Position.SENIOR_MANAGER) {
            return true;
        }
        return false;
    }

    public boolean isEmployee(Long id) {
        if (!personMap.containsKey(id)) {
            throw new RuntimeException("В базе нет такого сотрудника");
        }
        return !isManager(personMap.get(id));
    }
}
