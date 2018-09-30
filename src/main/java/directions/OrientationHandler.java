package directions;

import model.Orientation;

import java.util.Arrays;
import java.util.List;

public interface OrientationHandler {

    List<Orientation> orientations = Arrays.asList(Orientation.values());

    int getNextIndex(Orientation orientation);

    default int getCurrentIndex(Orientation orientation) {
        return orientations.indexOf(orientation);
    }


}
