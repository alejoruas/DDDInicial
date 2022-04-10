package tv.codely.apps.mooc.backend.controller.students;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;

final class StudentPutControllerShould extends MoocApplicationTestCase {
    @Test
    void register_a_valida_non_existing_student() throws Exception{
        assertRequestWithBody("PUT", "/register-student/c97f842c-36a6-4378-a354-21ee05d98654",
            "{\"name\":\"Alejandro\", \"surname\":\"Rua\", \"email\":\"alejoruasuarez@gmail.com\"}", 201);
    }
}
