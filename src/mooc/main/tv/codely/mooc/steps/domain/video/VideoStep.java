package tv.codely.mooc.steps.domain.video;

import tv.codely.mooc.steps.domain.Step;
import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.StepTitle;
import tv.codely.shared.domain.VideoUrl;

import java.util.Objects;

public final class VideoStep extends Step {
    private VideoUrl videoUrl;
    private VideoStepText videoStepText;

    public VideoStep(StepId id, StepTitle tittle, VideoUrl videoUrl, VideoStepText videoStepText) {
        super(id, tittle);
        this.videoUrl = videoUrl;
        this.videoStepText = videoStepText;
    }

    private VideoStep() {
        super(null, null);
        this.videoUrl = null;
        this.videoStepText = null;
    }

    public VideoUrl videoUrl() {
        return videoUrl;
    }

    public VideoStepText videoStepText() {
        return videoStepText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VideoStep videoStep = (VideoStep) o;
        return Objects.equals(videoUrl, videoStep.videoUrl) && Objects.equals(videoStepText, videoStep.videoStepText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), videoUrl, videoStepText);
    }

    @Override
    public String toString() {
        return "VideoStep{" +
            "videoUrl=" + videoUrl +
            ", videoStepText=" + videoStepText +
            '}';
    }
}
