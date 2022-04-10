package tv.codely.mooc.Students.application.register;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.application.register.RegisterStudentRequest;
import tv.codely.mooc.students.application.register.StudentRegister;
import tv.codely.mooc.students.domain.*;

import static org.mockito.Mockito.*;

final class StudentRegisterShould {
    @Test
    void register_a_valid_student() {
        StudentRepository repository = mock(StudentRepository.class);

        StudentRegister register = new StudentRegister(repository);

        RegisterStudentRequest request = new RegisterStudentRequest(
            "c97f842c-36a6-4378-a354-21ee05d98654", "Alejandro", "Rua", "alejoruasuarez@gmail.com");

        StudentId id = new StudentId(request.id());
        StudentName name = new StudentName(request.name());
        StudentSurname surname = new StudentSurname(request.surname());
        StudentEmail email = new StudentEmail(request.email());
        Student student = new Student(id, name, surname, email);

        register.registerStudent(request);

        verify(repository, atLeastOnce()).register(student);
    }
}
