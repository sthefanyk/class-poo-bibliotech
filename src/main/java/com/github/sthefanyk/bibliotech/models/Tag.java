package com.github.sthefanyk.bibliotech.models;

public enum Tag {
    ARTIFICIAL_INTELLIGENCE,
    MACHINE_LEARNING,
    DATA_SCIENCE,
    SOFTWARE_DEVELOPMENT,
    WEB_DEVELOPMENT,
    MOBILE_DEVELOPMENT,
    DATABASES,
    NETWORKING,
    CYBERSECURITY,
    CLOUD_COMPUTING,
    DEVOPS,
    PROGRAMMING_LANGUAGES,
    ALGORITHMS,
    DATA_STRUCTURES,
    OPERATING_SYSTEMS,
    HUMAN_COMPUTER_INTERACTION;

    public static Tag fromString(String tag) {
        try {
            String enumName = tag.replace(" ", "_").toUpperCase();
            return Tag.valueOf(enumName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid tag: " + tag);
        }
    }
}
