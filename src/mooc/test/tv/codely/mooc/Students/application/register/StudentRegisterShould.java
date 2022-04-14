package tv.codely.mooc.Students.application.register;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.Students.domain.StudentIdMother;
import tv.codely.mooc.Students.domain.StudentMother;
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

        Student student = StudentMother.fromRequest(request);

        register.registerStudent(request);

        verify(repository, atLeastOnce()).register(student);
    }
}
