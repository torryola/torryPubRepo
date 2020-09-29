package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class ServiceApp implements ServiceInterface
{
    private String type;
    public ServiceApp(String type)
    {
        this.type = type;
    }
    @Override
    public void getSecuredResource()
    {
        System.out.println("Accessing Secure Service :"+type);
    }

    @Override
    public void getResource()
    {
        System.out.println("Accessing InSecure Service :"+type);

    }
}
