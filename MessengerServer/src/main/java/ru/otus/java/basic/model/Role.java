package ru.otus.java.basic.model;

import java.util.HashMap;
import java.util.Map;

public enum Role {
    ADMIN("admin"),
    USER("user");

    private final String roleName;
    private static final Map<String, Role> map;

    static {
        map = new HashMap<>();
        for (Role value : Role.values()) {
            map.put(value.getRoleName(), value);
        }
    }

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public static Role enumForValue(String value) {
        return map.get(value);
    }
}
