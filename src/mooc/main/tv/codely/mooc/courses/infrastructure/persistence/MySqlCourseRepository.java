package tv.codely.mooc.courses.infrastructure.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.domain.Service;

import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlCourseRepository implements CourseRepository {
    private SessionFactory sessionFactory;

    public MySqlCourseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    @Override
    public Optional<Course> search(String id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Course.class, id));
    }
}
