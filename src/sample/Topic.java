package sample;

import static sample.Subtopic.*;

/**
 * Created by ia on 2018. 06. 25..
 */
public enum Topic {
    CODING(new Subtopic[]{INTRO, SOURCE_CODING});

    private Subtopic[] subtopics;
    Topic(Subtopic[] subtopics) {
        this.subtopics = subtopics;
    }

    public Subtopic[] getSubtopics() {
        return subtopics;
    }
}
