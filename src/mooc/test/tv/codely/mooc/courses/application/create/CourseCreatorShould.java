package tv.codely.mooc.courses.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.CoursesModuleUnitTestCase;
import tv.codely.mooc.courses.domain.*;
import tv.codely.shared.domain.course.CourseCreatedDomainEvent;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

final class CourseCreatorShould extends CoursesModuleUnitTestCase {

    CourseCreator creator;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        creator = new CourseCreator(repository, eventBus);
    }

    @Test
    void save_a_valid_course() {
        CreateCourseRequest request = new CreateCourseRequest("0e94458e-2bf7-43b8-884f-2f03d6494615", "some-name", "some-duration");

        Course course = CourseMother.fromRequest(request);

        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.fromCourse(course);

        creator.create(request);

        shouldHaveSaved(course);
        shouldHavePublished(domainEvent);
    }
}
