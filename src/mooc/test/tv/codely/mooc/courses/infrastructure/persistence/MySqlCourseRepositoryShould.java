package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.CourseModuleInfrastructureTestCase;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseIdMother;
import tv.codely.mooc.courses.domain.CourseMother;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
/*La anotación Transactional permite que todo lo que se ejecute en BD durante los Test se haga su respectivo Rollback*/
@Transactional
class MySqlCourseRepositoryShould extends CourseModuleInfrastructureTestCase {
    @Test
    void save_a_course() {
        Course course = CourseMother.random();
        mysqlCourseRepository.save(course);
    }

    @Test
    void return_an_existing_course() {
        Course course = CourseMother.random();
        mysqlCourseRepository.save(course);

        assertEquals(Optional.of(course), mysqlCourseRepository.search(course.id()));
    }

    @Test
    void not_return_a_non_existing_course() {
        assertFalse(mysqlCourseRepository.search(CourseIdMother.random()).isPresent());
    }

}
