package sample;

/**
 * Created by ia on 2018. 06. 25..
 */
public enum Subtopic {
    //graphs
    BASIC_DEFINITIONS("Basic Definitions"),
    TREES("Trees"),
    SPECIAL_WALKS("Special Walks"),

    //groups
    DEFINITIONS("Definitions"),
    SUBGROUPS("Subgroups, generated subgroups"),
    CYCLYC_GROUPS("Cyclic Groups"),
    COSETS("Cosets"),
    NORMAL_SUBGROUPS("Normal subgroups"),

    //coding
    INTRO("Introduction to Information Theory"),
    SOURCE_CODING("Source Coding");

    private String name;

    Subtopic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
