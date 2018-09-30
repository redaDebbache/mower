package directions;

import model.Mower;
import model.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static model.Orientation.*;
import static directions.TurnCommandParamTest.ExpectedOrientationForGiven;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class TurnRightParamTest {

    @Parameterized.Parameters
    public static List<ExpectedOrientationForGiven> params() {
        return Arrays.asList(
                new ExpectedOrientationForGiven(N, E, 0, 1),
                new ExpectedOrientationForGiven(E, S, 1, 2),
                new ExpectedOrientationForGiven(S, W, 2, 3),
                new ExpectedOrientationForGiven(W, N, 3, 0)
        );
    }

    private ExpectedOrientationForGiven expectedOrientationForGiven;

    public TurnRightParamTest(ExpectedOrientationForGiven expectedOrientationForGiven) {
        this.expectedOrientationForGiven = expectedOrientationForGiven;
    }

    @Test
    public void should_safely_increment_index() {
        //Given
        TurnRight turnRight = new TurnRight();
        //When
        int resultedIndex = turnRight.increment(expectedOrientationForGiven.getGivenIndex());
        //Then
        assertThat(resultedIndex).isEqualTo(expectedOrientationForGiven.getExpectedIndex());
    }

    @Test
    public void should_return_east_when_current_orientation_is_north() {
        //Given
        TurnRight turnRight = new TurnRight();
        Mower mower = new Mower(mock(Position.class), expectedOrientationForGiven.getGivenOrientation(), mock(Position.class));
        //When
        turnRight.move(mower);
        //Then
        assertThat(mower.getOrientation()).isEqualTo(expectedOrientationForGiven.getExpectedOrientation());
    }

}
