package net.torrypubrepo;

public class Main {

    public static void main(String[] args)
    {
        System.out.println(" Mp3 Player ");
        MediaPlayerInterface audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","disco");

        System.out.println("\n Vlc Player ");
        AdvancedMediaPlayerInterface vlcPlayer = new VlcPlayer();
        // Use Adapter
        MediaPlayerAdapter mediaPlayerAdapter = new MediaPlayerAdapter(vlcPlayer);
        mediaPlayerAdapter.play("vlc", "Shake-it");

        System.out.println("\n Mp4 Player ");
        AdvancedMediaPlayerInterface mp4Player = new Mp4Player();
        // Use Adapter
        MediaPlayerAdapter mediaPlayerAdapter1 = new MediaPlayerAdapter(mp4Player);
        mediaPlayerAdapter1.play("mp4", "Beat-it");

        System.out.println("\n Unsupported Type ");
        audioPlayer.play("vlc", "shake-it");

    }
}
