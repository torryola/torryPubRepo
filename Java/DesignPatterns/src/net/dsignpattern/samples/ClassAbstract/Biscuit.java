package net.dsignpattern.samples.ClassAbstract;
// To be Extended by all kid of biscuits to be made
public abstract class Biscuit
{
    private int quantity;
    public Biscuit(int qty)
    {
        if (qty <= 0)
            throw new IllegalArgumentException("Zero(0) quantity is not allowed");
        quantity = qty;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public abstract String produce();
}
