package tv.codely.mooc.Students.domain;

import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.shared.domain.UuidMother;

public final class StudentIdMother {
    public static StudentId create(String value) {
        return new StudentId(value);
    }

    public static StudentId random() {
        return create(UuidMother.random());
    }

}
