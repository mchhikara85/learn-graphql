package com.example.learngraphql.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Rating {
    FIVE_STAR("Five Stars"),
    FOUR_STAR("Four Stars"),
    THREE_STAR("Three Stars"),
    TWO_STAR("Two Stars"),
    ONE_STAR("One Star");

    private String star;

    Rating(String star) {
        this.star = star;
    }

    @JsonValue
    public String getStar() {
        return star;
    }
}
