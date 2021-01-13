package net.torrypubrepo.ecomdashboard.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 Created by Toriola Jan
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler
{
    private String resLinkAccessed;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException
    {
        // In production env, you can Log Successful Login for auditing etc
        System.out.println("Login Successful to Access : ");

        System.out.println(" Successful Request Details ==> : "+httpServletRequest.getHeader("username"));

        System.out.println(" Successful Response Details ==> : "+httpServletResponse.toString());

        if (authentication.isAuthenticated())
        {
            System.out.println("Logged in as : " + authentication.getPrincipal());
            System.out.println("User is : "+authentication.getName());
            System.out.println("Role is : "+authentication.getAuthorities());
            authentication.getAuthorities().forEach(s ->
            {
                if (s.getAuthority().contains("ROLE_ADMIN"))
                    System.out.println("Admin Logged in ");
                else
                    System.out.println("Manager Logged in ");
            });

            if (authentication.getAuthorities().stream().findFirst().get().getAuthority().equals("ROLE_ADMIN")) {
                System.out.println(" ROLE_ADMIN User Logged in ");
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.sendRedirect("/index");
            }
            else if (authentication.getAuthorities().stream().findFirst().get().getAuthority().equals("ROLE_MANAGER")) {
                System.out.println(" ROLE_MANAGER User Logged in ");
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.sendRedirect("/branches");
            }

        }

    }

    public void setResourceAccessed(String resLink)
    {
        resLinkAccessed = resLink;
    }

    public String getResLinkAccessed()
    {
        return resLinkAccessed;
    }

}
