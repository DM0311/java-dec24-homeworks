package ru.otus.java.basic.homeworks.homework18.basic;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private Map<Long, Person> personMap;
    private final EnumSet<Position> managers;

    public PersonDataBase() {
        this.personMap = new HashMap<>();
        this.managers = EnumSet.of(Position.MANAGER,
                Position.DIRECTOR,
                Position.BRANCH_DIRECTOR,
                Position.SENIOR_MANAGER);
    }

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
        return managers.contains(person.getPosition());
    }

    public boolean isEmployee(Long id) {
        if (!personMap.containsKey(id)) {
            throw new RuntimeException("В базе нет такого сотрудника");
        }
        return !isManager(personMap.get(id));
    }
}
