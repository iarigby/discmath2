package sample;

import static sample.Subtopic.*;

public enum Topic {
    GRAPHS(new Subtopic[]{GRAPHS_DEFINITIONS, ISOMORPHIC_GRAPHS, SUBGRAPHS, TREES, SPECIAL_WALKS, PLANAR_GRAPHS}),
    DIGRAPHS(new Subtopic[]{DIGRAPHS_DEFINITIONS, DIRECTED_SUBGRAPHS, DIRECTED_TREES, GRAPH_REPRESENTATIONS}),
    GROUPS(new Subtopic[]{DEFINITIONS, SUBGROUPS, CYCLIC_GROUPS, COSETS, NORMAL_SUBGROUPS}),
    RINGS(new Subtopic[]{definitions_homomorphisms_character, SUBRINGS_IDEALS, UFDS, EUCLIDEAN_DOMAINS}),
    POLYNOMIALS(new Subtopic[]{POLYNOMIALS_DEFINITIONS, EUCLIDEAN_DIVISION, ROOTS_OF_POLYNOMIAL}),
    CODING(new Subtopic[]{INTRO, SOURCE_CODING, OPTIMAL_CODES, ERROR_DETECTION_CORRECTION, LINEAR_CODE});

    private Subtopic[] subtopics;
    Topic(Subtopic[] subtopics) {
        this.subtopics = subtopics;
    }

    public Subtopic[] getSubtopics() {
        return subtopics;
    }
}
