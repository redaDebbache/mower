package model;


import directions.HorizontalMover;
import directions.Mover;
import directions.VerticalMover;

public enum Orientation {
    N(new VerticalMover(), 1), E(new HorizontalMover(), 1), S(new VerticalMover(), -1), W(new HorizontalMover(), -1);

    private Mover mover;
    private Integer sign;

    Orientation(Mover mover, Integer sign) {
        this.mover = mover;
        this.sign = sign;
    }

    public Mover getMover() {
        return mover;
    }

    public Integer getSign() {
        return sign;
    }
}
