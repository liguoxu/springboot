package root.entrance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/**
 * @SpringBootApplication本身就包含了@ComponentScan注解，
 * 但是！包含的@ComponentScan注解只是扫描入口所在包及其子包
 * 若配置文件与入口类不在同一层包下，那么重新指定@ComponentScan注解的扫描包路径
 */
@ComponentScan(basePackages = {"root"})
//通过使用@MapperScan指定要扫描带有@Mapper注解的接口的路径
@MapperScan("root.code.mapper")
//SpringBootServletInitializer类是外部TOMCAT启动时需要继承的类，功能类似WEB.XML执行Spring的过滤器
public class SpringbootApplication  extends SpringBootServletInitializer {

	//外部TOMCAT启动时重写Method
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootApplication.class);
	}

	//spring boot jar 启动入口
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
