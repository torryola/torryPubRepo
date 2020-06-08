package net.dsignpattern.samples;

import net.dsignpattern.samples.ClassAbstract.Biscuit;

public class OreoBiscuit extends Biscuit
{
    public OreoBiscuit(int qty)
    {
        super(qty);
    }

    @Override
    public String produce()
    {
        return getQuantity() + " Oreo Biscuit Produced";
    }
}
