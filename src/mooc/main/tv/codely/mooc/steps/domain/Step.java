package tv.codely.mooc.steps.domain;

import java.util.Objects;

public abstract class Step {
    private StepId id;
    private StepTitle title;

    public Step(StepId id, StepTitle tittle) {
        this.id = id;
        this.title = tittle;
    }

    public StepId id() {
        return id;
    }

    public StepTitle title() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return Objects.equals(id, step.id) && Objects.equals(title, step.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Step{" +
            "id=" + id +
            ", title=" + title +
            '}';
    }
}
