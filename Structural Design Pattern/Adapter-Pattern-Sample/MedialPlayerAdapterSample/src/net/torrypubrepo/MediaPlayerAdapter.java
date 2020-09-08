package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class MediaPlayerAdapter implements MediaPlayerInterface
{
    //Adaptee
   private AdvancedMediaPlayerInterface advancedMediaPlayerInterface;

    public MediaPlayerAdapter(AdvancedMediaPlayerInterface playerInterface)
    {
        advancedMediaPlayerInterface = playerInterface;
    }

    @Override
    public void play(String type, String fileName)
    {
        advancedMediaPlayerInterface.loadFileName(fileName);
        advancedMediaPlayerInterface.listen();

    }
}
