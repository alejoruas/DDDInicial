package tv.codely.mooc.students.application.register;

import tv.codely.mooc.students.domain.*;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.EventBus;
import tv.codely.shared.domain.student.StudentRegisteredDomainEvent;

import java.util.Collections;

@Service
public final class StudentRegister {
    private StudentRepository repository;
    private EventBus eventBus;

    public StudentRegister(StudentRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void registerStudent(RegisterStudentRequest request) {
        StudentId studentId = new StudentId(request.id());
        StudentName studentName = new StudentName(request.name());
        StudentSurname studentSurname = new StudentSurname(request.surname());
        StudentEmail studentEmail = new StudentEmail(request.email());

        Student student = Student.create(studentId, studentName, studentSurname, studentEmail, repository, eventBus);
    }
}
