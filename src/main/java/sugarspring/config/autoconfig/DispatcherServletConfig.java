package sugarspring.config.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import sugarspring.config.MyAutoConfiguration;

@MyAutoConfiguration
public class DispatcherServletConfig {
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
}
