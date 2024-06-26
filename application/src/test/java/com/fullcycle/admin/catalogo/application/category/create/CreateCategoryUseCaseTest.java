package com.fullcycle.admin.catalogo.application.category.create;

import com.fullcycle.admin.catalogo.domain.category.CategoryGateway;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.Assertions;
import org.mockito.Mockito;

import java.util.Objects;

import static junit.runner.Version.id;
import static org.mockito.AdditionalAnswers.returnsFirstArg;


@CreateCategoryUseCaseTest
public @interface CreateCategoryUseCaseTest {


    public
    class CreateCategoryUseCaseTest {
        private Object gateway;
        private TestCase assertions;

        //1. Teste do caminho feliz
        //2. Teste passando uma propriedade inválida (name)
        //3. Teste criando uma categoria inativa//
        //4. Teste simulando um erro genérico vindo do gateway


        @Test
        public void givenAValidCommand_whenCallsCreateCategory_shouldReturnCategoryId( ) {
            givenAValidCommand_whenCallsCreateCategory_shouldReturnCategoryId ( null );
        }

        @Test
        public void givenAValidCommand_whenCallsCreateCategory_shouldReturnCategoryId( TestCase Assertions ) {
            assertions = Assertions;

            final var expectedName = "Filme";
            final var expectedDescription = "A categoria mais assistida";
            final var expectedIsActive = true;

            final var aCommand = CreateCategoryCommand.with(expectedName, expectedDescription, expectedIsActive);

            final CategoryGateway categoryGateway = Mockito.mock(CategoryGateway.class);
            Mockito.when(categoryGateway.create(Mockito.any()))
            .thenAnswer(returnsFirstArg());

            final var useCase = new CreateCategoryUseCase ( categoryGateway ) {
                @Override
                public
                CreateCategoryOutput execute ( CreateCategoryCommand anIn ) {
                    return null;
                }

                @Override
                public
                CreateCategoryOutput excute ( CreateCategoryCommand anIn ) {
                    return null;
                }
            };

            final var actualOutput = useCase.excute(aCommand);


            TestCase.assertNotNull (actualOutput);
            Assertions.assertNotNull(actualOutput.id ()actualOutput.id ( ) );

            Mockito.verify(categoryGateway, Mockito.times(1))
                    .create(Mockito.argThat (aCategory -> {
                     return Objects.equals(expectedName, aCategory.getName())
                            && Objects.equals(expectedDescription, aCategory.getDescription())
                            && Objects.equals(expectedIsActive, aCategory.isActive())
                            && Objects.nonNull(aCategory.getId())
                            && Objects.nonNull(aCategory.getCreatedAt())
                            && Objects.nonNull(aCategory.getUpdatedAt())
                            && Objects.isNull(aCategory.getDeletedAt ());
                    }
             ));
        }

    }

}
