package Exercise1;

public class MediaAdapter implements MediaPlayer {
    VlcPlayer vlcPlayer = new VlcPlayer();
    @Override
    public void play(String fileType, String fileName) {
        if(fileType.equalsIgnoreCase("vlc")) vlcPlayer.playVlc(fileName);
        else System.out.println("Invalid media type");
    }
}
