package directions;


import model.Mower;
import model.Orientation;
import model.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static model.Orientation.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class MoveForwardTest {

    @Parameterized.Parameters
    public static List<ExpectedPositionForGiven> parameters() {
        return Arrays.asList(
                new ExpectedPositionForGiven(new Position(0, 0), N, new Position(0, 1)),
                new ExpectedPositionForGiven(new Position(1, 2), E, new Position(2, 2)),
                new ExpectedPositionForGiven(new Position(1, 2), S, new Position(1, 1)),
                new ExpectedPositionForGiven(new Position(1, 0), W, new Position(0, 0)),
                new ExpectedPositionForGiven(new Position(0, 0), S, new Position(0, 0)),
                new ExpectedPositionForGiven(new Position(5, 5), N, new Position(5, 5))
        );
    }

    private ExpectedPositionForGiven expectedPositionForGiven;

    public MoveForwardTest(ExpectedPositionForGiven expectedPositionForGiven) {
        this.expectedPositionForGiven = expectedPositionForGiven;
    }

    @Test
    public void should_move_forward() {
        //Given
        MoveForward moveForward = new MoveForward();
        Mower mower = new Mower(expectedPositionForGiven.givenPosition, expectedPositionForGiven.givenOrientation, new Position(5, 5));
        //When
        moveForward.move(mower);
        //Then
        assertThat(mower.getPosition()).isEqualTo(expectedPositionForGiven.expectedPosition);
    }


    static class ExpectedPositionForGiven {
        Position givenPosition;
        private Orientation givenOrientation;
        private Position expectedPosition;

        ExpectedPositionForGiven(Position givenPosition, Orientation givenOrientation, Position expectedPosition) {
            this.givenPosition = givenPosition;
            this.givenOrientation = givenOrientation;
            this.expectedPosition = expectedPosition;
        }
    }
}
