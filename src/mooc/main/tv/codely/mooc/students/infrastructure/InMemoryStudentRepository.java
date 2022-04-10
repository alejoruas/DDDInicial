package tv.codely.mooc.students.infrastructure;

import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public final class InMemoryStudentRepository implements StudentRepository {
    private HashMap<String, Student> map = new HashMap<>();
    @Override
    public void register(Student student) {
        map.put(student.id().value(), student);
    }

    @Override
    public Optional<Student> searchById(StudentId id) {
        return Optional.ofNullable(map.get(id.value()));
    }
}
