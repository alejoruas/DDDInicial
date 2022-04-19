package tv.codely.shared.domain.student;

import tv.codely.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class StudentRegisteredDomainEvent extends DomainEvent {
    private final String name;
    private final String surName;
    private final String email;

    public StudentRegisteredDomainEvent() {
        super();
        name = null;
        surName = null;
        email = null;
    }

    public StudentRegisteredDomainEvent(String aggregateId, String name, String surName, String email) {
        super(aggregateId);
        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    public StudentRegisteredDomainEvent(String aggregateId, String eventId, String occurredOn, String name, String surName, String email) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
        this.surName = surName;
        this.email = email;
    }

    @Override
    public String eventName() {
        return "student.registered";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return null;
    }

    @Override
    public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }

    public String name() {
        return name;
    }

    public String surName() {
        return surName;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentRegisteredDomainEvent that = (StudentRegisteredDomainEvent) o;
        return Objects.equals(name, that.name) && Objects.equals(surName, that.surName) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, email);
    }
}
