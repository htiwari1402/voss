package voss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class Application {

  public static void main(final String[] args) {

    final SpringApplication app = new SpringApplication(Application.class);
    app.setShowBanner(false);

    app.run(args);
  }
}
