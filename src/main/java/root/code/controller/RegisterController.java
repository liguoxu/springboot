package root.code.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import root.code.dto.FindRegister;
import root.code.dto.ResultInfo;
import root.code.pojo.Register;
import root.code.service.RegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Slf4j
public class RegisterController {

    @Autowired
    @Qualifier("register")
    private RegisterService registerService;

    @RequestMapping("/dispatcherRegister")
    public ModelAndView dispatcherRegister() {
        ModelAndView modelAndView = new ModelAndView("findRegister");
        return modelAndView;
    }

    @RequestMapping("/findRegister")
    public @ResponseBody
    ResultInfo<FindRegister> findRegister(Register register, @Param("checkCode")String checkCode, HttpServletRequest request) {
        log.info(register.toString());
        log.info(checkCode);
        return registerService.findRegister(register, checkCode, request);
    }

    @RequestMapping("/checkCode")
    public void checkCodeImage(HttpServletRequest request, HttpServletResponse response){
        registerService.checkCodeImage(request, response);
    }
}
