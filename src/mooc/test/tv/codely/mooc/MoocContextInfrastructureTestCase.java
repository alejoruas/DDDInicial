package tv.codely.mooc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import tv.codely.apps.mooc.backend.MoocBackendApplication;
import tv.codely.shared.infrastructure.InfrastructureTestCase;

/*SpringBootTest es para que se entienda que cuando se van a ejecutar los test se hará desde el container
El ContextConfiguration es para indicar donde cargar los servicios registrados
 */
@ContextConfiguration(classes = MoocBackendApplication.class)
@SpringBootTest
public abstract class MoocContextInfrastructureTestCase extends InfrastructureTestCase {
}
