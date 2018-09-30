package directions;

public enum Command {
    D(new TurnRight()), G(new TunrLeft()), A(new MoveForward());

    private DirectionManager directionManager;

    Command(DirectionManager directionManager) {
        this.directionManager = directionManager;
    }

    public DirectionManager getDirectionManager() {
        return directionManager;
    }
}
