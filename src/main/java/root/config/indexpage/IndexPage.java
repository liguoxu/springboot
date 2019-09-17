package root.config.indexpage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页Controller
 */
@Slf4j
@Controller
public class IndexPage {

    /**
     * @Slf4j替代一下代码，默认使用变量log
     * private static final Logger log = LoggerFactory.getLogger(UserController.class);
     */

    @RequestMapping(value = {"/", "/index"})
    public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response){
        log.info("用户访问 ... ... 正在进入首页");
        ModelAndView indexPage = new ModelAndView("/index");
        return indexPage;
    }
}
