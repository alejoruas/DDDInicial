package tv.codely.mooc.Students.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.*;
import tv.codely.mooc.students.infrastructure.InMemoryStudentRepository;

import java.util.Optional;

final class InMemoryStudentRepositoryShould {
    @Test
    void register_a_valid_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        StudentId id = new StudentId("4C4C4544-0047-4A10-804A-B5C04F334732");
        StudentName name = new StudentName("Alejandro");
        StudentSurname surname = new StudentSurname("Rua");
        StudentEmail email = new StudentEmail("alejoruasuarez@gmail.com");
        repository.register(new Student(id, name, surname, email));
    }

    @Test
    void search_a_existing_student() throws Exception{
        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        StudentId id = new StudentId("4C4C4544-0047-4A10-804A-B5C04F334732");
        StudentName name = new StudentName("Alejandro");
        StudentSurname surname = new StudentSurname("Rua");
        StudentEmail email = new StudentEmail("alejoruasuarez@gmail.com");
        Student student = new Student(id, name, surname, email);
        repository.register(student);

        Assert.assertEquals(Optional.of(student), repository.searchById(student.id()));
    }

    @Test
    void not_find_a_non_existing_course() throws Exception{
        InMemoryStudentRepository repository = new InMemoryStudentRepository();

        Assert.assertFalse(repository.searchById(new StudentId("28a29608-2dc7-41bb-87ac-ca442314b2db")).isPresent());
    }
}
