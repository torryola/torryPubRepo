package net.torrypubrepo;

public class BritishSocket {

    public static void main(String[] args)
    {
        System.out.println("This is a 3-Pin Socket");
        // Use British Plug
        BritishPlug britishPlug = new BritishPlug();
        System.out.println(britishPlug.plug());

        System.out.println("\nUse a Plug Adapter for an American Plug in 3-Pin Socket");
        TwoPinPlugInterface twoPinPlugInterface = new AmericanPlug();
        // Use Adapter In British Socket
        PlugAdapter adapter = new PlugAdapter(twoPinPlugInterface);
        System.out.println(adapter.plug());
    }
}
