package tv.codely.mooc.Students.application.register;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.Students.StudentModuleUnitCase;
import tv.codely.mooc.Students.domain.StudentIdMother;
import tv.codely.mooc.Students.domain.StudentMother;
import tv.codely.mooc.Students.domain.StudentRegisteredDomainEventMother;
import tv.codely.mooc.students.application.register.RegisterStudentRequest;
import tv.codely.mooc.students.application.register.StudentRegister;
import tv.codely.mooc.students.domain.*;
import tv.codely.shared.domain.student.StudentRegisteredDomainEvent;

import static org.mockito.Mockito.*;

final class StudentRegisterShould extends StudentModuleUnitCase {
    StudentRegister register;

    @BeforeEach
    public void setUp() {
        super.setUp();
        register = new StudentRegister(repository, eventBus);
    }

    @Test
    void register_a_valid_student() {
        RegisterStudentRequest request = new RegisterStudentRequest(
            "c97f842c-36a6-4378-a354-21ee05d98654", "Alejandro", "Rua", "alejoruasuarez@gmail.com");

        Student student = StudentMother.fromRequest(request);

        StudentRegisteredDomainEvent studentRegisteredDomainEvent = StudentRegisteredDomainEventMother.fromStudent(student);

        register.registerStudent(request);

        shouldHaveSave(student);
        shouldHavePublished(studentRegisteredDomainEvent);
    }
}
