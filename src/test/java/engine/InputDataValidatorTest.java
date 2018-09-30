package engine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputDataValidatorTest {

    @Test
    public void should_throw_exception_when_predicate_fail() {
        //Given
        InputDataValidator validator = new InputDataValidator();
        //When
        String position = "1 2 N";
        try {
            validator.validate(position, data -> data.matches("//d //d"), "The given data does not match the position pattern");
        } catch (RuntimeException ex) {
            //Then
            assertThat(ex).isInstanceOf(InvalidInputDataException.class);
            assertThat(ex.getMessage()).isEqualTo("The given data does not match the position pattern");
        }

    }
    @Test
    public void should_throw_exception_when_value_null() {
        //Given
        InputDataValidator validator = new InputDataValidator();
        //When
        String position = null;
        try {
            validator.validate(position, data -> data.matches("//d //d"), "The given data does not match the position pattern");
        } catch (RuntimeException ex) {
            //Then
            assertThat(ex).isInstanceOf(InvalidInputDataException.class);
            assertThat(ex.getMessage()).isEqualTo("The given data does not match the position pattern");
        }

    }
}