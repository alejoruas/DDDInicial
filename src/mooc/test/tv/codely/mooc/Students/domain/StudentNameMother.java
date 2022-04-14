package tv.codely.mooc.Students.domain;

import tv.codely.mooc.courses.domain.CourseName;
import tv.codely.mooc.students.domain.StudentName;
import tv.codely.shared.domain.StringValueObject;

public class StudentNameMother {
    public static StudentName create(String value) {
        return new StudentName(value);
    }

    public static  StudentName random() {
        return create(tv.codely.shared.domain.WordMother.random());
    }
}
