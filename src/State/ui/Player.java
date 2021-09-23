package State.ui;

import State.states.ReadyState;
import State.states.State;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;
    private boolean isPlaying = false;
    private List<String> playList = new ArrayList<>();
    private int currentTrack = 0;

    public Player() {
        state = new ReadyState(this);
        setPlaying(true);
        for (int i = 0; i < 12; i++) {
            playList.add("track: " + i);
        }
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public String startPlayBack() {
        return "Playing " + playList.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack > playList.size() - 1) {
            currentTrack = 0;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playList.size() - 1;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public void setCurrentTrackAfterStop() {
        currentTrack = 0;
    }
}
