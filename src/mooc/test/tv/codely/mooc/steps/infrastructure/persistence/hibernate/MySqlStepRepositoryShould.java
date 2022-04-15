package tv.codely.mooc.steps.infrastructure.persistence.hibernate;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.steps.StepModuleInfraestructureTestCase;
import tv.codely.mooc.steps.domain.challenge.ChallengeStep;
import tv.codely.mooc.steps.domain.challenge.ChallengeStepMother;
import tv.codely.mooc.steps.domain.video.VideoStep;
import tv.codely.mooc.steps.domain.video.VideoStepMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class MySqlStepRepositoryShould extends StepModuleInfraestructureTestCase {

    @Test
    void save_a_video_step() {
        VideoStep step = VideoStepMother.random();
        repository.save(step);
    }

    @Test
    void save_a_challenge_step() {
        ChallengeStep step = ChallengeStepMother.random();
        repository.save(step);
    }

    @Test
    void return_an_existing_challenge_step() {
        ChallengeStep step = ChallengeStepMother.random();

        repository.save(step);

        assertEquals(Optional.of(step), repository.search(step.id()));
    }

    @Test
    void return_an_existing_video_step() {
        VideoStep step = VideoStepMother.random();
        repository.save(step);

        assertEquals(Optional.of(step), repository.search(step.id()));
    }
}
