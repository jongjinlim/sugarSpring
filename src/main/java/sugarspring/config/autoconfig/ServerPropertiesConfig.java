package sugarspring.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import sugarspring.config.MyAutoConfiguration;

@MyAutoConfiguration
public class ServerPropertiesConfig {
	@Bean
	public ServerProperties serverProperties(Environment environment) {

		// 이렇게 가져오는건 좀 번거롭다
//		ServerProperties properties = new ServerProperties();
//		properties.setContextPath(environment.getProperty("contextPath"));
//		properties.setPort(Integer.parseInt(environment.getProperty("port")));
//		return properties;

		// 이렇게 바꿔주면 훨씬 편안
		return Binder.get(environment).bind("", ServerProperties.class).get();
	}
}
