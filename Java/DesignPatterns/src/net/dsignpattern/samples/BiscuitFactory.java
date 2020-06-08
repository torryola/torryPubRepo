package net.dsignpattern.samples;

import net.dsignpattern.samples.ClassAbstract.Biscuit;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class BiscuitFactory
{
    public static void main(String[] args)
    {
        final Biscuit chocolateBiscuit = BiscuitFactory.producBiscuit("Chocolate", 15000);
        final Biscuit gingerBiscuit = BiscuitFactory.producBiscuit("Ginger", 12000);
        final Biscuit oreoBiscuit = BiscuitFactory.producBiscuit("Oreo", 10000);
        //final Biscuit iceBiscuit = BiscuitFactory.producBiscuit("Ice", 1000);

        Consumer<Biscuit> predicate = s -> System.out.println(s.produce());
        predicate.accept(chocolateBiscuit);
        predicate.accept(gingerBiscuit);
        predicate.accept(oreoBiscuit);
    }
    public static Biscuit producBiscuit(String type, int qty)
    {
        Biscuit biscuit = null;
        switch (type)
        {
            case "Oreo":
               biscuit =  new OreoBiscuit(qty);
                break;
            case "Ginger":
               biscuit = new GingerBiscuit(qty);
                break;
            case "Chocolate":
               biscuit =  new ChocolateBiscuit(qty);
                break;
            default:
                throw new UnsupportedOperationException("We don't produce "+type+" Biscuit yet");
        }//End switch

        return biscuit;
    }
}//End
