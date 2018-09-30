package directions;

import model.Mower;
import model.Orientation;

public class TurnRight implements DirectionManager, OrientationHandler {

    @Override
    public Mower move(Mower mower) {
        mower.setOrientation(orientations.get(getNextIndex(mower.getOrientation())));
        return mower;
    }

    @Override
    public int getNextIndex(Orientation orientation) {
        return increment(getCurrentIndex(orientation));
    }

    int increment(int index) {
        return ++index % Orientation.values().length;
    }
}
