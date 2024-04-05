package com.fullcycle.admin.catalogo.domain.category;

import com.fullcycle.admin.catalogo.domain.AggregrateRoot;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.time.Instant;

public class Category extends AggregrateRoot<CategoryID> {

    public Instant updatedAt;
    private String name;
    private String description;
    private Boolean active;
    private Instant createdAt;
    private Instant deletedAt;

    public Category(
            final CategoryID anId,
            final String aName,
            final String aDescription,
            final Boolean isActive,
            final Instant aCreationDate,
            final Instant aUpdateDate,
            final Instant aDeleteDate
    ) {
        super(anId);
        this.name=aName ;
        this.description=aDescription;
        this.active=isActive;
        this.createdAt=aCreationDate;
        this.updatedAt=aUpdateDate;
        this.deletedAt=aDeleteDate;
    }

    public static Category newCategory(final String aName, final String aDescription, final boolean isActive) {
        final var id = CategoryID.unique() ;
        final var now = Instant.now();
        final var deletedAt = isActive ? null : now;
        return new Category(id, aName, aDescription, isActive, now, now, deletedAt);
    }

    @Override
    public void validate( final ValidationHandler  handler) {
        new CategoryValidator (this, handler).validate ();
    }

    public Category activate() {
       this.deletedAt = null;
       this.active = true;
       this.updatedAt = Instant.now ();
       return this;
    }
    public Category deactivate() {
        if (getDeletedAt ( ) == null) {
            this.deletedAt = Instant.now ( );
        }

        this.active = false;
        this.updatedAt = Instant.now ();
        return this;
    }

    public Category update(
            final String aName,
            final String aDescription,
            final boolean isActive
    ) {
        if (isActive) {
            activate ( );
        } else {
            deactivate ();
        }
        this.name = aName;
        this.description = aDescription;
        this.updatedAt = Instant.now ();
        return this;
    }

    public CategoryID getId() {
        return id;
    }

    public String getName () {
        return name;
    }

    public String getDescription () {
        return description;
    }

    public Boolean getActive () {
        return active;
    }

    public Instant getCreatedAt () {
        return createdAt;
    }

    public Instant getUpdatedAt () {
        return updatedAt;
    }

    public Instant getDeletedAt () {
        return deletedAt;
    }

    @Override
    public
    boolean isActive () {
        return false;
    }
}



