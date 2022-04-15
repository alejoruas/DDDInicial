package tv.codely.mooc.steps.domain;

import tv.codely.shared.domain.Identifier;

public final class StepId  extends Identifier {
    public StepId(String id) {
        super(id);
    }

    private StepId() {
        super(null);
    }
}
