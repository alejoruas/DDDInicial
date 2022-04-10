package tv.codely.apps.mooc.backend.controller.courses;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;

public final class CoursePutControllerShould extends MoocApplicationTestCase {
    @Test
    void create_a_valid_non_existing_course() throws Exception {
        assertRequestWithBody("PUT", "/courses/4C4C4544-0047-4A10-804A-B5C04F334732",
            "{\"name\": \"The best course\", \"duration\":\"5 hours\"}", 201);
    }
}
