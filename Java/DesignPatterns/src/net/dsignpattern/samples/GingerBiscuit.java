package net.dsignpattern.samples;

import net.dsignpattern.samples.ClassAbstract.Biscuit;

public class GingerBiscuit extends Biscuit
{
    public GingerBiscuit(int qty)
    {
        super(qty);
    }

    @Override
    public String produce()
    {
        return getQuantity() + " Ginger Biscuit Produced";
    }

}
