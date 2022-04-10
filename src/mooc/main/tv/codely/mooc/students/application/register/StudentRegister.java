package tv.codely.mooc.students.application.register;

import tv.codely.mooc.students.domain.*;
import tv.codely.shared.domain.Service;

@Service
public final class StudentRegister {
    private StudentRepository repository;

    public StudentRegister(StudentRepository repository) {
        this.repository = repository;
    }

    public void registerStudent(RegisterStudentRequest request) {
        StudentId studentId = new StudentId(request.id());
        StudentName studentName = new StudentName(request.name());
        StudentSurname studentSurname = new StudentSurname(request.surname());
        StudentEmail studentEmail = new StudentEmail(request.email());

        Student student = new Student(studentId, studentName, studentSurname, studentEmail);

        repository.register(student);
    }
}
