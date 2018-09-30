package engine;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerEngineTest {
    @Test
    public void should_throw_exception_on_inconsistent_input_data() {
        //Given
        MowerEngine engine = new MowerEngine();
        try {
            //When
            engine.start("eeeeeeeee");
        } catch (RuntimeException ex) {
            //Then
            assertThat(ex).isInstanceOf(InvalidInputDataException.class);
            assertThat(ex.getMessage()).isEqualTo("Inconsistent input data.");
        }

    }

    @Test
    public void should_throw_exception_input_data_is_null() {
        //Given
        MowerEngine engine = new MowerEngine();
        try {
            //When
            engine.start(null);
        } catch (RuntimeException ex) {
            //Then
            assertThat(ex).isInstanceOf(InvalidInputDataException.class);
            assertThat(ex.getMessage()).isEqualTo("Inconsistent input data.");
        }

    }

    @Test
    public void should_work_perfectly() {
        //Given
        MowerEngine engine = new MowerEngine();
        //When
        String logs = engine.start("5 5\n" +
                "1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA");
        //Then
        assertThat(logs).isEqualTo("1 3 N\n" +
                "5 1 E");
    }
}