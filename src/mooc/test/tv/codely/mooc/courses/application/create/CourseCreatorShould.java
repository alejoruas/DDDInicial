package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

final class CourseCreatorShould {

    @Test
    void save_a_valid_course() {
        CourseRepository repository = mock(CourseRepository.class);

        CourseCreator creator = new CourseCreator(repository);

        CreateCourseRequest request = new CreateCourseRequest("some-id", "some-name", "some-duration");
        Course course = new Course(request.id(),request.name(), request.duration());

        creator.create(request);

        verify(repository, atLeastOnce()).save(course);
    }
}
