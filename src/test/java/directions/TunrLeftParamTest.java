package directions;

import model.Mower;
import model.Position;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static model.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class TunrLeftParamTest extends TurnCommandParamTest {

    @Parameterized.Parameters
    public static List<ExpectedOrientationForGiven> params() {
        return Arrays.asList(
                new ExpectedOrientationForGiven(N, W, 0, 3),
                new ExpectedOrientationForGiven(W, S, 3, 2),
                new ExpectedOrientationForGiven(S, E, 2, 1),
                new ExpectedOrientationForGiven(E, N, 1, 0)
        );
    }

    private ExpectedOrientationForGiven expectedOrientationForGiven;

    public TunrLeftParamTest(ExpectedOrientationForGiven expectedOrientationForGiven) {
        this.expectedOrientationForGiven = expectedOrientationForGiven;
    }

    @Test
    public void should_return_decremented_orientation_for_given_one() {
        //Given
        TunrLeft turnLeftDirection = new TunrLeft();
        Mower mower = new Mower(mock(Position.class), expectedOrientationForGiven.getGivenOrientation(), mock(Position.class));
        //When
        turnLeftDirection.move(mower);
        //Then
        assertThat(mower.getOrientation()).isEqualTo(expectedOrientationForGiven.getExpectedOrientation());
    }

    @Test
    public void should_next_index_be_equal_to_current_index_minus_one() {
        //Given
        TunrLeft turnLeftDirection = new TunrLeft();
        //When
        int nextIndex = turnLeftDirection.getNextIndex(expectedOrientationForGiven.getGivenOrientation());
        //Then
        assertThat(nextIndex).isEqualTo(expectedOrientationForGiven.getExpectedIndex());
    }

    @Test
    public void should_return_decremented_index_for_given_one() {
        //Given
        TunrLeft turnLeftDirection = new TunrLeft();
        //When
        int expectedResult = turnLeftDirection.decrement(expectedOrientationForGiven.getGivenIndex());
        //Then
        assertThat(expectedResult).isEqualTo(expectedOrientationForGiven.getExpectedIndex());
    }
}
