package tv.codely.mooc.courses.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.domain.*;

import java.util.Optional;

final class InMemoryCourseRepositoryShould {

    @Test
    void save_a_valid_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = CourseMother.random();
        repository.save(course);
    }

    @Test
    void search_an_existing_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = CourseMother.random();
        repository.save(course);
        Assert.assertEquals(Optional.of(course), repository.search(course.id().value()));
    }

    @Test
    void not_find_a_non_existing_course() throws Exception {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Assert.assertFalse(repository.search("non-existing-id").isPresent());
    }
}
