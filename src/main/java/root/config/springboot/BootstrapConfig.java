package root.config.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.ArrayList;
import java.util.List;

/**
 * 自动解析.yml文件
 */
@Configuration
@Slf4j
public class BootstrapConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        //setResources(Resource... resources),看到这个参数形式你应该就明白了
        /**
         * 特别注释：
         *      因系统默认使用application.yml配置文件配置，所以spring boot的实体bean
         *      中仅使用@ConfigurationProperties标明前缀，而未使用@PropertySource注解指定位置,
         *      所以这让我们有机可乘，可以提前创建定义好自己所需的yml，只要在项目启动时自动解析，那么
         *      就可以不需要死板的使用spring boot默认的application.yml文件。
         *      另一种实现方式，是使用spring boot中的yml属性spring.profiles.active与spring.profiles.include
         *      通过利用spring boot的多环境配置切换设计来达到与上述相同的目的，但问题是这样的配置文件路径暂时不知怎么修改
         */
        List<org.springframework.core.io.Resource> oList = new ArrayList<org.springframework.core.io.Resource>();
        oList.add(new ClassPathResource("config/freemarker/freemarkerConfig.yml"));
        yaml.setResources(oList.toArray(new ClassPathResource[0]));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }

}
