package my.spring.test.app;


import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
@EnableScheduling
@EnableAsync
public class App {
	private ThreadPoolTaskExecutor executor;
	
	public static void main(String[] args) {
		LogManager.getLogger().debug("Started");
		
		ApplicationContext appContext = SpringApplication.run(App.class, args);
		
		LogManager.getLogger().debug("Finished initializing context " + appContext);

		URL system = ClassLoader.getSystemClassLoader().getResource(".");

		URL context = Thread.currentThread().getContextClassLoader().getResource(".");

		System.out.println(system);
		System.out.println(context);
	}


	@Bean("test-executor")
	public ThreadPoolTaskExecutor getAsyncExecutor() {
		if (executor == null) {
			executor = new ThreadPoolTaskExecutor();
			executor.setCorePoolSize(1);
			executor.setMaxPoolSize(1);
			executor.setQueueCapacity(0);
			executor.setThreadNamePrefix("my-spring-test-");
			executor.initialize();
		}

		return executor;
	}

}
