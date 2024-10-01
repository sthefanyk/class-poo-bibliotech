package com.github.sthefanyk.bibliotech.models;

public enum Tag {
    ARTIFICIAL_INTELLIGENCE("Inteligência Artificial"),
    MACHINE_LEARNING("Aprendizado de Máquina"),
    DATA_SCIENCE("Ciência de Dados"),
    SOFTWARE_DEVELOPMENT("Desenvolvimento de Software"),
    WEB_DEVELOPMENT("Desenvolvimento Web"),
    MOBILE_DEVELOPMENT("Desenvolvimento Mobile"),
    DATABASES("Bancos de Dados"),
    NETWORKING("Redes"),
    CYBERSECURITY("Cibersegurança"),
    CLOUD_COMPUTING("Computação em Nuvem"),
    DEVOPS("DevOps"),
    PROGRAMMING_LANGUAGES("Linguagens de Programação"),
    ALGORITHMS("Algoritmos"),
    DATA_STRUCTURES("Estruturas de Dados"),
    OPERATING_SYSTEMS("Sistemas Operacionais"),
    HUMAN_COMPUTER_INTERACTION("Interação Humano-Computador");

    private final String displayName;

    Tag(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static Tag fromString(String tag) {
        try {
            String enumName = tag.replace(" ", "_").toUpperCase();
            return Tag.valueOf(enumName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid tag: " + tag);
        }
    }
}
