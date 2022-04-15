package tv.codely.mooc.students.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public final class MysqlStudentRepository implements StudentRepository {
    private SessionFactory sessionFactory;

    public MysqlStudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void register(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public Optional<Student> searchById(StudentId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Student.class, id));
    }
}
