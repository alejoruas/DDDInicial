package tv.codely.mooc.Students.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.Students.StudentModuleInfrastructureTestCase;
import tv.codely.mooc.Students.domain.StudentMother;
import tv.codely.mooc.students.domain.Student;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

final class MysqlStudentRepositoryShould extends StudentModuleInfrastructureTestCase {

    @Test
    void save_a_student() {
        Student student = StudentMother.random();
        repository.register(student);
    }

    @Test
    void return_an_existing_student() {
        Student student = StudentMother.random();
        repository.register(student);

        assertEquals(Optional.of(student), repository.searchById(student.id()));
    }

    @Test
    void return_a_non_existing_student() {
        assertFalse(repository.searchById(StudentMother.random().id()).isPresent());
    }
}
