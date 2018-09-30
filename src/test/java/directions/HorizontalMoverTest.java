package directions;

import model.Mower;
import model.Orientation;
import model.Position;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HorizontalMoverTest {

    @Test
    public void should_move_to_right() {
        //Given
        HorizontalMover mover = new HorizontalMover();
        Mower mower = new Mower(new Position(0,0), Orientation.E, new Position(5, 5));
        //When
        Position finalPosition = mover.nextPosition(mower);
        //Then
        assertThat(finalPosition).isEqualTo(new Position(1, 0));

    }

    @Test
    public void should_move_to_left() {
        //Given
        HorizontalMover mover = new HorizontalMover();
        Mower mower = new Mower(new Position(1,0), Orientation.W, new Position(5, 5));
        //When
        Position finalPosition = mover.nextPosition(mower);
        //Then
        assertThat(finalPosition).isEqualTo(new Position(0, 0));

    }

    @Test
    public void should_not_move_when_max_bounds_reached() {
        //Given
        HorizontalMover mover = new HorizontalMover();
        Mower mower = new Mower(new Position(5,5), Orientation.E, new Position(5, 5));
        //When
        Position finalPosition = mover.nextPosition(mower);
        //Then
        assertThat(finalPosition).isEqualTo(new Position(5, 5));
    }

    @Test
    public void should_not_move_when_min_bounds_reached() {
        //Given
        HorizontalMover mover = new HorizontalMover();
        Mower mower = new Mower(new Position(0,0), Orientation.W, new Position(5, 5));
        //When
        Position finalPosition = mover.nextPosition(mower);
        //Then
        assertThat(finalPosition).isEqualTo(new Position(0, 0));
    }

}
