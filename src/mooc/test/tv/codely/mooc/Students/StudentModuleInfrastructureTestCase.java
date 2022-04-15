package tv.codely.mooc.Students;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.students.domain.StudentRepository;

public class StudentModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    @Autowired
    protected StudentRepository repository;
}
