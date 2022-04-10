package tv.codely.mooc.courses.infrastructure;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;

import javax.persistence.criteria.CriteriaBuilder;

import static org.junit.jupiter.api.Assertions.*;

final class InMemoryCourseRepositoryTest {

    @Test
    void save_a_valid_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        repository.save(new Course("some-id", "some-name", "some-duration"));
    }

    @Test
    void search_an_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = new Course("some-id", "some-name", "some-duration");
        repository.save(course);
    }
}
