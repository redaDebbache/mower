package engine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MowerEngineTest {

    @InjectMocks
    private MowerEngine engine;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private InputDataValidator validator;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private MowerBuilder builder;
    
    @Test
    public void should_throw_exception_on_inconsistent_input_data() {
        //Given engine property
       
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
        //Given engine property engine property
       
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
        //Given engine property
       
        //When
        String logs = engine.start("5 5\n" +
                "1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA");
        //Then
        verify(validator).validate(anyString(), any(Predicate.class), anyString());
        verify(builder).buildMowers(anyString());
        assertThat(logs).isEqualTo("1 3 N\n" +
                "5 1 E");
    }
}