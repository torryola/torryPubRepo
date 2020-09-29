package net.torrypubrepo;

/*
 Created by Toriola Sep
 */
public class ServiceProxy implements ServiceInterface
{
    private ServiceApp serviceApp;
    private String url;
    private String serviceType;

    public ServiceProxy(String url)
    {
        this.url = url;
    }

    @Override
    public void getSecuredResource()
    {
        if (url != null && url.startsWith("https"))
        {
            if (serviceApp == null)
                serviceApp = new ServiceApp(url);

            serviceApp.getSecuredResource();
        }
        else
            throw new SecurityException("Access Denied");
    }

    @Override
    public void getResource()
    {

        if (url != null && url.startsWith("http"))
        {
            if (serviceApp == null)
                serviceApp = new ServiceApp(url);

            serviceApp.getResource();
        }
        else
            throw new SecurityException("Access Denied");

    }
}
