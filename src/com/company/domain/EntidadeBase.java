package com.company.domain;

import java.util.Objects;

public abstract class EntidadeBase {

    private static int geradorId = 0;
    private Integer id;

    public EntidadeBase() {
        this.id = geradorId++;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadeBase entidadeBase = (EntidadeBase) o;
        return Objects.equals(id, entidadeBase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
