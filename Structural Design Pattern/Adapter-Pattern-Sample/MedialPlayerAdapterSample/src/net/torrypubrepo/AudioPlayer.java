package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class AudioPlayer implements MediaPlayerInterface
{
    @Override
    public void play(String type, String fileName)
    {
        if (type.equalsIgnoreCase(TYPE_MP3))
            System.out.println("Now Playing... : "+fileName+"."+TYPE_MP3);
        else
            throw new UnsupportedOperationException("This file format is not supported, Convert it to Mp3");
    }
}//End AudioPlayer
