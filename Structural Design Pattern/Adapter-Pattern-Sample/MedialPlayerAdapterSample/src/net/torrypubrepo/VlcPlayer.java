package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class VlcPlayer implements AdvancedMediaPlayerInterface
{
    private String fileName;
    private static final String TYPE_VLC = ".vlc";

    public VlcPlayer()
    {

    }

    @Override
    public void loadFileName(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public void listen()
    {
        System.out.println("Now Playing... "+fileName+TYPE_VLC);
    }
}
