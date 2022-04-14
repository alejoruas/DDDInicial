package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.CoursesModuleUnitTestCase;
import tv.codely.mooc.courses.domain.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

final class CourseCreatorShould extends CoursesModuleUnitTestCase {

    @Test
    void save_a_valid_course() {
        CourseRepository repository = mock(CourseRepository.class);

        CourseCreator creator = new CourseCreator(repository);

        CreateCourseRequest request = new CreateCourseRequest("0e94458e-2bf7-43b8-884f-2f03d6494615", "some-name", "some-duration");

        Course course = CourseMother.fromRequest(request);

        creator.create(request);

        verify(repository, atLeastOnce()).save(course);
    }
}
