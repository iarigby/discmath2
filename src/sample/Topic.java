package sample;

import static sample.Subtopic.*;

/**
 * Created by ia on 2018. 06. 25..
 */
public enum Topic {
    GRAPHS(new Subtopic[]{BASIC_DEFINITIONS, TREES, SPECIAL_WALKS}),
    GROUPS(new Subtopic[]{DEFINITIONS, SUBGROUPS, CYCLIC_GROUPS, COSETS, NORMAL_SUBGROUPS}),
    CODING(new Subtopic[]{INTRO, SOURCE_CODING, OPTIMAL_CODES, ERROR_DETECTION_CORRECTION});

    private Subtopic[] subtopics;
    Topic(Subtopic[] subtopics) {
        this.subtopics = subtopics;
    }

    public Subtopic[] getSubtopics() {
        return subtopics;
    }
}
