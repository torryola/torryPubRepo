package net.torrypubrepo;

public class Service_Client {

    public static void main(String[] args)
    {
        // Instantiate Service Proxy
        ServiceProxy securedAccess = new ServiceProxy("https://www.bbc.com/breaking");
        ServiceProxy openAccess = new ServiceProxy("http://www.opensource.net");

        // Secured Access
        securedAccess.getSecuredResource();

        // All Valid Access
        openAccess.getResource();

    }
}
