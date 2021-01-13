package net.torrypubrepo.ecomdashboard.Controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 Created by Toriola Jan
 */
@Component
public class LoginAccessDeniedHandler implements AccessDeniedHandler
{

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse
            httpServletResponse, AccessDeniedException e) throws IOException, ServletException
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
        {
            System.out.println("Access Log ===>>> "+authentication.getDetails());
        }
        httpServletResponse.sendRedirect(httpServletRequest.getRequestURI() + "/access-denied");
    }
}
