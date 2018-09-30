package model;

import directions.Command;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mower {
    private static final String EMPTY = "";
    private static final String OUTPUT_FORMAT = "%s %s";
    private Position position;
    private Orientation orientation;
    private Position farthestPosition;
    private List<Command> commands;


    public Mower(Position position, Orientation orientation, Position farthestPosition) {
        this.position = position;
        this.orientation = orientation;
        this.farthestPosition = farthestPosition;
    }

    public Mower(Position initialPosition, Orientation orientation, Position farthestPosition, String commands) {
        this(initialPosition, orientation, farthestPosition);
        this.commands = Stream.of(commands.split(EMPTY)).map(Command::valueOf).collect(Collectors.toList());
    }

    public Position getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getShiftingSign() {
        return orientation.getSign();
    }

    public Position getFarthestPosition() {
        return farthestPosition;
    }

    public String move(){
     //   commands.forEach(command -> command.getDirectionManager().move(this));
        StringBuffer logs = commands.stream().map(command -> command.getDirectionManager().move(this))
                .map(Object::toString)
                .reduce(new StringBuffer(), StringBuffer::append, StringBuffer::append);
        System.out.println(logs.toString());
        return this.toString();
    }

    @Override
    public String toString() {
        return String.format(OUTPUT_FORMAT, this.position.toString(), this.orientation.name());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mower mower = (Mower) o;
        return position.equals(mower.position)
                && orientation == mower.orientation
                && farthestPosition.equals(mower.farthestPosition);
    }

}
