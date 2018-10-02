package directions;

import model.Mower;
import model.Position;

import static java.lang.Math.*;

public class HorizontalMover implements Mover {

    @Override
    public Position nextPosition(Mower mower) {
        Position currentPosition = mower.getPosition();
        Position maxEdgesToReachPosition = mower.getFarthestPosition();
        Integer shiftingSign = mower.getShiftingSign();
        return new Position(max(0, min(currentPosition.getX() + shiftingSign, maxEdgesToReachPosition.getX())), currentPosition.getY());
    }
}
