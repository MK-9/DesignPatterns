package State.states;

import State.ui.Player;

public class LockedState extends State{

    public LockedState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        return null;
    }

    @Override
    public String onPlay() {
        return null;
    }

    @Override
    public String onNext() {
        return null;
    }

    @Override
    public String onPrevious() {
        return null;
    }
}
