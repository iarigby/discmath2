package sample;

public enum Subtopic {
    //graphs
    GRAPHS_DEFINITIONS("Basic Definitions"),
    ISOMORPHIC_GRAPHS("Isomorphic graphs"),
    SUBGRAPHS("Subgraphs"),
    TREES("Trees"),
    SPECIAL_WALKS("Special Walks"),
    PLANAR_GRAPHS("Planar Graphs"),

    //digraphs
    DIGRAPHS_DEFINITIONS("Basic Definitions"),
    GRAPH_REPRESENTATIONS("Representations of graphs"),
    DIRECTED_SUBGRAPHS("Directed Subgraphs"),
    DIRECTED_TREES("Directed Trees"),


    //polynomials
    //definitions
    POLYNOMIALS_DEFINITIONS("Basic Definitions"),
    EUCLIDEAN_DIVISION("Euclidean Division"),
    ROOTS_OF_POLYNOMIAL("Roots of polynomial"),

    //groups
    DEFINITIONS("Definitions"),
    SUBGROUPS("Subgroups, generated subgroups"),
    CYCLIC_GROUPS("Cyclic Groups"),
    COSETS("Cosets"),
    NORMAL_SUBGROUPS("Normal subgroups"),

    //Rings
    definitions_homomorphisms_character("definitions, homomorphisms, character"),
    SUBRINGS_IDEALS("Subrings and Ideals"),
    UFDS("UFDs"),
    EUCLIDEAN_DOMAINS("Euclidean Domains"),

    //coding
    INTRO("Introduction to Information Theory"),
    SOURCE_CODING("Source Coding"),
    OPTIMAL_CODES("Optimal codes"),
    ERROR_DETECTION_CORRECTION("Error Detection/Correction"),
    LINEAR_CODE("Linear Code")
    ;

    private String name;

    Subtopic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
