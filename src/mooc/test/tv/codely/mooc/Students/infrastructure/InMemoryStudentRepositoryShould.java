package tv.codely.mooc.Students.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.Students.domain.StudentIdMother;
import tv.codely.mooc.Students.domain.StudentMother;
import tv.codely.mooc.students.domain.*;
import tv.codely.mooc.students.infrastructure.persistence.InMemoryStudentRepository;

import java.util.Optional;

final class InMemoryStudentRepositoryShould {
    @Test
    void register_a_valid_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        repository.register(StudentMother.random());
    }

    @Test
    void search_a_existing_student() throws Exception{
        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        Student student = StudentMother.random();
        repository.register(student);

        Assert.assertEquals(Optional.of(student), repository.searchById(student.id()));
    }

    @Test
    void not_find_a_non_existing_course() throws Exception{
        InMemoryStudentRepository repository = new InMemoryStudentRepository();

        Assert.assertFalse(repository.searchById(StudentIdMother.random()).isPresent());
    }
}
