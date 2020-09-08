package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class Mp4Player implements AdvancedMediaPlayerInterface
{
    private String fileName;
    private static final String TYPE_MP4 = ".mp4";

    public Mp4Player()
    {

    }

    @Override
    public void loadFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void listen() {
        System.out.println("Now Playing... "+fileName+TYPE_MP4);
    }
}
