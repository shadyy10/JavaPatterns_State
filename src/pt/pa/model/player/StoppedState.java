package pt.pa.model.player;

import pt.pa.model.Song;

public class StoppedState extends MusicPlayerState {

    public StoppedState(MusicPlayer player) {
        super(player);
    }

    @Override
    public void playPause() {
        player.initPlayer(player.getPlaylist().getCurrent());
        player.startPlayback();
        player.changeState(new PlayingState(player));
    }

    @Override
    public void stop() {
        //do nothing. Keep state.
    }

    @Override
    public void next() {
        //load next song. Keep state.
        Song next = player.getPlaylist().getNext();
        player.initPlayer(next);
    }

    @Override
    public void prev() {
        //load previous song. Keep state.
        Song prev = player.getPlaylist().getNext();
        player.initPlayer(prev);
    }

    @Override
    public String status() {
        return "Stopped. Deck contains " + player.getPlaylist().getCurrent().toString();
    }
}
