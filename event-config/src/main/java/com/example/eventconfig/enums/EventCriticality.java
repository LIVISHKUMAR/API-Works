package com.example.eventconfig.enums;

public enum EventCriticality {
    CRITICAL("CRITICAL", 1),
    HIGH("HIGH", 2),
    MEDIUM("MEDIUM", 3),
    LOW("LOW", 4),
    WARNING("WARNING", 5);

    private final String name;
    private final int priority;

    EventCriticality(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public static EventCriticality findByCriticality(String abbr) {
        for (EventCriticality v : values()) {
            if (v.name().equals(abbr)) {
                return v;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
