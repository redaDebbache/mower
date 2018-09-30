package directions;

import model.Mower;
import model.Position;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class VerticalMover implements Mover {

    @Override
    public Position nextPosition(Mower mower) {
        Position currentPosition = mower.getPosition();
        Position maxEdgesToReachPosition = mower.getFarthestPosition();
        Integer shiftingSign = mower.getShiftingSign();
        return new Position(currentPosition.getX(), max(0, min(currentPosition.getY() + shiftingSign, maxEdgesToReachPosition.getY())));
    }
}
