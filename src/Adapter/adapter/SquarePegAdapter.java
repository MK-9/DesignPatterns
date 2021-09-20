package Adapter.adapter;

import Adapter.round.RoundPeg;
import Adapter.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {

    private SquarePeg squarePeg;

    public SquarePegAdapter(SquarePeg squarePeg) {
        this.squarePeg = squarePeg;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(squarePeg.getSquare() / 2);
    }
}
