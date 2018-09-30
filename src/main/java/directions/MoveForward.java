package directions;

import model.Mower;
import model.Position;

public class MoveForward implements DirectionManager {

    @Override
    public Mower move(Mower mower) {
        Position position = mower.getOrientation().getMover().nextPosition(mower);
        mower.setPosition(position);
        return mower;
    }

}
