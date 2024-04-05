package com.fullcycle.admin.catalogo.domain.validation;

import com.fullcycle.admin.catalogo.domain.validation.handler.Erros;

import java.util.List;

public interface ValidationHandler {

    ValidationHandler append(Error anError);
    ValidationHandler append(ValidationHandler  anHandler);

    ValidationHandler validate(Validation  aValidation);

    List<Erros> getErros();

    default boolean hasError( ) {
        return getErrors () != null && !(getErrors ().isEmpty ());
    }

    List<Error> getErrors ();

    public interface Validation{
       void validate();

    }
}
