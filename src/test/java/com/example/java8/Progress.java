package com.example.java8;

import java.time.Duration;
import java.util.Optional;

public class Progress {
    private Duration studyDuration;
    private boolean finished;
    public Optional<Duration> getStudyDuration() {
        // if (studyDuration == null) throw new IllegalStateException("studyDuration is null");
        return Optional.ofNullable(studyDuration);
    }
    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }
}
