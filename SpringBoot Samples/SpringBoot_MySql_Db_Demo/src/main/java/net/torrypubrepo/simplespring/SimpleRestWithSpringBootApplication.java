package net.torrypubrepo.simplespring;

import net.torrypubrepo.simplespring.DataModel.Feeds;
import net.torrypubrepo.simplespring.DbUtil.DataSourceConfig;
import net.torrypubrepo.simplespring.Services.FeedServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
public class SimpleRestWithSpringBootApplication implements CommandLineRunner
{
	private static Random random= new Random();

	@Autowired
	DataSourceConfig dataSourceConfig;
	@Autowired
	FeedServices feedServices;
	public static void main(String[] args) {
		SpringApplication.run(SimpleRestWithSpringBootApplication.class, args);
	}

	// Pre-Populating the Feeds Map
	@Override
	public void run(String... args) throws Exception
	{
		System.out.println(" *****************  Creating MySql Database locally *************************");
	}
}
