package directions;

import model.Mower;
import model.Orientation;
import model.Position;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VerticalMoverTest {
    
    @Test
    public void should_move_up() {
        //Given
        VerticalMover mover = new VerticalMover();
        Mower mower = new Mower(new Position(0, 0), Orientation.N, new Position(5, 5));
        //When
        Position finalPosition = mover.nextPosition(mower);
        //Then
        assertThat(finalPosition).isEqualTo(new Position(0, 1));

    }

    @Test
    public void should_move_down() {
        //Given
        VerticalMover mover = new VerticalMover();
        Mower mower = new Mower(new Position(0, 1), Orientation.S, new Position(5, 5));

        //When
        Position finalPosition = mover.nextPosition(mower);

        //Then
        assertThat(finalPosition).isEqualTo(new Position(0, 0));

    }

    @Test
    public void should_not_move_when_max_bounds_reached() {
        //Given
        VerticalMover mover = new VerticalMover();
        Mower mower = new Mower(new Position(5, 5), Orientation.E, new Position(5, 5));

        //When
        Position finalPosition = mover.nextPosition(mower);

        //Then
        assertThat(finalPosition).isEqualTo(new Position(5, 5));
    }

    @Test
    public void should_not_move_when_min_bounds_reached() {
        //Given
        VerticalMover mover = new VerticalMover();
        Mower mower = new Mower(new Position(0, 0), Orientation.S, new Position(5, 5));

        //When
        Position finalPosition = mover.nextPosition(mower);

        //Then
        assertThat(finalPosition).isEqualTo(new Position(0, 0));
    }


}
