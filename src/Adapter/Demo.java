package Adapter;

import Adapter.adapter.SquarePegAdapter;
import Adapter.round.RoundHole;
import Adapter.round.RoundPeg;
import Adapter.square.SquarePeg;

public class Demo {

    public static void main(String[] args) {
        RoundPeg roundPeg = new RoundPeg(5);
        RoundHole roundHole = new RoundHole(5);

        if (roundHole.fit(roundPeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallPeg = new SquarePeg(2);
        SquarePeg largePeg = new SquarePeg(20);
//        doesNot compile
//        roundHole.fit(smallPeg)

        SquarePegAdapter smallAdapter = new SquarePegAdapter(smallPeg);
        SquarePegAdapter largeAdapter = new SquarePegAdapter(largePeg);

        if (roundHole.fit(smallAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }

        if (!roundHole.fit(largeAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }

    }

}
