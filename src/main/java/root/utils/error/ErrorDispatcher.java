//package root.utils.error;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class ErrorDispatcher implements ErrorController {
//
//    @RequestMapping(value = "/error")
//    public String sendErrorCodeForPage(HttpServletRequest request){
//        //获取statusCodess:401,404,500
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        return statusCode+"";
//
//    }
//
//    @Override
//    public String getErrorPath() {
//        System.out.println("??????????????????");
//        return "redirect:/error";
//    }
//}
