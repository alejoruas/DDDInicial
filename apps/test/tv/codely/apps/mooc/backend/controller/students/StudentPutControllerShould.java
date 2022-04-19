package tv.codely.apps.mooc.backend.controller.students;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;
import tv.codely.shared.domain.UuidMother;

final class StudentPutControllerShould extends MoocApplicationTestCase {
    @Test
    void register_a_valida_non_existing_student() throws Exception{
        assertRequestWithBody("PUT", "/register-student/" + UuidMother.random(),
            "{\"name\":\"Alejandro\", \"surname\":\"Rua\", \"email\":\"alejoruasuarez@gmail.com\"}", 201);
    }
}
