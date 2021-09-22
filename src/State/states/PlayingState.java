package State.states;

import State.ui.Player;

public class PlayingState extends State{

    public PlayingState(Player player) {
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
