package tv.codely.mooc.Students.domain;

import tv.codely.mooc.students.domain.*;
import tv.codely.shared.domain.student.StudentRegisteredDomainEvent;

public final class StudentRegisteredDomainEventMother {
    public static StudentRegisteredDomainEvent create(StudentId id, StudentName name, StudentSurname surname, StudentEmail email) {
        return new StudentRegisteredDomainEvent(id.value(), name.value(), surname.value(), email.toString());
    }

    public static StudentRegisteredDomainEvent fromStudent(Student student) {
        return new StudentRegisteredDomainEvent(student.id().value(), student.name().value(), student.surname().value(), student.email().toString());
    }

    public static StudentRegisteredDomainEvent random() {
        return create(StudentIdMother.random(), StudentNameMother.random(), StudentSurnameMother.random(), StudentEmailMother.random());
    }
}
