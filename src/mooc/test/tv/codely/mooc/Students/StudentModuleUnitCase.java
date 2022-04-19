package tv.codely.mooc.Students;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.EventBus;
import tv.codely.shared.infrastructure.UnitTestCase;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public abstract class StudentModuleUnitCase extends UnitTestCase {
    protected StudentRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = mock(StudentRepository.class);
        eventBus = mock(EventBus.class);
    }

    public void shouldHaveSave(Student student) {
        verify(repository, atLeastOnce()).register(student);
    }

    public void shouldHavePublished(List<DomainEvent> domainEventList) {
        verify(eventBus, atLeastOnce()).publish(domainEventList);
    }

    public void shouldHavePublished(DomainEvent domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }
}
