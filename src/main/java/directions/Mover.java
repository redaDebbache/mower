package directions;

import model.Mower;
import model.Position;

public interface Mover {
    Position nextPosition(Mower mower);
}
