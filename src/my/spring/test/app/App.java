package my.spring.test.app;


import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
public class App {

	
	public static void main(String[] args) {
		LogManager.getLogger().debug("Started");
		
		ApplicationContext appContext = SpringApplication.run(App.class, args);
		
		LogManager.getLogger().debug("Finished");
	}
	
	
}
