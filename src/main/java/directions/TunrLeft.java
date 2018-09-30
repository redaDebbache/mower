package directions;

import model.Mower;
import model.Orientation;

public class TunrLeft implements DirectionManager, OrientationHandler {

    private static final int MIN_ORIENTATION_INDEX = 0;
    private static final int MAX_ORIENTATION_INDEX = 3;
    private static final int INCREMENTATION_UNIT = 1;

    @Override
    public Mower move(Mower mower) {
        mower.setOrientation(orientations.get(getNextIndex(mower.getOrientation())));
        return mower;
    }

    @Override
    public int getNextIndex(Orientation orientation) {
        return decrement(getCurrentIndex(orientation));
    }

    int decrement(int currentIndex) {
        return currentIndex == MIN_ORIENTATION_INDEX ? MAX_ORIENTATION_INDEX : currentIndex - INCREMENTATION_UNIT;
    }
}
