package tv.codely.mooc.Students.domain;

import tv.codely.mooc.students.domain.StudentEmail;

public final class StudentEmailMother {
    public static StudentEmail create(String value) { return new StudentEmail(value); }

    public static StudentEmail random() {
        String name = tv.codely.shared.domain.WordMother.random();
        String domain = tv.codely.shared.domain.WordMother.random();
        return new StudentEmail(name + "@" + domain + ".com");
    }
}
