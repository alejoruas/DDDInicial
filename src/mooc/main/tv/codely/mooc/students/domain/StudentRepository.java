package tv.codely.mooc.students.domain;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    public void register(Student student);
    public Optional<Student> searchById(StudentId id);
}
