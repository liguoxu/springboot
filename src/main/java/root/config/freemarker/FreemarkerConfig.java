package root.config.freemarker;

import freemarker.template.TemplateModelException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Freemarker配置
 */
@Configuration
@Slf4j
public class FreemarkerConfig {

    //用于设置Freemarker共享变量
    @Resource
    private freemarker.template.Configuration configuration;

    //用于存储Freemarker共享变量的键值对
    private Map<String,Object> varMap = new HashMap<String,Object>();
    {
        varMap.put("Hello", 1234656666);
    }

    /**
     * 共享变量
     * @return
     */
    @Bean
    public freemarker.template.Configuration setUpFreemarkerConfig(){
        try {
            configuration.setSharedVaribles(varMap);
        } catch (TemplateModelException e) {
            log.error(e.toString());
        }
        return configuration;
    }
}
