package com.fullcycle.admin.catalogo.domain.validation.handler;

import com.fullcycle.admin.catalogo.domain.validation.Error;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class Notification implements ValidationHandler {

    private final List<Error> errors;

    private Notification ( final List<Error> errors ) {
        this.errors=errors;
    }

    public static Notification create () {
        return new Notification ( new ArrayList<> ( ) ) {

            @Override
            public List<Erros> getErros () {
                return null;
            }

            @Override
            public List<Error> getErrors () {
                return null;
            }
        };
    }

    public static Notification create ( final Throwable t ) {
        return create ( new Error ( t.getMessage ( ) ) );
    }

    public static Notification create ( final Error anError ) {
        return new Notification ( new ArrayList<> ( ) ) {
            @Override
            public List<Erros> getErros () {
                return null;
            }

            @Override
            public List<Error> getErrors () {
                return null;
            }

        }.append ( anError );
    }

    @Override
    public Notification append ( final Error anError ) {
        this.errors.add ( anError );
        return this;
    }

    @Override
    public Notification append ( final ValidationHandler anHandler ) {
        this.errors.addAll ( anHandler.getErrors ( ) );
        return this;
    }

    @Override
    public ValidationHandler validate ( Validation aValidation ) {
        return null;
    }

    public void isempty () {

    }
}