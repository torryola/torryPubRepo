package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class PlugAdapter implements ThreePinPlugInterface
{
    private TwoPinPlugInterface twoPinPlugInterface;

    public PlugAdapter(TwoPinPlugInterface amPlug)
    {
        this.twoPinPlugInterface = amPlug;
    }

    @Override
    public String plug()
    {
        return twoPinPlugInterface.plug()+" with an Adapter for British Socket";
    }
}
