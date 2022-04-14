package tv.codely.apps.mooc.backend.controller.courses;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;

import java.util.UUID;

public final class CoursePutControllerShould extends MoocApplicationTestCase {
    @Test
    void create_a_valid_non_existing_course() throws Exception {
        assertRequestWithBody("PUT", "/courses/" + UUID.randomUUID().toString(),
            "{\"name\": \"The best course\", \"duration\":\"5 hours\"}", 201);
    }
}
