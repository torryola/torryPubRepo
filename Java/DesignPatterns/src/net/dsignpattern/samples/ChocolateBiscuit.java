package net.dsignpattern.samples;

import net.dsignpattern.samples.ClassAbstract.Biscuit;

public class ChocolateBiscuit extends Biscuit
{
    public ChocolateBiscuit(int qty)
    {
        super(qty);
    }
    @Override
    public String produce()
    {
        return getQuantity() + " Chocolate Biscuit Produced";
    }
}
