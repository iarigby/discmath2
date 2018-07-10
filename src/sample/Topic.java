package sample;

import static sample.Subtopic.*;

/**
 * Created by ia on 2018. 06. 25..
 */
public enum Topic {
    GRAPHS(new Subtopic[]{BASIC_DEFINITIONS, ISOMORPHIC_GRAPHS, SUBGRAPHS, TREES, SPECIAL_WALKS}),
    GROUPS(new Subtopic[]{DEFINITIONS, SUBGROUPS, CYCLIC_GROUPS, COSETS, NORMAL_SUBGROUPS}),
    RINGS(new Subtopic[]{definitions_homomorphisms_character, SUBRINGS_IDEALS, UFDS, EUCLIDEAN_DOMAINS}),
    POLYNOMIALS(new Subtopic[]{DEFINITIONS, EUCLIDEAN_DIVISION, ROOTS_OF_POLYNOMIAL}),
    CODING(new Subtopic[]{INTRO, SOURCE_CODING, OPTIMAL_CODES, ERROR_DETECTION_CORRECTION, LINEAR_CODE});

    private Subtopic[] subtopics;
    Topic(Subtopic[] subtopics) {
        this.subtopics = subtopics;
    }

    public Subtopic[] getSubtopics() {
        return subtopics;
    }
}
