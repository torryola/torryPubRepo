package net.torrypubrepo.simplespring.DbUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/*
 Created by Toriola in 2020
 */
@Configuration // So it can be Autowired
public class DataSourceConfig
{
    @Value("${demo.msg}")
    private String profileMsg;

    // Datasource Profile Prefix
    private static final String PREFIX = "spring.datasource.";
    // Properties variables
    @Value("${"+PREFIX+"url}")
    private String url;
    @Value("${"+PREFIX+"username}")
    private String username;
    @Value("${"+PREFIX+"password}")
    private String password;
    @Value("${"+PREFIX+"driverClassName}")
    private String driverClassName;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Constructor
    public DataSourceConfig()
    {

    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Dev Profile
    @Profile("dev")
    @Bean //tells that a method produces a bean to be managed by the Spring container
    public void getDev_Profile()
    {
        System.out.println("Profile Msg :"+profileMsg);
        System.out.println("Drive :"+ getDriverClassName());
        System.out.println("Url :"+getUrl());
        System.out.println("User :"+ getUsername());
        System.out.println("Password :"+getPassword());
    }
    // Test Profile
    @Profile("test")
    @Bean //tells that a method produces a bean to be managed by the Spring container
    public void getTest_Profile()
    {
        System.out.println("Profile Msg :"+profileMsg);
        System.out.println("Drive :"+ getDriverClassName());
        System.out.println("Url :"+getUrl());
        System.out.println("User :"+ getUsername());
        System.out.println("Password :"+getPassword());
    }

    // Prod Profile
    @Profile("prod")
    @Bean //tells that a method produces a bean to be managed by the Spring container
    public void getProd_Profile()
    {
        System.out.println("Profile Msg :"+profileMsg);
        System.out.println("Drive :"+ getDriverClassName());
        System.out.println("Url :"+getUrl());
        System.out.println("User :"+ getUsername());
        System.out.println("Password :"+getPassword());
    }

    @Override
    public String toString()
    {
        return "DataSourceConfig{" +
                "profileMsg='" + profileMsg + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}//End DataSourceConfig
