package tv.codely.mooc.courses.domain;

import static org.junit.jupiter.api.Assertions.*;

public final class CourseNameMother {
    public static CourseName create(String value) {
        return new CourseName(value);
    }

    public static  CourseName random() {
        return create(tv.codely.shared.domain.WordMother.random());
    }
}
