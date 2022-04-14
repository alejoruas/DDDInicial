package tv.codely.mooc.Students.domain;

import tv.codely.mooc.students.domain.StudentName;
import tv.codely.mooc.students.domain.StudentSurname;

public final class StudentSurnameMother {
    public static StudentSurname create(String value) {
        return new StudentSurname(value);
    }

    public static  StudentSurname random() {
        return create(tv.codely.shared.domain.WordMother.random());
    }
}
