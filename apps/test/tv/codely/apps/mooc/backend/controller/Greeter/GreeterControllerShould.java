package tv.codely.apps.mooc.backend.controller.Greeter;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;

import static org.junit.jupiter.api.Assertions.*;

final class GreeterControllerShould extends MoocApplicationTestCase {

    @Test
    void check_is_saludar_response_ok() throws Exception{
        assertResponse("/greeter?name=Alejo", 200, "{'response': 'Hola Alejo'}");
    }
}
