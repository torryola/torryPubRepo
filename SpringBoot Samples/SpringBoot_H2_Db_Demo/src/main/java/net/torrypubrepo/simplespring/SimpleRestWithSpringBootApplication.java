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
		System.out.println(" *****************  Creating H2 Database locally *************************");
		/*
		System.out.println(" Pre Populating Feeds on Application Start for Demo only");
		Feeds feeds1 = new Feeds("Spring Boot",
				"CRUD Ops in Spring Boot", LocalDateTime.now().toString());
		feeds1.setId(random.nextInt(10));

		Feeds feeds2 = new Feeds("Spring Boot",
				"Advocates RAD style ", LocalDateTime.now().toString());
		feeds2.setId(random.nextInt(10));

		feedServices.addNew_Feed(feeds1);
		feedServices.addNew_Feed(feeds2);

		 */
	}
}
