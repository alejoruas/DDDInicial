package tv.codely.mooc.courses.domain;

import tv.codely.shared.domain.bus.event.EventBus;
import tv.codely.shared.domain.course.CourseCreatedDomainEvent;

import java.util.Collections;
import java.util.Objects;

public final class Course {
    private final CourseId id;
    private final CourseName name;
    private final CourseDuration duration;

    private Course() {
        this.id = null;
        this.name = null;
        this.duration = null;
    }

    public Course (CourseId id, CourseName name, CourseDuration duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public static Course create(CourseId id, CourseName name, CourseDuration duration, CourseRepository repository, EventBus eventBus) {
        Course course = new Course(id, name, duration);

        repository.save(course);
        eventBus.publish(Collections.singletonList(new CourseCreatedDomainEvent(
            id.value(),
            name.value(),
            duration.value()))
        );

        return course;
    }

    public CourseId id() {
        return id;
    }

    public CourseName name() {
        return name;
    }

    public CourseDuration duration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
            Objects.equals(name, course.name) &&
            Objects.equals(duration, course.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
