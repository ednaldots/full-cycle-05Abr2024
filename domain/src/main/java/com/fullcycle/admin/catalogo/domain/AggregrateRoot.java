package com.fullcycle.admin.catalogo.domain;

public abstract class AggregrateRoot <ID extends Identifier> extends Entity<ID>{

    protected AggregrateRoot (final ID id) {
        super(id);
    }



}
